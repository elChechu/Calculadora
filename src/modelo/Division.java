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
public class Division extends Operacion {

    Operacion resta;

    public Division(int n1, int n2) {
        super(n1, n2, '/');
        while (n1 >= n2) {
            resta = new Resta(n1, n2);
            n1 = resta.re;
            this.re++;
        }
    }
}
