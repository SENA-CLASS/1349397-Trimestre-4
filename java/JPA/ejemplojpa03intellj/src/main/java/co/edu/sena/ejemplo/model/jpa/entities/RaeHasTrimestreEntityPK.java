package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RaeHasTrimestreEntityPK implements Serializable {
    private String raeCodigo;
    private String competenciaCodigo;
    private String programaCodigoVersion;
    private String idTrimestre;
    private String jornada;

    @Column(name = "rae_codigo")
    @Id
    public String getRaeCodigo() {
        return raeCodigo;
    }

    public void setRaeCodigo(String raeCodigo) {
        this.raeCodigo = raeCodigo;
    }

    @Column(name = "competencia_codigo")
    @Id
    public String getCompetenciaCodigo() {
        return competenciaCodigo;
    }

    public void setCompetenciaCodigo(String competenciaCodigo) {
        this.competenciaCodigo = competenciaCodigo;
    }

    @Column(name = "programa_codigo_version")
    @Id
    public String getProgramaCodigoVersion() {
        return programaCodigoVersion;
    }

    public void setProgramaCodigoVersion(String programaCodigoVersion) {
        this.programaCodigoVersion = programaCodigoVersion;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaeHasTrimestreEntityPK that = (RaeHasTrimestreEntityPK) o;
        return Objects.equals(raeCodigo, that.raeCodigo) &&
                Objects.equals(competenciaCodigo, that.competenciaCodigo) &&
                Objects.equals(programaCodigoVersion, that.programaCodigoVersion) &&
                Objects.equals(idTrimestre, that.idTrimestre) &&
                Objects.equals(jornada, that.jornada);
    }

    @Override
    public int hashCode() {

        return Objects.hash(raeCodigo, competenciaCodigo, programaCodigoVersion, idTrimestre, jornada);
    }
}
