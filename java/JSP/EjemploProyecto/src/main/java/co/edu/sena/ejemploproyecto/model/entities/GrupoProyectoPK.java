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
public class GrupoProyectoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero_ficha")
    private String numeroFicha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private int codigo;

    public GrupoProyectoPK() {
    }

    public GrupoProyectoPK(String numeroFicha, int codigo) {
        this.numeroFicha = numeroFicha;
        this.codigo = codigo;
    }

    public String getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroFicha != null ? numeroFicha.hashCode() : 0);
        hash += (int) codigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoProyectoPK)) {
            return false;
        }
        GrupoProyectoPK other = (GrupoProyectoPK) object;
        if ((this.numeroFicha == null && other.numeroFicha != null) || (this.numeroFicha != null && !this.numeroFicha.equals(other.numeroFicha))) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.ejemploproyecto.model.entities.GrupoProyectoPK[ numeroFicha=" + numeroFicha + ", codigo=" + codigo + " ]";
    }
    
}
