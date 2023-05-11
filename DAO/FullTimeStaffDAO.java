package DAO;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.*;
public class FullTimeStaffDAO extends DAODAL<FullTimeStaffDTO> implements Serializable {

       private PhieuNhapDAO data_PhieuNhap = new PhieuNhapDAO();
       private PhieuXuatDAO data_PhieuXuat = new PhieuXuatDAO();
       private HoaDonDAO data_HoaDon = new HoaDonDAO();

       @Override
       public boolean delete(FullTimeStaffDTO t) throws SQLException {
              
              if (check_delete(t.getId())) {
                     String sql_Address = String.format("DELETE FROM tblAddressStaff WHERE ID_NV = '%s' ", t.getId());

                     String sql_FullTime = String.format("DELETE FROM tblFullTimeStaff WHERE ID_FullTimeStaff = '%s' ",
                                   t.getId());

                     String sql_Staff = String.format("DELETE FROM tblStaff WHERE ID = '%s' ", t.getId());

                     PreparedStatement statement1 = data.prepareStatement(sql_Address);
                     PreparedStatement statement2 = data.prepareStatement(sql_FullTime);
                     PreparedStatement statement3 = data.prepareStatement(sql_Staff);

                     return statement1.executeUpdate() > 0 && statement2.executeUpdate() > 0
                                   && statement3.executeUpdate() > 0;
              }
              return false;

       }

       @Override
       public boolean deleteById(String id) throws SQLException {
              if (check_delete(id)) {
                     String sql_Address = String.format("DELETE FROM tblAddressStaff WHERE ID_NV = '%s' ", id);

                     String sql_FullTime = String.format("DELETE FROM tblFullTimeStaff WHERE ID_FullTimeStaff = '%s' ",
                                   id);

                     String sql_Staff = String.format("DELETE FROM tblStaff WHERE ID = '%s' ", id);

                     PreparedStatement statement1 = data.prepareStatement(sql_Address);
                     PreparedStatement statement2 = data.prepareStatement(sql_FullTime);
                     PreparedStatement statement3 = data.prepareStatement(sql_Staff);

                     return statement1.executeUpdate() > 0 && statement2.executeUpdate() > 0
                                   && statement3.executeUpdate() > 0;
              }
              return false;

       }

       @Override
       public FullTimeStaffDTO get(String id) throws SQLException {
              String sql = String.format(
                            "SELECT *FROM tblStaff,tblAddressStaff,tblFullTimeStaff WHERE ID = ID_NV AND ID = ID_FullTimeStaff AND ID = '%s' ",
                            id);

              PreparedStatement statement = data.prepareStatement(sql);
              ResultSet rs = statement.executeQuery();

              if (rs.next()) {
                     FullTimeStaffDTO fullTimeStaff = new FullTimeStaffDTO();
                     AddressDTO diachi = new AddressDTO();

                     diachi.setCity(rs.getString("ThanhPho"));
                     diachi.setDistrict(rs.getString("Quan"));
                     diachi.setStreet(rs.getString("SoNha"));

                     fullTimeStaff.setId(rs.getString("ID"));
                     fullTimeStaff.setName(rs.getString("Name"));
                     fullTimeStaff.setDate(rs.getString("Date_in"));
                     fullTimeStaff.setCmnd(rs.getString("CMND"));
                     fullTimeStaff.setGender(rs.getString("Gender"));
                     fullTimeStaff.setPassWord(rs.getString("Password"));
                     fullTimeStaff.setBaseSalary(rs.getInt("BaseSalary"));
                     fullTimeStaff.setBonusRate(rs.getFloat("BonusRate"));
                     fullTimeStaff.setWorkDays(rs.getInt("WorkDay"));
                     fullTimeStaff.setAddress(diachi);

                     return fullTimeStaff;
              }
              return null;
       }

