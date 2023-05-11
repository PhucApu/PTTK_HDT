package DAO;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.*;
public class FoodProductsDAO extends DAODAL<FoodDTO> implements Serializable {

       private PhieuXuatDAO data_PhieuXuat = new PhieuXuatDAO();
       private HoaDonDAO data_HoaDon = new HoaDonDAO();

       @Override
       public boolean delete(FoodDTO t) throws SQLException {
              if (check_delete(t.getMaSP())) {
                     String sql_Products = String.format("DELETE FROM tblProducts WHERE Ma_Product = '%s' ",
                                   t.getMaSP());

                     String sql_Food = String.format("DELETE FROM tblFood WHERE Ma_Food = '%s' ", t.getMaSP());

                     PreparedStatement statement1 = data.prepareStatement(sql_Food);
                     PreparedStatement statement2 = data.prepareStatement(sql_Products);
                     return statement1.executeUpdate() > 0 && statement2.executeUpdate() > 0;
              }
              return false;

       }

       @Override
       public boolean deleteById(String id) throws SQLException {
              if (check_delete(id)) {
                     String sql_Products = String.format("DELETE FROM tblProducts WHERE Ma_Product = '%s' ", id);

                     String sql_Food = String.format("DELETE FROM tblFood WHERE Ma_Food = '%s' ", id);

                     PreparedStatement statement1 = data.prepareStatement(sql_Food);
                     PreparedStatement statement2 = data.prepareStatement(sql_Products);
                     return statement1.executeUpdate() > 0 && statement2.executeUpdate() > 0;
              }
              return false;

       }

       @Override
       public FoodDTO get(String id) throws SQLException {
              String sql = String.format(
                            "SELECT * FROM tblFood,tblProducts WHERE Ma_Product = Ma_Food AND Ma_Product = '%s'", id);

              PreparedStatement statement = data.prepareStatement(sql);
              ResultSet rs = statement.executeQuery();

              if (rs.next()) {
                     FoodDTO food = new FoodDTO();

                     food.setMaSP(rs.getString("Ma_Product"));
                     food.setPrice(rs.getInt("Price"));
                     food.setNameProduct(rs.getString("Name"));
                     food.setTaxes(rs.getFloat("Taxes"));
                     food.setExpiry_date(rs.getString("ExpiryDate"));
                     food.setMaNCC(rs.getString("Ma_Supplier"));
                     food.setSoluong(rs.getInt("SoLuong"));
                     food.setSl_conlai(rs.getInt("SoLuong"));

                     if (rs.getString("Vegetarian").equals("Yes")) {
                            food.setVegetarian(true);
                     }
                     if (rs.getString("Vegetarian").equals("Yes") == false) {
                            food.setVegetarian(false);
                     }
                     if (rs.getString("Frozenfood").equals("Yes")) {
                            food.setFrozenfood(true);
                     }
                     if (rs.getString("Frozenfood").equals("Yes") == false) {
                            food.setFrozenfood(false);
                     }
                     return food;

              }
              return null;
       }

