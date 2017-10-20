/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.presentacion;

import duoc.cl.dej4501.entidades.Usuario;
import duoc.cl.dej4501.negocio.UsuarioController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alex
 */
@WebServlet(name = "AddPerfilServlet", urlPatterns = {"/editUser", "/editUsuario"})
public class EditUsuarioServlet extends HttpServlet {

    String msg = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        UsuarioController objPerfilController = new UsuarioController();
        String login = request.getParameter("loginUser");
        String pass = request.getParameter("passUser");
        String perfil = request.getParameter("perfilUser");
        Usuario oU = (Usuario)request.getSession().getAttribute("userToEdit");
        int id= oU.getId_perfil();
        Usuario objPerfil = new Usuario(id, login, pass, Integer.parseInt(perfil));
        if (objPerfilController.updateElemento(objPerfil)) {
            msg = "Usuario Editado Correctamente";
        } else {
            msg = objPerfil.toString();
        }
        sesion.setAttribute("msg", msg);
        response.sendRedirect("MantenedorUsuario.jsp");
    }

}
