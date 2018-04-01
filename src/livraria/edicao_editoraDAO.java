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
public class edicao_editoraDAO {
    
    public void create(edicao_editora edicao_editora1) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "INSERT INTO edicao_editora VALUES (?,?)";

                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, edicao_editora1.getISBN());
                stmt1.setInt(2, edicao_editora1.getId_editora());
                stmt1.execute();
            }
        });
    }
    
    public void delete(edicao_editora edicao_editora1) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "DELETE FROM edicao_editora WHERE ISBN = ? AND id_editora = ?";

                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, edicao_editora1.getISBN());
                stmt1.setInt(2, edicao_editora1.getId_editora());
                stmt1.execute();
            }
        });
    }
}