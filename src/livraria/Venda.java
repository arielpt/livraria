/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria;
import java.sql.Date;
/**
 *
 * @author Ariel
 */
public class Venda{
    private int idvenda;
    private Date data;
    private int id_funcionario;
    private int id_edicao;

    public Venda(int idvenda, Date data, int id_funcionario, int id_edicao) {
        this.idvenda = idvenda;
        this.data = data;
        this.id_funcionario = id_funcionario;
        this.id_edicao = id_edicao;
    }
    public Venda() {
            
    }
   
    public int getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public int getId_edicao() {
        return id_edicao;
    }

    public void setId_edicao(int id_edicao) {
        this.id_edicao = id_edicao;
    }

    void setDate(int i, Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
