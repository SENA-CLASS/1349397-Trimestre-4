package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ficha", schema = "observador_de_proyectos", catalog = "")
public class FichaEntity {
    private String numeroFicha;
    private String programaCodigoVersion;
    private String jornadaNombre;
    private String estado;
    private ProgramaEntity programaByProgramaCodigoVersion;
    private JornadaEntity jornadaByJornadaNombre;
    private FichaHasListaEntity fichaHasListaByNumeroFicha;
    private Collection<GrupoProyectoEntity> grupoProyectosByNumeroFicha;
    private Collection<InstructorFichaEntity> instructorFichasByNumeroFicha;

    @Id
    @Column(name = "numero_ficha")
    public String getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    @Basic
    @Column(name = "programa_codigo_version")
    public String getProgramaCodigoVersion() {
        return programaCodigoVersion;
    }

    public void setProgramaCodigoVersion(String programaCodigoVersion) {
        this.programaCodigoVersion = programaCodigoVersion;
    }

    @Basic
    @Column(name = "jornada_nombre")
    public String getJornadaNombre() {
        return jornadaNombre;
    }

    public void setJornadaNombre(String jornadaNombre) {
        this.jornadaNombre = jornadaNombre;
    }

    @Basic
    @Column(name = "estado")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FichaEntity that = (FichaEntity) o;
        return Objects.equals(numeroFicha, that.numeroFicha) &&
                Objects.equals(programaCodigoVersion, that.programaCodigoVersion) &&
                Objects.equals(jornadaNombre, that.jornadaNombre) &&
                Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {

        return Objects.hash(numeroFicha, programaCodigoVersion, jornadaNombre, estado);
    }

    @ManyToOne
    @JoinColumn(name = "programa_codigo_version", referencedColumnName = "codigo_version", nullable = false)
    public ProgramaEntity getProgramaByProgramaCodigoVersion() {
        return programaByProgramaCodigoVersion;
    }

    public void setProgramaByProgramaCodigoVersion(ProgramaEntity programaByProgramaCodigoVersion) {
        this.programaByProgramaCodigoVersion = programaByProgramaCodigoVersion;
    }

    @ManyToOne
    @JoinColumn(name = "jornada_nombre", referencedColumnName = "nombre", nullable = false)
    public JornadaEntity getJornadaByJornadaNombre() {
        return jornadaByJornadaNombre;
    }

    public void setJornadaByJornadaNombre(JornadaEntity jornadaByJornadaNombre) {
        this.jornadaByJornadaNombre = jornadaByJornadaNombre;
    }

    @OneToOne(mappedBy = "fichaByFicha")
    public FichaHasListaEntity getFichaHasListaByNumeroFicha() {
        return fichaHasListaByNumeroFicha;
    }

    public void setFichaHasListaByNumeroFicha(FichaHasListaEntity fichaHasListaByNumeroFicha) {
        this.fichaHasListaByNumeroFicha = fichaHasListaByNumeroFicha;
    }

    @OneToMany(mappedBy = "fichaByNumeroFicha")
    public Collection<GrupoProyectoEntity> getGrupoProyectosByNumeroFicha() {
        return grupoProyectosByNumeroFicha;
    }

    public void setGrupoProyectosByNumeroFicha(Collection<GrupoProyectoEntity> grupoProyectosByNumeroFicha) {
        this.grupoProyectosByNumeroFicha = grupoProyectosByNumeroFicha;
    }

    @OneToMany(mappedBy = "fichaByFicha")
    public Collection<InstructorFichaEntity> getInstructorFichasByNumeroFicha() {
        return instructorFichasByNumeroFicha;
    }

    public void setInstructorFichasByNumeroFicha(Collection<InstructorFichaEntity> instructorFichasByNumeroFicha) {
        this.instructorFichasByNumeroFicha = instructorFichasByNumeroFicha;
    }
}
