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
 * @author pbustosj
 */
@WebServlet(name = "ValidaUsuarioServlet", urlPatterns = {"/validaUsuarioServlet", "/validaUsuario"})
public class ValidaUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        UsuarioController objUsuarioBO = new UsuarioController();
        String login = request.getParameter("txtLogin");
        String pass = request.getParameter("txtPass");

        Usuario infoUsuario = objUsuarioBO.compruebaUsuario(login, pass);
        if (infoUsuario != null) {
            sesion.setAttribute("usuarioConectado", infoUsuario);
            response.sendRedirect("Home.jsp");
        } else {
            sesion.setAttribute("msgError", "Usuario No Existe");
            response.sendRedirect("login.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
