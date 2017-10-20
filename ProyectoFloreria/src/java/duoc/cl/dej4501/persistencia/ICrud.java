/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.persistencia;

import java.util.List;

/**
 *
 * @author amontess
 */
public interface ICrud {
    /**
     * método que permite agregar un objeto a una tabla
     * @param objetoInsert objeto a intsertar
     * @return resultado de la transacción
     */
    public boolean addElemento(Object objetoInsert);

    /**
     * método que permite la lectura de una tabla.
     * @return un listado con la información recuperada
     */
    public List readElementos();

    /**
     * Método que permite updatear con los datos de una tabla
     * @param objetoUpdate objeto con la información a updatear
     * @return true/false dependiendo del resultado de la transacción
     */
    public boolean updateElemento(Object objetoUpdate);
    
    /**
     * Método que permite eliminar un dato de una tabla
     * @param codigo del registro que se pretende eliminar
     * @return true/ false depeniendo del resultado final.
     */
    public boolean deleteElemento(int codigo);        
    
}
