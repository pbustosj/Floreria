/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.presentacion;

import duoc.cl.dej4501.negocio.UsuarioController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex
 */
@WebServlet(name = "EliminaUsuarioServlet", urlPatterns = {"/eliminaUsuario"})
public class EliminaUsuarioServlet extends HttpServlet {
    String msg=null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigoEliminar=Integer.parseInt(request.getParameter("id"));
        UsuarioController objPerfilController= new UsuarioController();
        if(objPerfilController.deleteElemento(codigoEliminar)){
            msg="informacion correctamente eliminada";
        }else{
            msg="Problemas al eliminar la información";
        }
        request.getSession().setAttribute("msg", msg);
        response.sendRedirect("MantenedorUsuario.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
