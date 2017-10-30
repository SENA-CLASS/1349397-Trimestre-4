package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "cliente", schema = "observador_de_proyectos", catalog = "")
@IdClass(ClienteEntityPK.class)
public class ClienteEntity {
    private String tipoDocumento;
    private String numeroDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private byte[] foto;
    private Collection<AprendizEntity> aprendizs;
    private TipoDocumentoEntity tipoDocumentoByTipoDocumento;
    private Collection<ClienteHasRolEntity> clienteHasRols;
    private Collection<InstructorFichaEntity> instructorFichas;
    private UsuarioEntity usuario;

    @Id
    @Column(name = "tipo_documento")
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Id
    @Column(name = "numero_documento")
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Basic
    @Column(name = "primer_nombre")
    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    @Basic
    @Column(name = "segundo_nombre")
    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    @Basic
    @Column(name = "primer_apellido")
    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    @Basic
    @Column(name = "segundo_apellido")
    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    @Basic
    @Column(name = "foto")
    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteEntity that = (ClienteEntity) o;
        return Objects.equals(tipoDocumento, that.tipoDocumento) &&
                Objects.equals(numeroDocumento, that.numeroDocumento) &&
                Objects.equals(primerNombre, that.primerNombre) &&
                Objects.equals(segundoNombre, that.segundoNombre) &&
                Objects.equals(primerApellido, that.primerApellido) &&
                Objects.equals(segundoApellido, that.segundoApellido) &&
                Arrays.equals(foto, that.foto);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(tipoDocumento, numeroDocumento, primerNombre, segundoNombre, primerApellido, segundoApellido);
        result = 31 * result + Arrays.hashCode(foto);
        return result;
    }

    @OneToMany(mappedBy = "cliente")
    public Collection<AprendizEntity> getAprendizs() {
        return aprendizs;
    }

    public void setAprendizs(Collection<AprendizEntity> aprendizs) {
        this.aprendizs = aprendizs;
    }

    @ManyToOne
    @JoinColumn(name = "tipo_documento", referencedColumnName = "documento", nullable = false)
    public TipoDocumentoEntity getTipoDocumentoByTipoDocumento() {
        return tipoDocumentoByTipoDocumento;
    }

    public void setTipoDocumentoByTipoDocumento(TipoDocumentoEntity tipoDocumentoByTipoDocumento) {
        this.tipoDocumentoByTipoDocumento = tipoDocumentoByTipoDocumento;
    }

    @OneToMany(mappedBy = "cliente")
    public Collection<ClienteHasRolEntity> getClienteHasRols() {
        return clienteHasRols;
    }

    public void setClienteHasRols(Collection<ClienteHasRolEntity> clienteHasRols) {
        this.clienteHasRols = clienteHasRols;
    }

    @OneToMany(mappedBy = "cliente")
    public Collection<InstructorFichaEntity> getInstructorFichas() {
        return instructorFichas;
    }

    public void setInstructorFichas(Collection<InstructorFichaEntity> instructorFichas) {
        this.instructorFichas = instructorFichas;
    }

    @OneToOne(mappedBy = "cliente")
    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
}
