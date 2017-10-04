package co.edu.sena.lesson07;

public class Ejemplo03 {
    public static void main(String[] args) {
        Perro<Boy> p1 = new Perro<>();
        p1.setDuenio(new Boy());

        Perro<Girl> p2 = new Perro<>();
        p2.setDuenio(new Girl());

    }
}
