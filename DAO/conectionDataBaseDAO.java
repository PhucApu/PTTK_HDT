package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class conectionDataBaseDAO {
       private Connection conn;
       private String dataBase_name = "FOOD_STORE";
       private String dataBase_pass = "0823072871phuc";
       public conectionDataBaseDAO(){
              try {
                     // com.microsoft.sqlserver.jdbc.SQLServerDriver
                     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                     conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename = FOOD_STORE;"+
                     "username = sa;password = 0823072871phuc");
              } catch (Exception e) {
                     e.printStackTrace();
              }
              if (conn == null){
                     System.out.println("ket noi database that bai");
              }
       }
       public Connection getConn() {
              return conn;
       }
       public static void main(String[] args) {
              conectionDataBaseDAO test =  new conectionDataBaseDAO();
              System.out.println(test.getConn());

       }
}
