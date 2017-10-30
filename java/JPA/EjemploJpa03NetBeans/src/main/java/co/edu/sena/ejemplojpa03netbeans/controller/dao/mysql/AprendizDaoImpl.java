/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejemplojpa03netbeans.controller.dao.mysql;

import co.edu.sena.ejemplojpa03netbeans.model.jpa.entities.Aprendiz;
import javax.persistence.EntityManager;

/**
 *
 * @author Enrique
 */
public class AprendizDaoImpl extends AbstractDao<Aprendiz>{

    public AprendizDaoImpl(Class<Aprendiz> entityClass) {
        super(entityClass);
    }
    
}
