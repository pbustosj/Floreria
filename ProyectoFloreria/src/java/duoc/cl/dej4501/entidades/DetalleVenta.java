
package duoc.cl.dej4501.entidades;

import java.io.Serializable;

/**
 *
 * @author pbustosj
 */
public class DetalleVenta implements Serializable{
    private int id_venta;
    private int id_articulo;
    private int cantidad_articulo;

    public DetalleVenta() {
    }

    public DetalleVenta(int id_venta, int id_articulo, int cantidad_articulo) {
        this.id_venta = id_venta;
        this.id_articulo = id_articulo;
        this.cantidad_articulo = cantidad_articulo;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public int getCantidad_articulo() {
        return cantidad_articulo;
    }

    public void setCantidad_articulo(int cantidad_articulo) {
        this.cantidad_articulo = cantidad_articulo;
    }
    
    
    
}
