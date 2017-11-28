/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejemplojpa03netbeans.controller.factory;

import co.edu.sena.ejemplojpa03netbeans.controller.dao.ClienteDao;
import co.edu.sena.ejemplojpa03netbeans.controller.dao.mysql.ClienteDaoImpl;
import co.edu.sena.ejemplojpa03netbeans.model.jpa.entities.Cliente;

/**
 *
 * @author Enrique
 */
public class ClienteFactory {
    
    public static ClienteDao<?> create(Class<Cliente> entityClass){
        return new ClienteDaoImpl(entityClass);
    }
    
}
