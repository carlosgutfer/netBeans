/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosrepasoserializable.Ejercicio2;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author carlo
 */
public class ClaseOutput extends ObjectOutputStream
{

    public ClaseOutput(OutputStream out) throws IOException {
        super(out);
    }

    protected void writeStreamHeader() throws IOException {}
}
