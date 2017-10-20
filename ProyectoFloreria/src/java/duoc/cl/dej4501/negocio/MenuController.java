
package duoc.cl.dej4501.negocio;


import duoc.cl.dej4501.entidades.Menu;
import duoc.cl.dej4501.persistencia.MenuDAO;
import java.util.List;

/**
 *
 * @author pbustosj
 */
public class MenuController {
    private MenuDAO objMenuDao;

    public MenuController() {
        this.objMenuDao = new MenuDAO();
    }
    
     public List<Menu> getMenuByIdPerfil(int id_perfil){
        return this.objMenuDao.getMenuByIdPerfil(id_perfil);
    }
    
    

 
    
}
