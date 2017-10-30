package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "jornada", schema = "observador_de_proyectos", catalog = "")
public class JornadaEntity {
    private String nombre;
    private byte estado;
    private String descripcion;
    private Collection<FichaEntity> fichasByNombre;
    private Collection<TrimestreEntity> trimestresByNombre;

    @Id
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JornadaEntity that = (JornadaEntity) o;
        return estado == that.estado &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nombre, estado, descripcion);
    }

    @OneToMany(mappedBy = "jornadaByJornadaNombre")
    public Collection<FichaEntity> getFichasByNombre() {
        return fichasByNombre;
    }

    public void setFichasByNombre(Collection<FichaEntity> fichasByNombre) {
        this.fichasByNombre = fichasByNombre;
    }

    @OneToMany(mappedBy = "jornadaByJornadaNombre")
    public Collection<TrimestreEntity> getTrimestresByNombre() {
        return trimestresByNombre;
    }

    public void setTrimestresByNombre(Collection<TrimestreEntity> trimestresByNombre) {
        this.trimestresByNombre = trimestresByNombre;
    }
}
