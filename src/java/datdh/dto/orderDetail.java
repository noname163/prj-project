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
public class orderDetail implements Serializable{

    public orderDetail(int detailId, int orderID, int productId, int quantity) {
        this.detailId = detailId;
        this.orderID = orderID;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "orderDetail{" + "detailId=" + detailId + ", orderID=" + orderID + ", productId=" + productId + ", quantity=" + quantity + '}';
    }

    public orderDetail() {
    }
    private int detailId;
    private int orderID;
    private int productId;
    private int quantity;
    
}
