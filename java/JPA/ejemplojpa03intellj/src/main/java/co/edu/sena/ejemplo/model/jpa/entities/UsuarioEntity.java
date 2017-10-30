package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usuario", schema = "observador_de_proyectos", catalog = "")
@IdClass(UsuarioEntityPK.class)
public class UsuarioEntity {
    private String tipoDocumento;
    private String numeroDocumento;
    private String correo;
    private String contrasenia;
    private ClienteEntity cliente;

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
    @Column(name = "correo")
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Basic
    @Column(name = "contrasenia")
    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return Objects.equals(tipoDocumento, that.tipoDocumento) &&
                Objects.equals(numeroDocumento, that.numeroDocumento) &&
                Objects.equals(correo, that.correo) &&
                Objects.equals(contrasenia, that.contrasenia);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tipoDocumento, numeroDocumento, correo, contrasenia);
    }

    @OneToOne
    @JoinColumns({@JoinColumn(name = "tipo_documento", referencedColumnName = "tipo_documento", nullable = false), @JoinColumn(name = "numero_documento", referencedColumnName = "numero_documento", nullable = false)})
    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
}
