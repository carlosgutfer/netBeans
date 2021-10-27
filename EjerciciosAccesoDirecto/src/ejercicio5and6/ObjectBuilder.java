/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5and6;

import com.sun.xml.internal.messaging.saaj.packaging.mime.Header;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author carlo
 */
public class ObjectBuilder extends ObjectOutputStream
{

    public ObjectBuilder(FileOutputStream out) throws IOException {
        super(out);
    }
    
    protected void writeStreamHeader() throws  IOException{}
}
