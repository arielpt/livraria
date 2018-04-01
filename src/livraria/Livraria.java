/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria;
import java.sql.Date;
/**
 *
 * @author ADM
 */
public class Livraria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Tecnico t = new Tecnico("Advocacia", 125446841, 2018, "Lei para tolos", "Portugues", 1);
       new TecnicoDAO().delete(t);
       
       Autores a = new Autores("Um autor brilhante",new Date(1998,11,19), "Harlan Coben",  1);
       new AutoresDAO().delete(a);
       
       livro_autor l = new livro_autor(1,1);
       new livro_autorDAO().delete(l);
       
       Editoras e = new Editoras("Saraiva", 1139334000, 1);
       new EditorasDAO().delete(e);
       
       Edicao d = new Edicao(1, 1039, 105, 29.50, 1);
       new EdicaoDAO().delete(d);
       
       edicao_editora i = new edicao_editora(1,1);
       new edicao_editoraDAO().delete(i);
       
       livro_edicao v = new livro_edicao(1,1);
       new livro_edicaoDAO().delete(v);
       
       Funcionario f = new Funcionario(1, "Ariel", 201314, "Operador de Caixa");
       new FuncionarioDAO().delete(f);
       
       Venda n = new Venda(1, new Date(2018,04,01), 1, 1);
       new VendaDAO().delete(n);
       
    }
    
}
