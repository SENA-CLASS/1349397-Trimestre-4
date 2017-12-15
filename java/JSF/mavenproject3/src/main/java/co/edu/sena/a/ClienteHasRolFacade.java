/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.a;

import co.edu.sena.mavenproject3.ClienteHasRol;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Enrique
 */
@Stateless
public class ClienteHasRolFacade extends AbstractFacade<ClienteHasRol> {

    @PersistenceContext(unitName = "co.edu.sena_mavenproject3_war_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteHasRolFacade() {
        super(ClienteHasRol.class);
    }
    
}
