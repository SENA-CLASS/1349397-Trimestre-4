package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "grupo_proyecto", schema = "observador_de_proyectos", catalog = "")
@IdClass(GrupoProyectoEntityPK.class)
public class GrupoProyectoEntity {
    private String numeroFicha;
    private int codigo;
    private String nombreProyecto;
    private String estadoGrupo;
    private Collection<AprendizEntity> aprendizs;
    private FichaEntity fichaByNumeroFicha;
    private Collection<ObservacionGeneralEntity> observacionGenerals;
    private Collection<RespuestaGrupoEntity> respuestaGrupos;

    @Id
    @Column(name = "numero_ficha")
    public String getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    @Id
    @Column(name = "codigo")
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "nombre_proyecto")
    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    @Basic
    @Column(name = "estado_grupo")
    public String getEstadoGrupo() {
        return estadoGrupo;
    }

    public void setEstadoGrupo(String estadoGrupo) {
        this.estadoGrupo = estadoGrupo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoProyectoEntity that = (GrupoProyectoEntity) o;
        return codigo == that.codigo &&
                Objects.equals(numeroFicha, that.numeroFicha) &&
                Objects.equals(nombreProyecto, that.nombreProyecto) &&
                Objects.equals(estadoGrupo, that.estadoGrupo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(numeroFicha, codigo, nombreProyecto, estadoGrupo);
    }

    @OneToMany(mappedBy = "grupoProyecto")
    public Collection<AprendizEntity> getAprendizs() {
        return aprendizs;
    }

    public void setAprendizs(Collection<AprendizEntity> aprendizs) {
        this.aprendizs = aprendizs;
    }

    @ManyToOne
    @JoinColumn(name = "numero_ficha", referencedColumnName = "numero_ficha", nullable = false)
    public FichaEntity getFichaByNumeroFicha() {
        return fichaByNumeroFicha;
    }

    public void setFichaByNumeroFicha(FichaEntity fichaByNumeroFicha) {
        this.fichaByNumeroFicha = fichaByNumeroFicha;
    }

    @OneToMany(mappedBy = "grupoProyecto")
    public Collection<ObservacionGeneralEntity> getObservacionGenerals() {
        return observacionGenerals;
    }

    public void setObservacionGenerals(Collection<ObservacionGeneralEntity> observacionGenerals) {
        this.observacionGenerals = observacionGenerals;
    }

    @OneToMany(mappedBy = "grupoProyecto")
    public Collection<RespuestaGrupoEntity> getRespuestaGrupos() {
        return respuestaGrupos;
    }

    public void setRespuestaGrupos(Collection<RespuestaGrupoEntity> respuestaGrupos) {
        this.respuestaGrupos = respuestaGrupos;
    }
}
