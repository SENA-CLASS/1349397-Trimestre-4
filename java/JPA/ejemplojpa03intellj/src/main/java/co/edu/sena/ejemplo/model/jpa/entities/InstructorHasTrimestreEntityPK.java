package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class InstructorHasTrimestreEntityPK implements Serializable {
    private String tipoDocumento;
    private String numeroDocumento;
    private String ficha;
    private String idTrimestre;
    private String jornada;
    private String tipoInstructor;

    @Column(name = "tipo_documento")
    @Id
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Column(name = "numero_documento")
    @Id
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Column(name = "ficha")
    @Id
    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    @Column(name = "id_trimestre")
    @Id
    public String getIdTrimestre() {
        return idTrimestre;
    }

    public void setIdTrimestre(String idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    @Column(name = "jornada")
    @Id
    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    @Column(name = "tipo_instructor")
    @Id
    public String getTipoInstructor() {
        return tipoInstructor;
    }

    public void setTipoInstructor(String tipoInstructor) {
        this.tipoInstructor = tipoInstructor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstructorHasTrimestreEntityPK that = (InstructorHasTrimestreEntityPK) o;
        return Objects.equals(tipoDocumento, that.tipoDocumento) &&
                Objects.equals(numeroDocumento, that.numeroDocumento) &&
                Objects.equals(ficha, that.ficha) &&
                Objects.equals(idTrimestre, that.idTrimestre) &&
                Objects.equals(jornada, that.jornada) &&
                Objects.equals(tipoInstructor, that.tipoInstructor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tipoDocumento, numeroDocumento, ficha, idTrimestre, jornada, tipoInstructor);
    }
}
