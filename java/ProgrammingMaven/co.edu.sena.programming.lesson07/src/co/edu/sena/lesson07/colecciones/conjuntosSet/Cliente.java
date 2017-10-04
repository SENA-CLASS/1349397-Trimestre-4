package co.edu.sena.lesson07.colecciones.conjuntosSet;

import java.util.Objects;

public class Cliente implements Comparable<Cliente> {
    private String tipoDocumento;
    private String numeroDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String nuemroDocumento) {
        this.numeroDocumento = nuemroDocumento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(tipoDocumento, cliente.tipoDocumento) &&
                Objects.equals(numeroDocumento, cliente.numeroDocumento);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tipoDocumento, numeroDocumento);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "tipoDocumento='" + tipoDocumento + '\'' +
                ", nuemroDocumento='" + numeroDocumento + '\'' +
                ", primerNombre='" + primerNombre + '\'' +
                ", segundoNombre='" + segundoNombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                '}';
    }

    @Override
    public int compareTo(Cliente o) {
        int retorno = 0;
        if (this.numeroDocumento.compareTo(o.numeroDocumento)==0 && this.tipoDocumento.compareTo(o.tipoDocumento)==0)
            retorno = 0;
         else if (this.numeroDocumento.compareTo(o.numeroDocumento)==1){
                retorno =1;


        }else{
             retorno=-1;
        }

        return retorno;
    }
}

