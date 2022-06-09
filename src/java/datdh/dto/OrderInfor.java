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
public class OrderInfor implements Serializable{

    public OrderInfor() {
    }
    private int orderId;
    private String orderDate;
    private String shipDate;
    private int orderStatus;
    private int accId;

    public OrderInfor(String orderDate, String shipDate,    int orderStatus, int accId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.orderStatus = orderStatus;
        this.accId = accId;
    }
    public OrderInfor(int orderId, String orderDate, String shipDate,    int orderStatus, int accId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.orderStatus = orderStatus;
        this.accId = accId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    @Override
    public String toString() {
        return "OrderInfor{" + "orderId=" + orderId + ", orderDate=" + orderDate + ", shipDate=" + shipDate + ", orderStatus=" + orderStatus + ", accId=" + accId + '}';
    }
    
}
