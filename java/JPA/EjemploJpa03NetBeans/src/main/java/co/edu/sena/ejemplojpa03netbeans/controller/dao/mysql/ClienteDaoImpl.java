/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejemplojpa03netbeans.controller.dao.mysql;

import co.edu.sena.ejemplojpa03netbeans.controller.dao.ClienteDao;
import co.edu.sena.ejemplojpa03netbeans.model.jpa.entities.Cliente;
import co.edu.sena.ejemplojpa03netbeans.model.jpa.entities.ClientePK;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Enrique
 */
public class ClienteDaoImpl extends AbstractDao<Cliente> implements ClienteDao<Cliente>{
    
    public ClienteDaoImpl(Class<Cliente> entityClass) {
        super(entityClass);
    }

    @Override
    public int updatePrimaryKey(ClientePK llaveNueva, ClientePK llaveVieja) {
        try {
            this.getEntityManager();
            
            if(this.find(llaveVieja)!=null){
            
            Query query = this.em.createNamedQuery("Cliente.updatePk");
            query.setParameter("nuevoTipoDocumento", llaveNueva.getTipoDocumento() );
            query.setParameter("nuevoDocumento", llaveNueva.getNumeroDocumento());
            query.setParameter("viejoTipoDocumento", llaveVieja.getTipoDocumento());
            query.setParameter("viejoDocumento", llaveVieja.getNumeroDocumento());
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
