package co.edu.sena.ejemplojpa02.model.jpa.entites.llavecompuesta;

import javax.persistence.*;

@Entity
@Table(name = "cliente2")
@IdClass(ClientePk.class)
public class Cliente2 implements java.io.Serializable{

    private final static long serialVersionUID = 34L;

    @Id
    @Column(name = "tipo_documento",length = 10)
    private String tipoDocumento;

    @Id
    @Column(name = "numero_documento", length = 40)
    private String numeroDocumento;

    @Column(name = "nombres")
    private String nombres;

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
}
