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
public class EdicaoDAO {

    public void create(Edicao edicao) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "SELECT MAX(isbn) from edicao",
                        sql2 = "INSERT INTO edicao values(?,?,?,?,?)";

                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                ResultSet rs = stmt1.executeQuery();
                int isbn = 0;

                if (rs.next()) {
                    isbn = rs.getInt("max") + 1;
                } else {
                    isbn = 1;
                }

                PreparedStatement stmt2 = connection.prepareStatement(sql2);
                stmt2.setInt(1, isbn);
                stmt2.setInt(2, edicao.getNumero());
                stmt2.setDouble(3, edicao.getValor());
                stmt2.setInt(4, edicao.getPaginas());
                stmt2.setInt(5, edicao.getEstoque());
                stmt2.execute();

            }
        });
    }

    public void update(Edicao edicao) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "UPDATE edicao SET isbn = ?, numero = ?, valor = ?, paginas = ?"
                        + " estoque = ? WHERE isbn = ?";

                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, edicao.getISBN());
                stmt1.setInt(2, edicao.getNumero());
                stmt1.setDouble(3, edicao.getValor());
                stmt1.setInt(4, edicao.getPaginas());
                stmt1.setInt(5, edicao.getEstoque());
            }
        });
    }

    public void delete(Edicao edicao) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "DELETE FROM edicao WHERE isbn = ?";

                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, edicao.getISBN());
                stmt1.execute();

            }
        });
    }

    public Edicao getEdicaoByIsbn(int isbn) {
        final Edicao edicao = new Edicao();
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "SELECT l.isbn, l.numero, l.valor, 1.paginas, 1.estoque"
                        + "on t.id = l.id WHERE l.id = ?";

                ResultSet rs = null;
                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, isbn);
                rs = stmt1.executeQuery();

                if (rs.next()) {
                    edicao.setISBN(rs.getInt(1));
                    edicao.setNumero(rs.getInt(2));
                    edicao.setValor(rs.getDouble(3));
                    edicao.setPaginas(rs.getInt(4));
                    edicao.setEstoque(rs.getInt(5));
                }
            }
        });
        return edicao;
    }
}
