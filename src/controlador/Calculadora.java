/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Scanner;
import modelo.Operacion;
import vista.texto;
import vista.vista;

/**
 *
 * @author daniel
 */
public class Calculadora {

    public Scanner teclado = new Scanner(System.in);

    public Calculadora() {
    }

    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();
        Scanner teclado = new Scanner(System.in);

        System.out.println("-----------------------------\nCalculadora\nDesea ver modo grafico (s/n)?");
        if (teclado.next().equals("s")) {
            vista vista = new vista(calculadora);
            vista.setVisible(true);
        } else {
            System.out.println("-----------------------------");
            do {
                texto texto = new texto(calculadora);
                System.out.println("Desea realizar otra operacion (s/n)?\n-----------------------------");
            } while (teclado.next().equals("s"));
        }

    }

    public void realizaOperacion(Operacion operacion) {
        if (operacion.getRe() != null) {
            System.out.println(operacion.getN1().getValor()+"b"+operacion.getN1().getBase()+operacion.getOper()+operacion.getN2().getValor()+"b"+operacion.getN2().getBase()+"="+operacion.getRe().getValor()+"b"+operacion.getRe().getBase());
        }

    }

}
