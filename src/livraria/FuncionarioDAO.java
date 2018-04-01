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
public class FuncionarioDAO {

    public void create(Funcionario funcionario) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "SELECT MAX(id) from funcionario",
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
                stmt2.setInt(1, id);
                stmt2.setString(2, funcionario.getNome());
                stmt2.setInt(3, funcionario.getMatricula());
                stmt2.setString(4, funcionario.getFuncao());
                stmt2.execute();

            }
        });
    }


    public void update(Funcionario funcionario) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "UPDATE funcionario SET id = ?, nome = ?,"
                        + " matricula = ?, funcao = ? WHERE id = ?",
                        sql2 = "UPDATE funcionario SET funcionario = ? WHERE id = ?";

                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, funcionario.getId());
                stmt1.setString(2, funcionario.getNome());
                stmt1.setInt(3, funcionario.getMatricula());
                stmt1.setString(4, funcionario.getFuncao());
                stmt1.execute();

               
            }
        });
    }

    public void delete(Funcionario funcionario) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "DELETE FROM funcionario WHERE id = ?",
                        sql2 = "DELETE FROM funcionario WHERE id = ?";

                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, funcionario.getId());
                stmt1.execute();

                PreparedStatement stmt2 = connection.prepareStatement(sql2);
                stmt2.setInt(1, funcionario.getId());
                stmt1.execute();
            }
        });
    }

    public Funcionario getFuncionarioById(int id) {
        final Funcionario funcionario = new Funcionario();
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "SELECT l.id, l.nome, l.matricula, l.funcao,"
                        + "on t.id = l.id WHERE l.id = ?";

                ResultSet rs = null;
                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, id);
                rs = stmt1.executeQuery();

                if (rs.next()) {
                    funcionario.setId(rs.getInt(1));
                    funcionario.setMatricula(rs.getInt(2));
                    funcionario.setFuncao(rs.getString(3));
                }
            }
        });
        return funcionario;
    }
}
