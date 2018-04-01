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
import java.util.Calendar;

/**
 *
 * @author ADM
 */
public class VendaDAO {

    public void create(Venda venda) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "SELECT MAX(id) from venda",
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
                stmt2.setCalendar(2, venda.getData().getTime());
                stmt2.setInt(3, venda.getId_funcionario());
                stmt1.setInt(4, venda.getId_edicao());
                stmt2.execute();

            }
        });
    }


    public void update(Venda venda) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "UPDATE venda SET id = ?, data = ?,"
                        + " id_funcionario = ?, id_edicao = ? WHERE id = ?",
                        sql2 = "UPDATE venda SET venda = ? WHERE id = ?";

                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, venda.getId());
                stmt1.setCalendar(2, venda.getData() .getTime());
                stmt1.setInt(3, venda.getId_funcionario());
                stmt1.setInt(4, venda.getId_edicao());
                stmt1.execute();

               
            }
        });
    }

    public void delete(Venda venda) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "DELETE FROM venda WHERE id = ?";

                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, venda.getId());
                stmt1.execute();
            }
        });
    }

    public Venda getVendaById(int id) {
        final Venda venda = new Venda();
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "SELECT l.id, l.data, l.id_funcionario, l.id_edicao,"
                        + "on t.id = l.id WHERE l.id = ?";

                ResultSet rs = null;
                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, id);
                rs = stmt1.executeQuery();

                if (rs.next()) {
                    venda.setId(rs.getInt(1));
                    venda.setData(rs.getCalendar(2));
                    venda.setId_funcionario(rs.getInt(3));
                    venda.setId_edicao(rs.getInt(4));
                }
            }
        });
        return venda;
    }
}
