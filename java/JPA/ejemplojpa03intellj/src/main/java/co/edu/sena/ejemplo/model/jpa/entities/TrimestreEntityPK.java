package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TrimestreEntityPK implements Serializable {
    private String idTrimestre;
    private String jornadaNombre;

    @Column(name = "id_trimestre")
    @Id
    public String getIdTrimestre() {
        return idTrimestre;
    }

    public void setIdTrimestre(String idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    @Column(name = "jornada_nombre")
    @Id
    public String getJornadaNombre() {
        return jornadaNombre;
    }

    public void setJornadaNombre(String jornadaNombre) {
        this.jornadaNombre = jornadaNombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrimestreEntityPK that = (TrimestreEntityPK) o;
        return Objects.equals(idTrimestre, that.idTrimestre) &&
                Objects.equals(jornadaNombre, that.jornadaNombre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTrimestre, jornadaNombre);
    }
}
