package com.example.hasofoodapp.models;

public class OrderModel {

    private int orderId;
    private int customerId;
    private String address;
    private String status;
    private String paymentStatus;
    private String deliveredBy;
    private String createdAt;
    private String deliveredAt;

    // Constructor
    public OrderModel(int orderId, int customerId, String address, String status, String paymentStatus, String deliveredBy, String createdAt, String deliveredAt) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.address = address;
        this.status = status;
        this.paymentStatus = paymentStatus;
        this.deliveredBy = deliveredBy;
        this.createdAt = createdAt;
        this.deliveredAt = deliveredAt;
    }

    // Getter methods
    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getDeliveredBy() {
        return deliveredBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getDeliveredAt() {
        return deliveredAt;
    }

    // Setter methods (if needed)
    // Add setters if you need to update the values later
}
