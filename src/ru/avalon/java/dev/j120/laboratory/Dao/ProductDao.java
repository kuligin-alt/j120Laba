/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.dev.j120.laboratory.Dao;

import java.util.Collection;
import ru.avalon.java.dev.j120.laboratory.entity.Product;

/**
 *
 * @author buzzz
 */
public interface ProductDao {
    public Collection<Product> findAll();
    public Product findById(String article);
    public Product save(Product product);
}
