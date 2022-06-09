/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datdh.dao;

import datdh.dto.Account;
import datdh.dto.Categories;
import datdh.dto.Product;
import datdh.utlis.DBUtlis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class CategoriesDaO {

    public static ArrayList<Categories> getCategorieses() {
        ArrayList<Categories> list = new ArrayList<Categories>();
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String slq = "select CateID,CateName from Categories";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(slq);

                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    Categories acc = new Categories(id, name);
                    list.add(acc);
                }
                cn.close();
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static int getToalCate() {
        int total = 0;
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String slq = "select count(*) from Categories";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(slq);

                while (rs.next()) {
                    total = rs.getInt(1);
                }
                cn.close();
            }
        } catch (Exception e) {
        }
        return total;
    }

    public static void newCategories(String cate) {
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String slq = "insert into Categories values(?)";
                PreparedStatement st = cn.prepareStatement(slq);
                st.setString(1, cate);
                ResultSet rs = st.executeQuery();
                st.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
        }
    }

    public static String getId(String cate) {
        String id = "";
        try {
            Categories categories = null;

            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String slq = "select * from [dbo].[Categories] where CateName=? ";
                PreparedStatement st = cn.prepareStatement(slq);
                st.setString(1, cate);
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    categories = new Categories(rs.getInt("CateID"), rs.getString("CateName"));
                }
                if (!rs.next()) {
                    cn.close();
                }
                id = Integer.toString(categories.getId());
            }
        } catch (Exception e) {
        }
        return id;
    }

    public static Categories getCateById(String cateId) {
        Categories cate = null;
        try {
            Categories categories = null;

            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String slq = "select * from Categories where CateID=? ";
                PreparedStatement st = cn.prepareStatement(slq);
                st.setString(1, cateId);
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    cate = new Categories(rs.getInt("CateID"), rs.getString("CateName"));
                }
                if (!rs.next()) {
                    cn.close();
                }

            }
        } catch (Exception e) {
        }
        return cate;
    }

    public static boolean isExist(String id) throws SQLException {
        boolean flag = false;
        Categories categories = null;
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select * from [dbo].[Categories] where CateID=? ";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, id);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    categories = new Categories(rs.getInt("CateID"), rs.getString("CateName"));
                }
                if (categories != null) {
                    flag = true;
                }
                if (!rs.next()) {
                    cn.close();
                }
            }
        } catch (Exception e) {

        }
        return flag;
    }
    public static boolean isExistName(String id) throws SQLException {
        boolean flag = false;
        Categories categories = null;
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select * from [dbo].[Categories] where CateName=? ";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, id);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    categories = new Categories(rs.getInt("CateID"), rs.getString("CateName"));
                }
                if (categories != null) {
                    flag = true;
                }
                if (!rs.next()) {
                    cn.close();
                }
            }
        } catch (Exception e) {

        }
        return flag;
    }

    public static void updateCate(String cId, String CName) throws ClassNotFoundException, SQLException {

        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "update Categories set CateName=? where CateID=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, CName);
                pst.setString(2, cId);
                pst.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
            e.printStackTrace();
        }
    }

    public static ArrayList<Categories> pagingCate(String index) {
        ArrayList<Categories> categorieses = new ArrayList<>();
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select * from Categories  order by CateID\n"
                        + "OFFSET ? rows fetch next 4 rows only ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(Integer.toString(((Integer.parseInt(index)) - 1) * 4)));
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    Categories categories = new Categories(rs.getInt("CateID"), rs.getString("CateName"));
                    categorieses.add(categories);
                }

                if (!rs.next()) {
                    cn.close();
                }
            }
        } catch (Exception e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
            e.printStackTrace();
        }
        return categorieses;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        CategoriesDaO a = new CategoriesDaO();
        ArrayList<Categories> list = a.getCategorieses();
        ArrayList<Categories> list1 = pagingCate("1");
        for (Categories c : list1) {
            System.out.println(c.toString());
        }
        System.out.println(a.isExist("test"));
        System.out.println(CategoriesDaO.getId("Violaceae"));
        System.out.println("total: " + getToalCate());
    }
}
