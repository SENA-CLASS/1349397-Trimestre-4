package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "rae", schema = "observador_de_proyectos", catalog = "")
@IdClass(RaeEntityPK.class)
public class RaeEntity {
    private String codigo;
    private String denominacion;
    private String competenciaCodigo;
    private String programaCodigoVersion;
    private Collection<ItemCheckerEntity> itemCheckers;
    private CompetenciaEntity competencia;
    private Collection<RaeHasTrimestreEntity> raeHasTrimestres;

    @Id
    @Column(name = "codigo")
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "denominacion")
    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaeEntity raeEntity = (RaeEntity) o;
        return Objects.equals(codigo, raeEntity.codigo) &&
                Objects.equals(denominacion, raeEntity.denominacion) &&
                Objects.equals(competenciaCodigo, raeEntity.competenciaCodigo) &&
                Objects.equals(programaCodigoVersion, raeEntity.programaCodigoVersion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(codigo, denominacion, competenciaCodigo, programaCodigoVersion);
    }

    @OneToMany(mappedBy = "rae")
    public Collection<ItemCheckerEntity> getItemCheckers() {
        return itemCheckers;
    }

    public void setItemCheckers(Collection<ItemCheckerEntity> itemCheckers) {
        this.itemCheckers = itemCheckers;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "competencia_codigo", referencedColumnName = "codigo", nullable = false), @JoinColumn(name = "programa_codigo_version", referencedColumnName = "programa_codigo_version", nullable = false)})
    public CompetenciaEntity getCompetencia() {
        return competencia;
    }

    public void setCompetencia(CompetenciaEntity competencia) {
        this.competencia = competencia;
    }

    @OneToMany(mappedBy = "rae")
    public Collection<RaeHasTrimestreEntity> getRaeHasTrimestres() {
        return raeHasTrimestres;
    }

    public void setRaeHasTrimestres(Collection<RaeHasTrimestreEntity> raeHasTrimestres) {
        this.raeHasTrimestres = raeHasTrimestres;
    }
}
