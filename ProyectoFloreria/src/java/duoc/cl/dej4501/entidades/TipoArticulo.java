
package duoc.cl.dej4501.entidades;

/**
 *
 * @author pbustosj
 */
public class TipoArticulo {
    private int id_tipoArticulo;
    private String descrip_tipoAticulo;

    public TipoArticulo() {
    }

    public TipoArticulo(int id_tipoArticulo, String descrip_tipoAticulo) {
        this.id_tipoArticulo = id_tipoArticulo;
        this.descrip_tipoAticulo = descrip_tipoAticulo;
    }

    public int getId_tipoArticulo() {
        return id_tipoArticulo;
    }

    public void setId_tipoArticulo(int id_tipoArticulo) {
        this.id_tipoArticulo = id_tipoArticulo;
    }

    public String getDescrip_tipoAticulo() {
        return descrip_tipoAticulo;
    }

    public void setDescrip_tipoAticulo(String descrip_tipoAticulo) {
        this.descrip_tipoAticulo = descrip_tipoAticulo;
    }
    
    
}
