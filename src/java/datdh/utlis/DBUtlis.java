/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datdh.utlis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class DBUtlis {

//    private final String serverName = "SE150011\\DATDHSE150011";
//    private final String dbName = "PlantShop";
//    private final String portNumber = "1433";
//    private final String instance = "";
//    private final String userName = "admin";
//    private final String pass = "dat163163";
    
//    String portNumber = "3306";
//    String url = "jdbc:mysql://localhost:"+portNumber+"/PlantShop?useSSL=false&autoReconnect=true";
//    String usernameForMySql = "root";
//    String passwordForMySql = "root";
    public Connection getConnection() throws ClassNotFoundException, SQLException {
//        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\"
//                + instance + ";databaseName=" + dbName;
//        if (instance == null || instance.trim().isEmpty()) {
//            url = "jdbc:sqlserver://" + serverName + ":" + portNumber
//                    + ";databaseName=" + dbName;
//        }
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        return DriverManager.getConnection(url, userName, pass);

   
//        System.out.println("Connecting database...");
//
//        try ( 
//            Connection connection1 = DriverManager.getConnection(url, usernameForMySql, passwordForMySql)) {
//            System.out.println("Database connected!");
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            return connection1;
//        } catch (SQLException e) {
//            throw new IllegalStateException("Cannot connect the database!", e);
//        }

    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBUtlis a = new DBUtlis();
        
        
        System.out.println(a.getConnection());
 
    }
}
