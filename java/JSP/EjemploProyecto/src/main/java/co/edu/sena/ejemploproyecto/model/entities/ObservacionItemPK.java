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
public class ObservacionItemPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_observacion")
    private int idObservacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero_ficha")
    private String numeroFicha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grupo_codigo")
    private int grupoCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lista_chequeo")
    private String listaChequeo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_item")
    private int idItem;

    public ObservacionItemPK() {
    }

    public ObservacionItemPK(int idObservacion, String numeroFicha, int grupoCodigo, String listaChequeo, int idItem) {
        this.idObservacion = idObservacion;
        this.numeroFicha = numeroFicha;
        this.grupoCodigo = grupoCodigo;
        this.listaChequeo = listaChequeo;
        this.idItem = idItem;
    }

    public int getIdObservacion() {
        return idObservacion;
    }

    public void setIdObservacion(int idObservacion) {
        this.idObservacion = idObservacion;
    }

    public String getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public int getGrupoCodigo() {
        return grupoCodigo;
    }

    public void setGrupoCodigo(int grupoCodigo) {
        this.grupoCodigo = grupoCodigo;
    }

    public String getListaChequeo() {
        return listaChequeo;
    }

    public void setListaChequeo(String listaChequeo) {
        this.listaChequeo = listaChequeo;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idObservacion;
        hash += (numeroFicha != null ? numeroFicha.hashCode() : 0);
        hash += (int) grupoCodigo;
        hash += (listaChequeo != null ? listaChequeo.hashCode() : 0);
        hash += (int) idItem;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObservacionItemPK)) {
            return false;
        }
        ObservacionItemPK other = (ObservacionItemPK) object;
        if (this.idObservacion != other.idObservacion) {
            return false;
        }
        if ((this.numeroFicha == null && other.numeroFicha != null) || (this.numeroFicha != null && !this.numeroFicha.equals(other.numeroFicha))) {
            return false;
        }
        if (this.grupoCodigo != other.grupoCodigo) {
            return false;
        }
        if ((this.listaChequeo == null && other.listaChequeo != null) || (this.listaChequeo != null && !this.listaChequeo.equals(other.listaChequeo))) {
            return false;
        }
        if (this.idItem != other.idItem) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.ejemploproyecto.model.entities.ObservacionItemPK[ idObservacion=" + idObservacion + ", numeroFicha=" + numeroFicha + ", grupoCodigo=" + grupoCodigo + ", listaChequeo=" + listaChequeo + ", idItem=" + idItem + " ]";
    }
    
}
