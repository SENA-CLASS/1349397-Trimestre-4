package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ficha_has_lista", schema = "observador_de_proyectos", catalog = "")
public class FichaHasListaEntity {
    private String ficha;
    private String listaChequeo;
    private FichaEntity fichaByFicha;
    private ListaChequeoEntity listaChequeoByListaChequeo;

    @Id
    @Column(name = "ficha")
    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    @Basic
    @Column(name = "lista_chequeo")
    public String getListaChequeo() {
        return listaChequeo;
    }

    public void setListaChequeo(String listaChequeo) {
        this.listaChequeo = listaChequeo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FichaHasListaEntity that = (FichaHasListaEntity) o;
        return Objects.equals(ficha, that.ficha) &&
                Objects.equals(listaChequeo, that.listaChequeo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ficha, listaChequeo);
    }

    @OneToOne
    @JoinColumn(name = "ficha", referencedColumnName = "numero_ficha", nullable = false)
    public FichaEntity getFichaByFicha() {
        return fichaByFicha;
    }

    public void setFichaByFicha(FichaEntity fichaByFicha) {
        this.fichaByFicha = fichaByFicha;
    }

    @ManyToOne
    @JoinColumn(name = "lista_chequeo", referencedColumnName = "id_lista", nullable = false)
    public ListaChequeoEntity getListaChequeoByListaChequeo() {
        return listaChequeoByListaChequeo;
    }

    public void setListaChequeoByListaChequeo(ListaChequeoEntity listaChequeoByListaChequeo) {
        this.listaChequeoByListaChequeo = listaChequeoByListaChequeo;
    }
}
