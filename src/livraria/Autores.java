/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria;
import java.util.Calendar;
/**
 *
 * @author ADM
 */
public class Autores {
    private String nota;
    private String nome;
    private Calendar data;
    private int id;

    public Autores(String nome, Calendar data, String nota, int id) {
        this.nota = nota;
        this.nome = nome;
        this.data = data;
        this.id = id;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
