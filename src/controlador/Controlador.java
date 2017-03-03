/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Calculadora;
import vista.vista;
import javax.swing.JButton;
import modelo.Numero;

/**
 *
 * @author daniel
 */
public class Controlador implements ActionListener {

    private final Calculadora modelo = new Calculadora();
    private final vista vista;
    private boolean limpiar = false;
    public String resultado = "", texto = "";
    
    public Controlador(vista vista) {
        System.out.println("Enlazando la vista con el controlador ...\n--");
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
        this.vista.base.addActionListener(this);
        this.vista.rbase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int base = Integer.parseInt((String)vista.rbase.getSelectedItem());
                if(limpiar) {
                    System.out.println(modelo.getResultado().valor+"."+modelo.getResultado().base);
                    if (modelo.getResultado().base != 10) {
                        modelo.getResultado().a_10();
                        System.out.println(modelo.getResultado().valor+"."+modelo.getResultado().base);
                    }
                    modelo.getResultado().de_10(base);
                    System.out.println(modelo.getResultado().valor+"."+modelo.getResultado().base);
                    texto = String.valueOf(modelo.getResultado().valor);
                    if (base != 10) {
                        texto = String.valueOf(modelo.getResultado().valor)+"<sub>"+modelo.getResultado().base;
                    }
                    mostrar();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            JButton boton = (JButton) ae.getSource();
            boolean error = true;
            
            this.vista.error.setText("");
            if (limpiar) {
                inicializa();
            }
            if (boton.getName().equals("numero")) {
                texto += boton.getText();
                mostrar();
            } else {
                switch (boton.getText()) {
                    case "=":
                    case "%":
                        if (this.modelo.getNumero1() != null) {
                            error = this.modelo.getNumero1().valida();
                        }
                        
                        switch (this.modelo.getOperacion()) {
                            case "+":
                                if (this.asignaNumero2("\\"+this.modelo.getOperacion())) {
                                    error = (error)?this.modelo.getNumero2().valida():error;
                                    this.modelo.setResultado(this.modelo.sumar());
                                } else {
                                    error = false;
                                }
                                break;

                            case "-":
                                if (this.asignaNumero2("\\"+this.modelo.getOperacion())) {
                                    error = (error)?this.modelo.getNumero2().valida():error;
                                    this.modelo.setResultado(this.modelo.restar());
                                } else {
                                    error = false;
                                }
                                break;

                            case "X":
                                if (this.asignaNumero2(this.modelo.getOperacion())) {
                                    error = (error)?this.modelo.getNumero2().valida():error;
                                    this.modelo.setResultado((boton.getText().equals("="))?this.modelo.multiplicar():this.modelo.porcentaje());
                                } else {
                                    error = false;
                                }
                                break;

                            case "/":
                                if (this.asignaNumero2(this.modelo.getOperacion())) {
                                    error = (error)?this.modelo.getNumero2().valida():error;
                                    this.modelo.setResultado(this.modelo.dividir());
                                } else {
                                    error = false;
                                }
                                break;

                            default:
                                this.modelo.setResultado(this.modelo.getNumero1());
                                break;
                        }
                        
                        Numero resultado = this.modelo.getResultado();
                        System.out.println(resultado.valor);
                        if (!vista.rbase.getSelectedItem().equals(resultado.base)) {
                            resultado.de_10(Integer.parseInt((String)vista.rbase.getSelectedItem()));
                        }
                        this.resultado = texto;
                        
                        texto = String.valueOf(resultado.valor);
                        if (resultado.base != 10) {
                            texto = String.valueOf(resultado.valor)+"<sub>"+resultado.base;
                        }
                        
                        if(error) {
                            mostrar();
                        } else {
                            this.vista.error.setText("Error");
                        }
                        limpiar = true;

                        break;

                    case "C":
                        inicializa();
                        break;

                    case "<":
                        if (texto.length() > 0) {
                            if (texto.substring(texto.length()-5, texto.length()).equals("<sub>")) {
                                texto = texto.substring(0, texto.length()-5);
                            } else if (texto.substring(texto.length()-6, texto.length()).equals("</sub>")) {
                                texto = texto.substring(0, texto.length()-6);
                            }
                            this.vista.error.setText("");
                            texto = texto.substring(0, texto.length()-1);
                            mostrar();
                        }
                        break;
                        
                    case "B":
                        if (texto.length() > 0) {
                            texto += "<sub>";
                        }
                        break;

                    default:
                        if (texto.length() > 0) {
                            this.modelo.setNumero1(asignaNumero1(texto));
                            this.modelo.setOperacion(boton.getText());
                            System.out.println("Operacion: "+ this.modelo.getOperacion());
                            texto += "</sub>" + boton.getText();
                            mostrar();
                        }
                        break;
                }
            }
        } catch (NumberFormatException e) {
            this.vista.error.setText("Error");
            System.out.println("Error:> "+e.getMessage());
        }
    }
    
    public Numero asignaNumero1(String numero1) {
        Numero numero;
        String [] partes = numero1.split("<sub>");
        if (partes.length == 1) {
            numero = new Numero(Integer.parseInt(numero1));
        } else {
            numero = new Numero(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]));
            if (!numero.valida()) {
                this.vista.error.setText("Base invalida");
            }
        }
        System.out.println("Numero: "+ numero.valor + "." + numero.base);
        
        return numero;
    }
    
    public boolean asignaNumero2(String operador) {
        String[] partes = texto.split(operador);
        
        if (partes.length == 2) {
            this.modelo.setNumero2(asignaNumero1(partes[1]));
            
            return true;
        } else if (partes.length == 3) {
            this.modelo.setNumero2(asignaNumero1(partes[2]));
            
            return true;
        }
        
        this.vista.error.setText("Error");
        return false;
    }
    
    public void inicializa() {
        System.out.println("Limpia...\n--");
        Numero numero = new Numero(0);
        resultado = texto = "";
        
        mostrar();
        this.modelo.setNumero1(numero);
        this.modelo.setNumero2(numero);
        this.modelo.setResultado(numero);
        this.modelo.setOperacion("");
        this.vista.error.setText("");
        this.limpiar = false;
    }
    
    public void mostrar() {
        vista.mostrar.setText("<div style='text-align:right;font-size:30px'><span>" + resultado + "</span><br /><span>" + texto + "</span></div>");
    }
}