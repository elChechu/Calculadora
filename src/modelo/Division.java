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

    public Division(Numero n1, Numero n2) {
        super(n1, n2, '/');
        Numero res = n1.a_10();
        int division = 0;
        
        if(n2.getValor() != 0) {
            while (res.getValor() >= n2.a_10().getValor()) {
                resta = new Resta(res, n2);
                res = resta.getRe();
                division++;
            }
            super.setRe(new Numero(String.valueOf(division)));
        } else {
            System.err.println("No es posible dividir por 0");
        }
    }
}
