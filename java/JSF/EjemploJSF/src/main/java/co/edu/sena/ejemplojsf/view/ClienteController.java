/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejemplojsf.view;

import co.edu.sena.ejemplojsf.controller.ejbs.ClienteFacade;
import co.edu.sena.ejemplojsf.model.entities.Cliente;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Enrique
 */
@Named(value = "clienteController")
@RequestScoped
public class ClienteController {

    @EJB
    private ClienteFacade clienteFacade;

    /**
     * Creates a new instance of ClienteController
     */
    public ClienteController() {
    }

    public List<Cliente> consultarCliente() {
        return clienteFacade.findAll();
    }

    public String saludar() {
        return "hola mundo";
    }

}
