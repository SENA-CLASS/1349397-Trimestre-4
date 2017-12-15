/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejemplojsf2.controller.ebjs;

import co.edu.sena.ejemplojsf2.model.entities.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Enrique
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "co.edu.sena_ejemploJSF2_war_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
    
    public List<Cliente> findByPrimerNOmbre(String primerNombre){
        Query query = em.createNamedQuery("Cliente.findByPrimerNombre");
        query.setParameter("primerNombre",primerNombre );
        return query.getResultList();
    
    }
    
}
