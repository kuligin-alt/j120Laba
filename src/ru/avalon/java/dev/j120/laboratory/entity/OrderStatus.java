
package ru.avalon.java.dev.j120.laboratory.entity;


public enum OrderStatus {
    PREPARING("Заказ готовится"),
    SHIPPED("Заказ отгружен"),
    CANCELED("Заказ отменен");
    
    private String status;

    private OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    
}
