package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "item_checker", schema = "observador_de_proyectos", catalog = "")
@IdClass(ItemCheckerEntityPK.class)
public class ItemCheckerEntity {
    private String listaChequeo;
    private int idItem;
    private String pregunta;
    private String raeCodigo;
    private String competenciaCodigo;
    private String programaCodigoVersion;
    private ListaChequeoEntity listaChequeoByListaChequeo;
    private RaeEntity rae;
    private Collection<RespuestaGrupoEntity> respuestaGrupos;

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
    @Column(name = "pregunta")
    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @Basic
    @Column(name = "rae_codigo")
    public String getRaeCodigo() {
        return raeCodigo;
    }

    public void setRaeCodigo(String raeCodigo) {
        this.raeCodigo = raeCodigo;
    }

    @Basic
    @Column(name = "competencia_codigo")
    public String getCompetenciaCodigo() {
        return competenciaCodigo;
    }

    public void setCompetenciaCodigo(String competenciaCodigo) {
        this.competenciaCodigo = competenciaCodigo;
    }

    @Basic
    @Column(name = "programa_codigo_version")
    public String getProgramaCodigoVersion() {
        return programaCodigoVersion;
    }

    public void setProgramaCodigoVersion(String programaCodigoVersion) {
        this.programaCodigoVersion = programaCodigoVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCheckerEntity that = (ItemCheckerEntity) o;
        return idItem == that.idItem &&
                Objects.equals(listaChequeo, that.listaChequeo) &&
                Objects.equals(pregunta, that.pregunta) &&
                Objects.equals(raeCodigo, that.raeCodigo) &&
                Objects.equals(competenciaCodigo, that.competenciaCodigo) &&
                Objects.equals(programaCodigoVersion, that.programaCodigoVersion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(listaChequeo, idItem, pregunta, raeCodigo, competenciaCodigo, programaCodigoVersion);
    }

    @ManyToOne
    @JoinColumn(name = "lista_chequeo", referencedColumnName = "id_lista", nullable = false)
    public ListaChequeoEntity getListaChequeoByListaChequeo() {
        return listaChequeoByListaChequeo;
    }

    public void setListaChequeoByListaChequeo(ListaChequeoEntity listaChequeoByListaChequeo) {
        this.listaChequeoByListaChequeo = listaChequeoByListaChequeo;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "rae_codigo", referencedColumnName = "codigo", nullable = false), @JoinColumn(name = "competencia_codigo", referencedColumnName = "competencia_codigo", nullable = false), @JoinColumn(name = "programa_codigo_version", referencedColumnName = "programa_codigo_version", nullable = false)})
    public RaeEntity getRae() {
        return rae;
    }

    public void setRae(RaeEntity rae) {
        this.rae = rae;
    }

    @OneToMany(mappedBy = "itemChecker")
    public Collection<RespuestaGrupoEntity> getRespuestaGrupos() {
        return respuestaGrupos;
    }

    public void setRespuestaGrupos(Collection<RespuestaGrupoEntity> respuestaGrupos) {
        this.respuestaGrupos = respuestaGrupos;
    }
}
