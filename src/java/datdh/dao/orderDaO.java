/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datdh.dao;

import datdh.dto.OrderInfor;
import datdh.dto.orderDetail;
import datdh.utlis.DBUtlis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class orderDaO {
    public static void insertOrder(String accId) throws ClassNotFoundException{
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "insert into [dbo].[Orders] values(GETDATE(),DATEADD(DAY,7,GETDATE()),1,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, accId);
                ResultSet rs = pst.executeQuery();
                pst.executeUpdate();
                cn.close();   
            }
        } catch (SQLException e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
            e.printStackTrace();
        }
    }
    public static ArrayList<OrderInfor> getOrderInfor(String accID) throws ClassNotFoundException, SQLException{
        ArrayList<OrderInfor> list = new ArrayList<>();
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select * from [dbo].[Orders] where AccID=?" ;
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, accID);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    OrderInfor order = new OrderInfor(rs.getInt("OrderId"), rs.getString("OrdDate"), rs.getString("shipdate"), rs.getInt("status"),rs.getInt("AccID"));
                    list.add(order);
                }
                
                if (!rs.next()) {
                    cn.close();
                }
            }
        }catch (Exception e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
        }
        return list;
    }
    public static OrderInfor getOrderId(String accID) throws ClassNotFoundException, SQLException{
        OrderInfor order = null;
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select * from [dbo].[Orders] where AccID=?" ;
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, accID);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    order = new OrderInfor(rs.getInt("OrderId"),
                            rs.getString("OrdDate"), 
                            rs.getString("shipdate"), 
                            rs.getInt("status"),
                            rs.getInt("AccID"));
                }
                
                if (!rs.next()) {
                    cn.close();
                }
            }
        }catch (Exception e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
        }
        return order;
    }
    public static void insertOrderDetail(String orderId, String pId,String quantity) throws ClassNotFoundException{
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "insert into OrderDetails values(?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, orderId);
                pst.setString(2, pId);
                pst.setString(3, quantity);
                ResultSet rs = pst.executeQuery();
                pst.executeUpdate();
                cn.close();   
            }
        } catch (SQLException e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
            e.printStackTrace();
        }
    }
    public static void updateStatus(String orderId, int status) throws ClassNotFoundException{
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "update [dbo].[Orders] set [status]=? where OrderID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, status);
                pst.setString(2, orderId);
                ResultSet rs = pst.executeQuery();
                pst.executeUpdate();
                cn.close();   
            }
        } catch (SQLException e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
            e.printStackTrace();
        }
    }
    public static ArrayList<orderDetail> getOrderDetails(String orderId){
        ArrayList<orderDetail> list = new ArrayList<>();
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select * from [dbo].[OrderDetails] where OrderID=?" ;
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, orderId);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    orderDetail order = new orderDetail(rs.getInt("DetailId"), rs.getInt("OrderID"), rs.getInt("FID"), rs.getInt("quantity"));
                    list.add(order);
                }
                if (!rs.next()) {
                    cn.close();
                }
            }
        }catch (Exception e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
        }
        return list;
    }
    public static orderDetail getOrderDetail(String orderId){
        orderDetail order = null;
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select * from [dbo].[OrderDetails] where OrderID=?" ;
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, orderId);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                     order = new orderDetail(rs.getInt("DetailId"), rs.getInt("OrderID"), rs.getInt("FID"), rs.getInt("quantity"));
                    
                }
                if (!rs.next()) {
                    cn.close();
                }
            }
        }catch (Exception e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
        }
        return order;
    }
    public static ArrayList<OrderInfor> getOrderByDate(String startDate, String endDate, String accId){
        ArrayList<OrderInfor> orders = new ArrayList<>();
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select * from Orders where OrdDate> ? and OrdDate < ? and AccID=? " ;
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, startDate);
                pst.setString(2, endDate);
                pst.setString(3, accId);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    OrderInfor order = new OrderInfor(rs.getInt("OrderID"), rs.getString("OrdDate"), rs.getString("shipdate"), rs.getInt("status"), rs.getInt("AccID"));
                    orders.add(order);
                }
                if (!rs.next()) {
                    cn.close();
                }
            }
        }catch (Exception e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
        }
        return orders;
    }
    public static ArrayList<OrderInfor> getOrdersByDate(String startDate, String endDate){
        ArrayList<OrderInfor> orders = new ArrayList<>();
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select * from Orders where OrdDate> ? and OrdDate < ?  " ;
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, startDate);
                pst.setString(2, endDate);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    OrderInfor order = new OrderInfor(rs.getInt("OrderID"), rs.getString("OrdDate"), rs.getString("shipdate"), rs.getInt("status"), rs.getInt("AccID"));
                    orders.add(order);
                }
                if (!rs.next()) {
                    cn.close();
                }
            }
        }catch (Exception e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
        }
        return orders;
    }
    public static ArrayList<OrderInfor> getOrderById(String id){
        ArrayList<OrderInfor> orders = new ArrayList<>();
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select * from Orders where AccID=? " ;
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    OrderInfor order = new OrderInfor(rs.getInt("OrderID"), rs.getString("OrdDate"), rs.getString("shipdate"), rs.getInt("status"), rs.getInt("AccID"));
                    orders.add(order);
                }
                if (!rs.next()) {
                    cn.close();
                }
            }
        }catch (Exception e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
        }
        return orders;
    }
    public static ArrayList<OrderInfor> getOrderByStatus(String id, String status){
        ArrayList<OrderInfor> orders = new ArrayList<>();
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select * from Orders where AccID= ? AND status=? " ;
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, id);
                pst.setString(2, status);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    OrderInfor order = new OrderInfor(rs.getInt("OrderID"), rs.getString("OrdDate"), rs.getString("shipdate"), rs.getInt("status"), rs.getInt("AccID"));
                    orders.add(order);
                }
                if (!rs.next()) {
                    cn.close();
                }
            }
        }catch (Exception e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
            e.printStackTrace();
        }
        return orders;
    }
    public static ArrayList<OrderInfor> getAllOrder(String accId){
        ArrayList<OrderInfor> orders = new ArrayList<>();
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select * from Orders where AccID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, accId);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    OrderInfor order = new OrderInfor(rs.getInt("OrderID"), rs.getString("OrdDate"), rs.getString("shipdate"), rs.getInt("status"), rs.getInt("AccID"));
                    orders.add(order);
                }
                if (!rs.next()) {
                    cn.close();
                }
            }
        }catch (Exception e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
            
        }
        return orders;
    }
    public static ArrayList<OrderInfor> getAllOrders(){
        ArrayList<OrderInfor> orders = new ArrayList<>();
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select * from Orders";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    OrderInfor order = new OrderInfor(rs.getInt("OrderID"), rs.getString("OrdDate"), rs.getString("shipdate"), rs.getInt("status"), rs.getInt("AccID"));
                    orders.add(order);
                }
                if (!rs.next()) {
                    cn.close();
                }
            }
        }catch (Exception e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
            e.printStackTrace();
        }
        return orders;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
            OrderInfor order =  orderDaO.getOrderId("1");
            ArrayList<orderDetail> detail = orderDaO.getOrderDetails("12");
            orderDetail oDetail = orderDaO.getOrderDetail("12");
            ArrayList<OrderInfor> orders = orderDaO.getOrderByDate("2022-03-01", "2022-03-09","3");
            ArrayList<OrderInfor> all = orderDaO.getAllOrder("3");
            ArrayList<OrderInfor> alls = orderDaO.getAllOrders();
            ArrayList<OrderInfor> id = orderDaO.getOrderById("4");
            ArrayList<OrderInfor> status =orderDaO.getOrderByStatus("1", "1");
            for(OrderInfor x: alls){
                System.out.println(x.toString());
            }
    }
}
