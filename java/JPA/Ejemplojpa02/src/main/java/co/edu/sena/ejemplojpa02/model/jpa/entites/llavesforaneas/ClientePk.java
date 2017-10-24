package co.edu.sena.ejemplojpa02.model.jpa.entites.llavesforaneas;

import com.sun.istack.internal.NotNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ClientePk implements java.io.Serializable{

    private final static long serialVersionUID = 34L;

    @Column(name = "tipo_documento",length = 50)
    @NotNull
    private String tipoDocumento;

    @Column(name = "numero_documento", length = 50)
    @NotNull
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientePk clientePk = (ClientePk) o;
        return Objects.equals(tipoDocumento, clientePk.tipoDocumento) &&
                Objects.equals(numeroDocumento, clientePk.numeroDocumento);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tipoDocumento, numeroDocumento);
    }
}
