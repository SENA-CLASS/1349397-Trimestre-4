package co.edu.sena.lesson07.colecciones.map;

import java.util.Objects;

public class Location implements Comparable<Location>{
    private double longitud;
    private double latitud;

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Double.compare(location.longitud, longitud) == 0 &&
                Double.compare(location.latitud, latitud) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(longitud, latitud);
    }

    @Override
    public String toString() {
        return "Location{" +
                "longitud=" + longitud +
                ", latitud=" + latitud +
                '}';
    }

    @Override
    public int compareTo(Location o) {
        int r =0;
        if(!(this.latitud == o.latitud && this.longitud == o.longitud)){
            if(this.latitud >o.latitud){
                r =1;
            }else{
                r=-1;
            }

        }
        return r;
    }
}
