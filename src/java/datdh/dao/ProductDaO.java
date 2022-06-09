/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datdh.dao;

import datdh.dto.Account;
import datdh.dto.Product;
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
public class ProductDaO {

    public static ArrayList<Product> getProducts() {
        ArrayList<Product> list = new ArrayList<Product>();
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String slq = "select * from Plants where status='1'";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(slq);

                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    int price = rs.getInt(3);
                    String img = rs.getString(4);
                    String decription = rs.getString(5);
                    Product product = new Product(id, name, price, img, decription);
                    list.add(product);
                }
                cn.close();
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static ArrayList<Product> getAllProducts() {
        ArrayList<Product> list = new ArrayList<Product>();
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String slq = "select * from Plants";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(slq);

                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    int price = rs.getInt(3);
                    String img = rs.getString(4);
                    String decription = rs.getString(5);
                    Product product = new Product(rs.getInt("PID"), rs.getString("PName"), rs.getInt("price"), rs.getString("imgPath"), rs.getString("description"), rs.getInt("status"), rs.getInt("CateID"));
                    list.add(product);
                }
                cn.close();
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static ArrayList<Product> getTopProducts() {
        ArrayList<Product> list = new ArrayList<Product>();
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String slq = "select * from Plants where PID in\n"
                        + "(select TopPID.PID from\n"
                        + "(select  distinct Top 3 PID, COUNT(PID) as countPID from Plants as P join OrderDetails as O\n"
                        + "on PID = FID\n"
                        + "group by PID \n"
                        + "order by COUNT(PID) desc) as TopPID )";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(slq);

                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    int price = rs.getInt(3);
                    String img = rs.getString(4);
                    String decription = rs.getString(5);
                    Product product = new Product(rs.getInt("PID"), rs.getString("PName"), rs.getInt("price"), rs.getString("imgPath"), rs.getString("description"), rs.getInt("status"), rs.getInt("CateID"));
                    list.add(product);
                }
                cn.close();
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static ArrayList<Product> getProduct(String categories) throws ClassNotFoundException, SQLException {
        ArrayList<Product> list = new ArrayList<Product>();
        Product product = null;
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select * from Plants where CateID =?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, categories);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    product = new Product(rs.getInt("PID"), rs.getString("PName"), rs.getInt("price"), rs.getString("imgPath"), rs.getString("description"), rs.getInt("status"), rs.getInt("CateID"));
                    list.add(product);
                }

                if (!rs.next()) {
                    cn.close();
                }
            }
        } catch (Exception e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
        }
        return list;
    }

    public static ArrayList<Product> searchProduct(String value) throws ClassNotFoundException, SQLException {
        ArrayList<Product> list = new ArrayList<Product>();
        Product product = null;
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select * from Plants where PName like ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + value + "%");
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                    list.add(product);
                }

                if (!rs.next()) {
                    cn.close();
                }
            }
        } catch (Exception e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
        }
        return list;
    }

    public static void addNewProduct(String PName, String price,
            String imgPath, String des,
            String status, String cateId) throws ClassNotFoundException, SQLException {

        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "insert into Plants values (?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, PName);
                pst.setString(2, price);
                pst.setString(3, imgPath);
                pst.setString(4, des);
                pst.setString(5, status);
                pst.setString(6, cateId);
                ResultSet rs = pst.executeQuery();
                pst.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
            e.printStackTrace();
        }
    }

    public static void updateProduct(String pId, String PName, String price,
            String imgPath, String des,
            String status, String cateId) throws ClassNotFoundException, SQLException {

        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "update Plants set PName=?, price=?,imgPath=?, description=?,status=?, CateID=? where PID=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, PName);
                pst.setString(2, price);
                pst.setString(3, imgPath);
                pst.setString(4, des);
                pst.setString(5, status);
                pst.setString(6, cateId);
                pst.setString(7, pId);
                ResultSet rs = pst.executeQuery();
                pst.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
            e.printStackTrace();
        }
    }

    public static Product getNewProduct() {
        Product newProduct = null;
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String slq = "select * from Plants INNER JOIN (select MAX(PID) MaxID from Plants) as MaxProduct \n"
                        + "on MaxProduct.MaxID=Plants.PID";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(slq);
                while (rs.next()) {
                    newProduct = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                }
            }
        } catch (Exception e) {
        }
        return newProduct;
    }

    public static Product getProductByName(String nameP) {
        Product newProduct = null;
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select * from Plants where PName=? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, nameP);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    newProduct = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                }
            }
        } catch (Exception e) {
        }
        return newProduct;
    }

    public static Product getProductById(String pId) {
        Product newProduct = null;
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select CateID, PID, PName, price, imgPath, description, status from Plants where PID=? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, pId);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    newProduct = new Product(rs.getInt("PID"), rs.getString("PName"), rs.getInt("price"), rs.getString("imgPath"), rs.getString("description"), rs.getInt("status"), rs.getInt("CateID"));
                    System.out.println(rs.getInt(1));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newProduct;
    }
    public static  ArrayList<Product> getProductByStatus(String status) {
         ArrayList<Product> products = new ArrayList<Product>();
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select CateID, PID, PName, price, imgPath, description, status from Plants where status =? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, status);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    Product newProduct = new Product(rs.getInt("PID"), rs.getString("PName"), rs.getInt("price"), rs.getString("imgPath"), rs.getString("description"), rs.getInt("status"), rs.getInt("CateID"));
                    products.add(newProduct);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public static int totalProducts() {
        int total = 0;
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String slq = "select count(*) from Plants";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(slq);
                while (rs.next()) {
                    total = rs.getInt(1);
                }
            }
        } catch (Exception e) {
        }
        return total;
    }

    public static ArrayList<Product> pagingProducts(String index) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select * from Plants where status='1' order by PID\n"
                        + "OFFSET ? rows fetch next 6 rows only";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(Integer.toString(((Integer.parseInt(index)) - 1) * 6)));
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    Product product = new Product(rs.getInt("PID"), rs.getString("PName"), rs.getInt("price"), rs.getString("imgPath"), rs.getString("description"), rs.getInt("status"), rs.getInt("CateID"));
                    products.add(product);
                }

                if (!rs.next()) {
                    cn.close();
                }
            }
        } catch (Exception e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
            e.printStackTrace();
        }
        return products;
    }

    public static ArrayList<Product> suggestionProducts(String FId) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select * from Plants where PID in \n"
                        + "(select distinct Top 3 FID as PID from OrderDetails as Ord join\n"
                        + "(select OrderID from OrderDetails where FID = ?) as OrdID on Ord.OrderID = OrdID.OrderID\n"
                        + "group by FID )";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, FId);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    Product product = new Product(rs.getInt("PID"), rs.getString("PName"), rs.getInt("price"), rs.getString("imgPath"), rs.getString("description"), rs.getInt("status"), rs.getInt("CateID"));
                    products.add(product);
                }

                if (!rs.next()) {
                    cn.close();
                }
            }
        } catch (Exception e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
            e.printStackTrace();
        }
        return products;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ProductDaO p = new ProductDaO();
        ArrayList<Product> list = p.getProducts();
        ArrayList<Product> list1 = p.searchProduct("i");
        Product n = p.getNewProduct();

        Product name = p.getProductByName("Lilium");
//        ProductDaO.updateProduct("4", "Rose", "20000", "test", "test", "1", "3");
        Product id = p.getProductById("4");
        ArrayList<Product> list2 = ProductDaO.getAllProducts();
        ArrayList<Product> list3 = ProductDaO.suggestionProducts("1");
        for (Product x : list3) {
            System.out.println(x.toString());
        }
//        System.out.println(n.toString());
        System.out.println("by ID: " + id.toString());
        System.out.println("total: " + ProductDaO.totalProducts());
    }
}
