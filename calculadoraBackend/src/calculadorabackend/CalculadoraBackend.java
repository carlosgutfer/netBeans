/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorabackend;

/**
 *
 * @author carlo
 */
public class CalculadoraBackend {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        switch(args[0])
        {
            case "suma":
                    System.out.println(Integer.parseInt(args[1]) + Integer.parseInt(args[2]));
                break;
            case "resta":
                    System.out.println(Integer.parseInt(args[1]) - Integer.parseInt(args[2]));
                break;
            case "multiplicacion":
                    System.out.println(Integer.parseInt(args[1]) * Integer.parseInt(args[2]));
                break;
            case "division":
                try
                {
                    System.out.println(Integer.parseInt(args[1]) / Integer.parseInt(args[2]));
                }catch(Exception e){System.out.println(e);}
                break;
            default:
                System.out.println("El primer parámetro no es suma/resta/multiplicacion/divison");  
        }      
    }
    
}
