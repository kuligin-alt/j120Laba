
package ru.avalon.java.dev.j120.laboratory.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import ru.avalon.java.dev.j120.laboratory.entity.OrderProduct;

public class OrderProducListIO {
    private static final String FILENAME = "orderProductlist.dat";
    
    public LinkedHashSet<OrderProduct> copyOrderList() {
        
        LinkedHashSet<OrderProduct> orderProductListLoad = readOrderProductList(FILENAME);
        return orderProductListLoad;
    }
    
    public void saveOrderProductList(LinkedHashSet<OrderProduct> orderProductList) {
        try (ObjectOutputStream out = 
                new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(FILENAME)))) {
            
            out.writeObject(orderProductList);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private  LinkedHashSet<OrderProduct> readOrderProductList(String filename) {
        if(!filename.endsWith(".dat")) {
            return null;
        }
        try (ObjectInputStream in = 
                    new ObjectInputStream(
                            new BufferedInputStream(
                                    new FileInputStream(filename)))) {
            
            
            return ( LinkedHashSet<OrderProduct>) in.readObject();
            
               
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            
        }
        
        return null;
    }
}
