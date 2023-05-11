package DAO;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.*;
import BUS.*;
public class ManagerDAO extends DAODAL<ManagerDTO> implements Serializable {

       @Override
       public boolean delete(ManagerDTO t) throws SQLException {
              String sql_Manager = String.format("DELETE FROM tblManager WHERE ID_Manager = '%s' ", t.getId());

              String sql_Address = String.format("DELETE FROM tblAddressStaff WHERE ID_NV = '%s' ", t.getId()) ;

              String sql_FullTime = String.format("DELETE FROM tblFullTimeStaff WHERE ID_FullTimeStaff = '%s' ", t.getId()) ;

              String sql_Staff = String.format("DELETE FROM tblStaff WHERE ID = '%s' ", t.getId()) ;

              PreparedStatement statement = data.prepareStatement(sql_Manager);
              PreparedStatement statement1 = data.prepareStatement(sql_Address);
              PreparedStatement statement2 = data.prepareStatement(sql_FullTime);
              PreparedStatement statement3 = data.prepareStatement(sql_Staff);

              return statement.executeUpdate() > 0 && statement1.executeUpdate() > 0 && statement2.executeUpdate() > 0 && statement3.executeUpdate() > 0;
       }

       @Override
       public boolean deleteById(String id) throws SQLException {
              String sql_Manager = String.format("DELETE FROM tblManager WHERE ID_Manager = '%s' ", id);

              String sql_Address = String.format("DELETE FROM tblAddressStaff WHERE ID_NV = '%s' ", id) ;

              String sql_FullTime = String.format("DELETE FROM tblFullTimeStaff WHERE ID_FullTimeStaff = '%s' ", id) ;

              String sql_Staff = String.format("DELETE FROM tblStaff WHERE ID = '%s' ", id) ;

              PreparedStatement statement = data.prepareStatement(sql_Manager);
              PreparedStatement statement1 = data.prepareStatement(sql_Address);
              PreparedStatement statement2 = data.prepareStatement(sql_FullTime);
              PreparedStatement statement3 = data.prepareStatement(sql_Staff);

              return statement.executeUpdate() > 0 && statement1.executeUpdate() > 0 && statement2.executeUpdate() > 0 && statement3.executeUpdate() > 0;
       }

       @Override
       public ManagerDTO get(String id) throws SQLException {
              String sql = String.format("SELECT *FROM tblStaff,tblAddressStaff,tblFullTimeStaff,tblManager WHERE ID = ID_NV AND ID = ID_FullTimeStaff AND ID_FullTimeStaff = ID_Manager AND ID = '%s' ", id);

              PreparedStatement statement = data.prepareStatement(sql);
              ResultSet rs = statement.executeQuery();

              if(rs.next()){
                     ManagerDTO manager = new ManagerDTO();
                     AddressDTO diachi = new AddressDTO();

                     diachi.setCity(rs.getString("ThanhPho"));
                     diachi.setDistrict(rs.getString("Quan"));
                     diachi.setStreet(rs.getString("SoNha"));

                     manager.setId(rs.getString("ID"));
                     manager.setName(rs.getString("Name"));
                     manager.setDate(rs.getString("Date_in"));
                     manager.setCmnd(rs.getString("CMND"));
                     manager.setGender(rs.getString("Gender"));
                     manager.setPassWord(rs.getString("Password"));

                     manager.setBaseSalary(rs.getInt("BaseSalary"));
                     manager.setWorkDays(rs.getInt("WorkDay"));
                     manager.setBonusRate(rs.getFloat("BonusRate"));
                     manager.setAllowance(rs.getInt("Allowance"));
                     manager.setAddress(diachi);
                     return manager;
              }
              return null;
       }

