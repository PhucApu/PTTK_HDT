package DAO;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.*;
import BUS.*;
public class PhieuXuatDAO extends DAODAL<PhieuXuatDTO> implements Serializable {

       @Override
       public boolean delete(PhieuXuatDTO t) throws SQLException {
              String sql_CTPhieu = String.format("DELETE FROM tblChiTietPhieuXuat WHERE ID_CTPhieuXuat = '%s' ",
                            t.getIDPhieu());

              String sql_PhieuXuat = String.format("DELETE FROM tblPhieuXuat WHERE ID_PhieuXuat = '%s' ", t.getIDPhieu());
              
              String sql_Phieu = String.format("DELETE FROM tblPhieu WHERE ID = '%s' ", t.getIDPhieu());

              PreparedStatement statement_Phieu = data.prepareStatement(sql_Phieu);

              PreparedStatement statement_PhieuNhap = data.prepareStatement(sql_PhieuXuat);

              PreparedStatement statement_CTPhieu = data.prepareStatement(sql_CTPhieu);

              return statement_CTPhieu.executeUpdate() > 0 && statement_PhieuNhap.executeUpdate() > 0 && statement_Phieu.executeUpdate() >0 ;
       }

       @Override
       public boolean deleteById(String id) throws SQLException {
              String sql_CTPhieu = String.format("DELETE FROM tblChiTietPhieuXuat WHERE ID_CTPhieuXuat = '%s' ",
                            id);

              String sql_PhieuXuat = String.format("DELETE FROM tblPhieuXuat WHERE ID_PhieuXuat = '%s' ", id);
              
              String sql_Phieu = String.format("DELETE FROM tblPhieu WHERE ID = '%s' ", id);

              PreparedStatement statement_Phieu = data.prepareStatement(sql_Phieu);

              PreparedStatement statement_PhieuNhap = data.prepareStatement(sql_PhieuXuat);

              PreparedStatement statement_CTPhieu = data.prepareStatement(sql_CTPhieu);

              return statement_CTPhieu.executeUpdate() > 0 && statement_PhieuNhap.executeUpdate() > 0 && statement_Phieu.executeUpdate() >0 ;
       }

       @Override
       public PhieuXuatDTO get(String id) throws SQLException {
              String sql = String.format(
                            "SELECT * FROM tblPhieuXuat,tblChiTietPhieuXuat,tblPhieu WHERE ID = ID_PhieuXuat AND ID_PhieuXuat = ID_CTPhieuXuat AND ID = '%s' ",
                            id);

                            PhieuXuatDTO phieuXuat = null;
              dsChiTietPhieuBUS temp = new dsChiTietPhieuBUS();
              PreparedStatement statement = data.prepareStatement(sql);
              ResultSet rs = statement.executeQuery();
              
              if(rs.next() == false){            // tang them 1 dong cho rs va kiem tra
                     return null;
              }

              // doc thong tin cho phieu
              String id_Phieu = rs.getString("ID");
              String date_Phieu = rs.getString("Ngay");
              String ID_Nv = rs.getString("ID_NV");
              String ID_HoaDon = rs.getString("ID_HoaDon");
              int Tongtien = rs.getInt("TongTien");
              String tinhtrang = rs.getString("TinhTrang");

              // doc thong tin cac chi tiet trong phieu
              while (true) {
                     ChiTietPhieuDTO CT = new ChiTietPhieuDTO(null, null, 0, 0);

                     CT.setNameProduct(rs.getString("TenSP"));
                     CT.setMaSP(rs.getString("MaSP"));
                     CT.setSoLuong(rs.getInt("SoLuong"));
                     CT.setDonGia(rs.getInt("DonGia"));
                     temp.add(CT);

                     
                     // neu het chi tiet trong phieu se tu break
                     if (rs.next() == false) {
                            break;
                     }
              }
              phieuXuat = new PhieuXuatDTO(id_Phieu, date_Phieu, temp, Tongtien, ID_Nv, ID_HoaDon, tinhtrang);
              return phieuXuat;
       }

