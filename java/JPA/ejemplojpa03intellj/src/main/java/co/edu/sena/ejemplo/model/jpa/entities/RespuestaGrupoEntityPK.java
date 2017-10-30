package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RespuestaGrupoEntityPK implements Serializable {
    private String ficha;
    private int grupoCodigo;
    private String listaChequeo;
    private int idItem;

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
        RespuestaGrupoEntityPK that = (RespuestaGrupoEntityPK) o;
        return grupoCodigo == that.grupoCodigo &&
                idItem == that.idItem &&
                Objects.equals(ficha, that.ficha) &&
                Objects.equals(listaChequeo, that.listaChequeo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ficha, grupoCodigo, listaChequeo, idItem);
    }
}
