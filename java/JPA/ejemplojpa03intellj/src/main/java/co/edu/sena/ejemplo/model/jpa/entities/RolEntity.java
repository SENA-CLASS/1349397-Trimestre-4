package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "rol", schema = "observador_de_proyectos", catalog = "")
public class RolEntity {
    private String idRol;
    private String descripcion;
    private byte estado;
    private Collection<ClienteHasRolEntity> clienteHasRolsByIdRol;

    @Id
    @Column(name = "id_rol")
    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    @Basic
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "estado")
    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolEntity rolEntity = (RolEntity) o;
        return estado == rolEntity.estado &&
                Objects.equals(idRol, rolEntity.idRol) &&
                Objects.equals(descripcion, rolEntity.descripcion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idRol, descripcion, estado);
    }

    @OneToMany(mappedBy = "rolByRol")
    public Collection<ClienteHasRolEntity> getClienteHasRolsByIdRol() {
        return clienteHasRolsByIdRol;
    }

    public void setClienteHasRolsByIdRol(Collection<ClienteHasRolEntity> clienteHasRolsByIdRol) {
        this.clienteHasRolsByIdRol = clienteHasRolsByIdRol;
    }
}
