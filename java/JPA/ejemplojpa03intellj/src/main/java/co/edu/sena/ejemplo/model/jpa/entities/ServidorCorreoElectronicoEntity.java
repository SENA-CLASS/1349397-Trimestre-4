package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "servidor_correo_electronico", schema = "observador_de_proyectos", catalog = "")
public class ServidorCorreoElectronicoEntity {
    private String correo;
    private String contrasenia;
    private String smtpHost;
    private int smtpPort;
    private byte smtpStartTlsEnable;
    private byte smtpAuth;
    private String asuntoRecuperacion;
    private String mensageRecuperacion;

    @Id
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

    @Basic
    @Column(name = "smtp_host")
    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    @Basic
    @Column(name = "smtp_port")
    public int getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(int smtpPort) {
        this.smtpPort = smtpPort;
    }

    @Basic
    @Column(name = "smtp_start_tls_enable")
    public byte getSmtpStartTlsEnable() {
        return smtpStartTlsEnable;
    }

    public void setSmtpStartTlsEnable(byte smtpStartTlsEnable) {
        this.smtpStartTlsEnable = smtpStartTlsEnable;
    }

    @Basic
    @Column(name = "smtp_auth")
    public byte getSmtpAuth() {
        return smtpAuth;
    }

    public void setSmtpAuth(byte smtpAuth) {
        this.smtpAuth = smtpAuth;
    }

    @Basic
    @Column(name = "asunto_recuperacion")
    public String getAsuntoRecuperacion() {
        return asuntoRecuperacion;
    }

    public void setAsuntoRecuperacion(String asuntoRecuperacion) {
        this.asuntoRecuperacion = asuntoRecuperacion;
    }

    @Basic
    @Column(name = "mensage_recuperacion")
    public String getMensageRecuperacion() {
        return mensageRecuperacion;
    }

    public void setMensageRecuperacion(String mensageRecuperacion) {
        this.mensageRecuperacion = mensageRecuperacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServidorCorreoElectronicoEntity that = (ServidorCorreoElectronicoEntity) o;
        return smtpPort == that.smtpPort &&
                smtpStartTlsEnable == that.smtpStartTlsEnable &&
                smtpAuth == that.smtpAuth &&
                Objects.equals(correo, that.correo) &&
                Objects.equals(contrasenia, that.contrasenia) &&
                Objects.equals(smtpHost, that.smtpHost) &&
                Objects.equals(asuntoRecuperacion, that.asuntoRecuperacion) &&
                Objects.equals(mensageRecuperacion, that.mensageRecuperacion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(correo, contrasenia, smtpHost, smtpPort, smtpStartTlsEnable, smtpAuth, asuntoRecuperacion, mensageRecuperacion);
    }
}