       @Override
       public ArrayList<FullTimeStaffDTO> getList() throws SQLException {
              ArrayList<FullTimeStaffDTO> fullTimeStaffs = new ArrayList<FullTimeStaffDTO>();
              String sql = "SELECT *FROM tblStaff,tblAddressStaff,tblFullTimeStaff WHERE ID = ID_NV AND ID = ID_FullTimeStaff";

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
                     FullTimeStaffDTO fullTimeStaff = new FullTimeStaffDTO();
                     AddressDTO diachi = new AddressDTO();

                     diachi.setCity(rs.getString("ThanhPho"));
                     diachi.setDistrict(rs.getString("Quan"));
                     diachi.setStreet(rs.getString("SoNha"));

                     fullTimeStaff.setId(rs.getString("ID"));
                     fullTimeStaff.setName(rs.getString("Name"));
                     fullTimeStaff.setDate(rs.getString("Date_in"));
                     fullTimeStaff.setCmnd(rs.getString("CMND"));
                     fullTimeStaff.setGender(rs.getString("Gender"));
                     fullTimeStaff.setPassWord(rs.getString("Password"));
                     fullTimeStaff.setBaseSalary(rs.getInt("BaseSalary"));
                     fullTimeStaff.setBonusRate(rs.getFloat("BonusRate"));
                     fullTimeStaff.setWorkDays(rs.getInt("WorkDay"));
                     fullTimeStaff.setAddress(diachi);

                     fullTimeStaffs.add(fullTimeStaff);

              }
              return fullTimeStaffs;
       }

       @Override
       public boolean save(FullTimeStaffDTO t) throws SQLException {
              if (t == null) {
                     throw new SQLException("FullTimeStaff rong");
              }

              String sql_Staff = "INSERT INTO tblStaff(ID,Name,Date_in,Gender,CMND,Password,Salary)"
                            + "VALUES (?,?,?,?,?,?,?)";
              String sql_Address = "INSERT INTO tblAddressStaff(ID_NV,SoNha,Quan,ThanhPho)" + "VALUES (?,?,?,?)";
              String sql_FullTimeStaff = "INSERT INTO tblFullTimeStaff(ID_FullTimeStaff,BaseSalary,BonusRate,WorkDay)"
                            + "VALUES (?,?,?,?)";

              PreparedStatement statement1 = data.prepareStatement(sql_Staff);
              PreparedStatement statement2 = data.prepareStatement(sql_Address);
              PreparedStatement statement3 = data.prepareStatement(sql_FullTimeStaff);

              // thong tin chung nhan vien
              statement1.setString(1, t.getId());
              statement1.setString(2, t.getName());
              statement1.setString(3, t.getDate());
              statement1.setString(4, t.getGender());
              statement1.setString(5, t.getCmnd());
              statement1.setString(6, t.getPassWord());
              statement1.setFloat(7, t.tinhLuong());

              // dia nha nhan vien
              statement2.setString(1, t.getId());
              statement2.setString(2, t.getAddress().getStreet());
              statement2.setString(3, t.getAddress().getDistrict());
              statement2.setString(4, t.getAddress().getCity());

              // thong tin reing cua full time
              statement3.setString(1, t.getId());
              statement3.setInt(2, t.getBaseSalary());
              statement3.setFloat(3, t.getBonusRate());
              statement3.setInt(4, t.getWorkDays());

              return statement1.executeUpdate() > 0 && statement2.executeUpdate() > 0 && statement3.executeUpdate() > 0;
       }

       @Override
       public boolean update(FullTimeStaffDTO t) throws SQLException {
              String sql_Staff = String.format("UPDATE tblStaff SET Name = ?,Date_in = ?,Gender = ?,CMND = ?,Password = ?,Salary = ? WHERE ID = '%s' ", t.getId());
              String sql_Address = String.format("UPDATE tblAddressStaff SET SoNha = ?,Quan = ?,ThanhPho = ? WHERE ID_NV = '%s' ", t.getId());
              String sql_FullTimeStaff = String.format("UPDATE tblFullTimeStaff SET BaseSalary = ?,BonusRate = ?,WorkDay = ? WHERE ID_FullTimeStaff = '%s' ", t.getId());

              PreparedStatement statement1 = data.prepareStatement(sql_Staff);
              PreparedStatement statement2 = data.prepareStatement(sql_Address);
              PreparedStatement statement3 = data.prepareStatement(sql_FullTimeStaff);

              // thong tin chung nhan vien
              statement1.setString(1, t.getName());
              statement1.setString(2, t.getDate());
              statement1.setString(3, t.getGender());
              statement1.setString(4, t.getCmnd());
              statement1.setString(5, t.getPassWord());
              statement1.setFloat(6, t.tinhLuong());

              // dia nha nhan vien
              statement2.setString(1, t.getAddress().getStreet());
              statement2.setString(2, t.getAddress().getDistrict());
              statement2.setString(3, t.getAddress().getCity());

              // thong tin reing cua full time
              statement3.setInt(1, t.getBaseSalary());
              statement3.setFloat(2, t.getBonusRate());
              statement3.setInt(3, t.getWorkDays());

              return statement1.executeUpdate() > 0 && statement2.executeUpdate() > 0 && statement3.executeUpdate() > 0;
       }

       private boolean check_delete(String id) throws SQLException {
              ArrayList<PhieuNhapDTO> list_PhieuNhap = data_PhieuNhap.getList();
              ArrayList<PhieuXuatDTO> list_PhieuXuat = data_PhieuXuat.getList();
              ArrayList<HoaDonDTO> list_HoaDon = data_HoaDon.getList();

              int flag_PhieuNhap = 0, flag_PhieuXuat = 0, flag_HoaDon = 0;
              for (PhieuNhapDTO phieuNhap : list_PhieuNhap) {
                     if (phieuNhap.getIDNhanVien().equals(id)) {
                            flag_PhieuNhap = 1;
                     }
              }
              for (PhieuXuatDTO phieuXuat : list_PhieuXuat) {
                     if (phieuXuat.getIDNhanVien().equals(id)) {
                            flag_PhieuXuat = 1;
                     }
              }
              for (HoaDonDTO hoaDon : list_HoaDon) {
                     if (hoaDon.getManv().equals(id)) {
                            flag_HoaDon = 1;
                     }
              }
              if (flag_HoaDon == 0 && flag_PhieuNhap == 0 && flag_PhieuXuat == 0) {
                     return true;
              }
              return false;
       }

       public static void main(String[] args) {
              // try {
              //        FullTimeStaff fullTimeStaff = new FullTimeStaff("NV001", "1111", "Phuc", "Nam",
              //                      new Address("Long An", "quan 5", "so 85"), "2002", "123", 10, 10, 10);

              //        FullTimeStaffDAO test = new FullTimeStaffDAO();

              //        // System.out.println(test.save(fullTimeStaff));
              //        // FullTimeStaff oo = test.get("NV001");
              //        // oo.xuat();
              //        // System.out.println(test.delete(fullTimeStaff));
              //        // System.out.println(test.update(fullTimeStaff));
              //        // ArrayList<FullTimeStaff> fullTimeStaffs = test.getList();

              //        // for (FullTimeStaff iterable_element : fullTimeStaffs) {
              //        // iterable_element.xuat();
              //        // }

              // } catch (Exception e) {
              //        e.printStackTrace();
              // }
       }

}
