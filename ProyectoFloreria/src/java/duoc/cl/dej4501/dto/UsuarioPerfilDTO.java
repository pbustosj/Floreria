/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author cetecom
 */
public class UsuarioPerfilDTO implements Serializable{
    private int id_usuario;
    private String login_usuario;
    private String pass_usuario;
    private String id_perfil;
    private String tipo_perfil;
 

    public UsuarioPerfilDTO() {
    }

    public UsuarioPerfilDTO(int id_usuario, String login_usuario, String pass_usuario, String id_perfil, String tipo_perfil) {
        this.id_usuario = id_usuario;
        this.login_usuario = login_usuario;
        this.pass_usuario = pass_usuario;
        this.id_perfil = id_perfil;
        this.tipo_perfil = tipo_perfil;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getLogin_usuario() {
        return login_usuario;
    }

    public void setLogin_usuario(String login_usuario) {
        this.login_usuario = login_usuario;
    }

    public String getPass_usuario() {
        return pass_usuario;
    }

    public void setPass_usuario(String pass_usuario) {
        this.pass_usuario = pass_usuario;
    }

    public String getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(String id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getTipo_perfil() {
        return tipo_perfil;
    }

    public void setTipo_perfil(String tipo_perfil) {
        this.tipo_perfil = tipo_perfil;
    }


   
    
}
