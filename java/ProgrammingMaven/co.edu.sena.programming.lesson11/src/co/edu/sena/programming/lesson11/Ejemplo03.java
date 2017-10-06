package co.edu.sena.programming.lesson11;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ejemplo03 {
    public static void main(String[] args) {
        Path ruta = Paths.get("D:\\ejemplosNIO2");

        try{
            DirectoryStream<Path> strem = Files.newDirectoryStream(ruta);
            for (Path rutica:strem
                 ) {
                System.out.println(rutica);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        Path ruta2 = Paths.get("D:\\ejemplosNIO2\\ejemplo.txt");

        List<String> lineas= new ArrayList<>();
        Charset cs = Charset.defaultCharset();
        System.out.println(cs.displayName());
        System.out.println(cs.name());
        try {
            lineas= Files.readAllLines(ruta2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String linea:lineas
             ) {
            String[] c = linea.split(",");
            for (String campo:c
                 ) {
                System.out.println(campo);
            }
        }


    }
}
