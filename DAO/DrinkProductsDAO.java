package DAO;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.*;
public class DrinkProductsDAO extends DAODAL<DrinkDTO>  implements Serializable{

       private PhieuXuatDAO data_PhieuXuat = new PhieuXuatDAO();
       private HoaDonDAO data_HoaDon = new HoaDonDAO();
       
       @Override
       public boolean delete(DrinkDTO t) throws SQLException {
              if(check_delete(t.getMaSP())){
                     String sql_Products = String.format("DELETE FROM tblProducts WHERE Ma_Product = '%s' ", t.getMaSP());

                     String sql_Drink = String.format("DELETE FROM tblDrink WHERE Ma_Drink = '%s' ", t.getMaSP());
       
                     PreparedStatement statement1 = data.prepareStatement(sql_Products);

                     PreparedStatement statement2 = data.prepareStatement(sql_Drink);
                     
                     return statement2.executeUpdate() > 0 && statement1.executeUpdate() > 0;
              }
              return false;
              
       }

       @Override
       public boolean deleteById(String id) throws SQLException {
              if(check_delete(id)){
                     String sql_Products = String.format("DELETE FROM tblProducts WHERE Ma_Product = '%s' ", id);

                     String sql_Drink = String.format("DELETE FROM tblDrink WHERE Ma_Drink = '%s' ", id);
       
                     PreparedStatement statement1 = data.prepareStatement(sql_Products);
                     PreparedStatement statement2 = data.prepareStatement(sql_Drink);
                     return statement2.executeUpdate() > 0 && statement1.executeUpdate() > 0;
              }
              return false;
              
       }

       @Override
       public DrinkDTO get(String id) throws SQLException {
              String sql = String.format(
                            "SELECT * FROM tblDrink,tblProducts WHERE Ma_Product = Ma_Drink AND Ma_Product = '%s'", id);

              PreparedStatement statement = data.prepareStatement(sql);      
              ResultSet rs = statement.executeQuery();                       

              if (rs.next()) {
                     DrinkDTO drink = new DrinkDTO();
                     drink.setMaSP(rs.getString("Ma_Product"));
                     drink.setPrice(rs.getInt("Price"));
                     drink.setNameProduct(rs.getString("Name"));
                     drink.setTaxes(rs.getFloat("Taxes"));
                     drink.setExpiry_date(rs.getString("ExpiryDate"));
                     drink.setMaNCC(rs.getString("Ma_Supplier"));
                     drink.setSoluong(rs.getInt("SoLuong"));
                     drink.setSl_conlai(rs.getInt("SoLuong"));
                     if (rs.getString("Alcoholic").equals("Yes")) {
                            drink.setAlcoholic(true);
                     }
                     if (rs.getString("Alcoholic").equals("Yes") == false) {
                            drink.setAlcoholic(false);
                     }
                     return drink;
              }
              return null;
       }

       @Override
       public ArrayList<DrinkDTO> getList() throws SQLException {
              String sql = "SELECT * FROM tblDrink,tblProducts WHERE Ma_Product = Ma_Drink";
              ArrayList<DrinkDTO> arr = new ArrayList<DrinkDTO>();

              PreparedStatement statement = data.prepareStatement(sql);
              // truy xuat thi dung excuteQuery()
              ResultSet check = statement.executeQuery();
              // kiem tra xem data co rong khong
              if (check.next() == false) {
                     return null;
              }
              check.close();

              ResultSet rs = statement.executeQuery();

              while (rs.next()) {
                     DrinkDTO drink = new DrinkDTO();
                     drink.setMaSP(rs.getString("Ma_Product"));
                     drink.setPrice(rs.getInt("Price"));
                     drink.setNameProduct(rs.getString("Name"));
                     drink.setTaxes(rs.getFloat("Taxes"));
                     drink.setExpiry_date(rs.getString("ExpiryDate"));
                     drink.setMaNCC(rs.getString("Ma_Supplier"));
                     drink.setSoluong(rs.getInt("SoLuong"));
                     drink.setSl_conlai(rs.getInt("SoLuong"));
                     if (rs.getString("Alcoholic").equals("Yes")) {
                            drink.setAlcoholic(true);
                     }
                     if (rs.getString("Alcoholic").equals("Yes") == false) {
                            drink.setAlcoholic(false);
                     }
                     arr.add(drink);
              }
              return arr;
       }

