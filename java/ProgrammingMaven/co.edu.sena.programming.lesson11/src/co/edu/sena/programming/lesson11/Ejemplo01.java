package co.edu.sena.programming.lesson11;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejemplo01 {
    public static void main(String[] args) {
        // esta construyento el sistema de archivos a partir del sistema operativo
        FileSystem fs = FileSystems.getDefault();
        // sirve para construir las rutas
        Path ruta1 = fs.getPath("D:\\ejemplosNIO2\\ejemplo.txt");
        Path ruta2 = fs.getPath("D:", "ejemplosNIO2", "ejemplo.txt");
        Path ruta3 = fs.getPath("ejemplosNIO2", "ejemplo.txt");

        System.out.println(ruta1.toString());
        System.out.println(ruta2.toString());

        System.out.println(ruta1.getFileName());
        System.out.println(ruta1.getParent());
        System.out.println(ruta1.getNameCount());
        System.out.println(ruta1.getRoot());
        System.out.println(ruta1.isAbsolute());
        System.out.println(ruta1.toAbsolutePath());
        System.out.println(ruta1.toUri());

        Path ruta4 = ruta1.subpath(0, 2);
        System.out.println(ruta4);


        System.out.println(Files.exists(ruta1));
        try {
            System.out.println(Files.size(ruta1));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // crear una archivo
        Path ruta5 = fs.getPath("D:\\ejemplosNIO2\\ejemplo5.txt");
        try {
            if (Files.notExists(ruta5))
                Files.createFile(ruta5);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // crear una directorio
        Path ruta6 = fs.getPath("D:\\ejemplosNIO2\\directorioNuevo");
        try {
            Files.createDirectories(ruta6);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
