package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RaeEntityPK implements Serializable {
    private String codigo;
    private String competenciaCodigo;
    private String programaCodigoVersion;

    @Column(name = "codigo")
    @Id
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaeEntityPK that = (RaeEntityPK) o;
        return Objects.equals(codigo, that.codigo) &&
                Objects.equals(competenciaCodigo, that.competenciaCodigo) &&
                Objects.equals(programaCodigoVersion, that.programaCodigoVersion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(codigo, competenciaCodigo, programaCodigoVersion);
    }
}
