package co.edu.sena.ejemplojpa02.model.jpa.entites;

import javax.persistence.*;


@Entity
@Table(name = "televisor")
public class Televisor implements java.io.Serializable {

    private final static long serialVersionUID = 34L;
    @Id
    @Column(name = "serial", length = 45)
    private String serial;

    @Column(name = "marca", length = 60,nullable = false)
    private String marca;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
