package co.edu.sena.programming.lesson10.serializable.ejemplo01;

import java.io.*;

public class Ejemplo {
    public static void main(String[] args) {

        // Read the Portfolio back in
        try (FileInputStream fis = new FileInputStream("miPortafolio.txt");
             ObjectInputStream in = new ObjectInputStream(fis)) {
            Portfolio newP = (Portfolio)in.readObject();
            System.out.println ("Success: read Portfolio back in:\n" + newP);
        } catch (ClassNotFoundException | IOException i) {
            System.out.println("Exception reading in Portfolio: " + i);
        }
    }
}
