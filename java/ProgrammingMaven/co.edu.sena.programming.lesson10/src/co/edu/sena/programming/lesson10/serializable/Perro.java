package co.edu.sena.programming.lesson10.serializable;

public class Perro implements java.io.Serializable  {

    private static long serialVersionUID = 43L;

    private String raza;
    private transient String nombre;


}
