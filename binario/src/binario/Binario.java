/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
Enunciado del ejercicio: 
En una empresa se tiene un fichero binario “nominas.dat” que almacena en cada registro 
el nombre de cada empleado (String) con el número de días de baja (int) y su nómina (double). 
Hacer un programa que actualice las nóminas de forma que:
- a los que tengan 0 días de baja se le hace un aumento del 5%, 
- a los que tengan entre 1 y 3 días de baja se quedan con la misma nómina, 
- a los que tengan entre 4 y 10 se les baja un 10% y 
- a los que tengan más de 10 días de baja se les se elimina del fichero.
Finalmente, se escribirá en pantalla el fichero “nominas.dat” ya actualizado, indicando
a cuantos empleados se ha dado de baja.
*/
public class Binario  {

     private File f1a, d1;
     private Scanner sc = new Scanner(System.in);
     private FileOutputStream fos;
     private DataOutputStream dos;
     private FileInputStream fis;
     private DataInputStream dis;
     private ArrayList<empleado> allEmpleados = new ArrayList();

    public static void main(String[] args)  {
            Binario init = new Binario();
            init.menu();
    }

    private void menu() {
        try {
          initFile();
        } catch (IOException e) {
            System.out.println("binario.Binario.menu()");
        }
        addEmployers();
        modifyEmployerV2();
    }


    private void addEmployers() {
        try{
            writeInit();
            do{
                System.out.println("Quiere añadir un nuevo registro (y/n):");
                if(sc.next().equals("n"))
                    break;
                System.out.println("Introduzca el nombre del empleado");
                dos.writeUTF(sc.next());
                System.out.println("Introduzca el número de días de baja");
                dos.writeInt(sc.nextInt());
                System.out.println("Introduzca la nómina");
                dos.writeFloat(sc.nextFloat());
                sc.nextLine();
            }while(true);
            dos.close();
            fos.close();
        }catch(IOException e){
            
        }
        showAllEmployers();
    }
    private void showAllEmployers() {
        try{
               readInit();
            try{
                while (true){
                  System.out.println(dis.readUTF()+" "+dis.readInt()+" "+dis.readFloat());    
                  System.out.println("!");
                    }
                }catch(EOFException e){

                }catch(IOException e){
                    System.err.println("(\"\" + e + \"Error en lectura del fichero\");");
                }
               readEnd();   
         }catch (IOException e){
             
            System.out.println("binario.Binario.showAllEmployers()");        
         }
          
        }
    private void modifyEmployer() {
        try{
            readInit();
            File fx = new File("auxiliar.dat");
            FileOutputStream fos = new FileOutputStream(fx);
            //FileOutputStream fos = new FileOutputStream("auxiliar.dat");
            DataOutputStream dos = new DataOutputStream(fos);            
            
            try{
                 int piContBajas= 0;
                while(true){
                    boolean wbEliminar = false;
                    String wsEmpleado = dis.readUTF();
                    int    wiDiasDeBaja = dis.readInt();
                    double wuNomina = dis.readDouble();
                    
                    if (wiDiasDeBaja == 0)
                        wuNomina = wuNomina + (wuNomina*0.05); 
                    
                    if (wiDiasDeBaja >= 4 && wiDiasDeBaja <= 10)
                        wuNomina = wuNomina - (wuNomina*0.1);  
                    
                    if (wiDiasDeBaja >10)
                        wbEliminar = true;
                    
                    if (!wbEliminar){
                        dos.writeUTF(wsEmpleado);
                        dos.writeInt(wiDiasDeBaja);
                        dos.writeDouble(wuNomina);
                    }else
                        piContBajas++;
					
                }//while
            }catch(EOFException e){
                System.out.println("mvActualizarFichDeNominas()--Lectura de fichero terminada\n");
            }catch(IOException e){
               System.out.println("Error IO "+ e +"Error en lectura o escritura de uno de los ficheros\n");
            }            
            
            dos.close();
            fos.close();
            dis.close();
            fis.close();
			
            f1a.delete();
            fx.renameTo(f1a); 

			
        }catch (IOException e){System.out.println("");}
        showAllEmployers();

    }
    private void modifyEmployerV2() {
        try{
            readInit();           
            try{
                 int piContBajas= 0;
                while(true){
                    boolean wbEliminar = false;
                    String wsEmpleado = dis.readUTF();
                    int    wiDiasDeBaja = dis.readInt();
                    double wuNomina = dis.readDouble();
                    
                    if (wiDiasDeBaja == 0)
                        wuNomina = wuNomina + (wuNomina*0.05); 
                    
                    if (wiDiasDeBaja >= 4 && wiDiasDeBaja <= 10)
                        wuNomina = wuNomina - (wuNomina*0.1);  
                    
                    if (wiDiasDeBaja >10)
                        wbEliminar = true;
                    
                    if (!wbEliminar){
                        allEmpleados.add(new empleado(wiDiasDeBaja,wsEmpleado,wuNomina));
                    }else
                        piContBajas++;
					
                }//while
             
            }catch(EOFException e){
                System.out.println("mvActualizarFichDeNominas()--Lectura de fichero terminada\n");
            }catch(IOException e){
               System.out.println("Error IO "+ e +"Error en lectura o escritura de uno de los ficheros\n");
            }       
           
   
               readEnd();
               f1a.delete();
               initFile();
               writeInit();
           
              allEmpleados.forEach((t) -> {
                try {
                    dos.writeUTF(t.getName());
                    dos.writeInt(t.getDaysOut());
                    dos.writeDouble(t.getSalary());
                    dos.flush();
                } catch (IOException ex) {
                    Logger.getLogger(Binario.class.getName()).log(Level.SEVERE, null, ex);
                }
               });
            allEmpleados.clear();
            writeEnd();
          
			
			
        }catch (IOException e){System.out.println("");}
        showAllEmployers();

    }
    
    private void initFile() throws IOException {
        
       d1 = new File (("C:/binario").replace('/', File.separatorChar));
       this.f1a= new File ((("C:/binario/nominas.dat").replace('/', File.separatorChar)));
       
      
        if ( !d1.exists()){
            d1.mkdirs();
        }else if (!f1a.exists()){
            f1a.createNewFile();
        }
    }
    private void readInit()throws IOException{
        fis = new FileInputStream(f1a);
        dis = new DataInputStream(fis); 
    } 
    private void readEnd() throws IOException{
         fis.close();
         dis.close();
    }
    private void writeInit() throws IOException{ 
        fos = new FileOutputStream(f1a,true);
        dos = new DataOutputStream(fos);
    }
    private void writeEnd() throws IOException{
           dos.close();
           fos.close();
    }
}


