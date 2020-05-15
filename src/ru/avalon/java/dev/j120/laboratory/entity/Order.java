
package ru.avalon.java.dev.j120.laboratory.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Order implements Serializable {
    private LocalDate creationDateOrder;  // дата создания заказа
    private Person contactPerson;         // контактное лицо
    private String orderStatus;           // статус заказа (готовится, отгружен, отменен)
    private Goods goodsPosition;          // список позиций товара (товар, количество, цена)

    public Order(LocalDate creationDateOrder, Person contactPerson, String orderStatus, Goods goodsPosition) {
        this.creationDateOrder = creationDateOrder;
        this.contactPerson = contactPerson;
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

    public Person getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(Person contactPerson) {
        this.contactPerson = contactPerson;
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
                contactPerson + ", orderStatus=" + 
                orderStatus + ", goodsPosition=" + goodsPosition + '}';
    }
}
