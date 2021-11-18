
package pqt;

import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        int numHilos = 4;
        Datos datos = new Datos("3", "100003", numHilos);
        
        double init = System.currentTimeMillis();
        
        Thread[] hilos = new Thread[numHilos];
        
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(new HiloCalcular(datos, 1));
            hilos[i].start();
        }
        
        for (int i = 0; i < hilos.length; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        double end = System.currentTimeMillis();
        
        double tiempo = (end - init)/ 1000;
        System.out.println("Tiempo trancurrido:\n"+ tiempo + " segundos");        
        datos.imprimir();        
    }
    
}
