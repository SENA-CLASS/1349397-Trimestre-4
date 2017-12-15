/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejemplojsf2.view.managerbeans;

import co.edu.sena.ejemplojsf2.controller.ebjs.LogErrorFacade;
import co.edu.sena.ejemplojsf2.controller.ebjs.TipoDocumentoFacade;
import co.edu.sena.ejemplojsf2.model.entities.LogError;
import co.edu.sena.ejemplojsf2.model.entities.TipoDocumento;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.persistence.PersistenceException;

/**
 *
 * @author Enrique
 */
@Named(value = "clienteCreateController")
@RequestScoped
public class ClienteCreateController {
    
    @EJB
    private TipoDocumentoFacade tipoDocumentoFacade;
    
    @EJB
    LogErrorFacade logErrorFacade;
    
    private TipoDocumento tipoDocumento;
    private String tipoDocumentoSeleccionado;
    private List<TipoDocumento> itemsSelector;

    /**
     * Creates a new instance of ClienteCreateController
     */
    public ClienteCreateController() {
    }
    
    public void guardar(){
    
        System.out.println(this.tipoDocumentoSeleccionado);
    
    }
    
     @PostConstruct
    public void init() {
        
        List<TipoDocumento> selectorTipoDocumento = null;
        try {
            selectorTipoDocumento = tipoDocumentoFacade.findAll();
        } catch (PersistenceException e) {
            LogError error = new LogError();
            error.setLevel(java.util.logging.Level.SEVERE.getName());
            
            logErrorFacade.create(error);
        }
        this.itemsSelector= selectorTipoDocumento;
       
    }
    
   

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<TipoDocumento> getItemsSelector() {
        return itemsSelector;
    }

    public void setItemsSelector(List<TipoDocumento> itemsSelector) {
        this.itemsSelector = itemsSelector;
    }

    public String getTipoDocumentoSeleccionado() {
        return tipoDocumentoSeleccionado;
    }

    public void setTipoDocumentoSeleccionado(String tipoDocumentoSeleccionado) {
        this.tipoDocumentoSeleccionado = tipoDocumentoSeleccionado;
    }
    
    
    
    
}
