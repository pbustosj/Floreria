
package duoc.cl.dej4501.persistencia;

import duoc.cl.dej4501.entidades.Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author pbustosj
 */
public class MenuDAO implements ICrud{

    @Override
    public boolean addElemento(Object objetoInsert) {
       Menu objMenu = (Menu) objetoInsert;
        try {
            Connection con = Conexion.getConexion();
            String query = "INSERT INTO menu VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objMenu.getNombre_menu());
            ps.setInt(2, objMenu.getPadre_menu());
            ps.setString(3, objMenu.getDestino_menu());
            ps.setInt(4, objMenu.getId_perfil());
         
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("error al insertar");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al Insertar en la BD" + e.getMessage());
        }
        return false;
    }

    @Override
    public List readElementos() {
         List listadoMenus = new LinkedList();
        try {
            Connection con = Conexion.getConexion();
            String query = "select * from menu";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Menu objMenu = new Menu(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getInt(5));
                listadoMenus.add(objMenu);
            }
        } catch (Exception e) {
            System.out.println("error al conectar la BD" + e.getMessage());
        }
        return listadoMenus;
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
          Menu objMenu = (Menu) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "update menu set nombre_menu=?,padre_menu=?,destino_menu=?,id_perfil=? where id_menu=?";
            PreparedStatement ps = con.prepareStatement(query);
           /* ps.setString(1, objUsuario.getLogin_usuario());
            ps.setString(2, objUsuario.getPass_usuario());
            ps.setString(3, objUsuario.getNombre_usuario());
            ps.setString(4, objUsuario.getApellido_usuario());
            ps.setString(5, objUsuario.getCorreo_usuario());
            ps.setInt(6, objUsuario.getEdad_usuario());
            ps.setInt(7, objUsuario.getCodigo_perfil());
            ps.setDate(8, new Date(objUsuario.getFechaNacimiento_perfil().getTime()));
            ps.setInt(9, objUsuario.getCodigo_usuario());*/
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Problemas al updatear");
            }
        } catch (Exception e) {
            System.out.println("No se pudo updatear la base de datos");
        }
        return false;
    }

    @Override
    public boolean deleteElemento(int codigo) {
        try {
            Connection con = Conexion.getConexion();
            String query = "DELETE FROM menu WHERE id_menu=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Error al Eliminar el registros" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al borrar los registros" + e.getMessage());
        }
        return false;
    }
    
    public List getMenuByIdPerfil(int id_perfil){
        List listadoMenus = new LinkedList();
          try {
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM menu WHERE id_perfil=? order by padre_menu";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id_perfil);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Menu objMenu = new Menu(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getInt(5));
                listadoMenus.add(objMenu);
            }
        } catch (Exception e) {
            System.out.println("Error al borrar los registros" + e.getMessage());
        }
    
        return listadoMenus;
    }
    
}
