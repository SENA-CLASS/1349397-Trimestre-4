/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejemplojpa03netbeans.controller.factory;

import co.edu.sena.ejemplojpa03netbeans.controller.dao.TipoDocumentoDao;
import co.edu.sena.ejemplojpa03netbeans.controller.dao.mysql.TipoDocumentoDaoImpl;
import co.edu.sena.ejemplojpa03netbeans.model.jpa.entities.TipoDocumento;

/**
 *
 * @author Enrique
 */
public class TipoDocumentoFactory {
    
    public static TipoDocumentoDao create(Class entityClass){
        return new TipoDocumentoDaoImpl(entityClass);
    }
    
}
