package co.edu.sena.lesson08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Ejemplo02 {
    public static void main(String[] args) {
        Properties misPropiedades = new Properties();
        try {
            FileInputStream archivo = new FileInputStream("Ejemplo.properties");

            misPropiedades.load(archivo);

            System.out.println(misPropiedades.getProperty("user"));
            System.out.println(misPropiedades.getProperty("pass"));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }



    }
}
