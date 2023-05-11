package DAO;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.*;
import BUS.*;
public class SeasonalStaffDAO extends DAODAL<SeasonalStaffDTO> implements Serializable {

       private PhieuNhapDAO data_PhieuNhap = new PhieuNhapDAO();
       private PhieuXuatDAO data_PhieuXuat = new PhieuXuatDAO();
       private HoaDonDAO data_HoaDon = new HoaDonDAO();

       @Override
       public boolean delete(SeasonalStaffDTO t) throws SQLException {
              if (check_delete(t.getId())) {
                     String sql_Address = String.format("DELETE FROM tblAddressStaff WHERE ID_NV = '%s' ", t.getId());

                     String sql_Seasonal = String.format("DELETE FROM tblSeasonalStaff WHERE ID_Seasonal = '%s' ",
                                   t.getId());

                     String sql_Staff = String.format("DELETE FROM tblStaff WHERE ID = '%s' ", t.getId());

                     PreparedStatement statement1 = data.prepareStatement(sql_Address);
                     PreparedStatement statement2 = data.prepareStatement(sql_Seasonal);
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

                     String sql_Seasonal = String.format("DELETE FROM tblSeasonalStaff WHERE ID_Seasonal = '%s' ", id);

                     String sql_Staff = String.format("DELETE FROM tblStaff WHERE ID = '%s' ", id);

                     PreparedStatement statement1 = data.prepareStatement(sql_Address);
                     PreparedStatement statement2 = data.prepareStatement(sql_Seasonal);
                     PreparedStatement statement3 = data.prepareStatement(sql_Staff);

                     return statement1.executeUpdate() > 0 && statement2.executeUpdate() > 0
                                   && statement3.executeUpdate() > 0;
              }
              return false;

       }

       @Override
       public SeasonalStaffDTO get(String id) throws SQLException {
              String sql = String.format(
                            "SELECT *FROM tblStaff,tblAddressStaff,tblSeasonalStaff WHERE ID = ID_NV AND ID = ID_Seasonal AND ID = '%s' ",
                            id);

              PreparedStatement statement = data.prepareStatement(sql);
              ResultSet rs = statement.executeQuery();

              if (rs.next()) {
                     SeasonalStaffDTO seasonalStaff = new SeasonalStaffDTO();
                     AddressDTO diachi = new AddressDTO();
                     diachi.setCity(rs.getString("ThanhPho"));
                     diachi.setDistrict(rs.getString("Quan"));
                     diachi.setStreet(rs.getString("SoNha"));

                     seasonalStaff.setId(rs.getString("ID"));
                     seasonalStaff.setName(rs.getString("Name"));
                     seasonalStaff.setDate(rs.getString("Date_in"));
                     seasonalStaff.setCmnd(rs.getString("CMND"));
                     seasonalStaff.setGender(rs.getString("Gender"));
                     seasonalStaff.setPassWord(rs.getString("Password"));
                     seasonalStaff.setHourlyWage(rs.getInt("HourlyWage"));
                     seasonalStaff.setWorkHours(rs.getInt("WorkHours"));
                     seasonalStaff.setAddress(diachi);
                     return seasonalStaff;
              }
              return null;
       }

       @Override
       public ArrayList<SeasonalStaffDTO> getList() throws SQLException {
              ArrayList<SeasonalStaffDTO> seasonalStaffs = new ArrayList<SeasonalStaffDTO>();
              String sql = "SELECT *FROM tblStaff,tblAddressStaff,tblSeasonalStaff WHERE ID = ID_NV AND ID = ID_Seasonal";

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
                     SeasonalStaffDTO seasonalStaff = new SeasonalStaffDTO();
                     AddressDTO diachi = new AddressDTO();

                     diachi.setCity(rs.getString("ThanhPho"));
                     diachi.setDistrict(rs.getString("Quan"));
                     diachi.setStreet(rs.getString("SoNha"));

                     seasonalStaff.setId(rs.getString("ID"));
                     seasonalStaff.setName(rs.getString("Name"));
                     seasonalStaff.setDate(rs.getString("Date_in"));
                     seasonalStaff.setCmnd(rs.getString("CMND"));
                     seasonalStaff.setGender(rs.getString("Gender"));
                     seasonalStaff.setPassWord(rs.getString("Password"));
                     seasonalStaff.setHourlyWage(rs.getInt("HourlyWage"));
                     seasonalStaff.setWorkHours(rs.getInt("WorkHours"));
                     seasonalStaff.setAddress(diachi);

                     seasonalStaffs.add(seasonalStaff);

              }
              return seasonalStaffs;
       }

       @Override
       public boolean save(SeasonalStaffDTO t) throws SQLException {
              if (t == null) {
                     throw new SQLException("FullTimeStaff rong");
              }
              String sql_Staff = "INSERT INTO tblStaff(ID,Name,Date_in,Gender,CMND,Password,Salary)"
                            + "VALUES (?,?,?,?,?,?,?)";
              String sql_Address = "INSERT INTO tblAddressStaff(ID_NV,SoNha,Quan,ThanhPho)" + "VALUES (?,?,?,?)";
              String sql_SeasonalStaff = "INSERT INTO tblSeasonalStaff(ID_Seasonal,HourlyWage,WorkHours)"
                            + "VALUES (?,?,?)";

              PreparedStatement statement1 = data.prepareStatement(sql_Staff);
              PreparedStatement statement2 = data.prepareStatement(sql_Address);
              PreparedStatement statement3 = data.prepareStatement(sql_SeasonalStaff);

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

              // thong tin seasonal staff
              statement3.setString(1, t.getId());
              statement3.setInt(2, t.getHourlyWage());
              statement3.setInt(3, t.getWorkHours());

              return statement1.executeUpdate() > 0 && statement2.executeUpdate() > 0 && statement3.executeUpdate() > 0;
       }

       @Override
       public boolean update(SeasonalStaffDTO t) throws SQLException {
              String sql_Staff = String.format("UPDATE tblStaff SET Name = ?,Date_in = ?,Gender = ?,CMND = ?,Password = ?,Salary = ? WHERE ID = '%s' ", t.getId());
              String sql_Address = String.format("UPDATE tblAddressStaff SET SoNha = ?,Quan = ?,ThanhPho = ? WHERE ID_NV = '%s' ", t.getId());
              String sql_SeasonalStaff = String.format("UPDATE tblSeasonalStaff SET HourlyWage = ? , WorkHours = ? WHERE ID_Seasonal = '%s' ", t.getId());

              PreparedStatement statement1 = data.prepareStatement(sql_Staff);
              PreparedStatement statement2 = data.prepareStatement(sql_Address);
              PreparedStatement statement3 = data.prepareStatement(sql_SeasonalStaff);

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

              // thong tin seasonal staff
              statement3.setInt(1, t.getHourlyWage());
              statement3.setInt(2, t.getWorkHours());

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
}
