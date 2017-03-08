/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Scanner;
import modelo.Numero;

/**
 *
 * @author jpena
 */
public class texto {

    public texto(Scanner teclado) {
        Numero n1 = new Numero();
        String operacion;
        do {
            System.out.println("Operacion:");
            operacion = teclado.next();
        } while (!validaOperacion(operacion));
        Numero n2 = new Numero();
        //realizaOperacion();
    }

    private boolean validaOperacion(String operador) {
        return operador.equals("+") || operador.equals("-") || operador.equals("*") || operador.equals("/");
    }
}
