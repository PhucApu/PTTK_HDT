package DAO;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.*;
public class SupplierDAO extends DAODAL<SupplierDTO> implements Serializable {

       // dung de kiem tra truoc khi xoa mot supplier
       private FoodProductsDAO data_food = new FoodProductsDAO();
       private DrinkProductsDAO data_drink = new DrinkProductsDAO();
       private PhieuNhapDAO data_PhieuNhap = new PhieuNhapDAO();

       @Override
       public boolean delete(SupplierDTO t) throws SQLException {
              if (check_delete(t.getMa()) == true) {
                     String sql_NCC = String.format("DELETE FROM tblSupplier WHERE Ma = '%s' ", t.getMa());
                     String sql_Address = String.format("DELETE FROM tblAddressSupplier WHERE MaNCC = '%s'", t.getMa());
                     PreparedStatement statement1 = data.prepareStatement(sql_Address);
                     PreparedStatement statement2 = data.prepareStatement(sql_NCC);
                     return statement1.executeUpdate() > 0 && statement2.executeUpdate() > 0;
              }
              return false;

       }

       @Override
       public boolean deleteById(String id) throws SQLException {
              if (check_delete(id) == true) {
                     String sql_NCC = String.format("DELETE FROM tblSupplier WHERE Ma = '%s' ", id);
                     String sql_Address = String.format("DELETE FROM tblAddressSupplier WHERE MaNCC = '%s'", id);
                     PreparedStatement statement1 = data.prepareStatement(sql_Address);
                     PreparedStatement statement2 = data.prepareStatement(sql_NCC);
                     return statement1.executeUpdate() > 0 && statement2.executeUpdate() > 0;
              }
              return false;

       }

       @Override
       public SupplierDTO get(String id) throws SQLException {
              String sql = String.format("SELECT * FROM tblSupplier,tblAddressSupplier WHERE Ma = MaNCC AND Ma = '%s' ",
                            id);
              PreparedStatement statement = data.prepareStatement(sql);

              ResultSet rs = statement.executeQuery();
              if (rs.next()) {
                     SupplierDTO supplier = new SupplierDTO();
                     AddressDTO diachi = new AddressDTO();
                     diachi.setCity(rs.getString("ThanhPho"));
                     diachi.setDistrict(rs.getString("Quan"));
                     diachi.setStreet(rs.getString("SoNha"));

                     supplier.setEmail(rs.getString("Email"));
                     supplier.setMa(rs.getString("Ma"));
                     supplier.setName(rs.getString("Ten"));
                     supplier.setSdt(rs.getString("SoDT"));
                     supplier.setAddress(diachi);
                     return supplier;

              }
              return null;
       }

       @Override
       public ArrayList<SupplierDTO> getList() throws SQLException {
              ArrayList<SupplierDTO> suppliers = new ArrayList<SupplierDTO>();
              String sql = "SELECT * FROM tblSupplier,tblAddressSupplier WHERE Ma = MaNCC";

              PreparedStatement statement = data.prepareStatement(sql);
              // truy xuat thi dung excuteQuery()

              ResultSet check = statement.executeQuery();
              // kiem tra xem data co rong khong
              if (check.next() == false) {
                     return null;
              }
              ResultSet rs = statement.executeQuery();
              check.close();
              while (rs.next()) {
                     SupplierDTO supplier = new SupplierDTO();
                     AddressDTO diachi = new AddressDTO();
                     diachi.setCity(rs.getString("ThanhPho"));
                     diachi.setDistrict(rs.getString("Quan"));
                     diachi.setStreet(rs.getString("SoNha"));

                     supplier.setEmail(rs.getString("Email"));
                     supplier.setMa(rs.getString("Ma"));
                     supplier.setName(rs.getString("Ten"));
                     supplier.setSdt(rs.getString("SoDT"));
                     supplier.setAddress(diachi);

                     suppliers.add(supplier);
              }
              return suppliers;

       }

