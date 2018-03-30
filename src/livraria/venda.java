/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria;
import java.util.Calendar;
/**
 *
 * @author Ariel
 */
public class venda extends funcionario {
    private int idvenda;
    private Calendar data;

    public venda(int id, String nome, int matricula, String funcao) {
        super(id, nome, matricula, funcao);
    }

    public venda(int idvenda, Calendar data, int id, String nome, int matricula, String funcao) {
        super(id, nome, matricula, funcao);
        this.idvenda = idvenda;
        this.data = data;
    }

    public int getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

   

    

   
}
