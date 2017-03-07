/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.util.Scanner;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import modelo.Numero;
import modelo.Operacion;
import modelo.Suma;
import modelo.Resta;
import modelo.Multiplicacion;
import modelo.Division;
import vista.vista;

/**
 *
 * @author daniel
 */
public class Calculadora implements ActionListener {

    private vista vista;
    public Scanner teclado;
    public String operacion, pantalla = "";

    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();

        /*
        resultado = new Suma(2, 4);
        System.out.println(resultado.getRe());
        resultado = new Division(20, 7);
        System.out.println(resultado.getRe());
         */
    }

    public Calculadora() {
        teclado = new Scanner(System.in);

        System.out.println("-----------------------------\nCalculadora\nDesea ver modo grafico (s/n)?");
        if (teclado.next().equals("s")) {
            vista = new vista();
            vista.setVisible(true);

            this.vista.n0.addActionListener(this);
            this.vista.n1.addActionListener(this);
            this.vista.n2.addActionListener(this);
            this.vista.n3.addActionListener(this);
            this.vista.n4.addActionListener(this);
            this.vista.n5.addActionListener(this);
            this.vista.n6.addActionListener(this);
            this.vista.n7.addActionListener(this);
            this.vista.n8.addActionListener(this);
            this.vista.n9.addActionListener(this);
            this.vista.sumar.addActionListener(this);
            this.vista.restar.addActionListener(this);
            this.vista.multiplicar.addActionListener(this);
            this.vista.dividir.addActionListener(this);
            this.vista.borrar.addActionListener(this);
            this.vista.operar.addActionListener(this);
            this.vista.decimal.addActionListener(this);
            this.vista.base.addActionListener(this);
        } else {
            System.out.println("-----------------------------");
            Numero n1 = new Numero();
            do {
                System.out.println("Operacion:");
                operacion = teclado.next();
                System.out.println(validaOperacion(operacion));
            } while (!validaOperacion(operacion));
            Numero n2 = new Numero();
            switch (operacion) {
                case "+":
                    break;

                case "-":
                    break;

                case "*":
                    break;

                case "/":
                    break;
            }
        }
    }

    private static boolean validaOperacion(String operador) {
        return operador.equals("+") || operador.equals("-") || operador.equals("*") || operador.equals("/");
    }

    public void mostrar() {
        vista.mostrar.setText("<div style='text-align:right;font-size:30px'><span>resultado</span><br /><span>" + pantalla + "</span></div>");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton boton = (JButton) ae.getSource();

        if (boton.getName().equals("numero")) {
            pantalla += boton.getText();
            mostrar();
        }  else {
            switch (boton.getText()) {
                case "=":
                    break;

                case "C":
                    break;

                case "<":
                    if (pantalla.substring(pantalla.length()-5, pantalla.length()).equals("<sub>")) {
                        pantalla = pantalla.substring(0, pantalla.length()-5);
                    } else if (pantalla.substring(pantalla.length()-6, pantalla.length()).equals("</sub>")) {
                        pantalla = pantalla.substring(0, pantalla.length()-6);
                    }
                    if (pantalla.length() > 0) {
                        this.vista.error.setText("");
                        pantalla = pantalla.substring(0, pantalla.length()-1);
                        mostrar();
                    }
                    break;

                case "B":
                    if (pantalla.length() > 0) {
                        pantalla += "<sub>";
                    }
                    break;

                default:
                    String [] partes = pantalla.split("<sub>");
                    if (partes.length == 1) {
                        Numero n1 = new Numero(partes[0]);
                    } else {
                        Numero n1 = new Numero(partes[0], partes[1]);
                        if (n1.getBase() != Integer.parseInt(partes[1])) {
                            this.vista.error.setText("Base invalida");
                        }
                    }
                    
                    if (this.vista.error.getText().equals("")) {
                        operacion = boton.getText();
                        pantalla += "</sub>" + boton.getText();
                        mostrar();
                    }
                    break;
            }
        }
    }

}
