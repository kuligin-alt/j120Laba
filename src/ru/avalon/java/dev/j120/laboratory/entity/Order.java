
package ru.avalon.java.dev.j120.laboratory.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


public class Order implements Serializable {  // класс заказ
    private LocalDate creationDateOrder;  // дата создания заказа
    private String contactPerson;         // контактное лицо
    private String deliveryAdress;        // адресс доставки
    private String phoneNumber;           // контактный телефон
    private Integer discount;             // процент скидки
    private String orderStatus;           // статус заказа (готовится, отгружен, отменен)
    private Goods goodsPosition;          // список позиций товара (товар, количество, цена)

    public Order(LocalDate creationDateOrder, String contactPerson, String deliveryAdress, String phoneNumber, Integer discount, String orderStatus, Goods goodsPosition) {
        this.creationDateOrder = creationDateOrder;
        this.contactPerson = contactPerson;
        this.deliveryAdress = deliveryAdress;
        this.phoneNumber = phoneNumber;
        this.discount = discount;
        this.orderStatus = orderStatus;
        this.goodsPosition = goodsPosition;
    }
    
    public static void orderGoods(Goods g) { // заказанный товар
        ArrayList<Goods> oGood = new ArrayList<>();
        oGood.add(g);
        for(int i = 0; i < oGood.size(); i++) {
            Object elements = oGood.get(i);
            System.out.println(elements);
        }
    }
    
    public static void quantityGoods() {  // количество товара
        
    }

    public LocalDate getCreationDateOrder() {
        return creationDateOrder;
    }

    public void setCreationDateOrder(LocalDate creationDateOrder) {
        this.creationDateOrder = creationDateOrder;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getDeliveryAdress() {
        return deliveryAdress;
    }

    public void setDeliveryAdress(String deliveryAdress) {
        this.deliveryAdress = deliveryAdress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Goods getGoodsPosition() {
        return goodsPosition;
    }

    public void setGoodsPosition(Goods goodsPosition) {
        this.goodsPosition = goodsPosition;
    }

    @Override
    public String toString() {
        return "Order{" + "creationDateOrder=" + 
                creationDateOrder + ", contactPerson=" + 
                contactPerson + ", deliveryAdress=" + 
                deliveryAdress + ", phoneNumber=" + 
                phoneNumber + ", discount=" + discount + ", orderStatus=" + 
                orderStatus + ", goodsPosition=" + goodsPosition + '}';
    }
      
}
