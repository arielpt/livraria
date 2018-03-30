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
public class Livro {
    private int codigo;
    private int ano;
    private String titulo;
    private String idioma;

    public Livro(int codigo, int ano, String titulo, String idioma, String tipo) {
        this.codigo = codigo;
        this.ano = ano;
        this.titulo = titulo;
        this.idioma = idioma;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Codigo:" + getCodigo() + "\nAno:" + getAno() + "\nTitulo:" + getTitulo() + "\nIdioma:" + getIdioma() + "\n";
    }
}
