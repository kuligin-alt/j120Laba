
package ru.avalon.java.dev.j120.laboratory.entity;


public class Goods {  // класс товар
    private int articleNumber;  // артикул
    private String name;        // наименование товара
    private String color;       // цвет товара
    private double price;       // цена товара
    private int stockBalance;   // остаток на складе

    public Goods(int articleNumber, String name, String color, double price, int stockBalance) {
        this.articleNumber = articleNumber;
        this.name = name;
        this.color = color;
        this.price = price;
        this.stockBalance = stockBalance;
    }

    public int getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(int articleNumber) {
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
        return "Goods{" + "articleNumber=" + articleNumber + ", name=" + 
                name + ", color=" + color + ", price=" + 
                price + ", stockBalance=" + stockBalance + '}';
    }
    
     
}
