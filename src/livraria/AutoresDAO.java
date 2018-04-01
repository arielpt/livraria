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
import java.sql.Date;
/**
 *
 * @author ADM
 */
public class AutoresDAO {

    public void create(Autores autores) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "SELECT MAX(id) from autores",
                        sql2 = "INSERT INTO funcionario values(?,?,?,?)";

                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                ResultSet rs = stmt1.executeQuery();
                int id = 0;

                if (rs.next()) {
                    id = rs.getInt("max") + 1;
                } else {
                    id = 1;
                }

                PreparedStatement stmt2 = connection.prepareStatement(sql2);
                stmt2.setString(1, autores.getNota());
                stmt2.setString(2, autores.getNome());
                stmt2.setDate(3, (java.sql.Date) (Date) autores.getData().getTime());
                stmt1.setInt(4, autores.getId());
                stmt2.execute();

            }
        });
    }


    public void update(Autores autores) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "UPDATE autores SET nota = ?, nome = ?,"
                        + " data = ?, id = ? WHERE id = ?";

                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setString(1, autores.getNota());
                stmt1.setString(2, autores.getNome());
                stmt1.setDate(3, (java.sql.Date) (Date) autores.getData().getTime());
                stmt1.setInt(4, autores.getId());
                stmt1.execute();

               
            }
        });
    }

    public void delete(Autores autores) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "DELETE FROM autores WHERE id = ?";

                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, autores.getId());
                stmt1.execute();
            }
        });
    }

    public Autores getAutoresById(int id) {
        final Autores autores = new Autores();
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "SELECT l.nota, l.nome, l.data, l.id"
                        + "on t.id = l.id WHERE l.id = ?";

                ResultSet rs = null;
                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, id);
                rs = stmt1.executeQuery();

                if (rs.next()) {
                    autores.setNota(rs.getString(1));
                    autores.setNome(rs.getString(2));
                    autores.setDate(3, (Date) autores.getData().getTime());
                    autores.setId(rs.getInt(4));
                }
            }
        });
        return autores;
    }
}
