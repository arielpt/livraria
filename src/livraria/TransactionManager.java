/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria;

import java.sql.Connection;

/**
 *
 * @author Ariel
 */
public class TransactionManager {

    private ConnectionFactory factory = new ConnectionFactory();

    /**
     * Executa uma lógica de negócio (callback) dentro de um contexto transacional
     */
    public void doInTransaction(TransactionCallback callback) {
        Connection conexao = null;
        try {
            conexao = this.factory.getConnection(); // abre conexão
            conexao.setAutoCommit(false); // inicia a transação

            // --
            callback.execute(conexao); // sua lógica executada aqui
            // --

            conexao.commit(); // comita transação
        } catch (Exception e) {
            if (conexao != null) {
                // desfaz alterações enviadas pro banco
                try { conexao.rollback(); } catch (SQLException e1) { e1.printStackTrace(); } 
            }
            throw new RuntimeException(e); // relança exceção
        } finally {
            if (conexao != null) {
                // fecha conexão e todos seus recursos
                try { conexao.close(); } catch (SQLException e) {} 
            }
        }
    }
}