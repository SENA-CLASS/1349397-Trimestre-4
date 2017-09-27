package co.edu.sena.lesson07.colecciones.clasesAyuda;

import java.util.Comparator;
import java.util.Objects;

public class Perro implements Comparable<Perro>, Comparator<Perro>{
    private String nombre;
    private String raza;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public int compare(Perro o1, Perro o2) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perro perro = (Perro) o;
        return Objects.equals(nombre, perro.nombre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Perro{" +
                "nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                '}';
    }


    @Override
    public int compareTo(Perro o) {
        if(this.getNombre().compareTo(o.getNombre())==0){
            return 0;
        }else if(this.getNombre().compareTo(o.getNombre())>=1){
            return 1;
        }else{
            return -1;
        }
    }
}
