package co.edu.sena.ejemplo.model.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GrupoProyectoEntityPK implements Serializable {
    private String numeroFicha;
    private int codigo;

    @Column(name = "numero_ficha")
    @Id
    public String getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    @Column(name = "codigo")
    @Id
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoProyectoEntityPK that = (GrupoProyectoEntityPK) o;
        return codigo == that.codigo &&
                Objects.equals(numeroFicha, that.numeroFicha);
    }

    @Override
    public int hashCode() {

        return Objects.hash(numeroFicha, codigo);
    }
}
