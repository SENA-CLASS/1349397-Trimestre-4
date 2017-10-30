package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "instructor_ficha", schema = "observador_de_proyectos", catalog = "")
@IdClass(InstructorFichaEntityPK.class)
public class InstructorFichaEntity {
    private String tipoDocumento;
    private String numeroDocumento;
    private String ficha;
    private ClienteEntity cliente;
    private FichaEntity fichaByFicha;
    private Collection<InstructorHasTrimestreEntity> instructorHasTrimestres;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstructorFichaEntity that = (InstructorFichaEntity) o;
        return Objects.equals(tipoDocumento, that.tipoDocumento) &&
                Objects.equals(numeroDocumento, that.numeroDocumento) &&
                Objects.equals(ficha, that.ficha);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tipoDocumento, numeroDocumento, ficha);
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
    @JoinColumn(name = "ficha", referencedColumnName = "numero_ficha", nullable = false)
    public FichaEntity getFichaByFicha() {
        return fichaByFicha;
    }

    public void setFichaByFicha(FichaEntity fichaByFicha) {
        this.fichaByFicha = fichaByFicha;
    }

    @OneToMany(mappedBy = "instructorFicha")
    public Collection<InstructorHasTrimestreEntity> getInstructorHasTrimestres() {
        return instructorHasTrimestres;
    }

    public void setInstructorHasTrimestres(Collection<InstructorHasTrimestreEntity> instructorHasTrimestres) {
        this.instructorHasTrimestres = instructorHasTrimestres;
    }
}
