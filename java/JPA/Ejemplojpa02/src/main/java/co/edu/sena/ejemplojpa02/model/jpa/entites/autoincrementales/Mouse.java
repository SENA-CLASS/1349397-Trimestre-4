package co.edu.sena.ejemplojpa02.model.jpa.entites.autoincrementales;

import javax.persistence.*;

@Entity
@Table(name= "mouse")
public class Mouse implements java.io.Serializable {

    private final static long serialVersionUID = 34L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMouse")
    private int idMouse;
    private String marca;

    public int getIdMouse() {
        return idMouse;
    }

    public void setIdMouse(int idMouse) {
        this.idMouse = idMouse;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
