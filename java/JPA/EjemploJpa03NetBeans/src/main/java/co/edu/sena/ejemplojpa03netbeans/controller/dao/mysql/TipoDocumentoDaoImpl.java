/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejemplojpa03netbeans.controller.dao.mysql;

import co.edu.sena.ejemplojpa03netbeans.controller.dao.TipoDocumentoDao;
import co.edu.sena.ejemplojpa03netbeans.model.jpa.entities.TipoDocumento;

/**
 *
 * @author Enrique
 */
public class TipoDocumentoDaoImpl extends AbstractDao<TipoDocumento> implements TipoDocumentoDao<TipoDocumento>{
    
    public TipoDocumentoDaoImpl(Class entityClass) {
        super(entityClass);
    }
    
}
