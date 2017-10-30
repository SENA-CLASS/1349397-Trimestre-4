package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "aprendiz", schema = "observador_de_proyectos")
@IdClass(AprendizEntityPK.class)
public class AprendizEntity  {
    private String tipoDocumento;
    private String numeroDocumento;
    private String estado;
    private String ficha;
    private int grupoCodigo;
    private ClienteEntity cliente;
    private EstadoFormacionEntity estadoFormacionByEstado;
    private GrupoProyectoEntity grupoProyecto;

    @Id
    @Column(name = "tipo_documento")
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Id
    @Column(name = "numero_documento")
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Basic
    @Column(name = "estado")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Id
    @Column(name = "ficha")
    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    @Id
    @Column(name = "grupo_codigo")
    public int getGrupoCodigo() {
        return grupoCodigo;
    }

    public void setGrupoCodigo(int grupoCodigo) {
        this.grupoCodigo = grupoCodigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AprendizEntity that = (AprendizEntity) o;
        return grupoCodigo == that.grupoCodigo &&
                Objects.equals(tipoDocumento, that.tipoDocumento) &&
                Objects.equals(numeroDocumento, that.numeroDocumento) &&
                Objects.equals(estado, that.estado) &&
                Objects.equals(ficha, that.ficha);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tipoDocumento, numeroDocumento, estado, ficha, grupoCodigo);
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "tipo_documento", referencedColumnName = "tipo_documento", nullable = false), @JoinColumn(name = "numero_documento", referencedColumnName = "numero_documento", nullable = false)})
    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    @ManyToOne
    @JoinColumn(name = "estado", referencedColumnName = "id_estado", nullable = false)
    public EstadoFormacionEntity getEstadoFormacionByEstado() {
        return estadoFormacionByEstado;
    }

    public void setEstadoFormacionByEstado(EstadoFormacionEntity estadoFormacionByEstado) {
        this.estadoFormacionByEstado = estadoFormacionByEstado;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "ficha", referencedColumnName = "numero_ficha", nullable = false), @JoinColumn(name = "grupo_codigo", referencedColumnName = "codigo", nullable = false)})
    public GrupoProyectoEntity getGrupoProyecto() {
        return grupoProyecto;
    }

    public void setGrupoProyecto(GrupoProyectoEntity grupoProyecto) {
        this.grupoProyecto = grupoProyecto;
    }
}
