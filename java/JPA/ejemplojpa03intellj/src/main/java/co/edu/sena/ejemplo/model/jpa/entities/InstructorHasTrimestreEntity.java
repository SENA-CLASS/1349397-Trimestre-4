package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "instructor_has_trimestre", schema = "observador_de_proyectos", catalog = "")
@IdClass(InstructorHasTrimestreEntityPK.class)
public class InstructorHasTrimestreEntity {
    private String tipoDocumento;
    private String numeroDocumento;
    private String ficha;
    private String idTrimestre;
    private String jornada;
    private String tipoInstructor;
    private InstructorFichaEntity instructorFicha;
    private TrimestreEntity trimestre;
    private TipoInstructorEntity tipoInstructorByTipoInstructor;

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
    @Column(name = "ficha")
    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    @Id
    @Column(name = "id_trimestre")
    public String getIdTrimestre() {
        return idTrimestre;
    }

    public void setIdTrimestre(String idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    @Id
    @Column(name = "jornada")
    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    @Id
    @Column(name = "tipo_instructor")
    public String getTipoInstructor() {
        return tipoInstructor;
    }

    public void setTipoInstructor(String tipoInstructor) {
        this.tipoInstructor = tipoInstructor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstructorHasTrimestreEntity that = (InstructorHasTrimestreEntity) o;
        return Objects.equals(tipoDocumento, that.tipoDocumento) &&
                Objects.equals(numeroDocumento, that.numeroDocumento) &&
                Objects.equals(ficha, that.ficha) &&
                Objects.equals(idTrimestre, that.idTrimestre) &&
                Objects.equals(jornada, that.jornada) &&
                Objects.equals(tipoInstructor, that.tipoInstructor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tipoDocumento, numeroDocumento, ficha, idTrimestre, jornada, tipoInstructor);
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "tipo_documento", referencedColumnName = "tipo_documento", nullable = false), @JoinColumn(name = "numero_documento", referencedColumnName = "numero_documento", nullable = false), @JoinColumn(name = "ficha", referencedColumnName = "ficha", nullable = false)})
    public InstructorFichaEntity getInstructorFicha() {
        return instructorFicha;
    }

    public void setInstructorFicha(InstructorFichaEntity instructorFicha) {
        this.instructorFicha = instructorFicha;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "id_trimestre", referencedColumnName = "id_trimestre", nullable = false), @JoinColumn(name = "jornada", referencedColumnName = "jornada_nombre", nullable = false)})
    public TrimestreEntity getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(TrimestreEntity trimestre) {
        this.trimestre = trimestre;
    }

    @ManyToOne
    @JoinColumn(name = "tipo_instructor", referencedColumnName = "modalidad", nullable = false)
    public TipoInstructorEntity getTipoInstructorByTipoInstructor() {
        return tipoInstructorByTipoInstructor;
    }

    public void setTipoInstructorByTipoInstructor(TipoInstructorEntity tipoInstructorByTipoInstructor) {
        this.tipoInstructorByTipoInstructor = tipoInstructorByTipoInstructor;
    }
}
