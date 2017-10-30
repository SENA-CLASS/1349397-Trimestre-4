package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "valoracion", schema = "observador_de_proyectos", catalog = "")
public class ValoracionEntity {
    private String valor;
    private byte estado;
    private Collection<RespuestaGrupoEntity> respuestaGruposByValor;

    @Id
    @Column(name = "valor")
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Basic
    @Column(name = "estado")
    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValoracionEntity that = (ValoracionEntity) o;
        return estado == that.estado &&
                Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(valor, estado);
    }

    @OneToMany(mappedBy = "valoracionByValoracionValor")
    public Collection<RespuestaGrupoEntity> getRespuestaGruposByValor() {
        return respuestaGruposByValor;
    }

    public void setRespuestaGruposByValor(Collection<RespuestaGrupoEntity> respuestaGruposByValor) {
        this.respuestaGruposByValor = respuestaGruposByValor;
    }
}
