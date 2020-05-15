
package ru.avalon.java.dev.j120.laboratory.entity;

import java.io.Serializable;

public class Goods implements Serializable { 
    private Long articleNumber;  // артикул
    private String name;         // наименование товара
    private String color;        // цвет товара
    private double price;        // цена товара
    public int stockBalance;     // остаток на складе

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

    public void setArticleNumber(Long articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public void setStockBalance(int stockBalance) {
        this.stockBalance = stockBalance;
    }

    @Override
    public String toString() {
        return (name + " Артикул: " + articleNumber + " Цвет: " + color + 
                " Цена: " + price + " Остаток на складе: " + stockBalance);
    }    
}
