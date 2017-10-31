/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejemplojpa03netbeans.controller.dao;

import co.edu.sena.ejemplojpa03netbeans.model.jpa.entities.TipoDocumento;
import java.util.List;

/**
 *
 * @author Enrique
 * @param <T>
 */
public interface TipoDocumentoDao<T extends TipoDocumento> extends InterfaceDao<T> {

    public List<T> findByDescripcion(String descripcion);
    public List<T> findByEstado(boolean estado);
    public List<T> findByLikeDescripcion(String descripcion);
    public List<T> findByLikeDocumento(String documento);
    public int updatePrimaryKey(String llaveNueva, String llaveVieja);
    

}
