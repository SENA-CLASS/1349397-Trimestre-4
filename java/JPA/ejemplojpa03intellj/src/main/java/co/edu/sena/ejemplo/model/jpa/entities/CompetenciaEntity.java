package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "competencia", schema = "observador_de_proyectos", catalog = "")
@IdClass(CompetenciaEntityPK.class)
public class CompetenciaEntity {
    private String codigo;
    private String denominacion;
    private String programaCodigoVersion;
    private ProgramaEntity programaByProgramaCodigoVersion;
    private Collection<RaeEntity> raes;

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
        CompetenciaEntity that = (CompetenciaEntity) o;
        return Objects.equals(codigo, that.codigo) &&
                Objects.equals(denominacion, that.denominacion) &&
                Objects.equals(programaCodigoVersion, that.programaCodigoVersion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(codigo, denominacion, programaCodigoVersion);
    }

    @ManyToOne
    @JoinColumn(name = "programa_codigo_version", referencedColumnName = "codigo_version", nullable = false)
    public ProgramaEntity getProgramaByProgramaCodigoVersion() {
        return programaByProgramaCodigoVersion;
    }

    public void setProgramaByProgramaCodigoVersion(ProgramaEntity programaByProgramaCodigoVersion) {
        this.programaByProgramaCodigoVersion = programaByProgramaCodigoVersion;
    }

    @OneToMany(mappedBy = "competencia")
    public Collection<RaeEntity> getRaes() {
        return raes;
    }

    public void setRaes(Collection<RaeEntity> raes) {
        this.raes = raes;
    }
}
