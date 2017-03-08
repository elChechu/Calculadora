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
public class Resta extends Operacion {

    public Resta(int n1, int n2) {
        super(n1, n2, '-');
        super.setRe(this.n1 - this.n2);
    }
}
