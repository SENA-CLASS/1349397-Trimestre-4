package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ClienteHasRolEntityPK implements Serializable {
    private String tipoDocumento;
    private String numeroDocumento;
    private String rol;

    @Column(name = "tipo_documento")
    @Id
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Column(name = "numero_documento")
    @Id
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Column(name = "rol")
    @Id
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteHasRolEntityPK that = (ClienteHasRolEntityPK) o;
        return Objects.equals(tipoDocumento, that.tipoDocumento) &&
                Objects.equals(numeroDocumento, that.numeroDocumento) &&
                Objects.equals(rol, that.rol);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tipoDocumento, numeroDocumento, rol);
    }
}
