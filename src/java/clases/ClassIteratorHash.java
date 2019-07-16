/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Giordano
 */
public class ClassIteratorHash implements Comparable {
    private int clave;
    private int valor;

    public ClassIteratorHash(int clave, int valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public int compareTo(Object o) {
        ClassIteratorHash nuevo = (ClassIteratorHash) o;
        return nuevo.getValor()-this.valor;
    }
    
    
}
