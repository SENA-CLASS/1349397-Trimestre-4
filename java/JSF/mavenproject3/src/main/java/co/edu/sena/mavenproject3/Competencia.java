/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.mavenproject3;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "competencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competencia.findAll", query = "SELECT c FROM Competencia c")
    , @NamedQuery(name = "Competencia.findByCodigo", query = "SELECT c FROM Competencia c WHERE c.competenciaPK.codigo = :codigo")
    , @NamedQuery(name = "Competencia.findByProgramaCodigoVersion", query = "SELECT c FROM Competencia c WHERE c.competenciaPK.programaCodigoVersion = :programaCodigoVersion")})
public class Competencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CompetenciaPK competenciaPK;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "denominacion", nullable = false, length = 65535)
    private String denominacion;
    @JoinColumn(name = "programa_codigo_version", referencedColumnName = "codigo_version", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Programa programa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competencia", fetch = FetchType.LAZY)
    private Collection<Rae> raeCollection;

    public Competencia() {
    }

    public Competencia(CompetenciaPK competenciaPK) {
        this.competenciaPK = competenciaPK;
    }

    public Competencia(CompetenciaPK competenciaPK, String denominacion) {
        this.competenciaPK = competenciaPK;
        this.denominacion = denominacion;
    }

    public Competencia(String codigo, String programaCodigoVersion) {
        this.competenciaPK = new CompetenciaPK(codigo, programaCodigoVersion);
    }

    public CompetenciaPK getCompetenciaPK() {
        return competenciaPK;
    }

    public void setCompetenciaPK(CompetenciaPK competenciaPK) {
        this.competenciaPK = competenciaPK;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    @XmlTransient
    public Collection<Rae> getRaeCollection() {
        return raeCollection;
    }

    public void setRaeCollection(Collection<Rae> raeCollection) {
        this.raeCollection = raeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (competenciaPK != null ? competenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competencia)) {
            return false;
        }
        Competencia other = (Competencia) object;
        if ((this.competenciaPK == null && other.competenciaPK != null) || (this.competenciaPK != null && !this.competenciaPK.equals(other.competenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.mavenproject3.Competencia[ competenciaPK=" + competenciaPK + " ]";
    }
    
}
