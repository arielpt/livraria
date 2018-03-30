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
public class livro_autor {
    private int idlivro;
    private int idautor;

    public livro_autor(int idlivro, int idautor) {
        this.idlivro = idlivro;
        this.idautor = idautor;
    }

    public int getIdlivro() {
        return idlivro;
    }

    public void setIdlivro(int idlivro) {
        this.idlivro = idlivro;
    }

    public int getIdautor() {
        return idautor;
    }

    public void setIdautor(int idautor) {
        this.idautor = idautor;
    }
    
    
}