       @Override
       public ArrayList<FoodDTO> getList() throws SQLException {
              String sql = "SELECT * FROM tblFood,tblProducts WHERE Ma_Product = Ma_Food";
              ArrayList<FoodDTO> arr = new ArrayList<FoodDTO>();

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
                     FoodDTO food = new FoodDTO();

                     food.setMaSP(rs.getString("Ma_Product"));
                     food.setPrice(rs.getInt("Price"));
                     food.setNameProduct(rs.getString("Name"));
                     food.setTaxes(rs.getFloat("Taxes"));
                     food.setExpiry_date(rs.getString("ExpiryDate"));
                     food.setMaNCC(rs.getString("Ma_Supplier"));
                     food.setSoluong(rs.getInt("SoLuong"));
                     food.setSl_conlai(rs.getInt("SoLuong"));
                     if (rs.getString("Vegetarian").equals("Yes")) {
                            food.setVegetarian(true);
                     }
                     if (rs.getString("Vegetarian").equals("Yes") == false) {
                            food.setVegetarian(false);
                     }
                     if (rs.getString("Frozenfood").equals("Yes")) {
                            food.setFrozenfood(true);
                     }
                     if (rs.getString("Frozenfood").equals("Yes") == false) {
                            food.setFrozenfood(false);
                     }
                     arr.add(food);

              }
              return arr;
       }

       @Override
       public boolean save(FoodDTO t) throws SQLException {
              String sql_Products = "INSERT INTO tblProducts (Ma_Product,Name,Price,Taxes,ExpiryDate,Ma_Supplier,SoLuong) "
                            + " VALUES (?,?,?,?,?,?,?)";

              String sql_Food = "INSERT INTO tblFood (Ma_Food,Vegetarian,Frozenfood) " + " VALUES (?,?,?)";

              PreparedStatement statement1 = data.prepareStatement(sql_Products);
              PreparedStatement statement2 = data.prepareStatement(sql_Food);

              // thong tin products
              statement1.setString(1, t.getMaSP());
              statement1.setString(2, t.getNameProduct());
              statement1.setInt(3, t.getPrice());
              statement1.setDouble(4, t.getTaxes());
              statement1.setString(5, t.getExpiry_date());
              statement1.setString(6, t.getMaNCC());
              statement1.setInt(7, t.getSoluong());

              // Thong tin food
              statement2.setString(1, t.getMaSP());

              if (t.isVegetarian()) {
                     statement2.setString(2, "Yes");
              }
              if (t.isVegetarian() == false) {
                     statement2.setString(2, "No");
              }
              if (t.isFrozenfood()) {
                     statement2.setString(3, "Yes");
              }
              if (t.isFrozenfood() == false) {
                     statement2.setString(3, "No");
              }

              return statement1.executeUpdate() > 0 && statement2.executeUpdate() > 0;
       }

       @Override
       public boolean update(FoodDTO t) throws SQLException {
              if( t == null){
                     throw new SQLException("Food rong");
              }
              String sql_Food = String.format("UPDATE tblFood SET Vegetarian = ?, Frozenfood = ? WHERE Ma_Food = '%s' ", t.getMaSP());
              String sql_Products = String.format("UPDATE tblProducts SET Name = ?, Price = ?,Taxes = ?,ExpiryDate = ?,Ma_Supplier = ?,SoLuong = ? WHERE Ma_Product = '%s' ",t.getMaSP());

              PreparedStatement statement1 = data.prepareStatement(sql_Products);
              PreparedStatement statement2 = data.prepareStatement(sql_Food);

              // Thong tin food

              if (t.isVegetarian()) {
                     statement2.setString(1, "Yes");
              }
              if (t.isVegetarian() == false) {
                     statement2.setString(1, "No");
              }
              if (t.isFrozenfood()) {
                     statement2.setString(2, "Yes");
              }
              if (t.isFrozenfood() == false) {
                     statement2.setString(2, "No");
              }
              // thong tin products
              statement1.setString(1, t.getNameProduct());
              statement1.setInt(2, t.getPrice());
              statement1.setDouble(3, t.getTaxes());
              statement1.setString(4, t.getExpiry_date());
              statement1.setString(5, t.getMaNCC());
              statement1.setInt(6, t.getSoluong());
              
              return statement2.executeUpdate() > 0 && statement1.executeUpdate() > 0;
       }

       private boolean check_delete(String id) throws SQLException {
              ArrayList<PhieuXuatDTO> list_PhieuXuat = data_PhieuXuat.getList();
              ArrayList<HoaDonDTO> list_HoaDon = data_HoaDon.getList();

              int flag_PhieuXuat = 0, flag_HoaDon = 0;

              for (PhieuXuatDTO phieuXuat : list_PhieuXuat) {
                     ChiTietPhieuDTO[] temp = phieuXuat.getDsChitietphieu2().getChiTietPhieu2s();
                     int soluongCT = phieuXuat.getDsChitietphieu2().getIndex();
                     for (int i = 0; i < soluongCT; i++) {
                            if (temp[i].getMaSP().equals(id)) {
                                   flag_PhieuXuat = 1;
                            }
                     }

              }
              for (HoaDonDTO hoaDon : list_HoaDon) {
                     ArrayList<ChiTietHDDTO> temp = hoaDon.getDsCTHD().getCthd();
                     for (ChiTietHDDTO chiTietHD : temp) {
                            if (chiTietHD.getMaSP().equals(id)) {
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
              //        Food food = new Food("Thit", false, true, 10, "2020", "F001", "NCC001", 10, 5);
              //        FoodProductsDAO test = new FoodProductsDAO();
              //        // System.out.println(test.save(food));
              //        // Food oo =test.get("F001");
              //        // oo.xuatThongTin();
              //        // ArrayList<Food> foods = test.getList();
              //        // for (Food iterable_element : foods) {
              //        // iterable_element.xuatThongTin();
              //        // }
              //        System.out.println(test.delete(food));
              // } catch (Exception e) {
              //        e.printStackTrace();
              // }
       }

}