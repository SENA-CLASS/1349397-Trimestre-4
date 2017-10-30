package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "observacion_general", schema = "observador_de_proyectos", catalog = "")
@IdClass(ObservacionGeneralEntityPK.class)
public class ObservacionGeneralEntity {
    private String grupoNumeroFicha;
    private int grupoCodigo;
    private int idObservacion;
    private String observacion;
    private String jurado;
    private Timestamp fecha;
    private String usuario;
    private GrupoProyectoEntity grupoProyecto;

    @Id
    @Column(name = "grupo_numero_ficha")
    public String getGrupoNumeroFicha() {
        return grupoNumeroFicha;
    }

    public void setGrupoNumeroFicha(String grupoNumeroFicha) {
        this.grupoNumeroFicha = grupoNumeroFicha;
    }

    @Id
    @Column(name = "grupo_codigo")
    public int getGrupoCodigo() {
        return grupoCodigo;
    }

    public void setGrupoCodigo(int grupoCodigo) {
        this.grupoCodigo = grupoCodigo;
    }

    @Id
    @Column(name = "id_observacion")
    public int getIdObservacion() {
        return idObservacion;
    }

    public void setIdObservacion(int idObservacion) {
        this.idObservacion = idObservacion;
    }

    @Basic
    @Column(name = "observacion")
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Basic
    @Column(name = "jurado")
    public String getJurado() {
        return jurado;
    }

    public void setJurado(String jurado) {
        this.jurado = jurado;
    }

    @Basic
    @Column(name = "fecha")
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "usuario")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObservacionGeneralEntity that = (ObservacionGeneralEntity) o;
        return grupoCodigo == that.grupoCodigo &&
                idObservacion == that.idObservacion &&
                Objects.equals(grupoNumeroFicha, that.grupoNumeroFicha) &&
                Objects.equals(observacion, that.observacion) &&
                Objects.equals(jurado, that.jurado) &&
                Objects.equals(fecha, that.fecha) &&
                Objects.equals(usuario, that.usuario);
    }

    @Override
    public int hashCode() {

        return Objects.hash(grupoNumeroFicha, grupoCodigo, idObservacion, observacion, jurado, fecha, usuario);
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "grupo_numero_ficha", referencedColumnName = "numero_ficha", nullable = false), @JoinColumn(name = "grupo_codigo", referencedColumnName = "codigo", nullable = false)})
    public GrupoProyectoEntity getGrupoProyecto() {
        return grupoProyecto;
    }

    public void setGrupoProyecto(GrupoProyectoEntity grupoProyecto) {
        this.grupoProyecto = grupoProyecto;
    }
}
