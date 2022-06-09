/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datdh.dto;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class Account implements Serializable{

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Account(int accountID, String email, String password, String fullName, int role) {
        this.accountID = accountID;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Account(String email, String password, String fullName, String phone, int role, int status) {
        this.accountID = accountID;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.phone = phone;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" + "accountID=" + accountID + ", email=" + email + ", password=" + password + ", fullName=" + fullName + ", role=" + role + ", phone=" + phone + ", status=" + status + '}';
    }

    public Account(int accountID, String email, String password, String fullName, int role, String phone, int status) {
        this.accountID = accountID;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.phone = phone;
        this.status = status;
    }

    public Account() {
    }
    private int accountID;
    private String email;
    private String password;
    private String fullName;
    private int role;
    private String phone;
    private int status;

}
