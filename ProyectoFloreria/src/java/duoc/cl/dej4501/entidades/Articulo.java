
package duoc.cl.dej4501.entidades;

import java.io.Serializable;

/**
 *
 * @author pbustosj
 */
public class Articulo implements Serializable{
    private int id_articulo;
    private String descrip_articulo;
    private int precio;
    private int stock;
    private int id_tipoArticulo;

    public Articulo() {
    }

    public Articulo(int id_articulo, String descrip_articulo, int precio, int stock, int id_tipoArticulo) {
        this.id_articulo = id_articulo;
        this.descrip_articulo = descrip_articulo;
        this.precio = precio;
        this.stock = stock;
        this.id_tipoArticulo = id_tipoArticulo;
    }
    
        public Articulo( String descrip_articulo, int precio, int stock, int id_tipoArticulo) {
 
        this.descrip_articulo = descrip_articulo;
        this.precio = precio;
        this.stock = stock;
        this.id_tipoArticulo = id_tipoArticulo;
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getDescrip_articulo() {
        return descrip_articulo;
    }

    public void setDescrip_articulo(String descrip_articulo) {
        this.descrip_articulo = descrip_articulo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId_tipoArticulo() {
        return id_tipoArticulo;
    }

    public void setId_tipoArticulo(int id_tipoArticulo) {
        this.id_tipoArticulo = id_tipoArticulo;
    }
        
        
    
    
    
    
}
