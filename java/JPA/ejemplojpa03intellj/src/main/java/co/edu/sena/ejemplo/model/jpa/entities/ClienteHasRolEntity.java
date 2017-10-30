package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "cliente_has_rol", schema = "observador_de_proyectos", catalog = "")
@IdClass(ClienteHasRolEntityPK.class)
public class ClienteHasRolEntity {
    private String tipoDocumento;
    private String numeroDocumento;
    private String rol;
    private byte estado;
    private Date fechaTerminacion;
    private ClienteEntity cliente;
    private RolEntity rolByRol;

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

    @Id
    @Column(name = "rol")
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Basic
    @Column(name = "estado")
    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "fecha_terminacion")
    public Date getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setFechaTerminacion(Date fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteHasRolEntity that = (ClienteHasRolEntity) o;
        return estado == that.estado &&
                Objects.equals(tipoDocumento, that.tipoDocumento) &&
                Objects.equals(numeroDocumento, that.numeroDocumento) &&
                Objects.equals(rol, that.rol) &&
                Objects.equals(fechaTerminacion, that.fechaTerminacion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tipoDocumento, numeroDocumento, rol, estado, fechaTerminacion);
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
    @JoinColumn(name = "rol", referencedColumnName = "id_rol", nullable = false)
    public RolEntity getRolByRol() {
        return rolByRol;
    }

    public void setRolByRol(RolEntity rolByRol) {
        this.rolByRol = rolByRol;
    }
}
