
package ru.avalon.java.dev.j120.laboratory.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Objects;

public class Order implements Serializable {
    private LocalDate creationDateOrder;            // дата создания заказа
    private Person contactPerson;                   // контактное лицо
    private String orderStatus;                     // статус заказа (готовится, отгружен, отменен)
    private LinkedHashSet<OrderProduct> goodsPosition;  // список позиций товара (товар, количество, цена)
    private int discount;                           // скидка
    

    public Order(LocalDate creationDateOrder, Person contactPerson, String orderStatus, LinkedHashSet<OrderProduct> goodsPosition, int discount) {
        this.creationDateOrder = creationDateOrder;
        this.contactPerson = contactPerson;
        this.orderStatus = orderStatus;
        this.goodsPosition = goodsPosition;
        this.discount = discount;
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

    //public ArrayList<OrderProduct> getGoodsPosition() {
    //    return goodsPosition;
    //}

    //public void setGoodsPosition(ArrayList<OrderProduct> goodsPosition) {
    //    this.goodsPosition = goodsPosition;
    //}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.creationDateOrder);
        hash = 73 * hash + Objects.hashCode(this.contactPerson);
        hash = 73 * hash + Objects.hashCode(this.orderStatus);
        hash = 73 * hash + Objects.hashCode(this.goodsPosition);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (!Objects.equals(this.orderStatus, other.orderStatus)) {
            return false;
        }
        if (!Objects.equals(this.creationDateOrder, other.creationDateOrder)) {
            return false;
        }
        if (!Objects.equals(this.contactPerson, other.contactPerson)) {
            return false;
        }
        if (!Objects.equals(this.goodsPosition, other.goodsPosition)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        return ("\n" + 
                " Дата создания заказа: " + creationDateOrder + "\n" +
                " Заказчик : " + contactPerson + "\n" +
                " Статус заказа: " + orderStatus + "\n" +
                " Список позиций: " + goodsPosition + "\n" +
                " Скидка: " + discount);
    }
}
