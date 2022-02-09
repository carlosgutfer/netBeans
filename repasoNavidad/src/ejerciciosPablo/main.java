package ejerciciosPablo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Pablo
 */
public class main {
    public  void main(String[] args) {
       File fcBin = new File("vehiculo.dat"); 
       
       File fcSeria = new File("vehiculo.obj");
        try {
            fcBin.createNewFile(); // Ficj Binario
            fcSeria.createNewFile(); //Fich Serialozable
            
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        try {
            FileOutputStream fos2 = new FileOutputStream(fcSeria);
            ObjectOutputStream oos = new ObjectOutputStream(fos2);
            
             oos.writeObject(new claseVehiculo("4842FLK", "Audi", 65.3, "A6-Avant"));
             
            oos.close();
            fos2.close();
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        //Escribir en el Serializable
       // try {
          //  FileOutputStream fos = new FileOutputStream(fcSeria,true);
          //  MiClaseOutput moo = new MiClaseOutput(fos);
            
            // LEER FICH BINARIO
            try {
            
                FileOutputStream fos = new FileOutputStream(fcSeria,true);
                MiClaseOutput moo = new MiClaseOutput(fos);
            
                
                FileInputStream fis = new FileInputStream(fcBin);
                DataInputStream dis = new DataInputStream(fis);
            
                String marca;
                String modelo;
                double capacidad;
                String matricula;
               
                //Acceder a cada valor de la linea (Registro)
                try {

                    while(true){
                        marca = dis.readUTF();
                        modelo = dis.readUTF();
                        capacidad = dis.readDouble();
                        matricula = dis.readUTF();
                        
                       // System.out.println("Marca: "+marca+" Modelo: "+modelo);
                    //Nueva linea como objeto > usando el constructor de la clase vehiculo
                        moo.writeObject(new claseVehiculo(matricula, marca, capacidad, modelo));
                        
                        moo.close();
                        fos.close();
                    }
                } catch (IOException e) {
                }

                dis.close();
                fis.close();
               
            } catch (IOException ex) {
                System.out.println("FINAL DEL FICHERO");
            }    
            
        //} catch (FileNotFoundException ex) {
       //     Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
      /*  }catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}


/*
                try {
                                    //esxribir serializable 
                
            FileOutputStream fos = new FileOutputStream(fcSeria); // añade al fichero == tipo Alumno
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
                oos.writeObject(new claseVehiculo("4842FLK", "Audi", 65.3, "A6-Avant"));
            
      

                    
                } catch (Exception e) {
                }
*/