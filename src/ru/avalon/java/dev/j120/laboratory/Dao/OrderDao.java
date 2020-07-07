/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.dev.j120.laboratory.Dao;

import java.util.Collection;
import ru.avalon.java.dev.j120.laboratory.entity.Order;

/**
 *
 * @author buzzz
 */
public interface OrderDao {
    public Collection<Order> findAll();
    public Order findById(Integer id);
    public Order save(Order order);
}
