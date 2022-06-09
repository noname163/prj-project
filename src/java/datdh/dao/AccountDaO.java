/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datdh.dao;

import datdh.dto.Account;
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
public class AccountDaO {

    public static void insertAccounts(String email, String password,
            String fullname, String phone) {
        Account acc = null;
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String slq = "insert into Accounts values(?,?,?,?,1,1,null);";
                PreparedStatement st = cn.prepareStatement(slq);
                st.setString(1, email);
                st.setString(2, password);
                st.setString(3, fullname);
                st.setString(4, phone);
                st.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Account getAccount(String email, String password, int role) throws ClassNotFoundException {
        Account acc = null;
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select * from [Accounts]\n"
                        + "where email= ? and role = ? and password = ?  COLLATE Latin1_General_CS_AS ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(3, password);
                pst.setInt(2, role);
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    acc = new Account(rs.getInt("accID"), rs.getString("email"), rs.getString("password"), rs.getString("fullname"), rs.getInt("role"), rs.getString("phone"), rs.getInt("status"));
                }

                if (!rs.next()) {
                    cn.close();
                }
            }
        } catch (Exception e) {
            System.out.println("erros");
            e.printStackTrace();
        }
        return acc;
    }

    public static Account getAccountById(String id) throws ClassNotFoundException {
        Account acc = null;
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select * from [Accounts]\n"
                        + "where accID=? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    acc = new Account(rs.getInt("accID"), rs.getString("email"), rs.getString("password"), rs.getString("fullname"), rs.getInt("role"), rs.getString("phone"), rs.getInt("status"));
                }

                if (!rs.next()) {
                    cn.close();
                }
            }
        } catch (Exception e) {
            System.out.println("erros");
            e.printStackTrace();
        }
        return acc;
    }

    public static boolean checkAccount(String email) throws ClassNotFoundException {
        String mail = "";
        boolean flag = false;
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select email from Accounts where email=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    mail = rs.getString(1);
                }
                if (!rs.next()) {
                    cn.close();
                }
                if (!mail.isEmpty()) {
                    flag = true;
                }

            }
        } catch (Exception e) {
        }
        return flag;
    }

    public static void updateAccount(String accId, String status) throws ClassNotFoundException {

        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "update Accounts set status=? where accID=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, status);
                pst.setString(2, accId);
                ResultSet rs = pst.executeQuery();
                pst.executeUpdate();
                cn.close();
            }
        } catch (SQLException e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
            e.printStackTrace();
        }
    }
    public static void promoteAccount(String accId, String status) throws ClassNotFoundException {

        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "update Accounts set role=? where accID=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, status);
                pst.setString(2, accId);
                ResultSet rs = pst.executeQuery();
                pst.executeUpdate();
                cn.close();
            }
        } catch (SQLException e) {
            System.out.println("datdh.dao.ProductDaO.getProduct()");
            e.printStackTrace();
        }
    }

    public static void changeAccount(String id, String fullName, String phone, String email) {
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "update [dbo].[Accounts] set fullname=? , phone = ?,email=? where accID=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, fullName);
                pst.setString(2, phone);
                pst.setString(3, email);
                pst.setString(4, id);
                ResultSet rs = pst.executeQuery();
                pst.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void setTokenAccount(String id, String token) {
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "update Accounts set token=? where accID=? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, token);
                pst.setString(2, id);
                ResultSet rs = pst.executeQuery();
                pst.executeUpdate();
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Account getAccountByToken(String token){
        Account acc = null;
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String sql = "select * from Accounts where token=? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, token);
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    acc = new Account(rs.getInt("accID"), rs.getString("email"), rs.getString("password"), rs.getString("fullname"), rs.getInt("role"), rs.getString("phone"), rs.getInt("status"));
                }

                if (!rs.next()) {
                    cn.close();
                }
            }
        } catch (Exception e) {
            System.out.println("erros");
            e.printStackTrace();
        }
        return acc;
    }
    public static ArrayList<Account> listAccounts() {
        ArrayList<Account> list = new ArrayList<Account>();
        try {
            Connection cn = new DBUtlis().getConnection();
            if (cn != null) {
                String slq = "select * from Accounts order by role asc ";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(slq);

                while (rs.next()) {
                    int id = rs.getInt("accID");
                    String email = rs.getString("email");
                    String pass = rs.getString("password");
                    String fullName = rs.getString("fullname");
                    String phone = rs.getString("phone");
                    int status = rs.getInt("status");
                    int role = rs.getInt("role");
                    Account acc = new Account(id, email, pass, fullName, role, phone, status);
                    list.add(acc);
                }
                cn.close();
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Account b = AccountDaO.getAccountById("1");
        System.out.println(b.toString());
        boolean a = AccountDaO.checkAccount("test@gmail.com");
        System.out.println(a);
        Account c = AccountDaO.getAccountByToken("4");
        ArrayList<Account> acc = AccountDaO.listAccounts();
        for (Account x : acc) {
            System.out.println(x.toString());
        }
        AccountDaO.insertAccounts("test", "testabc", "test", "011223344");
        Account d = getAccountById("11");
        System.out.println(d.toString());
    }
}
