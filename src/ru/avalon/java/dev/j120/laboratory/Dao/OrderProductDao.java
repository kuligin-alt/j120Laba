/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.dev.j120.laboratory.Dao;

import java.util.Collection;
import java.util.LinkedHashSet;
import ru.avalon.java.dev.j120.laboratory.entity.OrderProduct;

/**
 *
 * @author buzzz
 */
public interface OrderProductDao {
    public LinkedHashSet<OrderProduct> findAll();
    public OrderProduct findById(Long article);
    public OrderProduct save(OrderProduct orderProduct);
}
