
package duoc.cl.dej4501.presentacion;

import duoc.cl.dej4501.entidades.Menu;
import duoc.cl.dej4501.entidades.Usuario;
import duoc.cl.dej4501.negocio.MenuController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "CargaMenuServlet", urlPatterns = {"/cargaMenuServlet"})
public class CargaMenuServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession sesion=request.getSession();
            MenuController mC =  new MenuController();
            List lM = null;
            
            if(sesion.getAttribute("usuarioConectado")!=null){
                Usuario objUsuario =  (Usuario)sesion.getAttribute("usuarioConectado");
                lM = mC.getMenuByIdPerfil(objUsuario.getId_perfil());
                request.setAttribute("listadoMenu", lM);                
            }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
