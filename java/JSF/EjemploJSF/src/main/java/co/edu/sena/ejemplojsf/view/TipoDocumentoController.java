/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejemplojsf.view;

import co.edu.sena.ejemplojsf.controller.ejbs.TipoDocumentoFacade;
import co.edu.sena.ejemplojsf.model.entities.Cliente;
import co.edu.sena.ejemplojsf.model.entities.TipoDocumento;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Enrique
 */
@Named(value = "tipoDocumentoController")
@RequestScoped
public class TipoDocumentoController {

    @EJB
    private TipoDocumentoFacade tipoDocumentoFacade;

    private Cliente cliente;
    private TipoDocumento tipoDocumento;

    private String tipoDocumentoFormulario;
    private String numeroDocumentoFormulario;
    private boolean estadoFormulario;

    /**
     * Creates a new instance of TipoDocumentoController
     */
    public TipoDocumentoController() {
    }

    public boolean isEstadoFormulario() {
        return estadoFormulario;
    }

    public void setEstadoFormulario(boolean estadoFormulario) {
        this.estadoFormulario = estadoFormulario;
    }

    public void insertar() {

        
        TipoDocumento tipoDocumentoGuardar = new TipoDocumento();
        tipoDocumentoGuardar.setEstado(estadoFormulario);
        tipoDocumentoGuardar.setDescripcion(numeroDocumentoFormulario);
        tipoDocumentoGuardar.setDocumento(tipoDocumentoFormulario);
        tipoDocumentoFacade.create(tipoDocumentoGuardar);

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTipoDocumentoFormulario() {
        return tipoDocumentoFormulario;
    }

    public void setTipoDocumentoFormulario(String tipoDocumentoFormulario) {
        this.tipoDocumentoFormulario = tipoDocumentoFormulario;
    }

    public String getNumeroDocumentoFormulario() {
        return numeroDocumentoFormulario;
    }

    public void setNumeroDocumentoFormulario(String numeroDocumentoFormulario) {
        this.numeroDocumentoFormulario = numeroDocumentoFormulario;
    }

}
