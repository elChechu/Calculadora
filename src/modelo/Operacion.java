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

    Numero n1;
    Numero n2;
    Numero re;
    char oper;

    public Operacion(Numero n1, Numero n2, char op) {
        this.n1   = n1;
        this.n2   = n2;
        this.oper = op;
    }

    public Numero getN1() {
        return n1;
    }

    public void setN1(Numero n1) {
        this.n1 = n1;
    }

    public Numero getN2() {
        return n2;
    }

    public void setN2(Numero n2) {
        this.n2 = n2;
    }

    public Numero getRe() {
        return re;
    }

    public void setRe(Numero re) {
        this.re = re;
    }

    public char getOper() {
        return oper;
    }

    public void setOper(char oper) {
        this.oper = oper;
    }

}
