package co.edu.sena.ejemplodao.modelo.dto;

import java.util.Objects;

public class TipoDocumentoDTO implements java.io.Serializable {

    private static long serialVersionUID = 43L;
    private String documento;
    private String descripcion;
    private byte estado;

    public TipoDocumentoDTO() {
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

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
        TipoDocumentoDTO that = (TipoDocumentoDTO) o;
        return Objects.equals(documento, that.documento);
    }

    @Override
    public int hashCode() {

        return Objects.hash(documento);
    }

    @Override
    public String toString() {
        return "TipoDocumentoDTO{" +
                "documento='" + documento + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                '}';
    }
}
