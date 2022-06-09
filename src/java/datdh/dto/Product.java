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
public class Product implements Serializable{

    public Product() {
    }

    private int productId;
    private String productName;
    private int productPrice;
    private String productImg;
    private String productDecription;
    private int productStatus;
    private int quantity;
    private String orderDate;
    private int orderId;
    private int orderStatus;
    private int accId;
    private int cateId;
    
    public Product(int productId, String productName, int productPrice, String productImg, String productDecription, int productStatus, int cateId) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImg = productImg;
        this.productDecription = productDecription;
        this.productStatus = productStatus;
        this.cateId = cateId;
    }

    
    

    
    
    

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }
    

    public Product(int productId, String productName, int productPrice, String productImg, String productDecription, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImg = productImg;
        this.productDecription = productDecription;
        this.productStatus = productStatus;
    }
    public Product(int productId, String productName, int productPrice, String productImg, String productDecription) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImg = productImg;
        this.productDecription = productDecription;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getProductDecription() {
        return productDecription;
    }

    public void setProductDecription(String productDecription) {
        this.productDecription = productDecription;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    

    
    

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
    

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
   

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice + ", productImg=" + productImg + ", productDecription=" + productDecription + ", productStatus=" + productStatus + ", quantity=" + quantity + ", orderDate=" + orderDate + ", orderId=" + orderId + ", orderStatus=" + orderStatus + ", accId=" + accId + ", cateId=" + cateId + '}';
    }
    
}
