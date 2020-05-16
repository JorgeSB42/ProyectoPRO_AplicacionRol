package es.PRO.DAO;

import es.PRO.InDAO.IFichaPJDAO;
import es.PRO.modelo.FichaPJ;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jorge
 */
public class FichaPJDAO implements IFichaPJDAO {

    final String insercion = "INSERT INTO FICHAPJ (codigo, nombrePJ, raza, clase, nivel, fue, mag, agi, res)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    final String borrado = "DELETE FROM FICHAPJ WHERE codigo = ?";

    final String actualizar = "";

    final String getALL = "SELECT * FROM FICHAPJ";

    final String getONE = "SELECT * FROM FICHAPJ WHERE CODIGO =?";

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
            ps.setInt(5, obj.getNivel());
            ps.setInt(6, obj.getFue());
            ps.setInt(7, obj.getMag());
            ps.setInt(8, obj.getAgi());
            ps.setInt(9, obj.getRes());
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
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<FichaPJ> fichaspj = new ArrayList<>();
        FichaPJ fichapj = null;
        try {
            ps = con.prepareStatement(getALL);
            rs = ps.executeQuery();

            while (rs.next()) {
                fichapj = convertir(rs);
                fichaspj.add(fichapj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return fichaspj;
    }

    @Override
    public FichaPJ getObj(Integer codigo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        FichaPJ fichapj = null;
        try {
            ps = con.prepareStatement(getONE);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();

            if (rs.next()) {
                fichapj = convertir(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return fichapj;
    }

    @Override
    public void update(FichaPJ obj) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(actualizar);
            ps.setInt(1, obj.getCodigo());
            ps.setString(2, obj.getNombrePJ());
            ps.setString(3, obj.getRaza());
            ps.setString(4, obj.getClase());
            ps.setInt(5, obj.getNivel());
            ps.setInt(6, obj.getFue());
            ps.setInt(7, obj.getMag());
            ps.setInt(8, obj.getAgi());
            ps.setInt(9, obj.getRes());
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

    /**
     *
     * @param rs
     * @return
     */
    private FichaPJ convertir(ResultSet rs) {
        FichaPJ obj = null;
        try {
            if (rs != null) {
                obj = new FichaPJ();

                int codigo = rs.getInt("codigo");
                String nombrePJ = rs.getString("nombrePJ");
                String raza = rs.getString("raza");
                String clase = rs.getString("clase");
                int nivel = rs.getInt("nivel");
                int fue = rs.getInt("fue");
                int mag = rs.getInt("mag");
                int agi = rs.getInt("agi");
                int res = rs.getInt("res");

                obj.setCodigo(codigo);
                obj.setNombrePJ(nombrePJ);
                obj.setRaza(raza);
                obj.setClase(clase);
                obj.setNivel(nivel);
                obj.setFue(fue);
                obj.setMag(mag);
                obj.setAgi(agi);
                obj.setRes(res);
            }
        } catch (SQLException e) {

        }
        return obj;
    }

}
