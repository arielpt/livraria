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
public class Tecnico extends Livro {

    private String area;

    public Tecnico(String area, int codigo, int ano, String titulo, String idioma, String tipo, int id) {
        super(codigo, ano, titulo, idioma, tipo, id);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
