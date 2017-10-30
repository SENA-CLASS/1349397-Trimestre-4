package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "lista_chequeo", schema = "observador_de_proyectos", catalog = "")
public class ListaChequeoEntity {
    private String idLista;
    private byte estado;
    private String programaCodigoVersion;
    private Collection<FichaHasListaEntity> fichaHasListasByIdLista;
    private Collection<ItemCheckerEntity> itemCheckersByIdLista;
    private ProgramaEntity programaByProgramaCodigoVersion;

    @Id
    @Column(name = "id_lista")
    public String getIdLista() {
        return idLista;
    }

    public void setIdLista(String idLista) {
        this.idLista = idLista;
    }

    @Basic
    @Column(name = "estado")
    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
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
        ListaChequeoEntity that = (ListaChequeoEntity) o;
        return estado == that.estado &&
                Objects.equals(idLista, that.idLista) &&
                Objects.equals(programaCodigoVersion, that.programaCodigoVersion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idLista, estado, programaCodigoVersion);
    }

    @OneToMany(mappedBy = "listaChequeoByListaChequeo")
    public Collection<FichaHasListaEntity> getFichaHasListasByIdLista() {
        return fichaHasListasByIdLista;
    }

    public void setFichaHasListasByIdLista(Collection<FichaHasListaEntity> fichaHasListasByIdLista) {
        this.fichaHasListasByIdLista = fichaHasListasByIdLista;
    }

    @OneToMany(mappedBy = "listaChequeoByListaChequeo")
    public Collection<ItemCheckerEntity> getItemCheckersByIdLista() {
        return itemCheckersByIdLista;
    }

    public void setItemCheckersByIdLista(Collection<ItemCheckerEntity> itemCheckersByIdLista) {
        this.itemCheckersByIdLista = itemCheckersByIdLista;
    }

    @ManyToOne
    @JoinColumn(name = "programa_codigo_version", referencedColumnName = "codigo_version", nullable = false)
    public ProgramaEntity getProgramaByProgramaCodigoVersion() {
        return programaByProgramaCodigoVersion;
    }

    public void setProgramaByProgramaCodigoVersion(ProgramaEntity programaByProgramaCodigoVersion) {
        this.programaByProgramaCodigoVersion = programaByProgramaCodigoVersion;
    }
}
