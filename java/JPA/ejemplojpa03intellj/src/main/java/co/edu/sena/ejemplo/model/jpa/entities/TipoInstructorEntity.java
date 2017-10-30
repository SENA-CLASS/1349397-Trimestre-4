package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tipo_instructor", schema = "observador_de_proyectos", catalog = "")
public class TipoInstructorEntity {
    private String modalidad;
    private byte estado;
    private Collection<InstructorHasTrimestreEntity> instructorHasTrimestresByModalidad;

    @Id
    @Column(name = "modalidad")
    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
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
        TipoInstructorEntity that = (TipoInstructorEntity) o;
        return estado == that.estado &&
                Objects.equals(modalidad, that.modalidad);
    }

    @Override
    public int hashCode() {

        return Objects.hash(modalidad, estado);
    }

    @OneToMany(mappedBy = "tipoInstructorByTipoInstructor")
    public Collection<InstructorHasTrimestreEntity> getInstructorHasTrimestresByModalidad() {
        return instructorHasTrimestresByModalidad;
    }

    public void setInstructorHasTrimestresByModalidad(Collection<InstructorHasTrimestreEntity> instructorHasTrimestresByModalidad) {
        this.instructorHasTrimestresByModalidad = instructorHasTrimestresByModalidad;
    }
}
