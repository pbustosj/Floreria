/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.presentacion;

import duoc.cl.dej4501.dto.UsuarioPerfilDTO;
import duoc.cl.dej4501.entidades.Usuario;
import duoc.cl.dej4501.negocio.UsuarioController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cetecom
 */
@WebServlet(name = "GetAllUsuarioServlet", urlPatterns = {"/getAllUsuarioServlet","/getallUsuario"})
public class GetAllUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioController objUsuarioController= new UsuarioController();
        List<UsuarioPerfilDTO>listadoUsuario=objUsuarioController.getAllUsuarioDTO();
        request.getSession().setAttribute("listadoUsuario", listadoUsuario);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