       @Override
       public ArrayList<PhieuXuatDTO> getList() throws SQLException {
              String sql = "SELECT * FROM tblPhieuXuat,tblChiTietPhieuXuat,tblPhieu WHERE ID = ID_PhieuXuat AND ID_PhieuXuat = ID_CTPhieuXuat ORDER BY ID ASC";
              PreparedStatement statement = data.prepareStatement(sql);

              // kiem tra xem data co rong khong 
              ResultSet check = statement.executeQuery();
              if(check.next() == false){
                     return null;
              }
              check.close();
              ResultSet rs1 = statement.executeQuery();
              ArrayList<PhieuXuatDTO> arr = new ArrayList<PhieuXuatDTO>();
              ArrayList<String> arrMaID = new ArrayList<String>();           // doc ma~ ID phieu co trong sql

              while (rs1.next()) {
                     String ID = rs1.getString("ID");
                     if(arrMaID.contains(ID) == false){                      // nếu mã chưa có thì thêm vào
                            arrMaID.add(ID);
                     }
                     
              }
              rs1.close();         // đóng kết nối 
              // for (String iterable_element : arrMaID) {
              //        System.out.println(iterable_element);
              // }
              int i = 0;                  // duyệt phần tử trong arrMaID
              ResultSet rs2 = statement.executeQuery();        // tạo con trỏ truy vấn 2 
              String ID = arrMaID.get(i);        // thiet lap maID ban dau 
              rs2.next();                        // tang con tro rs2 len 1 --> dong dau tien trong sql
              int flag = 0;                      // dieu kien dung 
              dsChiTietPhieuBUS temp = new dsChiTietPhieuBUS();
              String ID_NV = "";
              String date = "";
              String tinhTrang = "";
              String ID_HoaDon = "";
              int tongTien = -1;

              while(flag == 0){
                     // so sánh ID_Phieu xuất trong sql với ID thu đc trong mảng arrMaID
                     // nếu đúng :
                     //            - tạo 1 chi tiết phiếu rồi add vào mảng DS chi tiết phiếu 
                     //            - di chuyển con trỏ rs sang dòng tiếp theo và kiểm tra dòng tiếp theo có null không:
                     //                   + nếu dòng tiếp theo null thì tiến hành add phiếu cuối cùng vô mảng rồi hủy
                     //                          vòng lặp ( xử lý phiếu cuối cùng)
                     // nếu sai:        
                     //            - tạo một 1 phiếu mới với thông tin đã có ở trên rồi add vào mảng
                     //            - reset lại mảng chi tiết phiếu có trong phiếu
                     //            - tăng giá trị i duyệt lên để lấy mã tiếp theo trong mảng
                     if(rs2.getString("ID_PhieuXuat").equals(ID)){
                            // System.out.println(ID);
                            ID_NV = rs2.getString("ID_NV");
                            date = rs2.getString("Ngay");
                            tinhTrang = rs2.getString("TinhTrang");
                            ID_HoaDon = rs2.getString("ID_HoaDon");
                            tongTien = rs2.getInt("TongTien");
                            ChiTietPhieuDTO moi = new ChiTietPhieuDTO("", "", 0, 0);
                            moi.setNameProduct(rs2.getString("TenSP"));
                            moi.setMaSP(rs2.getString("MaSP"));
                            moi.setSoLuong(rs2.getInt("SoLuong"));
                            moi.setDonGia(rs2.getInt("DonGia"));
                            temp.add(moi);
                            if(rs2.next() == false){
                                   flag = -1;
                                   arr.add(new PhieuXuatDTO(ID, date, temp, tongTien, ID_NV, ID_HoaDon, tinhTrang));
                            }

                     }
                     else{
                            arr.add(new PhieuXuatDTO(ID, date, temp, tongTien, ID_NV, ID_HoaDon, tinhTrang));
                            temp = new dsChiTietPhieuBUS();
                            i++;
                            ID = arrMaID.get(i);
                            
                     }
              }
              rs2.close();         // đóng kết nối 

              // in phiếu kiểm tra 
              // for (PhieuXuat iterable_element : arr) {
              //        iterable_element.inPhieu();
              // }

              return arr;

       }

       @Override
       public boolean save(PhieuXuatDTO t) throws SQLException {
              if (t == null) {
                     throw new SQLException("Phieu xuat trong");
              }
              int check_1 = 0, check_2 = 0,check_3 = 0;

              String sql_Phieu = "INSERT INTO tblPhieu(ID,Ngay,ID_NV,Tongtien)"
              + "VALUES (?,?,?,?)";
              String sql_phieuxuat = "INSERT INTO tblPhieuXuat(ID_PhieuXuat,ID_HoaDon,TinhTrang)"
                            + "VALUES (?,?,?)";
              String sql_CTPhieuXuat = "INSERT INTO tblChiTietPhieuXuat(ID_CTPhieuXuat,TenSP,MaSP,SoLuong,DonGia)"
                            + "VALUES (?,?,?,?,?)";
              PreparedStatement statement1 = data.prepareStatement(sql_Phieu);
              PreparedStatement statement2 = data.prepareStatement(sql_phieuxuat);
              PreparedStatement statement3 = data.prepareStatement(sql_CTPhieuXuat);

              // phieu 
              statement1.setString(1, t.getIDPhieu());
              statement1.setString(2, t.getDate());
              statement1.setString(3, t.getIDNhanVien());
              statement1.setInt(4, t.getSumMoney());
              
              if (statement1.executeUpdate() > 0) {
                     check_1 = 1;
              }

              // Phieu Xuat
              statement2.setString(1, t.getIDPhieu());
              statement2.setString(2, t.getIDHoaDon());
              statement2.setString(3, t.getTinhTrang());

              if(statement2.executeUpdate() > 0){
                     check_2 = 1;
              }
              // chi tiet phieu xuat
              ChiTietPhieuDTO[] arr = t.getDsChitietphieu2().getChiTietPhieu2s();
              int sl_CT = t.getDsChitietphieu2().getIndex();

              for (int i = 0; i < sl_CT; i++) {
                     statement3.setString(1, t.getIDPhieu());
                     statement3.setString(2, arr[i].getNameProduct());
                     statement3.setString(3, arr[i].getMaSP());
                     statement3.setInt(4, arr[i].getSoLuong());
                     statement3.setInt(5, arr[i].getDonGia());
                     if (statement3.executeUpdate() > 0) {
                            check_3 = 1;
                     } else {
                            check_3 = 0;
                     }

              }
              return check_1 == check_2 && check_2 == check_3;
       }

       @Override
       public boolean update(PhieuXuatDTO t) throws SQLException {
              if( t == null){
                     throw new SQLException("Phieu Xuat rong");
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

       

}
