package co.edu.sena.programming.lesson10.serializable.ejemplo03;

import co.edu.sena.programming.lesson10.serializable.ejemplo02.Portfolio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ejemplo {
    public static void main(String[] args) {
        Perro p1 = new Perro();
        p1.setNombre("pilli");
        p1.setRaza("dobermang");
        p1.setSexo("machito");
        p1.setPassword("123456");
        Perro p2 = new Perro();
        p2.setNombre("misi");
        p2.setRaza("cocker");
        p2.setSexo("hembrita");

        List<Perro> lista = new ArrayList<>();
        lista.add(p1);
        lista.add(p2);


        // Write out the Portfolio
        try (FileOutputStream fos = new FileOutputStream("perro.txt");
             ObjectOutputStream out = new ObjectOutputStream(fos)) {

            out.writeObject(p1);
            System.out.println ("Successfully wrote Portfolio as an object");
        } catch (IOException i) {
            System.out.println("Exception writing out Portfolio: " + i);
        }

        // Read the Portfolio back in
        try (FileInputStream fis = new FileInputStream("perro.txt");
             ObjectInputStream in = new ObjectInputStream(fis)) {
            Perro newP = (Perro)in.readObject();
            System.out.println ("Success: read Portfolio back in:\n" + newP);
        } catch (ClassNotFoundException | IOException i) {
            System.out.println("Exception reading in Portfolio: " + i);
        }



    }
}
