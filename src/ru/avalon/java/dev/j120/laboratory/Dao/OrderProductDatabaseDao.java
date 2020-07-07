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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.avalon.java.dev.j120.laboratory.ConnectionManager;
import ru.avalon.java.dev.j120.laboratory.entity.OrderProduct;
import ru.avalon.java.dev.j120.laboratory.entity.Product;

/**
 *
 * @author buzzz
 */
public class OrderProductDatabaseDao implements OrderProductDao {
    private static final String FIND_ALL_QUERY = "select article, name, color, amount, price from orderproduct";
    private static final String FIND_BY_ID_QUERY = "select article, name from orderproduct where article = ?";
    private static final String INSERT_QUERY = "insert into orderproduct(article, name, color, amount, price) values(?, ?, ?, ?, ?)";

    @Override
    public LinkedHashSet<OrderProduct> findAll() {
        LinkedHashSet<OrderProduct> orderProducts = new LinkedHashSet();
        
        try(Connection connection = ConnectionManager.getConnection();
                Statement st = connection.createStatement();
                ResultSet result = st.executeQuery(FIND_ALL_QUERY)) {
            
            while (result.next()) {
                OrderProduct orderProduct = resultSetToOrderProduct(result);
                orderProducts.add(orderProduct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return orderProducts;
    }

    @Override
    public OrderProduct findById(Long article) {
        try(Connection connection = ConnectionManager.getConnection();
                PreparedStatement st = connection.prepareStatement(FIND_BY_ID_QUERY);) {
            
            st.setLong(1, article);
            ResultSet result = st.executeQuery();
            
            if(result.next()) {
                return resultSetToOrderProduct(result);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public OrderProduct save(OrderProduct orderProduct) {
        try(Connection connection = ConnectionManager.getConnection();
                PreparedStatement st = connection.prepareStatement(INSERT_QUERY);) {
            
            st.setLong(1, orderProduct.getArticleOrderProduct());
            st.setString(2, orderProduct.getNameOrderProduct());
            st.setString(3, orderProduct.getColorOrderProduct());
            st.setInt(4, orderProduct.getAmountOrderProduct());
            st.setBigDecimal(5, orderProduct.getPriceOrderProduct());
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return orderProduct;
    }
    
    private OrderProduct resultSetToOrderProduct(ResultSet resultSet) throws SQLException {
        OrderProduct orderProduct = new OrderProduct(resultSet.getLong("article"), 
                resultSet.getString("name"), resultSet.getString("color"), 
                resultSet.getInt("amount"), resultSet.getBigDecimal("price"));
        
        
        return orderProduct;
    }
    
}
