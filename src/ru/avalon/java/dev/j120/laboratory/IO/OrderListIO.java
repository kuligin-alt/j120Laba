
package ru.avalon.java.dev.j120.laboratory.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import ru.avalon.java.dev.j120.laboratory.entity.Order;


public class OrderListIO {
    private static final String FILENAME = "orderlist.dat";
    
    public ArrayList<Order> copyOrderList() {
        
        ArrayList<Order> orderListLoad = readOrderList(FILENAME);
        return orderListLoad;
    }
    
    public void saveOrderList(ArrayList<Order> orderList) {
        try (ObjectOutputStream out = 
                new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(FILENAME)))) {
            
            out.writeObject(orderList);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private  ArrayList<Order> readOrderList(String filename) {
        if(!filename.endsWith(".dat")) {
            return null;
        }
        try (ObjectInputStream in = 
                    new ObjectInputStream(
                            new BufferedInputStream(
                                    new FileInputStream(filename)))) {
            
            
            return ( ArrayList<Order>) in.readObject();
            
               
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            
        }
        
        return null;
    }
}
