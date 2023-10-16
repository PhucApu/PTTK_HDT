package DAO;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BUS.dsChiTietPhieuBUS;
import DTO.ChiTietPhieuDTO;
import DTO.PhieuHuyDTO;


public class PhieuHuyDAO extends DAODAL<PhieuHuyDTO> implements Serializable  {
       @Override
       public boolean delete(PhieuHuyDTO t) throws SQLException {
              String sql_CTPhieu = String.format("DELETE FROM tblChiTietPhieuHuy WHERE ID_CTPhieuHuy = '%s' ",
                            t.getIDPhieu());

              String sql_PhieuHuy = String.format("DELETE FROM tblPhieuHuy WHERE ID_PhieuHuy = '%s' ", t.getIDPhieu());
              
              String sql_Phieu = String.format("DELETE FROM tblPhieu WHERE ID = '%s' ", t.getIDPhieu());

              PreparedStatement statement_Phieu = data.prepareStatement(sql_Phieu);

              PreparedStatement statement_PhieuNhap = data.prepareStatement(sql_PhieuHuy);

              PreparedStatement statement_CTPhieu = data.prepareStatement(sql_CTPhieu);

              return statement_CTPhieu.executeUpdate() > 0 && statement_PhieuNhap.executeUpdate() > 0 && statement_Phieu.executeUpdate() >0 ;
       }
       @Override
       public boolean deleteById(String id) throws SQLException {
              String sql_CTPhieu = String.format("DELETE FROM tblChiTietPhieuHuy WHERE ID_CTPhieuHuy = '%s' ",
                            id);

              String sql_PhieuNhap = String.format("DELETE FROM tblPhieuHuy WHERE ID_PhieuHuy = '%s' ", id);
              
              String sql_Phieu = String.format("DELETE FROM tblPhieu WHERE ID = '%s' ", id);

              PreparedStatement statement_Phieu = data.prepareStatement(sql_Phieu);

              PreparedStatement statement_PhieuNhap = data.prepareStatement(sql_PhieuNhap);

              PreparedStatement statement_CTPhieu = data.prepareStatement(sql_CTPhieu);

              return statement_CTPhieu.executeUpdate() > 0 && statement_PhieuNhap.executeUpdate() > 0 && statement_Phieu.executeUpdate() >0 ;
       }
       @Override
       public PhieuHuyDTO get(String id) throws SQLException {
              String sql = String.format(
                            "SELECT * FROM tblPhieuHuy,tblChiTietPhieuHuy,tblPhieu WHERE ID = ID_PhieuHuy AND ID_PhieuHuy = ID_CTPhieuHuy AND ID = '%s' ",
                            id);

              PreparedStatement statement = data.prepareStatement(sql);

              ResultSet rs = statement.executeQuery();                // dong so 0
              // System.out.println(rs.getRow());

              PhieuHuyDTO phieuHuy = null;

              dsChiTietPhieuBUS temp = new dsChiTietPhieuBUS();

              if(rs.next() == false){            // tang them 1 dong cho rs va kiem tra
                     return null;
              }
              // rs.next(); 
              // System.out.println(rs.getRow());

              // doc thong tin cho phieu nhap
              String id_Phieu = rs.getString("ID");
              String date_Phieu = rs.getString("Ngay");
              String ID_Nv = rs.getString("ID_NV");
              String LyDoHuy = rs.getString("Ly_Do_Huy");
              String TinhTrang = rs.getString("TinhTrang");
              int Tongtien = rs.getInt("TongTien");
              // System.out.println(rs.getRow());

              // doc thong tin cac chi tiet trong phieu
              while (true) {
                     // System.out.println(rs.getRow());
                     // String id_Phieu = rs.getString("ID");
                     // String date_Phieu = rs.getString("Ngay");
                     // String ID_Nv = rs.getString("ID_NV");
                     // String MaNSX = rs.getString("MaNSX");
                     // int Tongtien = rs.getInt("TongTien");

                     // while (rs.next()) {
                     // System.out.println(rs.getRow());
                     // ChiTietPhieu CT = new ChiTietPhieu(null, null, 0, 0);

                     // CT.setNameProduct(rs.getString("TenSP"));
                     // CT.setMaSP(rs.getString("MaSP"));
                     // CT.setSoLuong(rs.getInt("SoLuong"));
                     // CT.setDonGia(rs.getInt("DonGia"));
                     // temp.add(CT);

                     // }

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
              phieuHuy = new PhieuHuyDTO(id_Phieu, date_Phieu, temp, Tongtien, ID_Nv, LyDoHuy, TinhTrang);
              return phieuHuy;
       }
       @Override
       public ArrayList<PhieuHuyDTO> getList() throws SQLException {
              String sql = "SELECT * FROM tblPhieuHuy,tblChiTietPhieuHuy,tblPhieu WHERE ID = ID_PhieuHuy AND ID_PhieuHuy = ID_CTPhieuHuy ORDER BY ID ASC";
              PreparedStatement statement = data.prepareStatement(sql);
              // kiem tra xem data co rong khong 
              ResultSet check = statement.executeQuery();
              if(check.next() == false){
                     return null;
              }
              check.close();

              ResultSet rs1 = statement.executeQuery();               // dong 0

              ArrayList<PhieuHuyDTO> arr = new ArrayList<PhieuHuyDTO>();            

              ArrayList<String> arrMaID = new ArrayList<String>();           // doc ma~ ID phieu co trong sql

              while (rs1.next()) {
                     String ID = rs1.getString("ID");

                     if(arrMaID.contains(ID) == false){                      // nếu mã chưa có thì thêm vào
                            arrMaID.add(ID);            // N001 , N002 , N003 , N004 , N006
                     }
                     
              }
              rs1.close();         // đóng kết nối 
              
              
              int i = 0;                  // duyệt phần tử trong arrMaID
              ResultSet rs2 = statement.executeQuery();        // tạo con trỏ truy vấn 2 

              String ID = arrMaID.get(i);        // thiet lap maID ban dau   N001          
             
              rs2.next();                        // tang con tro rs2 len 1 --> dong dau tien trong sql

              int flag = 0;                      // dieu kien dung 

              dsChiTietPhieuBUS temp = new dsChiTietPhieuBUS();

              String ID_NV = "";
              String date = "";
              String LyDoHuy = "";
              String TinhTrang = "";

              while(flag == 0){
                     // so sánh ID_Phieu nhập trong sql với ID thu đc trong mảng arrMaID
                     // nếu đúng :
                     //            - tạo 1 chi tiết phiếu rồi add vào mảng DS chi tiết phiếu 
                     //            - di chuyển con trỏ rs sang dòng tiếp theo và kiểm tra dòng tiếp theo có null không:
                     //                   + nếu dòng tiếp theo null thì tiến hành add phiếu cuối cùng vô mảng rồi hủy
                     //                          vòng lặp ( xử lý phiếu cuối cùng)
                     // nếu sai:        
                     //            - tạo một 1 phiếu mới với thông tin đã có ở trên rồi add vào mảng
                     //            - reset lại mảng chi tiết phiếu có trong phiếu
                     //            - tăng giá trị i duyệt lên để lấy mã tiếp theo trong mảng
                     if(rs2.getString("ID_PhieuHuy").equals(ID)){    
                            // System.out.println(ID);

                            ID_NV = rs2.getString("ID_NV");
                            date = rs2.getString("Ngay");
                            LyDoHuy = rs2.getString("Ly_Do_Huy");
                            TinhTrang = rs2.getString("TinhTrang");

                            ChiTietPhieuDTO moi = new ChiTietPhieuDTO("", "", 0, 0);

                            moi.setNameProduct(rs2.getString("TenSP"));
                            moi.setMaSP(rs2.getString("MaSP"));
                            moi.setSoLuong(rs2.getInt("SoLuong"));
                            moi.setDonGia(rs2.getInt("DonGia"));

                            temp.add(moi);              // tehm chi tiet vao ds chi tiet phieu

                            if(rs2.next() == false){
                                   flag = -1;           
                                   arr.add(new PhieuHuyDTO(ID, date, temp, temp.Sum_money(), ID_NV, LyDoHuy,TinhTrang));
                            }

                     }
                     else{
                            arr.add(new PhieuHuyDTO(ID, date, temp, temp.Sum_money(), ID_NV,LyDoHuy,TinhTrang));

                            temp = new dsChiTietPhieuBUS();           // danh sach moi 
                            i++;          
                            ID = arrMaID.get(i);               // N002
                            
                     }
              }
              rs2.close();         // đóng kết nối 
              
              // in phiếu kiểm tra 
              // for (PhieuNhap iterable_element : arr) {
              //        iterable_element.inPhieu();
              // }

              return arr;
       }
       @Override
       public boolean save(PhieuHuyDTO t) throws SQLException {
              if (t == null) {
                     throw new SQLException("Phieu Nhap rong");
              }
              int check_1 = 0, check_2 = 0,check_3 = 0;

              String sql_Phieu = "INSERT INTO tblPhieu(ID,Ngay,ID_NV,Tongtien)"
              + "VALUES (?,?,?,?)";
              String sql_phieunhap = "INSERT INTO tblPhieuHuy(ID_PhieuHuy,Ly_Do_Huy,TinhTrang)"
                            + "VALUES (?,?,?)";
              String sql_CTPhieuNhap = "INSERT INTO tblChiTietPhieuHuy(ID_CTPhieuHuy,TenSP,MaSP,SoLuong,DonGia)"
                            + "VALUES (?,?,?,?,?)";
              PreparedStatement statement1 = data.prepareStatement(sql_Phieu);
              PreparedStatement statement2 = data.prepareStatement(sql_phieunhap);
              PreparedStatement statement3 = data.prepareStatement(sql_CTPhieuNhap);

              // phieu 
              statement1.setString(1, t.getIDPhieu());
              statement1.setString(2, t.getDate());
              statement1.setString(3, t.getIDNhanVien());
              statement1.setInt(4, t.getSumMoney());
              
              if (statement1.executeUpdate() > 0) {
                     check_1 = 1;
              }
              
              // Phieu Nhap
              statement2.setString(1, t.getIDPhieu());
              statement2.setString(2, t.getLyDoHuy());
              statement2.setString(3, t.getTinhTrang());
              

              // CT phieu nhap
              ChiTietPhieuDTO[] arr = t.getDsChitietphieu2().getChiTietPhieu2s();
              int sl_CT = t.getDsChitietphieu2().getIndex();

              
              if(statement2.executeUpdate() > 0){
                     check_2 = 1;
              }

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
       public boolean update(PhieuHuyDTO t) throws SQLException {
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
       
       

}
