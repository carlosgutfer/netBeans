/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pablo;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Pablo
 */

public class MiClaseOutput extends ObjectOutputStream { //modificar fichero serializable
    MiClaseOutput(FileOutputStream f) throws IOException{
    super(f);
}
 protected void writeStreamHeader() throws IOException{}
}