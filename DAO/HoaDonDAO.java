package DAO;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.*;
import BUS.*;
public class HoaDonDAO extends DAODAL<HoaDonDTO> implements Serializable {

       PhieuXuatDAO data_PhieuXuat = new PhieuXuatDAO();

       @Override
       public boolean delete(HoaDonDTO t) throws SQLException {
              if(check_delete(t.getMahd())){
                     String sql_HoaDon = String.format("DELETE FROM tblHoaDon WHERE Ma = '%s' ", t.getMahd());
                     String sql_CTHoaDon = String.format("DELETE FROM tblCTHoaDon WHERE MaHD = '%s' ", t.getMahd());
       
                     PreparedStatement statement_PhieuNhap = data.prepareStatement(sql_HoaDon);
       
                     PreparedStatement statement_CTPhieu = data.prepareStatement(sql_CTHoaDon);
       
                     return statement_CTPhieu.executeUpdate() > 0 && statement_PhieuNhap.executeUpdate() > 0;
              }
              return false;
              
       }

       @Override
       public boolean deleteById(String id) throws SQLException {
              if(check_delete(id)){
                     String sql_HoaDon = String.format("DELETE FROM tblHoaDon WHERE Ma = '%s' ", id);
                     String sql_CTHoaDon = String.format("DELETE FROM tblCTHoaDon WHERE MaHD = '%s' ", id);
       
                     PreparedStatement statement_PhieuNhap = data.prepareStatement(sql_HoaDon);
       
                     PreparedStatement statement_CTPhieu = data.prepareStatement(sql_CTHoaDon);
       
                     return statement_CTPhieu.executeUpdate() > 0 && statement_PhieuNhap.executeUpdate() > 0;
              }
              return false;
              
       }

       @Override
       public HoaDonDTO get(String id) throws SQLException {
              String sql = String.format(
                            "SELECT * FROM tblHoaDon,tblCTHoaDon WHERE Ma = MaHD AND Ma = '%s' ",
                            id);
              PreparedStatement statement = data.prepareStatement(sql);

              ResultSet rs = statement.executeQuery();
              HoaDonDTO hoaDon = null;
              DanhSachCTHDBUS temp = new DanhSachCTHDBUS();
              
              // tang them 1 dong va kiem tra
              if(rs.next() == false){
                     return null;
              }
              
              // doc thong tin hoa don
              String maHD = rs.getString("Ma");
              String MaNV = rs.getString("MaNV");
              String timexuat = rs.getString("ThoiGianXuat");
              int TongTien = rs.getInt("TongTien");
              String TinhTrang = rs.getString("TinhTrang");

              // doc thong tin cac chi tiet co trong hoa don
              while(true){
                     ChiTietHDDTO CT = new ChiTietHDDTO();
                     CT.setMaSP(rs.getString("MaSP"));
                     CT.setSoluong(rs.getInt("SoLuong"));
                     CT.setGia(rs.getInt("DonGia"));
                     temp.add(CT);

                     // neu het chi tiet trong hoa don se tu break
                     if(rs.next() == false){
                            break;
                     }
              }
              hoaDon = new HoaDonDTO(maHD, MaNV, timexuat, TongTien, temp, TinhTrang);
              return hoaDon;
       }

