package co.edu.sena.ejemplojpa02.model.jpa.entites.llavesforaneas;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tipo_documento")
public class TipoDocumento implements java.io.Serializable{

    private final static long serialVersionUID = 34L;

    @Id
    @Column(name = "documento", length = 50)
    private String documento;

    @Column(name = "descripcion", length = 200, nullable = false)
    private String descripcion;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "tipoDocumento", fetch = FetchType.LAZY)
    private Collection<Cliente> clienteCollection;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoDocumento that = (TipoDocumento) o;
        return Objects.equals(documento, that.documento);
    }

    @Override
    public int hashCode() {

        return Objects.hash(documento);
    }


}
