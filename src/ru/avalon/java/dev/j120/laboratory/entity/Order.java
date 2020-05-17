
package ru.avalon.java.dev.j120.laboratory.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Order implements Serializable {
    private LocalDate creationDateOrder;  // дата создания заказа
    private Person contactPerson;         // контактное лицо
    private String orderStatus;           // статус заказа (готовится, отгружен, отменен)
    private ArrayList<Goods> goodsPosition;          // список позиций товара (товар, количество, цена)

    public Order(LocalDate creationDateOrder, Person contactPerson, String orderStatus, ArrayList<Goods> goodsPosition) {
        this.creationDateOrder = creationDateOrder;
        this.contactPerson = contactPerson;
        this.orderStatus = orderStatus;
        this.goodsPosition = goodsPosition;
    }

    
    

    public LocalDate getCreationDateOrder() {
        return creationDateOrder;
    }

    public Person getContactPerson() {
        return contactPerson;
    }


    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public ArrayList<Goods> getGoodsPosition() {
        return goodsPosition;
    }

    public void setGoodsPosition(ArrayList<Goods> goodsPosition) {
        this.goodsPosition = goodsPosition;
    }

    @Override
    public String toString() {
        return (" Дата создания заказа: " + creationDateOrder + "\n" +
                " Заказчик : " + contactPerson + "\n" +
                " Статус заказа: " + orderStatus + "\n" +
                " Список позиций: " + goodsPosition);
    }
}
