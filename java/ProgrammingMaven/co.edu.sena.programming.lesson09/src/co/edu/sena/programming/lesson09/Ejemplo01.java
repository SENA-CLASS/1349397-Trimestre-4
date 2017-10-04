package co.edu.sena.programming.lesson09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ejemplo01 {

    public static void main(String[] args) {
    //try catch normal
        try {
            crearArchivo();
            double a = 1 / 0;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ArithmeticException e){
            System.out.println(e.getMessage());

        }
    // try-whit-resources
        try(FileInputStream archiv0 = new FileInputStream("nuevoArchivo.txt");){
            System.out.println(archiv0.available());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("hola mundo");

        List<String> asd= new ArrayList<>();

        String a = new String("");
        System.out.println(a.length());












    }

    public static void crearArchivo() throws FileNotFoundException, ArithmeticException {
        FileOutputStream archivo = new FileOutputStream("nuevoArchivo.txt");

    }


}
