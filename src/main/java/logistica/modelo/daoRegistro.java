 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica.modelo;

import seguridad.modelo.clsConexion;
import logistica.controlador.clsRegistro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoRegistro {

    private static final String SQL_SELECT = "SELECT regid, regnombre, regfecha FROM tbl_registro";
    private static final String SQL_INSERT = "INSERT INTO tbl_registro(regnombre, regfecha) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_registro SET regnombre=?, regfecha=? WHERE regid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_registro WHERE regid=?";
    private static final String SQL_QUERY = "SELECT regid, regnombre, regfecha FROM tbl_registro WHERE regid = ?";

    public List<clsRegistro> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsRegistro re = null;
        List<clsRegistro> res = new ArrayList<clsRegistro>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("regid");
                int nombre = rs.getInt("regnombre");
                String fecha = rs.getString("regfecha");
                
                re = new clsRegistro();
                re.setcodigo(codigo);
                re.setNombre(nombre);
                re.setfecha(fecha);
                
                res.add(re);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return res;
    }

    public int insert(clsRegistro re) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, re.getNombre());
            stmt.setString(2, re.getfecha());


            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int update(clsRegistro re) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, re.getNombre());
            stmt.setString(2, re.getfecha());
            stmt.setInt(3, re.getcodigo());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int delete(clsRegistro re) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, re.getcodigo());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public clsRegistro query(clsRegistro re) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsRegistro> res = new ArrayList<clsRegistro>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, re.getcodigo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("regid");
                int nombre = rs.getInt("regnombre");
                String fecha = rs.getString("regfecha");
                
                re = new clsRegistro();
                re.setcodigo(codigo);
                re.setNombre(nombre);
                re.setfecha(fecha);
                
                //vendedores.add(vendedor); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return vendedores;  // Si se utiliza un ArrayList
        return re;
    }
        
}
