/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author daniel
 */
public class modelo {
    private double numero1   = 0;
    private double numero2   = 0;
    private double resultado = 0;
    private String operacion = "";

    public double getNumero1() {
        return numero1;
    }

    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
    
    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
    
    public double sumar() {
        this.resultado = this.numero1 + this.numero2;
        return resultado;
    }
    
    public double restar() {
        this.resultado = this.numero1 - this.numero2;
        return resultado;
    }
    
    public double multiplicar() {
        this.resultado = this.numero1 * this.numero2;
        return resultado;
    }
    
    public double dividir() {
        this.resultado = this.numero1 / this.numero2;
        return resultado;
    }
    
    public double porcentaje() {
        this.resultado = this.numero1 * this.numero2 / 100;
        return resultado;
    }
}
