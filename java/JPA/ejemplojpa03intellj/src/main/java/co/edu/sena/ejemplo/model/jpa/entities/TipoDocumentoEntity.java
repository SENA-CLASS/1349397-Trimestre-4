package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tipo_documento", schema = "observador_de_proyectos", catalog = "")
public class TipoDocumentoEntity {
    private String documento;
    private String descripcion;
    private byte estado;
    private Collection<ClienteEntity> clientesByDocumento;

    @Id
    @Column(name = "documento")
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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
        TipoDocumentoEntity that = (TipoDocumentoEntity) o;
        return estado == that.estado &&
                Objects.equals(documento, that.documento) &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(documento, descripcion, estado);
    }

    @OneToMany(mappedBy = "tipoDocumentoByTipoDocumento")
    public Collection<ClienteEntity> getClientesByDocumento() {
        return clientesByDocumento;
    }

    public void setClientesByDocumento(Collection<ClienteEntity> clientesByDocumento) {
        this.clientesByDocumento = clientesByDocumento;
    }
}
