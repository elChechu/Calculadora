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
public class Calculadora {
    private Numero numero1;
    private Numero numero2;
    private Numero resultado;
    private String operacion = "";

    public Numero getNumero1() {
        return numero1;
    }

    public void setNumero1(Numero numero1) {
        this.numero1 = numero1;
    }

    public Numero getNumero2() {
        return numero2;
    }

    public void setNumero2(Numero numero2) {
        this.numero2 = numero2;
    }

    public Numero getResultado() {
        return resultado;
    }

    public void setResultado(Numero resultado) {
        this.resultado = resultado;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
    
    public boolean unifica() {
        if (this.numero1.base != 10) {
            this.numero1.a_10();
        }
        if (this.numero2 != null) {
            this.numero2.a_10();
            System.out.println(this.numero1.valor + this.operacion + this.numero2.valor + "=");
            
            return true;
        }
        return false;
    }
    
    public Numero sumar() {
        Numero resultado = new Numero(0);
        if (unifica()) {
            resultado.valor = this.numero1.valor + this.numero2.valor;
        }

        return resultado;
    }
    
    public Numero restar() {
        Numero resultado = new Numero(0);
        unifica();
        resultado.valor = this.numero1.valor - this.numero2.valor;
        
        return resultado;
    }
    
    public Numero multiplicar() {
        Numero resultado = new Numero(0);
        unifica();
        resultado.valor = this.numero1.valor * this.numero2.valor;
        
        return resultado;
    }
    
    public Numero dividir() {
        Numero resultado = new Numero(0);
        unifica();
        resultado.valor = this.numero1.valor / this.numero2.valor;
        
        return resultado;
    }
    
    public Numero porcentaje() {
        Numero resultado = new Numero(0);
        unifica();
        resultado.valor = this.numero1.valor * this.numero2.valor / 100;
        
        return resultado;
    }
}