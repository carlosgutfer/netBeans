/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosrepasoserializable.EJERCICIO1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author carlo
 */
public class ClaseOutput extends ObjectOutputStream { 
      ClaseOutput(FileOutputStream f) throws IOException{ 
        super(f); 
      } 
      protected void writeStreamHeader() throws IOException{} 
 }
