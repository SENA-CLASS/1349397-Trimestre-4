package co.edu.sena.programming.lesson10.serializable.ejemplo03;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Perro implements java.io.Serializable {

    private static long serialVersionUID = 43L;
    private String nombre;
    private String sexo;
    private  String raza;
    private  transient String password;

    private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {


        try{
            is.defaultReadObject();
            Integer leido = is.readInt();
            this.password = leido.toString();
        } catch (Exception e) { e.printStackTrace(); }

    }

    private void writeObject(ObjectOutputStream os) throws IOException, ClassNotFoundException {
        try{
            os.defaultWriteObject();
            os.writeInt(Integer.parseInt(this.password+123));
        }catch (Exception e) { e.printStackTrace(); }


    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "nombre='" + nombre + '\'' +
                ", sexo='" + sexo + '\'' +
                ", raza='" + raza + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
