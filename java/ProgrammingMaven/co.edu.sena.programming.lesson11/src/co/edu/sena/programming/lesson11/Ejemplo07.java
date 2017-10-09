package co.edu.sena.programming.lesson11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejemplo07 {
    public static void main(String[] args) {
        Path ruta4 = Paths.get("D://Temp//foo//bar//example");

        try {

            if(Files.notExists(ruta4))
                Files.createDirectories(ruta4);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            if(Files.exists(ruta4))
                Files.delete(ruta4);
            Files.deleteIfExists(ruta4);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
