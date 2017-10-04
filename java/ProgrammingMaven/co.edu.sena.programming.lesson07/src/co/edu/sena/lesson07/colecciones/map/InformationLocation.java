package co.edu.sena.lesson07.colecciones.map;

import java.util.Arrays;
import java.util.Objects;

public class InformationLocation {
    private String nombre;
    private String telefono;
    private String direccion;
    private byte[] foto;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

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
        InformationLocation that = (InformationLocation) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "InformationLocation{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", foto=" + Arrays.toString(foto) +
                '}';
    }
}
