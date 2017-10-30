package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "trimestre", schema = "observador_de_proyectos", catalog = "")
@IdClass(TrimestreEntityPK.class)
public class TrimestreEntity {
    private String idTrimestre;
    private String jornadaNombre;
    private Collection<InstructorHasTrimestreEntity> instructorHasTrimestres;
    private Collection<RaeHasTrimestreEntity> raeHasTrimestres;
    private JornadaEntity jornadaByJornadaNombre;

    @Id
    @Column(name = "id_trimestre")
    public String getIdTrimestre() {
        return idTrimestre;
    }

    public void setIdTrimestre(String idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    @Id
    @Column(name = "jornada_nombre")
    public String getJornadaNombre() {
        return jornadaNombre;
    }

    public void setJornadaNombre(String jornadaNombre) {
        this.jornadaNombre = jornadaNombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrimestreEntity that = (TrimestreEntity) o;
        return Objects.equals(idTrimestre, that.idTrimestre) &&
                Objects.equals(jornadaNombre, that.jornadaNombre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTrimestre, jornadaNombre);
    }

    @OneToMany(mappedBy = "trimestre")
    public Collection<InstructorHasTrimestreEntity> getInstructorHasTrimestres() {
        return instructorHasTrimestres;
    }

    public void setInstructorHasTrimestres(Collection<InstructorHasTrimestreEntity> instructorHasTrimestres) {
        this.instructorHasTrimestres = instructorHasTrimestres;
    }

    @OneToMany(mappedBy = "trimestre")
    public Collection<RaeHasTrimestreEntity> getRaeHasTrimestres() {
        return raeHasTrimestres;
    }

    public void setRaeHasTrimestres(Collection<RaeHasTrimestreEntity> raeHasTrimestres) {
        this.raeHasTrimestres = raeHasTrimestres;
    }

    @ManyToOne
    @JoinColumn(name = "jornada_nombre", referencedColumnName = "nombre", nullable = false)
    public JornadaEntity getJornadaByJornadaNombre() {
        return jornadaByJornadaNombre;
    }

    public void setJornadaByJornadaNombre(JornadaEntity jornadaByJornadaNombre) {
        this.jornadaByJornadaNombre = jornadaByJornadaNombre;
    }
}
