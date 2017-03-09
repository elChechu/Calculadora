/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Scanner;
import controlador.Calculadora;
import modelo.Division;
import modelo.Multiplicacion;
import modelo.Numero;
import modelo.Operacion;
import modelo.Resta;
import modelo.Suma;

/**
 *
 * @author jpena
 */
public class texto {

    public texto(Calculadora calculadora) {
        Operacion operacion = null;
        Numero n1 = new Numero();
        String opera;
        do {
            System.out.println("Operacion:");
            opera = calculadora.teclado.next();
        } while (!validaOperacion(opera));
        Numero n2 = new Numero();

        switch (opera) {
            case "+":
                operacion = new Suma(n1, n2);
                break;

            case "-":
                operacion = new Resta(n1, n2);
                break;

            case "*":
            case "X":
                operacion = new Multiplicacion(n1, n2);
                break;

            case "/":
                operacion = new Division(n1, n2);
                break;
        }
        System.out.println("Base:");
        operacion.setRe(operacion.getRe().de_10(calculadora.teclado.nextInt()));
        calculadora.realizaOperacion(operacion);
    }

    private boolean validaOperacion(String operador) {
        return operador.equals("+") || operador.equals("-") || operador.equals("*") || operador.equals("/");
    }
}
