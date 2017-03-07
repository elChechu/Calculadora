/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jpena
 */
public abstract class Operacion {

    int n1;
    int n2;
    char o;
    int re;

    public Operacion(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
    
    public static boolean validaOperacion(String operador) {
        return operador.equals("+") || operador.equals("-") || operador.equals("*") || operador.equals("/");
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public char getO() {
        return o;
    }

    public void setO(char o) {
        this.o = o;
    }

    public int getRe() {
        return re;
    }

    public void setRe(int re) {
        this.re = re;
    }

}
