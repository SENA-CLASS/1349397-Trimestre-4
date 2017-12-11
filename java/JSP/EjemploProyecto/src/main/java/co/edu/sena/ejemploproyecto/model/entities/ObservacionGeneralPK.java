/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejemploproyecto.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Enrique
 */
@Embeddable
public class ObservacionGeneralPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "grupo_numero_ficha")
    private String grupoNumeroFicha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grupo_codigo")
    private int grupoCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_observacion")
    private int idObservacion;

    public ObservacionGeneralPK() {
    }

    public ObservacionGeneralPK(String grupoNumeroFicha, int grupoCodigo, int idObservacion) {
        this.grupoNumeroFicha = grupoNumeroFicha;
        this.grupoCodigo = grupoCodigo;
        this.idObservacion = idObservacion;
    }

    public String getGrupoNumeroFicha() {
        return grupoNumeroFicha;
    }

    public void setGrupoNumeroFicha(String grupoNumeroFicha) {
        this.grupoNumeroFicha = grupoNumeroFicha;
    }

    public int getGrupoCodigo() {
        return grupoCodigo;
    }

    public void setGrupoCodigo(int grupoCodigo) {
        this.grupoCodigo = grupoCodigo;
    }

    public int getIdObservacion() {
        return idObservacion;
    }

    public void setIdObservacion(int idObservacion) {
        this.idObservacion = idObservacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupoNumeroFicha != null ? grupoNumeroFicha.hashCode() : 0);
        hash += (int) grupoCodigo;
        hash += (int) idObservacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObservacionGeneralPK)) {
            return false;
        }
        ObservacionGeneralPK other = (ObservacionGeneralPK) object;
        if ((this.grupoNumeroFicha == null && other.grupoNumeroFicha != null) || (this.grupoNumeroFicha != null && !this.grupoNumeroFicha.equals(other.grupoNumeroFicha))) {
            return false;
        }
        if (this.grupoCodigo != other.grupoCodigo) {
            return false;
        }
        if (this.idObservacion != other.idObservacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.ejemploproyecto.model.entities.ObservacionGeneralPK[ grupoNumeroFicha=" + grupoNumeroFicha + ", grupoCodigo=" + grupoCodigo + ", idObservacion=" + idObservacion + " ]";
    }
    
}
