/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejemploproyecto.controller.ejbs;

import co.edu.sena.ejemploproyecto.model.entities.Aprendiz;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Enrique
 */
@Stateless// ejb y es un bean de sesssion sin estado
public class AprendizFacade extends AbstractFacade<Aprendiz> {

    @PersistenceContext(unitName = "co.edu.sena_EjemploProyecto_war_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AprendizFacade() {
        super(Aprendiz.class);
    }
    
}
