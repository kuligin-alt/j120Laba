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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.avalon.java.dev.j120.laboratory.ConnectionManager;
import ru.avalon.java.dev.j120.laboratory.entity.Order;
import ru.avalon.java.dev.j120.laboratory.entity.Product;

/**
 *
 * @author buzzz
 */
public class OrderDatabaseDao { //implements OrderDao {
    
    private static final String FIND_ALL_QUERY = "select creationdateorder, person, orderstatus, discount from order";
    private static final String FIND_BY_ID_QUERY = "select id from person where id = ?";
    private static final String INSERT_QUERY = "insert into order(creationdateorder, person, orderstatus, discount) values(?, ?, ?, ?)";
    
    /*
    @Override
    public Collection<Order> findAll() {
        List<Order> orders = new ArrayList();
        
        try(Connection connection = ConnectionManager.getConnection();
                Statement st = connection.createStatement();
                ResultSet result = st.executeQuery(FIND_ALL_QUERY)) {
            
            while (result.next()) {
                Order order = resultSetToOrder(result);
                orders.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return orders;
    }

    @Override
    public Order findById(Integer id) {
        try(Connection connection = ConnectionManager.getConnection();
                PreparedStatement st = connection.prepareStatement(FIND_BY_ID_QUERY);) {
            
            st.setInt(1, id);
            ResultSet result = st.executeQuery();
            
            if(result.next()) {
                return resultSetToOrder(result);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public Order save(Order order) {
        try(Connection connection = ConnectionManager.getConnection();
                PreparedStatement st = connection.prepareStatement(INSERT_QUERY);) {
            
            st.setLocalDate(1, order.getCreationDateOrder());
            st.setString(2, order.);
            st.setString(3, order.getColor());
            st.setString(4, order.getColor());
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return order;
    }
    
    private Order resultSetToOrder(ResultSet resultSet) throws SQLException {
        Order order = new Order(resultSet.getString("article"), 
                resultSet.getString("name"), resultSet.getString("color"), 
                resultSet.getString("price"), resultSet.getString("stockbalance"));
        
        
        return order;
    }
    */
}
