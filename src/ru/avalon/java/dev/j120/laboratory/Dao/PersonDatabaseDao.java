/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.dev.j120.laboratory.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.avalon.java.dev.j120.laboratory.ConnectionManager;
import ru.avalon.java.dev.j120.laboratory.entity.Person;
import ru.avalon.java.dev.j120.laboratory.entity.Product;

/**
 *
 * @author buzzz
 */
public class PersonDatabaseDao implements PersonDao {
    private static final String FIND_ALL_QUERY = "select contactperson, deliveryaddress, phonenumber from person";
    private static final String FIND_BY_ID_QUERY = "select id from person where id = ?";
    private static final String INSERT_QUERY = "insert into person(contactperson, deliveryaddress, phonenumber) values(?, ?, ?)";

    @Override
    public Collection<Person> findAll() {
        List<Person> persons = new ArrayList();
        
        try(Connection connection = ConnectionManager.getConnection();
                Statement st = connection.createStatement();
                ResultSet result = st.executeQuery(FIND_ALL_QUERY)) {
            
            while (result.next()) {
                Person person = resultSetToPerson(result);
                persons.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return persons;
    }

    @Override
    public Person findById(Integer id) {
        try(Connection connection = ConnectionManager.getConnection();
                PreparedStatement st = connection.prepareStatement(FIND_BY_ID_QUERY);) {
            
            st.setInt(1, id);
            ResultSet result = st.executeQuery();
            
            if(result.next()) {
                return resultSetToPerson(result);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public Person save(Person person) {
        try(Connection connection = ConnectionManager.getConnection();
                PreparedStatement st = connection.prepareStatement(INSERT_QUERY);) {
            
            st.setString(1, person.getContactPerson());
            st.setString(2, person.getDeliveryAddress());
            st.setString(3, person.getPhoneNumber());
            
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return person;
    }
    
    private Person resultSetToPerson(ResultSet resultSet) throws SQLException {
        Person person = new Person(resultSet.getString("contactperson"), 
                resultSet.getString("deliveryaddress"), resultSet.getString("phonenumber"));
        
        
        return person;
    }
}
