package co.edu.sena.ejemplojpa02.model.jpa.entites.llavecompuesta2;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "estudiante")
public class Estudiante implements java.io.Serializable{

    private final static long serialVersionUID = 34L;

    @EmbeddedId
    private EstudiantePk estudiantePk;

    @Column(name = "nombres", length = 100)
    private String nombres;

    public EstudiantePk getEstudiantePk() {
        return estudiantePk;
    }

    public void setEstudiantePk(EstudiantePk estudiantePk) {
        this.estudiantePk = estudiantePk;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
}
