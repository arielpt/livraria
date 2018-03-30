/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria;

/**
 *
 * @author Ariel
 */
public class livro_edicao {
    private int livrocod;
    private int ISBN;

    public livro_edicao(int livrocod, int ISBN) {
        this.livrocod = livrocod;
        this.ISBN = ISBN;
    }

    public int getLivrocod() {
        return livrocod;
    }

    public void setLivrocod(int livrocod) {
        this.livrocod = livrocod;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
    
    
}
