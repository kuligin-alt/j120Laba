
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
import ru.avalon.java.dev.j120.laboratory.entity.Product;


public class GoodListIO {
    private static final String FILENAME = "goodlist.dat";
    
    public ArrayList<Product>  copyGood() {
        
        ArrayList<Product> goodLoad = readGoodList(FILENAME);
        return goodLoad;
        //System.out.println(orderLoad.toString());
        
    }
    
    public void saveGoodList(ArrayList<Product> goodList) {
        try (ObjectOutputStream out = 
                new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(FILENAME)))) {
            
            out.writeObject(goodList);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private ArrayList<Product> readGoodList(String filename) {
        if(!filename.endsWith(".dat")) {
            return null;
        }
        try (ObjectInputStream in = 
                    new ObjectInputStream(
                            new BufferedInputStream(
                                    new FileInputStream(filename)))) {
            
            
            return (ArrayList<Product>) in.readObject();
            
               
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            
        }
        
        return null;
    }
}
