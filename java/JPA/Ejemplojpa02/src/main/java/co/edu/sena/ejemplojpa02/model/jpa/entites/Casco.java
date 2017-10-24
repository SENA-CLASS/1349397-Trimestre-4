package co.edu.sena.ejemplojpa02.model.jpa.entites;

import javax.persistence.*;

@Entity
@Table(name = "casco")
public class Casco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "marca", length = 50)
    private String marca;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
