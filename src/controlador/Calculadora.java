/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Scanner;
import vista.texto;
import vista.vista;

/**
 *
 * @author daniel
 */
public class Calculadora {

    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();

        /*
        resultado = new Suma(2, 4);
        System.out.println(resultado.getRe());
        resultado = new Division(20, 7);
        System.out.println(resultado.getRe());
        
        switch (operacion) {
            case "+":
                break;

            case "-":
                break;

            case "*":
                break;

            case "/":
                break;
         */
    }

    public Calculadora() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("-----------------------------\nCalculadora\nDesea ver modo grafico (s/n)?");
        if (teclado.next().equals("s")) {
            vista vista = new vista();
            vista.setVisible(true);
        } else {
            System.out.println("-----------------------------");
            do {
                texto texto = new texto();
                System.out.println("Desea realizar otra operacion (s/n)?\n-----------------------------");
            } while(teclado.next().equals("s"));
        }
    }
}
