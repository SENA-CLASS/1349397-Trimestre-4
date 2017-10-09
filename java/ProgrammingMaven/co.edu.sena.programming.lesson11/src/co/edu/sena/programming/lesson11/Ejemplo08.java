package co.edu.sena.programming.lesson11;

import java.io.IOException;
import java.nio.file.*;

public class Ejemplo08 {
    public static void main(String[] args) {
        Path ruta4 = Paths.get("D://Temp//foo//bar//example//hola.txt");
        Path ruta5 = Paths.get("D://Temp//foo//bar//hola.txt");
        Path ruta6 = Paths.get("D://Temp//foo//hola.txt");

        try {


                Files.copy(ruta4, ruta5, StandardCopyOption.REPLACE_EXISTING, LinkOption.NOFOLLOW_LINKS);
                Files.move(ruta4, ruta6, StandardCopyOption.REPLACE_EXISTING, LinkOption.NOFOLLOW_LINKS);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
