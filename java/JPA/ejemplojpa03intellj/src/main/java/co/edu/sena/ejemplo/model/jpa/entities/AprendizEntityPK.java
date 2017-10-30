package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AprendizEntityPK implements Serializable {
    private String tipoDocumento;
    private String numeroDocumento;
    private String ficha;
    private int grupoCodigo;

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

    @Column(name = "ficha")
    @Id
    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    @Column(name = "grupo_codigo")
    @Id
    public int getGrupoCodigo() {
        return grupoCodigo;
    }

    public void setGrupoCodigo(int grupoCodigo) {
        this.grupoCodigo = grupoCodigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AprendizEntityPK that = (AprendizEntityPK) o;
        return grupoCodigo == that.grupoCodigo &&
                Objects.equals(tipoDocumento, that.tipoDocumento) &&
                Objects.equals(numeroDocumento, that.numeroDocumento) &&
                Objects.equals(ficha, that.ficha);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tipoDocumento, numeroDocumento, ficha, grupoCodigo);
    }
}
