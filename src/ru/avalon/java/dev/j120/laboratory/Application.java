
package ru.avalon.java.dev.j120.laboratory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import ru.avalon.java.dev.j120.laboratory.Dao.ProductDao;
import ru.avalon.java.dev.j120.laboratory.Dao.ProductDatabaseDao;
import ru.avalon.java.dev.j120.laboratory.IO.GoodsIO;
import ru.avalon.java.dev.j120.laboratory.IO.*;
import ru.avalon.java.dev.j120.laboratory.UI.NewJFrame;
import ru.avalon.java.dev.j120.laboratory.entity.*;

public class Application {
    private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    
    public static void main(String[] args) throws IOException {
        
        // Подключение драйвера базы данных:
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.exit(1);
        }
        
        //createGoodList();
        
        
        // Запуск UI:
        NewJFrame newJFrame = new NewJFrame();
        newJFrame.main2();
          
    }
    
    // Метод перекладывает товары из файла в БД:
    public static void createGoodList() throws IOException {
        
        GoodsIO listGood = new GoodsIO();
        String text = new String(listGood.goodsIO());
        
        ProductDao productDao = new ProductDatabaseDao();
        
        String [] lines = text.split("\n");
        for(String line : lines) {
            String [] words = line.split(";");
            
            Product newProduct = productDao.findById(words[0]);
                    
            if (words[2].equals("")) {
                if (newProduct == null) {
                    newProduct = new Product(words[0], words[1], "не указан", words[3], words[4]);
                    productDao.save(newProduct);
                }
                
            } else {
                if (newProduct == null) {
                    newProduct = new Product(words[0], words[1], words[2], words[3], words[4]);
                    productDao.save(newProduct);
                }
            }
        }
    }   
}