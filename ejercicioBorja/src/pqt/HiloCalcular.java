
package pqt;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class HiloCalcular implements Runnable{
    
    private HashMap<BigInteger,BigInteger> map = new HashMap<>();
    private final BigInteger dos = new BigInteger("2");
    private final BigInteger tres = new BigInteger("3");
    private final BigInteger uno = new BigInteger("1");
    private final BigInteger cero = new BigInteger("0");
    private final BigInteger cuatro = new BigInteger("4");
    private Datos datos;
    private int longitudCadena;
    private final int instruccion;
    private ArrayList<BigInteger> numerosAAnalizar;
    private int longitudCadenaMasLarga = 0;
    private ArrayList<BigInteger> cadenaMasLarga = new  ArrayList<>();
    private BigInteger mayor = cero;

    public HiloCalcular(Datos datos, int instruccion) {
        this.datos = datos;
        this.instruccion = instruccion;
        if(instruccion == 1){            
            numerosAAnalizar = datos.enviarRango();
        }
    }   
    
    @Override
    public void run() {
        if(instruccion == 0){
            BigInteger numAComprobar;
            while (!(numAComprobar = datos.enviarUnNumero()).equals(cero)) {
                boolean result = comprobarNumero(numAComprobar);
                if(!result)
                    datos.comprobarSiCumple(result, numAComprobar);
            }
        }else{
            for(BigInteger numAComprobar : numerosAAnalizar) {                            
                boolean result = comprobarNumero(numAComprobar);
                if(!result)
                    datos.comprobarSiCumple(result, numAComprobar);
            }
        }
        
        datos.comprobarCadenaMasLarga(longitudCadenaMasLarga, cadenaMasLarga, mayor);
    }
    
    private boolean comprobarNumero(BigInteger numAComprobar){
        map.clear();
        boolean cumpleLaSecuencia = true;
        BigInteger siguienteNumero;
        BigInteger inicio = numAComprobar;
        BigInteger mayor = numAComprobar;
        longitudCadena = 1;
        boolean salir = false;
        
        while (!salir) {            
            if(numAComprobar.remainder(dos).equals(cero)){
                siguienteNumero = numAComprobar.divide(dos);
            }else{
                siguienteNumero = (numAComprobar.multiply(tres)).add(uno);
            }
            
            if(siguienteNumero.compareTo(this.mayor) > 0)
                this.mayor = siguienteNumero;
            
            boolean comprobado = datos.yaEstaComprobado(numAComprobar);            
            if(map.containsKey(siguienteNumero) || comprobado){
                salir = true;  
                if(!map.containsKey(cuatro) && !map.containsKey(dos) && !comprobado)
                    cumpleLaSecuencia = false;
                if(comprobado){
                    //No comprendo porque salta el error si cuando entra aqui
                    //es porque ese numero ya esta en el HashMap principal
                    //por lo que si o si deberia de tener asociada una longitud
                    longitudCadena += datos.sacarLongitud(numAComprobar);
                }
            }else{
                map.put(numAComprobar, siguienteNumero);
                numAComprobar = siguienteNumero;
                ++longitudCadena;
            }
        }
        //Aunque analice algun numero de mas, es mas eficiente si añade cadenas
        //enteras que si se añade al HashMap principal en cada iteracion
        datos.añadirAAnalizados(map,longitudCadena - 1 ,inicio);
        comprobarCadenaMasLarga(inicio, longitudCadena);
        return cumpleLaSecuencia;
    }
    
    private void comprobarCadenaMasLarga(BigInteger numero, int longitudDeCadena){
        if(longitudDeCadena == longitudCadenaMasLarga){
            cadenaMasLarga.add(numero);
        }else if(longitudDeCadena > longitudCadenaMasLarga){
            cadenaMasLarga.clear();
            longitudCadenaMasLarga = longitudDeCadena;
            cadenaMasLarga.add(numero);
        }
    }   
    
    private HashMap<BigInteger,Integer> guardarLongitudes(int segunda,BigInteger inicio, HashMap<BigInteger,BigInteger> mapa){
        HashMap<BigInteger, Integer> longitudes = new HashMap<>();
        BigInteger numero = inicio; 
        for (int i = longitudCadena + segunda; i > segunda; i--) {
            longitudes.put(numero, longitudCadena);
            numero = mapa.get(numero);
        }
        
        return longitudes;
    }
}
