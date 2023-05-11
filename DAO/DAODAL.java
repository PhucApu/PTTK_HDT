package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class DAODAL <T> {
       conectionDataBaseDAO conn = new conectionDataBaseDAO();
       Connection data = conn.getConn();

       // lay danh sach phan tu luu trong data base
       public abstract ArrayList<T> getList() throws SQLException;

       // lay 1 doi tuong trong data base
       public abstract T get(String id) throws SQLException;

       // luu 1 doi tuong  vao data base
       public abstract boolean save(T t) throws SQLException;

       // cap nhat 1 doi tuong vao data base
       public abstract boolean update(T t) throws SQLException;

       // xoa 1 doi tuong ra khoi data base
       public abstract boolean delete(T t) throws SQLException;

       // xoa doi tuong ra khoi data base dua vao id
       public abstract boolean deleteById(String id) throws SQLException;
}