/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import controlador.controlador;
import vista.vista;

/**
 *
 * @author daniel
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        vista vista = new vista();
        new controlador(vista);

        vista.setVisible(true);
    }
    
}
