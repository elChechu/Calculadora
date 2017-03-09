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

    public Multiplicacion(Numero n1, Numero n2) {
        super(n1, n2, '*');
        Numero sum = new Numero("0");
        
        for (int i = 0; i < n2.a_10().getValor(); i++) {
            suma = new Suma(sum, n1);
            sum = suma.getRe();
        }
        super.setRe(sum);
    }
}
