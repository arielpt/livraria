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
public abstract class Livro {
    private int codigo;
    private int ano;
    private String titulo;
    private String idioma;
    private int id;

    public Livro(int codigo, int ano, String titulo, String idioma, int id) {
        this.codigo = codigo;
        this.ano = ano;
        this.titulo = titulo;
        this.idioma = idioma;
        this.id = id;
    }

    public Livro() {
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

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
     @Override
    public String toString() {
        return "Codigo:" + getCodigo() + "\nAno:" + getAno() + "\nTitulo:" + getTitulo() + "\nIdioma:" + getIdioma() + "\n";
    }
}
