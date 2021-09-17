/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectorficheros;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author carlo
 */
public class LectorFicheros {

    static private File f1;
    
    public static void main(String[] args) throws IOException {
            f1 = new File("lectorFichero.txt");
            f1.createNewFile();
            FileWriter fw = new FileWriter(f1);
            
            fw.append("carlos;25;");
            fw.close();
            
            
            FileReader fr = new FileReader(f1);
            String name = "", age = "";
            char st;
            int para=0;
            int wi;
            
            while (( wi = fr.read())!=-1){
                   st= (char)wi;
             if (para ==0){      
                if(st!=';')
                    name +=st;
                if(st==';')
                    para=1;
             }
             else if (para == 1 ){
                 if(st!=';')
                     age +=st;
                 else if(st==';'){
                     para=0;
                     System.out.println(" "+name+" "+age);
                 }   
             }
             
            };
            fr.close();
    }
    
}
