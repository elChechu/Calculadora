/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;
import controlador.Controlador;
import vista.vista;

/**
 *
 * @author daniel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Iniciando vista ...");
        vista vista = new vista();
        System.out.println("Iniciando controlador ...");
        new Controlador(vista);

        vista.setVisible(true);
    }
    
}
