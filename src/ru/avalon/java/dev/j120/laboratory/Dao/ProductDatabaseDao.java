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
import ru.avalon.java.dev.j120.laboratory.entity.Product;

/**
 *
 * @author buzzz
 */
public class ProductDatabaseDao implements ProductDao {
    private static final String FIND_ALL_QUERY = "select article, name, color, price, stockbalance from product";
    private static final String FIND_BY_ID_QUERY = "select article, name from product where article = ?";
    private static final String INSERT_QUERY = "insert into product(article, name, color, price, stockbalance) values(?, ?, ?, ?, ?)";

    @Override
    public Collection<Product> findAll() {
        List<Product> products = new ArrayList();
        
        try(Connection connection = ConnectionManager.getConnection();
                Statement st = connection.createStatement();
                ResultSet result = st.executeQuery(FIND_ALL_QUERY)) {
            
            while (result.next()) {
                Product product = resultSetToProduct(result);
                products.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return products;
    }

    @Override
    public Product findById(String article) {
        try(Connection connection = ConnectionManager.getConnection();
                PreparedStatement st = connection.prepareStatement(FIND_BY_ID_QUERY);) {
            
            st.setString(1, article);
            ResultSet result = st.executeQuery();
            
            if(result.next()) {
                return resultSetToProduct(result);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public Product save(Product product) {
        try(Connection connection = ConnectionManager.getConnection();
                PreparedStatement st = connection.prepareStatement(INSERT_QUERY);) {
            
            st.setLong(1, product.getArticleNumber());
            st.setString(2, product.getName());
            st.setString(3, product.getColor());
            st.setBigDecimal(4, product.getPrice());
            st.setInt(5, product.getStockBalance());
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDatabaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return product;
    }
    
    private Product resultSetToProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product(resultSet.getString("article"), 
                resultSet.getString("name"), resultSet.getString("color"), 
                resultSet.getString("price"), resultSet.getString("stockbalance"));
        
        //product.setArticleNumber(resultSet.getLong("article"));
        //product.setName(resultSet.getString("name"));
        //product.setColor(resultSet.getString("color"));
        //product.setPrice(resultSet.getBigDecimal("price"));
        //product.setStockBalance0(resultSet.getInt("stockbalance"));
        
        return product;
    }
}
