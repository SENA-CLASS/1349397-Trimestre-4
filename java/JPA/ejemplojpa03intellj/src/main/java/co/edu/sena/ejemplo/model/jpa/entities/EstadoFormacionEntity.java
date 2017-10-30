package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "estado_formacion", schema = "observador_de_proyectos", catalog = "")
public class EstadoFormacionEntity {
    private String idEstado;
    private byte estado;
    private Collection<AprendizEntity> aprendizsByIdEstado;

    @Id
    @Column(name = "id_estado")
    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
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
        EstadoFormacionEntity that = (EstadoFormacionEntity) o;
        return estado == that.estado &&
                Objects.equals(idEstado, that.idEstado);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idEstado, estado);
    }

    @OneToMany(mappedBy = "estadoFormacionByEstado")
    public Collection<AprendizEntity> getAprendizsByIdEstado() {
        return aprendizsByIdEstado;
    }

    public void setAprendizsByIdEstado(Collection<AprendizEntity> aprendizsByIdEstado) {
        this.aprendizsByIdEstado = aprendizsByIdEstado;
    }
}
