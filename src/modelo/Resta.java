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

    public Resta(Numero n1, Numero n2) {
        super(n1, n2, '-');
        super.setRe(new Numero(String.valueOf(this.n1.a_10().getValor() - this.n2.a_10().getValor())));
    }
}
