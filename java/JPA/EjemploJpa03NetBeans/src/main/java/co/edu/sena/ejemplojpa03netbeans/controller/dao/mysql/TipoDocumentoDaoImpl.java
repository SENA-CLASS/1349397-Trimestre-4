/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejemplojpa03netbeans.controller.dao.mysql;

import co.edu.sena.ejemplojpa03netbeans.controller.dao.TipoDocumentoDao;
import co.edu.sena.ejemplojpa03netbeans.model.jpa.entities.TipoDocumento;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Enrique
 */
public class TipoDocumentoDaoImpl extends AbstractDao<TipoDocumento> implements TipoDocumentoDao<TipoDocumento>{
    
    public TipoDocumentoDaoImpl(Class entityClass) {
        super(entityClass);
    }
    
    public List<TipoDocumento> findByDescripcion(String descripcion) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TipoDocumento.findByDescripcion");
            query.setParameter("descripcion", descripcion);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }
    
    public List<TipoDocumento> findByEstado(boolean estado) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TipoDocumento.findByEstado");
            query.setParameter("estado", estado);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }
    
      public List<TipoDocumento> findByLikeDescripcion(String descripcion) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TipoDocumento.findByLikeDescripcion");
            query.setParameter("descripcion", descripcion);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }
      
     public List<TipoDocumento> findByLikeDocumento(String documento) {
        try {
            this.getEntityManager();
            Query query = this.em.createNamedQuery("TipoDocumento.findByLikeDocumento");
            query.setParameter("documento", documento);
            return query.getResultList();
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
       return null;
    }
     
    public int updatePrimaryKey(String llaveNueva, String llaveVieja){
        try {
            this.getEntityManager();
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("TipoDocumento.updatePimaryKey");
            query.setParameter("documentoNuevo", llaveNueva );
            query.setParameter("documentoViejo", llaveVieja );
            this.em.getTransaction().begin();
            int res =query.executeUpdate();
            this.em.getTransaction().commit();
            return res;
            }else{
                return 0;
            }
            
        } catch (PersistenceException e) {
            System.out.println("Exception:" + e.getMessage());
        }
    
        return 0;
    
    }
    
    
    
    
}
