/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejemplotemplates.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "observacion_general")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObservacionGeneral.findAll", query = "SELECT o FROM ObservacionGeneral o")
    , @NamedQuery(name = "ObservacionGeneral.findByGrupoNumeroFicha", query = "SELECT o FROM ObservacionGeneral o WHERE o.observacionGeneralPK.grupoNumeroFicha = :grupoNumeroFicha")
    , @NamedQuery(name = "ObservacionGeneral.findByGrupoCodigo", query = "SELECT o FROM ObservacionGeneral o WHERE o.observacionGeneralPK.grupoCodigo = :grupoCodigo")
    , @NamedQuery(name = "ObservacionGeneral.findByIdObservacion", query = "SELECT o FROM ObservacionGeneral o WHERE o.observacionGeneralPK.idObservacion = :idObservacion")
    , @NamedQuery(name = "ObservacionGeneral.findByFecha", query = "SELECT o FROM ObservacionGeneral o WHERE o.fecha = :fecha")
    , @NamedQuery(name = "ObservacionGeneral.findByUsuario", query = "SELECT o FROM ObservacionGeneral o WHERE o.usuario = :usuario")})
public class ObservacionGeneral implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ObservacionGeneralPK observacionGeneralPK;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "observacion")
    private String observacion;
    @Lob
    @Size(max = 65535)
    @Column(name = "jurado")
    private String jurado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "usuario")
    private String usuario;
    @JoinColumns({
        @JoinColumn(name = "grupo_numero_ficha", referencedColumnName = "numero_ficha", insertable = false, updatable = false)
        , @JoinColumn(name = "grupo_codigo", referencedColumnName = "codigo", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GrupoProyecto grupoProyecto;

    public ObservacionGeneral() {
    }

    public ObservacionGeneral(ObservacionGeneralPK observacionGeneralPK) {
        this.observacionGeneralPK = observacionGeneralPK;
    }

    public ObservacionGeneral(ObservacionGeneralPK observacionGeneralPK, String observacion, Date fecha, String usuario) {
        this.observacionGeneralPK = observacionGeneralPK;
        this.observacion = observacion;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public ObservacionGeneral(String grupoNumeroFicha, int grupoCodigo, int idObservacion) {
        this.observacionGeneralPK = new ObservacionGeneralPK(grupoNumeroFicha, grupoCodigo, idObservacion);
    }

    public ObservacionGeneralPK getObservacionGeneralPK() {
        return observacionGeneralPK;
    }

    public void setObservacionGeneralPK(ObservacionGeneralPK observacionGeneralPK) {
        this.observacionGeneralPK = observacionGeneralPK;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getJurado() {
        return jurado;
    }

    public void setJurado(String jurado) {
        this.jurado = jurado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public GrupoProyecto getGrupoProyecto() {
        return grupoProyecto;
    }

    public void setGrupoProyecto(GrupoProyecto grupoProyecto) {
        this.grupoProyecto = grupoProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (observacionGeneralPK != null ? observacionGeneralPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObservacionGeneral)) {
            return false;
        }
        ObservacionGeneral other = (ObservacionGeneral) object;
        if ((this.observacionGeneralPK == null && other.observacionGeneralPK != null) || (this.observacionGeneralPK != null && !this.observacionGeneralPK.equals(other.observacionGeneralPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.ejemplotemplates.model.entities.ObservacionGeneral[ observacionGeneralPK=" + observacionGeneralPK + " ]";
    }
    
}
