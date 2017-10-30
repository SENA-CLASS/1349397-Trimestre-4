package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ObservacionGeneralEntityPK implements Serializable {
    private String grupoNumeroFicha;
    private int grupoCodigo;
    private int idObservacion;

    @Column(name = "grupo_numero_ficha")
    @Id
    public String getGrupoNumeroFicha() {
        return grupoNumeroFicha;
    }

    public void setGrupoNumeroFicha(String grupoNumeroFicha) {
        this.grupoNumeroFicha = grupoNumeroFicha;
    }

    @Column(name = "grupo_codigo")
    @Id
    public int getGrupoCodigo() {
        return grupoCodigo;
    }

    public void setGrupoCodigo(int grupoCodigo) {
        this.grupoCodigo = grupoCodigo;
    }

    @Column(name = "id_observacion")
    @Id
    public int getIdObservacion() {
        return idObservacion;
    }

    public void setIdObservacion(int idObservacion) {
        this.idObservacion = idObservacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObservacionGeneralEntityPK that = (ObservacionGeneralEntityPK) o;
        return grupoCodigo == that.grupoCodigo &&
                idObservacion == that.idObservacion &&
                Objects.equals(grupoNumeroFicha, that.grupoNumeroFicha);
    }

    @Override
    public int hashCode() {

        return Objects.hash(grupoNumeroFicha, grupoCodigo, idObservacion);
    }
}
