/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.persistencia;

import duoc.cl.dej4501.entidades.Perfil;
import duoc.cl.dej4501.persistencia.Conexion;
import duoc.cl.dej4501.persistencia.ICrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author amontess
 */
public class PerfilDAO implements ICrud{
    public PerfilDAO() {
    }
 
    //<editor-fold defaultstate="collapsed" desc="Crud">
    @Override
    public boolean addElemento(Object objetoInsert) {
        Perfil objPerfil = (Perfil) objetoInsert;
        int estado = 0;
        try {
            Connection con = Conexion.getConexion();
            String query = "insert into perfil (id_perfil,tipo_perfil) values (?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, ultimoID());
            ps.setString(2, objPerfil.getTipo_perfil());
            try {
                estado = ps.executeUpdate();
                System.out.println("información ingresada correctamente");
                return true;
            } catch (Exception e) {
                System.out.println("problemas al insertar " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al insertar en la bd" + e.getMessage());
        }
        return false;
    }

    @Override
    public List readElementos() {
        List listadoPerfiles = new LinkedList();
        try {
            Connection con = Conexion.getConexion();
            String query = "select * from perfil";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Perfil objPerfil = new Perfil(rs.getInt(1), rs.getString(2));
                //Perfil objPerfil= new Perfil(rs.getInt("codigo_perfil"), rs.getString("nombre_perfil"));
                listadoPerfiles.add(objPerfil);
            }

        } catch (Exception e) {
            System.out.println("problemas al leer la lista" + e);
        }
        return listadoPerfiles;
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
        Perfil objPerfil = (Perfil) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "update perfil set nombre_perfil=? where id_perfil=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objPerfil.getTipo_perfil());
            ps.setInt(2, objPerfil.getId_perfil());
            try {
                //return ps.executeUpdate()==1;
                ps.executeUpdate();
                return true;
            } catch (Exception e) {
                System.out.println("problemas al updatear" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("problemas en updatear las tablas" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteElemento(int codigo) {
        try {
            Connection con = Conexion.getConexion();
            String query1 = "DELETE FROM usuario WHERE usuario.id_perfil=?";
            String query2 ="DELETE FROM perfil WHERE perfil.id_perfil=?";
            PreparedStatement ps1 = con.prepareStatement(query1);
            PreparedStatement ps2 = con.prepareStatement(query2);
            ps1.setInt(1, codigo);
            ps2.setInt(1, codigo);
            try {
                ps1.executeUpdate();
                ps2.executeUpdate();
                return true;
            } catch (Exception e) {
                System.out.println("Problemas al eliminar" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("problemas al eliminar " + e.getMessage());
        }
        return false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    public int ultimoID() {
        int id = 0;
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT MAX(id_perfil) FROM perfil";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("error al leer la BD" + e);
        }
        return id + 1;
    }
    
    public Perfil buscaPerfilPOrID(int codigo_perfil) {
        Perfil objPerfil = null;
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM perfil WHERE id_perfil=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo_perfil);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                objPerfil = new Perfil(codigo_perfil, rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("No se pudo conectar a la BD" + e.getMessage());
        }
        return objPerfil;
    }
    //</editor-fold>
    
}
