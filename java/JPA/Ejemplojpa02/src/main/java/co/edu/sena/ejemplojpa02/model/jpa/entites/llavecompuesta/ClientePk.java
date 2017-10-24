package co.edu.sena.ejemplojpa02.model.jpa.entites.llavecompuesta;

public class ClientePk implements java.io.Serializable{

    private final static long serialVersionUID = 34L;

    private String tipoDocumento;
    private String numeroDocumento;

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
}
