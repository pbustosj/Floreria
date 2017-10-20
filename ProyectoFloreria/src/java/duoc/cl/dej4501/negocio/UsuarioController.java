/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.negocio;

import duoc.cl.dej4501.entidades.Usuario;
import duoc.cl.dej4501.persistencia.UsuarioDAO;
import java.util.List;

/**
 *
 * @author pbustosj
 */
public class UsuarioController {

    private UsuarioDAO objUsuarioDAO;

    public UsuarioController() {
        this.objUsuarioDAO = new UsuarioDAO();
    }

    public Usuario compruebaUsuario(String login, String pass) {
        return this.objUsuarioDAO.compruebaUsuario(login, pass);
    }

    public List getAllUsuario() {
        return this.objUsuarioDAO.readElementos();
    }

    public List getAllUsuarioDTO() {
        return this.objUsuarioDAO.readElementosDTO();
    }

    public boolean deleteElemento(int codigo) {
        return this.objUsuarioDAO.deleteElemento(codigo);
    }

    public boolean addElemento(Object elemento) {
        return this.objUsuarioDAO.addElemento(elemento);
    }

    public Usuario buscaUsuarioPorID(int codigo) {
        return this.objUsuarioDAO.buscaUsuarioPorID(codigo);
    }

    public boolean updateElemento(Object elemento) {

        return this.objUsuarioDAO.updateElemento(elemento);
    }
}
