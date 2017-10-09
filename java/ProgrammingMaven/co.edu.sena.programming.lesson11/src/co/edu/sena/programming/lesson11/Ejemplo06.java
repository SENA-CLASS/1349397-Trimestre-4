package co.edu.sena.programming.lesson11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejemplo06 {
    public static void main(String[] args) {
        Path ruta1 = Paths.get("D://Temp");

        Path ruta2 = Paths.get("D://Temp//foo");
        Path ruta3 = Paths.get("D://Temp//foo//bar");
        Path ruta4 = Paths.get("D://Temp//foo//bar//example");

        try {
            if(Files.notExists(ruta1))
            Files.createDirectory(ruta1);
            if(Files.notExists(ruta2))
            Files.createDirectory(ruta2);
            if(Files.notExists(ruta3))
            Files.createDirectory(ruta3);
            if(Files.notExists(ruta4))
            Files.createDirectory(ruta4);
        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
