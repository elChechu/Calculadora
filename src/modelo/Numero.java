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
public final class Numero {

    private int valor;
    private int base;

    public Numero() {
        String _valor;
        String _base;

        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("Valor:");
            _valor = teclado.next();
        } while (!validaValor(_valor));

        do {
            System.out.println("Base:");
            _base = teclado.next();
        } while (!validaValor(_base) || !validaBase(_valor, _base));

        valor = Integer.parseInt(_valor);
        base = Integer.parseInt(_base);
    }

    public Numero(String valor) {
        if (validaValor(valor)) {
            this.valor = Integer.parseInt(valor);
            base = 10;
        }
    }

    public Numero(String valor, String base) {
        if (validaValor(valor) && validaValor(base) && validaBase(valor, base)) {
            this.valor = Integer.parseInt(valor);
            this.base = Integer.parseInt(base);
        }
    }

    public int a_10() {
        int _valor = 0, i = 0, negativo = 1;
        if (this.valor < 0) {
            negativo = -1;
            this.valor *= negativo;
        }
        while (this.valor > 0) {
            _valor += (this.valor % 10) * Math.pow(this.base, i);
            this.valor = this.valor / 10;
            i++;
        }
        return _valor * negativo;
    }

    public void de_10(int base) {
        int _valor = 0, i = 0, negativo = 1;

        if (this.valor < 0) {
            negativo = -1;
            this.valor *= negativo;
        }
        while (this.valor > 0) {
            _valor += (this.valor % base) * Math.pow(this.base, i);
            this.valor = this.valor / base;
            i++;
        }
        this.valor = _valor * negativo;
        this.base = base;
    }

    public boolean validaValor(String valor) {
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public boolean validaBase(String valor, String base) {
        int _valor = Integer.parseInt(valor);
        int _base = Integer.parseInt(base);

        if (_base > 1 && _base < 11) {
            while (_valor > 0) {
                if (_valor % 10 >= _base) {
                    return false;
                }
                _valor /= 10;
            }
            return true;
        }
        return false;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }
}
