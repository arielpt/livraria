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
public class TecnicoDAO {

    public void create(Tecnico tecnico) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "SELECT max(id) from livro",
                        sql2 = "INSERT INTO livro values(?,?,?,?,?)",
                        sql3 = "INSERT INTO tecnicos values (?,?)";

                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                ResultSet rs = stmt1.executeQuery();
                int id = 0;

                if (rs.next()) {
                    id = rs.getInt("max");
                } else {
                    id = 1;
                }

                PreparedStatement stmt2 = connection.prepareStatement(sql2);
                stmt2.setInt(1, id);
                stmt2.setInt(2, tecnico.getCodigo());
                stmt2.setInt(3, tecnico.getAno());
                stmt2.setString(4, tecnico.getTitulo());
                stmt2.setString(5, tecnico.getIdioma());
                stmt2.execute();

                PreparedStatement stmt3 = connection.prepareStatement(sql3);
                stmt3.setInt(1, id);
                stmt3.setString(2, tecnico.getArea());
                stmt3.execute();
            }
        });
    }

    public void update(Tecnico tecnico) {
        TransactionManager txManager = new TransactionManager();
        txManager.doInTransaction(new TransactionCallback() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String sql1 = "UPDATE livro SET livrocod = ?, titulo = ?,"
                        + " idioma = ?, ano = ? WHERE id = ?",
                        sql2 = "UPDATE tecnicos SET area = ? WHERE id = ?";

                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1, tecnico.getCodigo());
                stmt1.setString(2, tecnico.getTitulo());
                stmt1.setString(3, tecnico.getIdioma());
                stmt1.setInt(4, tecnico.getAno());
                stmt1.setInt(5, tecnico.getId());
                stmt1.execute();

                PreparedStatement stmt2 = connection.prepareStatement(sql2);
                stmt2.setString(1, tecnico.getArea())
            
        
    
;
