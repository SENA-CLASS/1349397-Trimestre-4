package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "log_auditoria", schema = "observador_de_proyectos", catalog = "")
public class LogAuditoriaEntity {
    private long idLog;
    private String level;
    private String logName;
    private String mensage;
    private Timestamp fecha;
    private String usuario;

    @Id
    @Column(name = "id_log")
    public long getIdLog() {
        return idLog;
    }

    public void setIdLog(long idLog) {
        this.idLog = idLog;
    }

    @Basic
    @Column(name = "level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Basic
    @Column(name = "log_name")
    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    @Basic
    @Column(name = "mensage")
    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }

    @Basic
    @Column(name = "fecha")
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "usuario")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogAuditoriaEntity that = (LogAuditoriaEntity) o;
        return idLog == that.idLog &&
                Objects.equals(level, that.level) &&
                Objects.equals(logName, that.logName) &&
                Objects.equals(mensage, that.mensage) &&
                Objects.equals(fecha, that.fecha) &&
                Objects.equals(usuario, that.usuario);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idLog, level, logName, mensage, fecha, usuario);
    }
}
