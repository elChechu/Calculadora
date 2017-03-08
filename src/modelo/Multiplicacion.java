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
public class Multiplicacion extends Operacion {

    Operacion suma;

    public Multiplicacion(int n1, int n2) {
        super(n1, n2, '*');
        for (int i = 0; i < n2; i++) {
            suma = new Suma(this.re, n1);
            super.setRe(suma.re);
        }
    }
}
