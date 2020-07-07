/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.dev.j120.laboratory.Dao;

import java.util.Collection;
import ru.avalon.java.dev.j120.laboratory.entity.Person;
import ru.avalon.java.dev.j120.laboratory.entity.Product;

/**
 *
 * @author buzzz
 */
public interface PersonDao {
    public Collection<Person> findAll();
    public Person findById(Integer id);
    public Person save(Person person);
}
