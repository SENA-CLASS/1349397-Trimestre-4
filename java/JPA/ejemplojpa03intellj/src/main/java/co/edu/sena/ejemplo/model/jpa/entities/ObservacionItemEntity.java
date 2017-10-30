package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "observacion_item", schema = "observador_de_proyectos", catalog = "")
@IdClass(ObservacionItemEntityPK.class)
public class ObservacionItemEntity {
    private int idObservacion;
    private String numeroFicha;
    private int grupoCodigo;
    private String listaChequeo;
    private int idItem;
    private String observacion;
    private String jurados;
    private Timestamp fecha;
    private String usuario;
    private RespuestaGrupoEntity respuestaGrupo;

    @Id
    @Column(name = "id_observacion")
    public int getIdObservacion() {
        return idObservacion;
    }

    public void setIdObservacion(int idObservacion) {
        this.idObservacion = idObservacion;
    }

    @Id
    @Column(name = "numero_ficha")
    public String getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
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
    @Column(name = "lista_chequeo")
    public String getListaChequeo() {
        return listaChequeo;
    }

    public void setListaChequeo(String listaChequeo) {
        this.listaChequeo = listaChequeo;
    }

    @Id
    @Column(name = "id_item")
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
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
    @Column(name = "jurados")
    public String getJurados() {
        return jurados;
    }

    public void setJurados(String jurados) {
        this.jurados = jurados;
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
        ObservacionItemEntity that = (ObservacionItemEntity) o;
        return idObservacion == that.idObservacion &&
                grupoCodigo == that.grupoCodigo &&
                idItem == that.idItem &&
                Objects.equals(numeroFicha, that.numeroFicha) &&
                Objects.equals(listaChequeo, that.listaChequeo) &&
                Objects.equals(observacion, that.observacion) &&
                Objects.equals(jurados, that.jurados) &&
                Objects.equals(fecha, that.fecha) &&
                Objects.equals(usuario, that.usuario);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idObservacion, numeroFicha, grupoCodigo, listaChequeo, idItem, observacion, jurados, fecha, usuario);
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "numero_ficha", referencedColumnName = "ficha", nullable = false), @JoinColumn(name = "grupo_codigo", referencedColumnName = "grupo_codigo", nullable = false), @JoinColumn(name = "lista_chequeo", referencedColumnName = "lista_chequeo", nullable = false), @JoinColumn(name = "id_item", referencedColumnName = "id_item", nullable = false)})
    public RespuestaGrupoEntity getRespuestaGrupo() {
        return respuestaGrupo;
    }

    public void setRespuestaGrupo(RespuestaGrupoEntity respuestaGrupo) {
        this.respuestaGrupo = respuestaGrupo;
    }
}
