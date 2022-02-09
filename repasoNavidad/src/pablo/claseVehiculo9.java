/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pablo;

import java.io.*;

/**
 *
 * @author Pablo
 */
    public class claseVehiculo9 implements Serializable{
        private String matricula;
        private String marca;
        private Double capacidad;
        private String modelo;

        public claseVehiculo9(String matricula, String marca, Double capacidad, String modelo) {
            this.matricula = matricula;
            this.marca = marca;
            this.capacidad = capacidad;
            this.modelo = modelo;
        }

        public String getMatricula() {
            return matricula;
        }

        public void setMatricula(String matricula) {
            this.matricula = matricula;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public Double getCapacidad() {
            return capacidad;
        }

        public void setCapacidad(Double capacidad) {
            this.capacidad = capacidad;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        @Override
        public String toString() {
            return "Vehiclo{" + "matricula=" + matricula + ", marca=" + marca + ", capacidad=" + capacidad + ", modelo=" + modelo + '}';
        }
    
}

