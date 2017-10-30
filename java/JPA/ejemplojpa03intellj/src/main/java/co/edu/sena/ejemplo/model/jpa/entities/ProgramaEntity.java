package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "programa", schema = "observador_de_proyectos", catalog = "")
public class ProgramaEntity {
    private String codigoVersion;
    private String estado;
    private String nombre;
    private Collection<CompetenciaEntity> competenciasByCodigoVersion;
    private Collection<FichaEntity> fichasByCodigoVersion;
    private Collection<ListaChequeoEntity> listaChequeosByCodigoVersion;

    @Id
    @Column(name = "codigo_version")
    public String getCodigoVersion() {
        return codigoVersion;
    }

    public void setCodigoVersion(String codigoVersion) {
        this.codigoVersion = codigoVersion;
    }

    @Basic
    @Column(name = "estado")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgramaEntity that = (ProgramaEntity) o;
        return Objects.equals(codigoVersion, that.codigoVersion) &&
                Objects.equals(estado, that.estado) &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(codigoVersion, estado, nombre);
    }

    @OneToMany(mappedBy = "programaByProgramaCodigoVersion")
    public Collection<CompetenciaEntity> getCompetenciasByCodigoVersion() {
        return competenciasByCodigoVersion;
    }

    public void setCompetenciasByCodigoVersion(Collection<CompetenciaEntity> competenciasByCodigoVersion) {
        this.competenciasByCodigoVersion = competenciasByCodigoVersion;
    }

    @OneToMany(mappedBy = "programaByProgramaCodigoVersion")
    public Collection<FichaEntity> getFichasByCodigoVersion() {
        return fichasByCodigoVersion;
    }

    public void setFichasByCodigoVersion(Collection<FichaEntity> fichasByCodigoVersion) {
        this.fichasByCodigoVersion = fichasByCodigoVersion;
    }

    @OneToMany(mappedBy = "programaByProgramaCodigoVersion")
    public Collection<ListaChequeoEntity> getListaChequeosByCodigoVersion() {
        return listaChequeosByCodigoVersion;
    }

    public void setListaChequeosByCodigoVersion(Collection<ListaChequeoEntity> listaChequeosByCodigoVersion) {
        this.listaChequeosByCodigoVersion = listaChequeosByCodigoVersion;
    }
}
