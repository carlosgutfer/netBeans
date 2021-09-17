/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class Files {
      private File f1a,f2,f3,f4,f6,dir1,dir2,dir3,dir4;
       private FileWriter fw;
       private FileReader fr;
       private char pc = File.separatorChar;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      /* Scanner woTeclado = new Scanner(System.in);
       String ws1 = woTeclado.nextLine();*/
       
       Files newFile = new Files(); 
      
       newFile.Files();
       newFile.Directories();
       
       try{
           newFile.createDirectories();
           newFile.createFiles();
           System.out.println("correct");
       }catch(IOException exception){
          exception.printStackTrace();    
       }
       
       try{
       newFile.permisionFiles();
       newFile.writeSomething();
       newFile.readSomething();
       newFile.readAllText();
       }catch(IOException exception){
                exception.printStackTrace();
       }catch(Exception e){
            
        }
        // TODO code application logic here
    }


    private void Files() {
        this.f1a = new File("document1.txt");
        this.f2 = new File("documento2.txt");
        this.f3 = new File("C:kk/documento3.txt".replace('/', pc)); 
        this.f4 = new File("C:/kk", "documento4.txt".replace('/', pc)); 
        this.f6 = new File (dir1,"documento6.txt");
    }
    private void Directories(){
        
        this.dir1 = new File("dir1");
        this.dir2 = new File("ruta2/dir2".replace('/', pc));
        this.dir3 = new File("ruta3/dir3".replace('/', pc));  
        this.dir4 = new File("C:/kk".replace('/', pc));
    }
    private void createDirectories(){
            dir1.mkdirs();
            dir2.mkdirs();
            dir3.mkdirs();
            dir4.mkdirs();
            
    }
    private void createFiles() throws IOException{
       f1a.createNewFile();
       f2.createNewFile();
       f3.createNewFile();
       f4.createNewFile();
       f6.createNewFile();
    }
    
    private void permisionFiles(){
            System.out.println(f1a.length()+" "+f1a.canRead()+" "+f1a.getAbsolutePath()+" "+f1a.canWrite());
            
    }
    
    private void writeSomething() throws IOException{
        fw = new FileWriter(f1a,true);
         
        persona newPersona = new persona("carlos",26);
        fw.write(""+newPersona);
              newPersona = new persona("Aida",23);
        fw.write(""+newPersona);
        fw.close();
    }
    
    private void readSomething() throws IOException{
        
      fr = new FileReader(f1a);
      char c =(char)fr.read();
      for(int i=0;i<f1a.length();i++){
            System.out.println((char)c);
            c =(char)fr.read();
      }
        fr.close();
        
    }
    
    private void readAllText() throws IOException{
         String texto = "";
        
            FileReader fr = new FileReader(f1a);
            BufferedReader br = new BufferedReader(fr);
            texto = br.readLine();
            while (texto != null) {
                System.out.println(texto);
                texto = br.readLine();
            }
            br.close();
            fr.close();
    }
    
    
}
/*
    public static void main00() {
        $$("--------------- salida del main00");

       
/// import java.io.File;


///C:\kk
        File f3 = new File("C:\\kk\\MiFichero3.txt"); // la carpeta kk si existe
        //File f31 = new File ("C:\\kkk\\MiFichero31.txt");   // la carpeta kkk no existe
        File f4 = new File("C:\\kk", "MiFichero4.txt"); // un constructor con dos parámetros
        File dir1 = new File("dir1");
        File dir2 = new File("ruta2\\dir2");
        File dir3 = new File("ruta3\\dir3");        
        File f6 = new File(dir1, "MiFichero6.txt");
        
        try{
            f1a.createNewFile();
            f2.createNewFile();
            f3.createNewFile();
            //f31.createNewFile();
            f4.createNewFile();
            dir1.mkdir();
            dir2.mkdir();
            dir3.mkdirs();  
            f6.createNewFile();
        }catch (IOException ioe) {ioe.printStackTrace();}            

        $$("Nombre del fichero:     " + f1a.getName());
        $$("Path relativo:          " + f1a.getPath());
        $$("Path absoluto:          " + f1a.getAbsolutePath());       
        $$("Permiso de lectura:     " + f1a.canRead());
        $$("Permiso de escritura:   " + f1a.canWrite());
        $$("Longitud:               " + f1a.length());
        $$("Es un Fichero:          " + f1a.isFile());
        $$("Es un Directorio:       " + f1a.isDirectory()); 
        $$("Antes de borrarlo:      " + f1a.exists());
        f1a.delete(); // borramos f1a  
        $$("después de borrarlo:    " + f1a.exists()); 
        
        File dir11 = new File(".");
        String [] was = dir11.list();        
        $("Total de Ficheros y directorios: "+was.length + "\n" + 
                "Path absoluto: "+dir11.getAbsolutePath() + "\nFicheros:\n" );
        for(String ws : was) $$(ws); $$("");
        
        dir11 = new File("..");
        was = dir11.list();        
        $("Total de Ficheros y directorios: "+was.length + "\n" + 
                "Path absoluto: "+dir11.getAbsolutePath() + "\nFicheros:\n" );
        for(String ws : was) $$(ws);  $$("");    

         String ws = woTeclado.nextLine();       
        
        File f99 = new File("Fichero99.txt");       
        if (f99.exists())
            f99.delete();
        $$("Despues de borrar el f99:      " + f99.exists());
          ws = woTeclado.nextLine();
       
        $$("Nombre del fichero:     " + f2.getName());   
        f2.renameTo(f99);  // Le cambiamos el nombre 
        $$("después de renombrarlo:    " + f2.exists()); 
        $$("Nombre del fichero:     " + f2.getName());     

        $$("después de renombrarlo:    " + f99.exists()); 
        $$("Nombre del fichero:     " + f99.getName());     

     }//main0()*/