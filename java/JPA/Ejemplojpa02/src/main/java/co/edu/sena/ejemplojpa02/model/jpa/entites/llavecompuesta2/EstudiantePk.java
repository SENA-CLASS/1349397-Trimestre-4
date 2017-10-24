package co.edu.sena.ejemplojpa02.model.jpa.entites.llavecompuesta2;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EstudiantePk implements java.io.Serializable {
    private final static long serialVersionUID = 34L;

    @Column(name = "tipo_documento", length = 20)
    private String tipoDocumento;
    @Column(name = "numero_documento",length = 40)
    private String numeroDocumento;

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
}
