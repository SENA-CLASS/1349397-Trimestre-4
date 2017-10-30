package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ItemCheckerEntityPK implements Serializable {
    private String listaChequeo;
    private int idItem;

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
        ItemCheckerEntityPK that = (ItemCheckerEntityPK) o;
        return idItem == that.idItem &&
                Objects.equals(listaChequeo, that.listaChequeo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(listaChequeo, idItem);
    }
}
