/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.negocio;

import duoc.cl.dej4501.persistencia.PerfilDAO;
import duoc.cl.dej4501.entidades.Perfil;
import java.util.List;

/**
 *
 * @author amontess
 */
public class PerfilController {
    PerfilDAO objPerfilDAO;

    public PerfilController() {
        this.objPerfilDAO= new PerfilDAO();
    }
    
    public List<Perfil> getAllPerfil(){
        return this.objPerfilDAO.readElementos();
    }
    
    public Perfil getPerfilXCodigo(int codigoPerfil){
        return this.objPerfilDAO.buscaPerfilPOrID(codigoPerfil);
    }
    
    public boolean addPerfil(Perfil perfil){
        return this.objPerfilDAO.addElemento(perfil);
    }
    
    public boolean editPerfil(Perfil objPerfil){
        return this.objPerfilDAO.updateElemento(objPerfil);
    }
    
    public boolean deletePerfil(int codigoPerfil){
        return this.objPerfilDAO.deleteElemento(codigoPerfil);
    }
}
