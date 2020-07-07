
package ru.avalon.java.dev.j120.laboratory.entity;

import java.io.Serializable;
import java.math.BigDecimal;


public class OrderProduct implements Serializable  {   // Строка заказа
    private long articleOrderProduct;      // Артикул заказанного товара
    private String nameOrderProduct;       // Наименование заказанного товара
    private String colorOrderProduct;      // Цвет заказанного товара
    private int amountOrderProduct;        // Количество заказанного товарв
    private BigDecimal priceOrderProduct;  // Цена заказанного товара

    public OrderProduct(long articleOrderProduct, String nameOrderProduct, String colorOrderProduct, int amountOrderProduct, BigDecimal priceOrderProduct) {
        this.articleOrderProduct = articleOrderProduct;
        this.nameOrderProduct = nameOrderProduct;
        this.colorOrderProduct = colorOrderProduct;
        this.amountOrderProduct = amountOrderProduct;
        this.priceOrderProduct = priceOrderProduct; // Цена должна звиксироваться
    }

    public OrderProduct(String nameOrderProduct) {
        this.nameOrderProduct = nameOrderProduct;
    }

    public void setPriceOrderProduct(int discount) {
        BigDecimal a = this.priceOrderProduct.divide(BigDecimal.valueOf(100));
        this.priceOrderProduct = a.multiply(BigDecimal.valueOf(100-discount));
    }

    
    
    

    public void setAmountOrderProduct(int amountOrderProduct) {
        this.amountOrderProduct = amountOrderProduct;
    }

    public long getArticleOrderProduct() {
        return articleOrderProduct;
    }

    public String getNameOrderProduct() {
        return nameOrderProduct;
    }

    public String getColorOrderProduct() {
        return colorOrderProduct;
    }

    public int getAmountOrderProduct() {
        return amountOrderProduct;
    }

    public BigDecimal getPriceOrderProduct() {
        return priceOrderProduct;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (int) (this.articleOrderProduct ^ (this.articleOrderProduct >>> 32));
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
        final OrderProduct other = (OrderProduct) obj;
        if (this.articleOrderProduct != other.articleOrderProduct) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return (" Наименование товара: " + nameOrderProduct +
                " Артикул: " + articleOrderProduct +
                " Цвет: " + colorOrderProduct +
                " Цена: " + priceOrderProduct +
                " Количество: " + amountOrderProduct);
    }
}
