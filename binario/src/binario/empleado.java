/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;


public class empleado {
private int daysOut;
private String name;
private double salary; 

    public empleado(int daysOut, String name, double salary) {
        this.daysOut = daysOut;
        this.name = name;
        this.salary = salary;
    }

    public int getDaysOut() {
        return daysOut;
    }

    public void setDaysOut(int daysOut) {
        this.daysOut = daysOut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

}
