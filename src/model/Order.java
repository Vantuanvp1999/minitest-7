package model;

import java.io.Serializable;

public abstract class Order implements Payable, Comparable<Order>, Serializable {
    private String orderId;
    private String customerName;
    private int orderDate;

    public Order() {
    }

    public Order(String orderId, String customerName, int orderDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(int orderDate) {
        this.orderDate = orderDate;
    }
    public abstract void displayInfo();

    @Override
    public int compareTo(Order o) {
        return this.orderDate - o.orderDate;
    }
}