       @Override
       public ArrayList<ManagerDTO> getList() throws SQLException {
              ArrayList<ManagerDTO> managers = new ArrayList<ManagerDTO>();
              String sql = "SELECT *FROM tblStaff,tblAddressStaff,tblFullTimeStaff,tblManager WHERE ID = ID_NV AND ID = ID_FullTimeStaff AND ID_Manager = ID_FullTimeStaff";

              PreparedStatement statement = data.prepareStatement(sql);

              // truy xuat thi dung excuteQuery()

              ResultSet check = statement.executeQuery();
              // kiem tra xem data co rong khong
              if(check.next() == false){
                     return null;
              }
              check.close();
              ResultSet rs = statement.executeQuery();
              while(rs.next()){
                     ManagerDTO manager = new ManagerDTO();
                     AddressDTO diachi = new AddressDTO();

                     diachi.setCity(rs.getString("ThanhPho"));
                     diachi.setDistrict(rs.getString("Quan"));
                     diachi.setStreet(rs.getString("SoNha"));

                     manager.setId(rs.getString("ID"));
                     manager.setName(rs.getString("Name"));
                     manager.setDate(rs.getString("Date_in"));
                     manager.setCmnd(rs.getString("CMND"));
                     manager.setGender(rs.getString("Gender"));
                     manager.setPassWord(rs.getString("Password"));

                     manager.setBaseSalary(rs.getInt("BaseSalary"));
                     manager.setWorkDays(rs.getInt("WorkDay"));
                     manager.setBonusRate(rs.getInt("BonusRate"));
                     manager.setAllowance(rs.getInt("Allowance"));
                     manager.setAddress(diachi);

                     managers.add(manager);

              }

              return managers;
       }

       @Override
       public boolean save(ManagerDTO t) throws SQLException {
              if (t == null){
                     throw new SQLException("FullTimeStaff rong");
              }
              
              String sql_Staff = "INSERT INTO tblStaff(ID,Name,Date_in,Gender,CMND,Password,Salary)" + "VALUES (?,?,?,?,?,?,?)";
              String sql_Address = "INSERT INTO tblAddressStaff(ID_NV,SoNha,Quan,ThanhPho)" + "VALUES (?,?,?,?)";
              String sql_FullTimeStaff = "INSERT INTO tblFullTimeStaff(ID_FullTimeStaff,BaseSalary,BonusRate,WorkDay)" + "VALUES (?,?,?,?)";

              String sql_Manager = "INSERT INTO tblManager(ID_Manager,Allowance)" + "VALUES (?,?)";

              PreparedStatement statement1 = data.prepareStatement(sql_Staff);
              PreparedStatement statement2 = data.prepareStatement(sql_Address);
              PreparedStatement statement3 = data.prepareStatement(sql_FullTimeStaff);
              PreparedStatement statement4 = data.prepareStatement(sql_Manager);

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

              // thong tin cua Manager
              statement4.setString(1, t.getId());
              statement4.setInt(2, t.getAllowance());

              return statement1.executeUpdate() > 0 && statement2.executeUpdate() > 0 && statement3.executeUpdate() > 0 && statement4.executeUpdate() > 0;
       }

       @Override
       public boolean update(ManagerDTO t) throws SQLException {
              String sql_Staff = String.format("UPDATE tblStaff SET Name = ?,Date_in = ?,Gender = ?,CMND = ?,Password = ?,Salary = ? WHERE ID = '%s' ", t.getId());
              String sql_Address = String.format("UPDATE tblAddressStaff SET SoNha = ?,Quan = ?,ThanhPho = ? WHERE ID_NV = '%s' ", t.getId());
              String sql_FullTimeStaff = String.format("UPDATE tblFullTimeStaff SET BaseSalary = ?,BonusRate = ?,WorkDay = ? WHERE ID_FullTimeStaff = '%s' ", t.getId());
              String sql_Manager = String.format("UPDATE tblManager SET Allowance = ? WHERE ID_Manager = '%s' ", t.getId());

              PreparedStatement statement1 = data.prepareStatement(sql_Staff);
              PreparedStatement statement2 = data.prepareStatement(sql_Address);
              PreparedStatement statement3 = data.prepareStatement(sql_FullTimeStaff);
              PreparedStatement statement4 = data.prepareStatement(sql_Manager);

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

              // thong tin cua Manager
              statement4.setInt(1, t.getAllowance());

              return statement1.executeUpdate() > 0 && statement2.executeUpdate() > 0 && statement3.executeUpdate() > 0 && statement4.executeUpdate() > 0;


       }
}