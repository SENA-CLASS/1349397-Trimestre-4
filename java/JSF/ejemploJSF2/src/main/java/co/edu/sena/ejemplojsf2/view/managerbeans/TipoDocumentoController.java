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
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author Enrique
 */
@Named(value = "tipoDocumentoController")
@RequestScoped
public class TipoDocumentoController {
    
    @EJB
    TipoDocumentoFacade tipoDocumentoFacade;
    
       @EJB
    LogErrorFacade logErrorFacade;
    
    private String tipoDocumentoFormulario;
    private String descripcionFormulario;
    private boolean estado;
    
    /**
     * Creates a new instance of TipoDocumentoController
     */
    public TipoDocumentoController() {
    }
    
    public void guardar(){
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setDocumento(this.tipoDocumentoFormulario);
        tipoDocumento.setDescripcion(this.descripcionFormulario);
        tipoDocumento.setEstado(estado);
        try {
            if(tipoDocumentoFacade.find(tipoDocumento.getDocumento())==null){
                 tipoDocumentoFacade.create(tipoDocumento);
                FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado", "se pudo registar");
                FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            }else{
                FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "ya esxite");
                FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            
            }
            
           
        } catch (PersistenceException e) {
            LogError error = new LogError();
            error.setLevel(java.util.logging.Level.SEVERE.getName());
            
            logErrorFacade.create(error);
        }
    
    
    }
    
    @PostConstruct
    public void init() {
      
       
       
    }

   
    public String getTipoDocumentoFormulario() {
        return tipoDocumentoFormulario;
    }

    public void setTipoDocumentoFormulario(String tipoDocumentoFormulario) {
        this.tipoDocumentoFormulario = tipoDocumentoFormulario;
    }

    public String getDescripcionFormulario() {
        return descripcionFormulario;
    }

    public void setDescripcionFormulario(String descripcionFormulario) {
        this.descripcionFormulario = descripcionFormulario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    
    
    
}
