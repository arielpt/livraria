/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria;
import java.util.GregorianCalendar;
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
       new TecnicoDAO().create(t);
       
       Autores a = new Autores("Um autor brilhante",new GregorianCalendar(1998,11,19), "Harlan Coben",  1);
       new AutoresDAO().create(a);
       
       livro_autor l = new livro_autor(1,1);
       new livro_autorDAO().create(l);
       
       Editoras e = new Editoras("Saraiva", 1139334000, 1);
       new EditorasDAO().create(e);
       
       Edicao d = new Edicao(1, 1039, 105, 29.50, 1);
       new EdicaoDAO().create(d);
       
       edicao_editora i = new edicao_editora(1,1);
       new edicao_editoraDAO().create(i);
       
       livro_edicao v = new livro_edicao(1,1);
       new livro_edicaoDAO().create(v);
       
       Funcionario f = new Funcionario(1, "Ariel", 201314, "Operador de Caixa");
       new FuncionarioDAO().create(f);
       
       Venda n = new Venda(1, new GregorianCalendar(2018,04,01), 1, 1);
       new VendaDAO().create(n);
       
    }
    
}