       @Override
       public boolean save(DrinkDTO t) throws SQLException {
              String sql_Products = "INSERT INTO tblProducts (Ma_Product,Name,Price,Taxes,ExpiryDate,Ma_Supplier,SoLuong) "
                            + " VALUES (?,?,?,?,?,?,?)";
              String sql_Drink = "INSERT INTO tblDrink (Ma_Drink,Alcoholic) " + " VALUES (?,?)";

              PreparedStatement statement1 = data.prepareStatement(sql_Products);
              PreparedStatement statement2 = data.prepareStatement(sql_Drink);

              // thong tin products
              statement1.setString(1, t.getMaSP());
              statement1.setString(2, t.getNameProduct());
              statement1.setInt(3, t.getPrice());
              statement1.setDouble(4, t.getTaxes());
              statement1.setString(5, t.getExpiry_date());
              statement1.setString(6, t.getMaNCC());
              statement1.setInt(7, t.getSoluong());

              // Thong tin Drink
              statement2.setString(1, t.getMaSP());
              if (t.isAlcoholic()) {
                     statement2.setString(2, "Yes");
              }
              if (t.isAlcoholic() == false) {
                     statement2.setString(2, "No");
              }
              return statement1.executeUpdate() > 0 && statement2.executeUpdate() > 0;
       }

       @Override
       public boolean update(DrinkDTO t) throws SQLException {
              if(t == null){
                     throw new SQLException("Drink rong");
              }
              String sql_Drink = String.format("UPDATE tblDrink SET Alcoholic = ? WHERE Ma_Drink ='%s'  ",t.getMaSP() ) ;
              String sql_Products = String.format("UPDATE tblProducts SET Name = ?, Price = ?,Taxes = ?,ExpiryDate = ?,Ma_Supplier = ?,SoLuong = ? WHERE Ma_Product = '%s' ",t.getMaSP());

              PreparedStatement statement1 = data.prepareStatement(sql_Products);
              PreparedStatement statement2 = data.prepareStatement(sql_Drink);
              
              // Thong tin Drink
              statement2.setString(1, t.getMaSP());
              if (t.isAlcoholic()) {
                     statement2.setString(1, "Yes");
              }
              if (t.isAlcoholic() == false) {
                     statement2.setString(1, "No");
              }
              // thong tin products
              statement1.setString(1, t.getNameProduct());
              statement1.setInt(2, t.getPrice());
              statement1.setDouble(3, t.getTaxes());
              statement1.setString(4, t.getExpiry_date());
              statement1.setString(5, t.getMaNCC());
              statement1.setInt(6, t.getSoluong());

              // int check_1 = 0, check_2 = 0;
              // if (delete(t)) {
              //        check_1 = 1;
              // }
              // if (save(t)) {
              //        check_2 = 1;
              // }
              // return check_1 == check_2;
              return statement2.executeUpdate() > 0 && statement1.executeUpdate() > 0;

       }
       // ham kiem tra
       private boolean check_delete(String id) throws SQLException {

              ArrayList<PhieuXuatDTO> list_PhieuXuat = data_PhieuXuat.getList();
              ArrayList<HoaDonDTO> list_HoaDon = data_HoaDon.getList();

              int  flag_PhieuXuat = 0, flag_HoaDon = 0;

              for (PhieuXuatDTO phieuXuat : list_PhieuXuat) {
                            // phieu xuat : doi tuong dsChiTietPhieu
                            // getDsChitietphieu2 --> doi tuong class dsChiTietPhieu 
                            // dsChiTietPhieu.getChiTietPhieu2s       --> lay cai mang trong doi tuong do
                            ChiTietPhieuDTO [] temp = phieuXuat.getDsChitietphieu2().getChiTietPhieu2s();

                            int soluongCT = phieuXuat.getDsChitietphieu2().getIndex();

                            for (int i = 0; i < soluongCT; i++) {
                                   if (temp[i].getMaSP().equals(id)) {
                                          flag_PhieuXuat = 1;
                                   }
                            }

              }
              for (HoaDonDTO hoaDon : list_HoaDon) {
                            ArrayList<ChiTietHDDTO> temp =  hoaDon.getDsCTHD().getCthd();
                            for (ChiTietHDDTO chiTietHD : temp) { 
                                   if(chiTietHD.getMaSP().equals(id)){
                                          flag_HoaDon = 1;
                                   }
                            }
              }
              if (flag_HoaDon == 0 && flag_PhieuXuat == 0) {
                     return true;
              }
              return false;
       }
       public static void main(String[] args) {
              // try {
              //        Drink drink = new Drink("Ruou", false, 10, "2002", 5, "D001", "NCC001", 10);

              //        DrinkProductsDAO test = new DrinkProductsDAO();
              //        System.out.println(test.update(drink));
              // } catch (Exception e) {
              //        e.printStackTrace();
              //        // TODO: handle exception
              // }

       }
}
