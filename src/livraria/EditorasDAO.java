/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADM
 */
public class EditorasDAO {

    public void create(Editoras editoras) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "SELECT MAX(id) from editoras",
                        sql2 = "INSERT INTO editoras values(?,?,?)";

                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                ResultSet rs = stmt1.executeQuery();
                int id = 0;

                if (rs.next()) {
                    id = rs.getInt("max") + 1;
                } else {
                    id = 1;
                }

                PreparedStatement stmt2 = connection.prepareStatement(sql2);
                stmt2.setInt(1, id);
                stmt2.setString(2, editoras.getNome());
                stmt2.setInt(3, editoras.getTelefone());
                stmt2.execute();

            }
        });
    }

    public void update(Editoras editoras) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "UPDATE editoras SET id = ?, nome = ?,"
                        + " telefone = ? WHERE id = ?",
                        sql2 = "UPDATE editoras SET nome = ? WHERE id = ?";

                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, editoras.getId());
                stmt1.setString(2, editoras.getNome());
                stmt1.setInt(3, editoras.getTelefone());
                stmt1.execute();

                PreparedStatement stmt2 = connection.prepareStatement(sql2);
                stmt2.setString(1, editoras.getNome());
                stmt2.setInt(2, editoras.getId());
                stmt1.execute();
            }
        });
    }

    public void delete(Editoras editoras) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "DELETE FROM editoras WHERE id = ?";

                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, editoras.getId());
                stmt1.execute();

            }
        });
    }

    public Editoras getEditorasById(int id) {
        final Editoras editoras = new Editoras();
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "SELECT l.id, l.nome, l.telefone"
                        + "on t.id = l.id WHERE l.id = ?";

                ResultSet rs = null;
                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, id);
                rs = stmt1.executeQuery();

                if (rs.next()) {
                    editoras.setId(rs.getInt(1));
                    editoras.setNome(rs.getString(2));
                    editoras.setTelefone(rs.getInt(3));
                }
            }
        });
        return editoras;
    }
}
