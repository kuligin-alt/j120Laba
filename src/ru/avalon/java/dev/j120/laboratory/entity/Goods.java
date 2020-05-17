
package ru.avalon.java.dev.j120.laboratory.entity;

import java.io.Serializable;
import java.util.Objects;

public class Goods implements Serializable { 
    private Long articleNumber;   // артикул
    private String name;          // наименование товара
    private String color;         // цвет товара
    private double price;         // цена товара
    private int stockBalance;     // остаток на складе

    public Goods(String articleNumber, String name, String color, String price, String stockBalance) {
        this.articleNumber = Long.parseLong(articleNumber);
        this.name = name;
        this.color = color;
        this.price = Double.parseDouble(price);
        this.stockBalance = Integer.parseInt(stockBalance);
    }

    public Goods(String articleNumber, String name, String price, String stockBalance) {
        this.articleNumber = Long.parseLong(articleNumber);
        this.name = name;
        this.price = Double.parseDouble(price);
        this.stockBalance = Integer.parseInt(stockBalance);
    }

    public Long getArticleNumber() {
        return articleNumber;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockBalance() {
        return stockBalance;
    }

    public boolean setStockBalance(int orderBalance) {
        if ((this.stockBalance - orderBalance) < 0) {
            return true;
        } else {
            this.stockBalance = this.stockBalance - orderBalance;
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.articleNumber);
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.color);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 59 * hash + this.stockBalance;
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
        final Goods other = (Goods) obj;
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (this.stockBalance != other.stockBalance) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.articleNumber, other.articleNumber)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return (" Наименование товара: " + name +
                " Артикул: " + articleNumber +
                " Цвет: " + color +
                " Цена: " + price +
                " Остаток на складе: " + stockBalance);
    }    
}
