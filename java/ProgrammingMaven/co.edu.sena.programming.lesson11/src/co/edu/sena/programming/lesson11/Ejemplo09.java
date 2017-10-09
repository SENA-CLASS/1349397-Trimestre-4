package co.edu.sena.programming.lesson11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;
import java.util.Map;

public class Ejemplo09 {
    public static void main(String[] args) {
        Path ruta4 = Paths.get("D://Temp//foo//bar//example//hola.txt");
        Path ruta5 = Paths.get("D://Temp//foo//bar//hola.txt");
        Path ruta6 = Paths.get("D://Temp//foo//hola.txt");
        DosFileAttributes atributos=null;
        try {
            atributos = Files.readAttributes(ruta6, DosFileAttributes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(ruta6);
        if(atributos!=null) {
            System.out.println(atributos.creationTime());
            System.out.println(atributos.isDirectory());
            System.out.println(atributos.isHidden());
            System.out.println(atributos.isReadOnly());
            System.out.println(atributos.isArchive());
            System.out.println(atributos.isSystem());
        }
    }
}
