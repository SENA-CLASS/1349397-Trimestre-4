package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ObservacionItemEntityPK implements Serializable {
    private int idObservacion;
    private String numeroFicha;
    private int grupoCodigo;
    private String listaChequeo;
    private int idItem;

    @Column(name = "id_observacion")
    @Id
    public int getIdObservacion() {
        return idObservacion;
    }

    public void setIdObservacion(int idObservacion) {
        this.idObservacion = idObservacion;
    }

    @Column(name = "numero_ficha")
    @Id
    public String getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    @Column(name = "grupo_codigo")
    @Id
    public int getGrupoCodigo() {
        return grupoCodigo;
    }

    public void setGrupoCodigo(int grupoCodigo) {
        this.grupoCodigo = grupoCodigo;
    }

    @Column(name = "lista_chequeo")
    @Id
    public String getListaChequeo() {
        return listaChequeo;
    }

    public void setListaChequeo(String listaChequeo) {
        this.listaChequeo = listaChequeo;
    }

    @Column(name = "id_item")
    @Id
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObservacionItemEntityPK that = (ObservacionItemEntityPK) o;
        return idObservacion == that.idObservacion &&
                grupoCodigo == that.grupoCodigo &&
                idItem == that.idItem &&
                Objects.equals(numeroFicha, that.numeroFicha) &&
                Objects.equals(listaChequeo, that.listaChequeo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idObservacion, numeroFicha, grupoCodigo, listaChequeo, idItem);
    }
}
