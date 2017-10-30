package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "respuesta_grupo", schema = "observador_de_proyectos", catalog = "")
@IdClass(RespuestaGrupoEntityPK.class)
public class RespuestaGrupoEntity {
    private String ficha;
    private int grupoCodigo;
    private String listaChequeo;
    private int idItem;
    private String valoracionValor;
    private Timestamp fecha;
    private Collection<ObservacionItemEntity> observacionItems;
    private GrupoProyectoEntity grupoProyecto;
    private ItemCheckerEntity itemChecker;
    private ValoracionEntity valoracionByValoracionValor;

    @Id
    @Column(name = "ficha")
    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    @Id
    @Column(name = "grupo_codigo")
    public int getGrupoCodigo() {
        return grupoCodigo;
    }

    public void setGrupoCodigo(int grupoCodigo) {
        this.grupoCodigo = grupoCodigo;
    }

    @Id
    @Column(name = "lista_chequeo")
    public String getListaChequeo() {
        return listaChequeo;
    }

    public void setListaChequeo(String listaChequeo) {
        this.listaChequeo = listaChequeo;
    }

    @Id
    @Column(name = "id_item")
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    @Basic
    @Column(name = "valoracion_valor")
    public String getValoracionValor() {
        return valoracionValor;
    }

    public void setValoracionValor(String valoracionValor) {
        this.valoracionValor = valoracionValor;
    }

    @Basic
    @Column(name = "fecha")
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RespuestaGrupoEntity that = (RespuestaGrupoEntity) o;
        return grupoCodigo == that.grupoCodigo &&
                idItem == that.idItem &&
                Objects.equals(ficha, that.ficha) &&
                Objects.equals(listaChequeo, that.listaChequeo) &&
                Objects.equals(valoracionValor, that.valoracionValor) &&
                Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ficha, grupoCodigo, listaChequeo, idItem, valoracionValor, fecha);
    }

    @OneToMany(mappedBy = "respuestaGrupo")
    public Collection<ObservacionItemEntity> getObservacionItems() {
        return observacionItems;
    }

    public void setObservacionItems(Collection<ObservacionItemEntity> observacionItems) {
        this.observacionItems = observacionItems;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "ficha", referencedColumnName = "numero_ficha", nullable = false), @JoinColumn(name = "grupo_codigo", referencedColumnName = "codigo", nullable = false)})
    public GrupoProyectoEntity getGrupoProyecto() {
        return grupoProyecto;
    }

    public void setGrupoProyecto(GrupoProyectoEntity grupoProyecto) {
        this.grupoProyecto = grupoProyecto;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "lista_chequeo", referencedColumnName = "lista_chequeo", nullable = false), @JoinColumn(name = "id_item", referencedColumnName = "id_item", nullable = false)})
    public ItemCheckerEntity getItemChecker() {
        return itemChecker;
    }

    public void setItemChecker(ItemCheckerEntity itemChecker) {
        this.itemChecker = itemChecker;
    }

    @ManyToOne
    @JoinColumn(name = "valoracion_valor", referencedColumnName = "valor", nullable = false)
    public ValoracionEntity getValoracionByValoracionValor() {
        return valoracionByValoracionValor;
    }

    public void setValoracionByValoracionValor(ValoracionEntity valoracionByValoracionValor) {
        this.valoracionByValoracionValor = valoracionByValoracionValor;
    }
}
