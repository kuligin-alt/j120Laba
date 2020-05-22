
package ru.avalon.java.dev.j120.laboratory.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Product implements Serializable { 
    private Long articleNumber;   // артикул
    private String name;          // наименование товара
    private String color;         // цвет товара
    private BigDecimal price;     // цена товара
    private int stockBalance;     // остаток на складе

    public Product(String articleNumber, String name, String color, String price, String stockBalance) {
        this.articleNumber = Long.parseLong(articleNumber);
        this.name = name;
        this.color = color;
        this.price = new BigDecimal(price);
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.articleNumber);
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
        final Product other = (Product) obj;
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
