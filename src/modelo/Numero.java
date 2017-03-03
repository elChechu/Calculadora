/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.Scanner;

/**
 *
 * @author Estudiantes
 */
public class Numero {
    public int valor;
    public int base;

    public Numero() {
        Scanner teclado = new Scanner (System.in);
        System.out.println ("Escriba el valor: ");
        valor = teclado.nextInt();
        System.out.println ("Escriba la base: ");
        base = teclado.nextInt();
    }

    public Numero(int valor) {
        this.valor = valor;
        this.base = 10;
    }

    public Numero(int valor, int base) {
        this.valor = valor;
        this.base = base;
    }
    
    public void a_10() {
        int valor = 0, i = 0, negativo = 1;
        if (this.valor < 0) {
            negativo = -1;
            this.valor *= negativo;
        }
        while (this.valor > 0) {
            valor += (this.valor % 10) * Math.pow(this.base, i);
            this.valor = this.valor / 10;
            i++;
        }
        this.valor = valor * negativo;
        this.base  = 10;
    }

    public void de_10(int base) {
        int valor = 0, i = 0, negativo = 1;
        
        if (this.valor < 0) {
            negativo = -1;
            this.valor *= negativo;
        }
        while(this.valor > 0) {
            valor += (this.valor % base) * Math.pow(this.base, i);
            this.valor = this.valor / base;
            i++;
        }
        this.valor = valor * negativo;
        this.base  = base;
    }
    
    public boolean valida() {
        int valor = this.valor;
        
        if(base > 1 && base < 11) {    
            while (valor > 0) {
                if (valor % 10 >= base) {
                    return false;
                }
                valor /= 10;
            }
            return true;
        }
        return false;
    }
}