/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.modelo;
import vista.vista;
import javax.swing.JButton;

/**
 *
 * @author daniel
 */
public class controlador implements ActionListener {

    private final modelo modelo = new modelo();
    private final vista vista;
    private boolean limpiar = false;
    
    public controlador(vista vista) {
        this.vista  = vista;
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
        this.vista.porciento.addActionListener(this);
        this.vista.borrar.addActionListener(this);
        this.vista.operar.addActionListener(this);
        this.vista.decimal.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            JButton boton = (JButton) ae.getSource();
            if (this.limpiar) {
                this.vista.resultado.setText("");
                this.modelo.setNumero1(0);
                this.modelo.setNumero2(0);
                this.modelo.setResultado(0);
                this.modelo.setOperacion("");
                this.limpiar = false;
            }
            if (boton.getName().equals("numero")) {
    //            System.out.println(this.vista.resultado.getText()+boton.getText());
                this.vista.resultado.setText(this.vista.resultado.getText()+boton.getText());
            } else {
                switch (boton.getText()) {
                    case "=":
                    case "%":
                        switch (this.modelo.getOperacion()) {
                            case "+":
                                this.Numero2("\\"+this.modelo.getOperacion());
                                this.modelo.setResultado(this.modelo.sumar());
                                break;

                            case "-":
                                this.Numero2("\\"+this.modelo.getOperacion());
                                this.modelo.setResultado(this.modelo.restar());
                                break;

                            case "X":
                                this.Numero2(this.modelo.getOperacion());
                                this.modelo.setResultado((boton.getText().equals("="))?this.modelo.multiplicar():this.modelo.porcentaje());
                                break;

                            case "/":
                                this.Numero2(this.modelo.getOperacion());
                                this.modelo.setResultado(this.modelo.dividir());
                                break;

                            default:
                                this.modelo.setResultado(Double.parseDouble(this.vista.resultado.getText()));
                                break;
                        }

                        this.vista.resultado.setText(this.vista.resultado.getText()+"\n"+this.modelo.getResultado());
                        this.limpiar = true;
                        break;

                    case "C":
                        this.vista.resultado.setText("");
                        this.modelo.setNumero1(0);
                        this.modelo.setNumero2(0);
                        this.modelo.setResultado(0);
                        this.modelo.setOperacion("");
                        break;

                    case "<":
                        if(this.vista.resultado.getText().length() > 0) {
                            this.vista.resultado.setText(this.vista.resultado.getText().substring(0, this.vista.resultado.getText().length()-1));
                        }
                        break;

                    default:
                        if (this.vista.resultado.getText().length() > 0) {
                            this.modelo.setNumero1(Double.parseDouble(this.vista.resultado.getText()));
                            this.modelo.setOperacion(boton.getText());
                            this.vista.resultado.setText(this.vista.resultado.getText()+boton.getText());
                        }
                        break;
                }
            }
        } catch (Exception e) {
            this.vista.resultado.setText(this.vista.resultado.getText()+"\nError");
        }
    }
    
    public boolean Numero2(String operador) {
        String[] partes;

        partes = this.vista.resultado.getText().split(operador);
        if (!partes[1].equals("")) {
            this.modelo.setNumero2(Double.parseDouble(partes[1]));
            return true;
        }
        return false;
    }
}
