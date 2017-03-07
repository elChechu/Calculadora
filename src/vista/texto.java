/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.Numero;

/**
 *
 * @author jpena
 */
public class texto implements gui {

    public texto() {
        Numero n1 = new Numero();
        do {
            System.out.println("Operacion:");
//            operacion = teclado.next();
//            System.out.println(validaOperacion(operacion));
//        } while (!validaOperacion(operacion));
        } while (!true);
        Numero n2 = new Numero();
    }

    @Override
    public boolean asignaNumero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
