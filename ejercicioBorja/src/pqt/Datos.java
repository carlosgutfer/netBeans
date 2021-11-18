
package pqt;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Datos {
    private ArrayList<BigInteger> noCumplenLaSecuiencia;
    private HashMap<BigInteger,BigInteger> analizados;
    private ArrayList<BigInteger> cadenaMasLarga;
    private int longitudCadenaMasLarga;
    private BigInteger inicio;
    private BigInteger fin;
    private BigInteger numeroAEnviar;
    private BigInteger rango;
    private  BigInteger mayor;
    private int contadorHilos;
    private int numHilos;
    private HashMap<BigInteger, Integer> longitudes = new HashMap<>();

    public Datos(String inicio, String fin, int numHilos) {
        noCumplenLaSecuiencia = new ArrayList<>();
        analizados = new HashMap<>();
        cadenaMasLarga = new ArrayList<>();
        longitudCadenaMasLarga = 0;
        contadorHilos = 1;
        mayor = new BigInteger("1");
        this.numHilos = numHilos;
        this.inicio = new BigInteger(inicio);
        this.fin = new BigInteger(fin);
        this.numeroAEnviar = this.inicio;
        rango = this.fin.subtract(this.inicio);
        rango = rango.divide(BigInteger.valueOf(numHilos));
    }
    
    
    
    public synchronized BigInteger enviarUnNumero(){
        BigInteger pasar = null;
        
        if(numeroAEnviar.compareTo(fin) <= 0  ){
            pasar = numeroAEnviar;
            numeroAEnviar = numeroAEnviar.add(new BigInteger("1"));
        }else{
            pasar = new BigInteger("0");
        }
        return pasar;
    }
    
    public ArrayList<BigInteger> enviarRango (){
        ArrayList<BigInteger> pasar = new ArrayList<>();        
        
        if(contadorHilos < numHilos){
            BigInteger suma = numeroAEnviar.add(rango);
            while (numeroAEnviar.compareTo(suma) < 0) {                
                pasar.add(numeroAEnviar);   
                numeroAEnviar = numeroAEnviar.add(new BigInteger("1"));
            }
        }else{
            while (numeroAEnviar.compareTo(fin) <= 0) {                
                pasar.add(numeroAEnviar);
                numeroAEnviar = numeroAEnviar.add(new BigInteger("1"));
            }
        }
        
        ++contadorHilos;
        return pasar;
        
    }
    
    public synchronized void comprobarCadenaMasLarga(int longitud,
            ArrayList<BigInteger> cadenasMasLargas, BigInteger mayor){
        if(longitudCadenaMasLarga == longitud){
            cadenaMasLarga.addAll(cadenasMasLargas);
            longitudCadenaMasLarga = longitud;
        }else if(longitudCadenaMasLarga < longitud){
            cadenaMasLarga.clear();
            cadenaMasLarga.addAll(cadenasMasLargas);
            longitudCadenaMasLarga = longitud;
        }
        
        if(mayor.compareTo(this.mayor) > 0){
            this.mayor = mayor;
        }
    }
    
    //Si el numero no cumple la secuencia lo añade a un ArrayList 
    public synchronized void comprobarSiCumple(boolean cumple, BigInteger numero){
        noCumplenLaSecuiencia.add(numero);
    }
    
    
    //Recibe el mapa con una cadena analizada y guarda esa cadena en el HashMap 
    //de analizados en total y guarda en otro HashMap cada numero con su longitud
    public synchronized void añadirAAnalizados(HashMap<BigInteger,BigInteger> mapa,
            int longitud, BigInteger inicio){
//        analizados.putAll(mapa);
//        
//        while(!longitudes.containsKey(inicio) && !inicio.equals(BigInteger.valueOf(1))){
//            longitudes.put(inicio, longitud);
//            --longitud;
//            inicio = analizados.get(inicio);
//        }
        
        while(!analizados.containsKey(inicio)){
            //Se guarda la longitud
            longitudes.put(inicio, longitud);
            --longitud;
            //Se guarda el numero con el siguiente que corresponda
            analizados.put(inicio, mapa.get(inicio));
            inicio = mapa.get(inicio);
        }
    }
    
//    public synchronized void añadirLongitud(HashMap<BigInteger,BigInteger> mapa,
//            int longitud, BigInteger inicio){
//        while(!longitudes.containsKey(inicio) && !inicio.equals(BigInteger.valueOf(1))){
//            longitudes.put(inicio, longitud);
//            --longitud;
//            inicio = mapa.get(inicio);
//        }
//    }
    
    public synchronized boolean yaEstaComprobado(BigInteger num){
        boolean salir = false;        
        if(longitudes.containsKey(num))
            salir = true;        
        
        return salir;
    }
    
//    public boolean yaEstaComprobado(BigInteger num){
//        if(longitudes.containsKey(num))
//            return true;        
//        return false;
//    }
    
    public void imprimir(){
        System.out.println("Cadenas mas largas:");        
        BigInteger uno = new BigInteger("1");
        
        for (int i = 0; i < cadenaMasLarga.size(); i++) {
            BigInteger numero = cadenaMasLarga.get(i);
            System.out.print(numero+", ");
            while(!numero.equals(uno)){
                numero = analizados.get(numero);                
                System.out.print(numero);
                if(!numero.equals(uno))
                    System.out.print(", ");
            }
            System.out.println("");
        }
        System.out.println("Longitud cadena mas larga:");
        System.out.println(longitudCadenaMasLarga);
        System.out.print("Mayor:");
        System.out.println(mayor);
        System.out.print("No cumplen la secuencia:");
        if(noCumplenLaSecuiencia.size() > 0)
            System.out.println(" "+noCumplenLaSecuiencia.get(0));
        else
            System.out.println(" <ninguno>");
    }
    
    public synchronized int sacarLongitud(BigInteger ppp){
        //Si no utilizo este if hay veces que devuelve un puntero nulo.
        //Aunque la diferencia de tiempo es casi inexistente ya que ocurre 
        //pocas veces, no comprendo porque ocurre 
//        if(!longitudes.containsKey(ppp)){
//            try {
//                System.out.println(ppp);
//                Thread.currentThread().sleep(8);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        return longitudes.get(ppp);
    }
    
}
