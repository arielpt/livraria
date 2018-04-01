/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ADM
 */
public class livro_edicaoDAO {
    
    public void create(livro_edicao livro_edicao1) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "INSERT INTO livro_edicao VALUES (?,?)";

                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, livro_edicao1.getLivrocod());
                stmt1.setInt(2, livro_edicao1.getISBN());
                stmt1.execute();
            }
        });
    }
    
    public void delete(livro_edicao livro_edicao1) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "DELETE FROM livro_edicao WHERE livrocod = ? AND ISBN = ?";

                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, livro_edicao1.getLivrocod());
                stmt1.setInt(2, livro_edicao1.getISBN());
                stmt1.execute();
            }
        });
    }
}