/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejemplojsf2.view.managerbeans;

import co.edu.sena.ejemplojsf2.controller.ebjs.ClienteFacade;
import co.edu.sena.ejemplojsf2.controller.ebjs.LogErrorFacade;
import co.edu.sena.ejemplojsf2.model.entities.Cliente;
import co.edu.sena.ejemplojsf2.model.entities.LogError;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.PersistenceException;

/**
 *
 * @author Enrique
 */
@Named(value = "clienteController")
@RequestScoped
public class ClienteController {

    @EJB
    ClienteFacade clienteFacade;
    
    @EJB
    LogErrorFacade logErrorFacade;
    
    
    private List<Cliente> consulta;
    private Cliente seleccionado;
      
    

    public Cliente getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Cliente seleccionado) {
        this.seleccionado = seleccionado;
    }
    

    /**
     * Creates a new instance of ClienteController
     */
    public ClienteController() {
    }
    
    public void guardar(){
    
       
    
    }
    
    @PostConstruct
    public void init() {
        
        try {
            consulta = clienteFacade.findAll();
        } catch (PersistenceException e) {
            LogError error = new LogError();
            error.setLevel(java.util.logging.Level.SEVERE.getName());
            
            logErrorFacade.create(error);
        }
       
    }

    public List<Cliente> getConsulta() {
        return consulta;
    }

    public void setConsulta(List<Cliente> consulta) {
        this.consulta = consulta;
    }

   

   

}