       @Override
       public ArrayList<HoaDonDTO> getList() throws SQLException {
              String sql = "SELECT * FROM tblHoaDon,tblCTHoaDon WHERE Ma = MaHD ORDER BY Ma ASC";
              PreparedStatement statement = data.prepareStatement(sql);
              
               // kiem tra xem data co rong khong
              ResultSet check = statement.executeQuery();
              if(check.next() == false){
                     return null;
              }
              check.close();

              ArrayList<HoaDonDTO> arr = new ArrayList<HoaDonDTO>();
              ArrayList<String> arrMaHD = new ArrayList<String>();           // doc ma~ ID phieu co trong sql
              ResultSet rs1 = statement.executeQuery();
              while (rs1.next()) {
                     String Ma = rs1.getString("Ma");
                     if(arrMaHD.contains(Ma) == false){                      // nếu mã chưa có thì thêm vào
                            arrMaHD.add(Ma);
                     }
              }
              rs1.close();  // dong ket noi

              int i =0;     // duyet phan tu trong arrMaHD
              String MaHD = arrMaHD.get(i); // thiet lap ma ban dau
              int flag = 0; // co hieu
              DanhSachCTHDBUS temp = new DanhSachCTHDBUS();
              String Ma_NV = "";
              String timexuat = "";
              int TongTien = -1;
              String TinhTrang = "";
              ResultSet rs2 = statement.executeQuery();
              rs2.next();                        // tang con tro rs2 len 1 --> dong dau tien trong sql

              while(flag == 0){
                     // so sánh MaHD trong chi tiet hao don trong sql với MaHD thu đc trong mảng arrMaHD
                     // nếu đúng :
                     //            - tạo 1 chi tiết hóa đơn rồi add vào mảng DS chi tiết hoa don 
                     //            - di chuyển con trỏ rs sang dòng tiếp theo và kiểm tra dòng tiếp theo có null không:
                     //                   + nếu dòng tiếp theo null thì tiến hành add phiếu cuối cùng vô mảng rồi hủy
                     //                          vòng lặp ( xử lý hóa đơn cuối cùng)
                     // nếu sai:        
                     //            - tạo một 1 hóa đơn mới với thông tin đã có ở trên rồi add vào mảng
                     //            - reset lại mảng chi tiết hóa đơn có trong hóa đơn
                     //            - tăng giá trị i duyệt lên để lấy mã tiếp theo trong mảng
                     if(rs2.getString("MaHD").equals(MaHD)){
                            // System.out.println(ID);
                            Ma_NV = rs2.getString("MaNV");
                            timexuat = rs2.getString("ThoiGianXuat");
                            TongTien = rs2.getInt("TongTien");
                            TinhTrang = rs2.getString("TinhTrang");
                            ChiTietHDDTO moi = new ChiTietHDDTO();
                            moi.setMaSP(rs2.getString("MaSP"));
                            moi.setSoluong(rs2.getInt("SoLuong"));
                            moi.setGia(rs2.getInt("DonGia"));
                            temp.add(moi);
                            if(rs2.next() == false){
                                   flag = -1;
                                   arr.add(new HoaDonDTO(MaHD, Ma_NV, timexuat, TongTien, temp, TinhTrang));
                            }

                     }
                     else{
                            arr.add(new HoaDonDTO(MaHD, Ma_NV, timexuat, TongTien, temp, TinhTrang));
                            temp = new DanhSachCTHDBUS();
                            i++;
                            MaHD = arrMaHD.get(i);
                            
                     }
              }
              rs2.close();         // đóng kết nối 
              
              // for (HoaDon iterable_element : arr) {
              //        iterable_element.xuatThongTin();
              //        iterable_element.getDsCTHD().XuatCTHD();
              // }

              return arr;
       }      

       @Override
       public boolean save(HoaDonDTO t) throws SQLException {
              if (t == null) {
                     throw new SQLException("Hoa Don rong");
              }
              int check_1 = -1, check_2 = -1;
              String sql_HoaDon = "INSERT INTO tblHoaDon(Ma,MaNV,ThoiGianXuat,TongTien,TinhTrang)"
                            + "VALUES(?,?,?,?,?)";

              String sql_CTHD = "INSERT INTO tblCTHoaDon(MaHD,MaSP,SoLuong,DonGia)" + "VALUES(?,?,?,?)";

              PreparedStatement statement1 = data.prepareStatement(sql_HoaDon);
              PreparedStatement statement2 = data.prepareStatement(sql_CTHD);

              // Hoa Don
              statement1.setString(1, t.getMahd());
              statement1.setString(2, t.getManv());
              statement1.setString(3, t.getTimexuat());
              statement1.setInt(4, t.getTongtien());
              statement1.setString(5, t.getTinhTrang());

              // Chi tiet hoa don
              ArrayList<ChiTietHDDTO> arr_CT = t.getDsCTHD().getCthd();
              int sl_CT = arr_CT.size();

              if (statement1.executeUpdate() > 0) {
                     check_1 = 1;
              }
              for (int i = 0; i < sl_CT; i++) {
                     statement2.setString(1, t.getMahd());
                     ChiTietHDDTO temp = arr_CT.get(i);
                     statement2.setString(2, temp.getMaSP());
                     statement2.setInt(3, temp.getSoluong());
                     statement2.setInt(4, temp.getGia());
                     if (statement2.executeUpdate() > 0) {
                            check_2 = 1;
                     } else {
                            check_2 = 0;
                     }

              }
              return check_1 == 1 && check_2 == 1;
       }

       @Override
       public boolean update(HoaDonDTO t) throws SQLException {
              if( t == null){
                     throw new SQLException("Phieu Nhap rong");
              }
              int check_1 = -1, check_2 = -1;
              if(delete(t)){
                     check_1 = 1;
              }
              if(save(t)){
                     check_2 = 1;
              }
              return check_1 == check_2;
       }
       private boolean check_delete(String id) throws SQLException{
              ArrayList<PhieuXuatDTO> list_PhieuXuats = data_PhieuXuat.getList();
              int flag = 0;
              for (PhieuXuatDTO phieuXuat : list_PhieuXuats) {
                     if(phieuXuat.getIDHoaDon().equals(id)){
                            flag = 1;
                     }
              }
              if(flag == 0){
                     return true;
              }
              return false;
       }

       
       
}

