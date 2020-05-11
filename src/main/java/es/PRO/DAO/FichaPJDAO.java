/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.PRO.DAO;

import es.PRO.InDAO.IFichaPJDAO;
import es.PRO.modelo.FichaPJ;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jorge
 */
public class FichaPJDAO implements IFichaPJDAO {

    final String insercion = "INSERT INTO FICHAPJ (codigo, nombrePJ, raza, clase, fue, mag, agi, res)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
    final String borrado = "DELETE FROM FICHAPJ WHERE codigo = ?";

    private Connection con = null;

    public FichaPJDAO(Connection con) {
        this.con = con;
    }

    @Override
    public void insert(FichaPJ obj) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(insercion);
            ps.setInt(1, obj.getCodigo());
            ps.setString(2, obj.getNombrePJ());
            ps.setString(3, obj.getRaza());
            ps.setString(4, obj.getClase());
            ps.setInt(5, obj.getFue());
            ps.setInt(6, obj.getMag());
            ps.setInt(7, obj.getAgi());
            ps.setInt(8, obj.getRes());
            if (ps.executeUpdate() == 0) {
                throw new SQLException("No se ha podido insertar correctamente");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<FichaPJ> getObj() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FichaPJ getObj(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(FichaPJ obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(FichaPJ obj) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(borrado);
            ps.setInt(1, obj.getCodigo());
            if (ps.executeUpdate() == 0) {
                throw new SQLException("No se ha podido insertar correctamente");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
