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
public class FiccaoDAO {

    public void create(Ficcao ficcao) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "SELECT max(id) from livro",
                        sql2 = "INSERT INTO livro values(?,?,?,?,?)",
                        sql3 = "INSERT INTO ficcao values (?,?)";

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
                stmt2.setInt(2, ficcao.getCodigo());
                stmt2.setInt(3, ficcao.getAno());
                stmt2.setString(4, ficcao.getTitulo());
                stmt2.setString(5, ficcao.getIdioma());
                stmt2.execute();

                PreparedStatement stmt3 = connection.prepareStatement(sql3);
                stmt3.setInt(1, id);
                stmt3.setString(2, ficcao.getGenero());
                stmt3.execute();
            }
        });
    }

    public void update(Ficcao ficcao) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "UPDATE livro SET livrocod = ?, titulo = ?,"
                        + " idioma = ?, ano = ? WHERE id = ?",
                        sql2 = "UPDATE ficcao SET genero = ? WHERE id = ?";

                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, ficcao.getCodigo());
                stmt1.setString(2, ficcao.getTitulo());
                stmt1.setString(3, ficcao.getIdioma());
                stmt1.setInt(4, ficcao.getAno());
                stmt1.setInt(5, ficcao.getId());
                stmt1.execute();

                PreparedStatement stmt2 = connection.prepareStatement(sql2);
                stmt2.setString(1, ficcao.getGenero());
                stmt2.setInt(2, ficcao.getId());
                stmt1.execute();
            }
        });
    }

    public void delete(Ficcao ficcao) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "DELETE FROM ficcao WHERE id = ?",
                        sql2 = "DELETE FROM livro WHERE id = ?";

                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, ficcao.getId());
                stmt1.execute();

                PreparedStatement stmt2 = connection.prepareStatement(sql2);
                stmt2.setInt(1, ficcao.getId());
                stmt1.execute();
            }
        });
    }

    public Ficcao getFiccaoByCodigo(int codigo) {
        final Ficcao ficcao = new Ficcao();
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "SELECT l.id, l.livrocod, l.titulo, l.idioma,"
                        + "l.ano, t.genero from livro l inner join ficcao t"
                        + "on t.id = l.id WHERE l.id = ?";

                ResultSet rs = null;
                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, codigo);
                rs = stmt1.executeQuery();

                if (rs.next()) {
                    ficcao.setId(rs.getInt(1));
                    ficcao.setCodigo(rs.getInt(2));
                    ficcao.setTitulo(rs.getString(3));
                    ficcao.setIdioma(rs.getString(4));
                    ficcao.setAno(rs.getInt(5));
                    ficcao.setGENERO(rs.getString(6));
                }
            }
        });
        return ficcao;
    }
}
