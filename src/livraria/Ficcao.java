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
public class Ficcao extends Livro {

    private String genero;

    public Ficcao(String genero, int codigo, int ano, String titulo, String idioma, String tipo, int id) {
        super(codigo, ano, titulo, idioma, tipo, id);
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