       @Override
       public boolean save(SupplierDTO t) throws SQLException {
              if (t == null) {
                     throw new SQLException("Supplier rong");
              }
              String sql_Supplier = "INSERT INTO tblSupplier(Ma,Ten,SoDT,Email)" + "VALUES (?,?,?,?)";
              String sql_Address = "INSERT INTO tblAddressSupplier(MaNCC,SoNha,Quan,ThanhPho)" + "VALUES (?,?,?,?)";
              PreparedStatement statement1 = data.prepareStatement(sql_Supplier);
              PreparedStatement statement2 = data.prepareStatement(sql_Address);

              // Thong tin nha cung cap
              statement1.setString(1, t.getMa());
              statement1.setString(2, t.getName());
              statement1.setString(3, t.getSdt());
              statement1.setString(4, t.getEmail());
              // dia chi nha cung cap
              statement2.setString(1, t.getMa());
              statement2.setString(2, t.getAddress().getStreet());
              statement2.setString(3, t.getAddress().getDistrict());
              statement2.setString(4, t.getAddress().getCity());

              // luu thanh cong
              return statement1.executeUpdate() > 0 && statement2.executeUpdate() > 0;

       }

       @Override
       public boolean update(SupplierDTO t) throws SQLException {
              if (t == null) {
                     throw new SQLException("Supplier rong");
              }
              String sql = String.format("UPDATE tblSupplier "+
              "SET Ten = ?, SoDt = ? ,Email = ?" +" WHERE Ma = '%s' ",t.getMa());
              String sql2 = String.format("UPDATE tblAddressSupplier "+
              "SET SoNha = ?, Quan = ? ,ThanhPho = ? WHERE MaNCC = '%s' ",
              t.getMa());
              PreparedStatement statement1 = data.prepareStatement(sql);
              PreparedStatement statement2 = data.prepareStatement(sql2);

              statement1.setString(1, t.getName());
              statement1.setString(2, t.getSdt());
              statement1.setString(3, t.getEmail());

              statement2.setString(1, t.getAddress().getStreet());
              statement2.setString(2, t.getAddress().getDistrict());
              statement2.setString(3, t.getAddress().getCity());

              return statement2.executeUpdate() > 0 && statement1.executeUpdate() > 0;

              // luu thanh cong
              // int check_1 = 0, check_2 = 0;
              // if (delete(t)) {
              //        check_1 = 1;
              // }
              // if (save(t)) {
              //        check_2 = 1;
              // }
              // return check_1 == check_2;
       }

       private boolean check_delete(String id) {
              try {

                     ArrayList<FoodDTO> list_food = data_food.getList();
                     ArrayList<DrinkDTO> list_Drink = data_drink.getList();
                     ArrayList<PhieuNhapDTO> list_PhieuNhap = data_PhieuNhap.getList();

                     int flag_food= 0,flag_drink = 0,flag_PhieuNhap = 0;
                     for (FoodDTO food : list_food) {
                            if (food.getMaNCC().equals(id)) {
                                   flag_food = 1;
                            }
                     }
                     for (DrinkDTO drink : list_Drink) {
                            if (drink.getMaNCC().equals(id)) {
                                   flag_drink = 1;
                            }
                     }
                     for (PhieuNhapDTO phieuNhap : list_PhieuNhap) {
                            if (phieuNhap.getMaNXS().equals(id)) {
                                   flag_PhieuNhap = 1;
                            }
                     }
                     if (flag_PhieuNhap == 0 && flag_food == 0 && flag_drink == 0) {
                            return true;
                     }

              } catch (Exception e) {
                     e.printStackTrace();
              }
              return false;
       }

       public static void main(String[] args) throws SQLException {
              // Supplier team = new Supplier("Toan", new Address("Long an", "quan 5", "So 85"), "0823072871",
              //               "truongphuc056@gmail.com", "NV001");
              // SupplierDAO test = new SupplierDAO();
              // // System.out.println(test.save(team));
              // // System.out.println(test.update(team));
              // // System.out.println(test.delete(team));
              // ArrayList<Supplier> arr = test.getList();
              // System.out.println(arr.size());
              // for (Supplier iterable_element : arr) {
              //        iterable_element.xuatThongTin();
              // }
              // Supplier oo = test.get("NV001");
              // oo.xuatThongTin();
       }

}
