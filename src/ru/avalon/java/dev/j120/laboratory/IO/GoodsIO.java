
package ru.avalon.java.dev.j120.laboratory.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GoodsIO {
    
    public byte[] goodsIO() throws FileNotFoundException, IOException {
        
        FileInputStream stream = new FileInputStream("reassesment.csv");
        
        int lehgth = stream.available();
        byte[] data = new byte [lehgth];
        stream.read(data);
        
        return (data);
        
    }  
}
