/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria;

/**
 *
 * @author ADM
 */
public class Edicao{
    private int ISBN;
    private int numero;
    private int paginas;
    private int estoque;
    private double valor;

    public Edicao(int numero, int paginas, int estoque, double valor, int ISBN) {
        this.numero = numero;
        this.paginas = paginas;
        this.estoque = estoque;
        this.valor = valor;
        this.ISBN = ISBN;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
    
}
