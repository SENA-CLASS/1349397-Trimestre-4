package co.edu.sena.lesson07;

public class Perro <T extends Person> {
    private T duenio;

    public T getDuenio() {
        return duenio;
    }

    public void setDuenio(T duenio) {
        this.duenio = duenio;
    }
}
