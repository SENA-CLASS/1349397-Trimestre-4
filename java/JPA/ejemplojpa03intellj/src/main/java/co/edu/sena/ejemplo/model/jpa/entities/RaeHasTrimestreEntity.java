package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rae_has_trimestre", schema = "observador_de_proyectos", catalog = "")
@IdClass(RaeHasTrimestreEntityPK.class)
public class RaeHasTrimestreEntity {
    private String raeCodigo;
    private String competenciaCodigo;
    private String programaCodigoVersion;
    private String idTrimestre;
    private String jornada;
    private RaeEntity rae;
    private TrimestreEntity trimestre;

    @Id
    @Column(name = "rae_codigo")
    public String getRaeCodigo() {
        return raeCodigo;
    }

    public void setRaeCodigo(String raeCodigo) {
        this.raeCodigo = raeCodigo;
    }

    @Id
    @Column(name = "competencia_codigo")
    public String getCompetenciaCodigo() {
        return competenciaCodigo;
    }

    public void setCompetenciaCodigo(String competenciaCodigo) {
        this.competenciaCodigo = competenciaCodigo;
    }

    @Id
    @Column(name = "programa_codigo_version")
    public String getProgramaCodigoVersion() {
        return programaCodigoVersion;
    }

    public void setProgramaCodigoVersion(String programaCodigoVersion) {
        this.programaCodigoVersion = programaCodigoVersion;
    }

    @Id
    @Column(name = "id_trimestre")
    public String getIdTrimestre() {
        return idTrimestre;
    }

    public void setIdTrimestre(String idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    @Id
    @Column(name = "jornada")
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
        RaeHasTrimestreEntity that = (RaeHasTrimestreEntity) o;
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

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "rae_codigo", referencedColumnName = "codigo", nullable = false), @JoinColumn(name = "competencia_codigo", referencedColumnName = "competencia_codigo", nullable = false), @JoinColumn(name = "programa_codigo_version", referencedColumnName = "programa_codigo_version", nullable = false)})
    public RaeEntity getRae() {
        return rae;
    }

    public void setRae(RaeEntity rae) {
        this.rae = rae;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "id_trimestre", referencedColumnName = "id_trimestre", nullable = false), @JoinColumn(name = "jornada", referencedColumnName = "jornada_nombre", nullable = false)})
    public TrimestreEntity getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(TrimestreEntity trimestre) {
        this.trimestre = trimestre;
    }
}
