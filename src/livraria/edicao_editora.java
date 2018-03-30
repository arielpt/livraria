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
public class edicao_editora {
    private int ISBN;
    private int id_editora;

    public edicao_editora(int ISBN, int id_editora) {
        this.ISBN = ISBN;
        this.id_editora = id_editora;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getId_editora() {
        return id_editora;
    }

    public void setId_editora(int id_editora) {
        this.id_editora = id_editora;
    }
    
    
}
