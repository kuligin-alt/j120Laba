
package ru.avalon.java.dev.j120.laboratory.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ru.avalon.java.dev.j120.laboratory.entity.Goods;
import ru.avalon.java.dev.j120.laboratory.entity.Person;


public class GoodsIO {
    private static final String FILENAME = "goods.sob";
    
    public void copyPerson() {
        
        Goods good_1 = new Goods(12589, "apple", "green", 45.60, 10);
        saveGoods(good_1); 
        
        //Person newPerson = readPerson(FILENAME);
        //System.out.println(newPerson.toString());
        
    }
    
    private void saveGoods(Goods good_1) {
        try (ObjectOutputStream out = 
                new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(FILENAME)))) {
            
            out.writeObject(good_1);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private Person readPerson(String filename) {
        if(!filename.endsWith(".sob")) {
            return null;
        }
        try (ObjectInputStream in = 
                    new ObjectInputStream(
                            new BufferedInputStream(
                                    new FileInputStream(filename)))) {
            
            
            return (Person) in.readObject();
            
               
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
}
