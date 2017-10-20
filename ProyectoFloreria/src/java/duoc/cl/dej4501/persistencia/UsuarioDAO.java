/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.persistencia;

import duoc.cl.dej4501.dto.UsuarioPerfilDTO;
import duoc.cl.dej4501.entidades.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author pbustosj
 */
public class UsuarioDAO implements ICrud{

    public UsuarioDAO() {
    }

    //<editor-fold defaultstate="collapsed" desc="Crud">
    /**
     * Método que permite agregar un objeto a una tabla
     * @param objetoInsert objeto corresponde al registro a insertar
     * @return true/false dependiendo del resultado de la transacción
     */
    @Override
    public boolean addElemento(Object objetoInsert) {
        Usuario objUsuario = (Usuario) objetoInsert;
        try {
            Connection con = Conexion.getConexion();
            String query = "INSERT INTO usuario VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, ultimoID());
            ps.setString(2, objUsuario.getLogin_usuario());
            ps.setString(3, objUsuario.getPass_usuario());
            ps.setInt(4, objUsuario.getId_perfil());
         
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

    /**
     * retorna listado con los elementos consultados a la tabla usuario
     * @return list con los registros de la tabla usuario
     */
    @Override
    public List readElementos() {
        List listadoUsuarios = new LinkedList();
        try {
            Connection con = Conexion.getConexion();
            String query = "select * from usuario";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario objUsuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                listadoUsuarios.add(objUsuario);
            }
        } catch (Exception e) {
            System.out.println("error al conectar la BD" + e.getMessage());
        }
        return listadoUsuarios;
    }
    /**
     * Metodo que permite recuererar una consulta cruzada de perfil con usuario
     * @return objeto UsuarioPerfilDTO
     */
    public List readElementosDTO() {
        List listadoUsuarios = new LinkedList();
        try {
            Connection con = Conexion.getConexion();
            String query = "select u.*,p.tipo_perfil from usuario u,perfil p where u.id_perfil=p.id_perfil";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UsuarioPerfilDTO objUsuario = new UsuarioPerfilDTO(rs.getInt(1), rs.getString(2), 
                        rs.getString(3), rs.getString(4), rs.getString(5));
                listadoUsuarios.add(objUsuario);
            }
        } catch (Exception e) {
            System.out.println("error al conectar la BD" + e.getMessage());
        }
        return listadoUsuarios;
    }

    /**
     * metodo que permite updatear la tabla usuario con los datos del objeto cargado
     * @param objetoUpdate objeto que contiene información a modificar
     * @return true/false dependiendo del resultado de la transacción
     */
    @Override
    public boolean updateElemento(Object objetoUpdate) {
        Usuario objUsuario = (Usuario) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "update usuario set login_usuario=?,pass_usuario=?,id_perfil=? where id_usuario=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objUsuario.getLogin_usuario());
            ps.setString(2, objUsuario.getPass_usuario());
            ps.setInt(3, objUsuario.getId_perfil());
            ps.setInt(4, objUsuario.getId_usuario());
            String qr="update usuario set login_usuario="+objUsuario.getLogin_usuario()+","
                    + "pass_usuario="+objUsuario.getPass_usuario()+","
                    + "id_perfil="+objUsuario.getId_perfil()+""
                    + "where id_usuario="+objUsuario.getId_usuario();
           
             try {
                //return ps.executeUpdate()==1;
                ps.executeUpdate();
                return true;
            } catch (Exception e) {
                
                System.out.println("problemas al updatear" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("No se pudo updatear la base de datos");
        }
        return false;
    }

    /**
     * permite borrar un registro de la tabla usuario
     * @param codigo parametro int 
     * @return true/false dependiendo del resultado de la transacción
     */
    @Override
    public boolean deleteElemento(int codigo) {
        try {
            Connection con = Conexion.getConexion();
            String query = "DELETE FROM usuario WHERE id_usuario=?";
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    public int ultimoID() {
        int ultim = 0;
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT MAX(id_usuario) FROM usuario";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ultim = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("No se pudo conectar a la BD" + e.getMessage());
        }
        return ultim + 1;
    }

    /**
     * método que permite validar existencia de un usuario en la base de datos
     * @param login String que tiene datos del login
     * @param pass String que tiene los datos del pass
     * @return null u objeto encontrado 
     */
    public Usuario compruebaUsuario(String login, String pass) {
        Usuario ObjUsuario = null;
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM usuario WHERE login_usuario= ? AND pass_usuario= ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ObjUsuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (Exception e) {
            System.out.println("Error al conectar con la BD" + e.getMessage());
        }

        return ObjUsuario;
    }

    /**
     * método que busca un usuario en particular
     * @param codigo valor int
     * @return null u objeto encontrado.
     */
    public Usuario buscaUsuarioPorID(int codigo) {
        Usuario objUsuario = null;
        try {
            Connection con = Conexion.getConexion();
            String query = "select * from usuario where id_usuario=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                objUsuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (Exception e) {
            System.out.println("No se pudo conectar la BD" + e);
        }
        return objUsuario;
    }

    //</editor-fold>
}
