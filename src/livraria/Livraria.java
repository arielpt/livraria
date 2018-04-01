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
public class Livraria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Tecnico t = new Tecnico("Advocacia", 125446841, 2018, "Lei para tolos", "Portugues", 1);
       new TecnicoDAO.create(t);
    }
    
}
