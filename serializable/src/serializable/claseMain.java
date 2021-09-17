/*
 * To change this license header, chcoe License Headers in Project Properties.
 * To change this template file, chcoe Tools | Templates
 * and open the template in the editor.
 */
package serializable;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author carlo
 */
public class claseMain {

 
    
    private File f1,d1;
    private persona p1;
    
    public static void main(String[] args) throws ClassNotFoundException{
        claseMain init = new claseMain(); 
        init.menu();
    }

    private void menu() {
        initFileDir();
        if(!f1.exists()||f1.length()<0)
           addPerson();
        showAllPerson();
        raddPerson();
        showAllPerson();
    }

    private void initFileDir() {
        this.d1 = new File(("C:/personas").replace('/', File.separatorChar));
        this.f1 = new File ( ("C:/personas/persona.obj").replace('/',File.separatorChar));
        if (!d1.exists()||!f1.exists())
            try{
                d1.mkdir();
                f1.createNewFile();
            }catch (IOException e){

            }
    }

    private void addPerson() {
        
        try{
            FileOutputStream fos = new FileOutputStream(f1);
            ObjectOutputStream co = new ObjectOutputStream(fos);

            co.writeObject( new persona("carlos","25"));
            co.writeObject(new persona("Aida","23"));
            co.close();
            fos.close();
        }catch ( IOException e  ){
            
        }
        
    }
    private void raddPerson() {
        
        try{
            FileOutputStream fos = new FileOutputStream(f1,true);
            ClaseOuput co = new ClaseOuput(fos);

            co.writeObject( new persona("carlos","25"));
            co.writeObject(new persona("Aida","23"));
            co.close();
            fos.close();
        }catch ( IOException e  ){
            
        }
        
    }

    private void showAllPerson()   {
   
        try {
        FileInputStream fis = new FileInputStream(f1);
        ObjectInputStream ois = new ObjectInputStream(fis);
                
         
                try{
                    while(true){
                       persona p = (persona) ois.readObject();
                    System.out.println(p.getEdad());
                    
                    }                    
                }catch (EOFException ex) {
                    System.out.println("*********** FIN DE LOS REGISTROS *****************");
                }
            
            ois.close();
            fis.close();
        } catch ( ClassNotFoundException | IOException e) {
                System.out.println("a "+e);

        }
        
    }
    
    
    
}
