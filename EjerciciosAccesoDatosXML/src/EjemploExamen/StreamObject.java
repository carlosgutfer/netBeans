/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploExamen;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author carlo
 */
public class StreamObject extends ObjectOutputStream {

    public StreamObject(FileOutputStream out) throws IOException {
        super(out);
    }
    
    protected void writeStreamHeader() throws IOException {
    }

   
    
    
    
}
