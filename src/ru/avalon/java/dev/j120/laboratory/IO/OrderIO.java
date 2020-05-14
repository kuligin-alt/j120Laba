
package ru.avalon.java.dev.j120.laboratory.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ru.avalon.java.dev.j120.laboratory.entity.Order;


public class OrderIO {
    private static final String FILENAME = "order.dat";
    
    
    private void saveOrder(Order order) {
        try (ObjectOutputStream out = 
                new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(FILENAME)))) {
            
            out.writeObject(order);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private Order readOrder(String filename) {
        if(!filename.endsWith(".dat")) {
            return null;
        }
        try (ObjectInputStream in = 
                    new ObjectInputStream(
                            new BufferedInputStream(
                                    new FileInputStream(filename)))) {
            
            
            return (Order) in.readObject();
            
               
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
}
