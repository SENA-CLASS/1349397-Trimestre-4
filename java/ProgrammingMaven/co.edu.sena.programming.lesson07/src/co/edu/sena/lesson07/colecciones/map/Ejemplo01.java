package co.edu.sena.lesson07.colecciones.map;

import java.util.HashMap;
import java.util.Map;

public class Ejemplo01 {
    public static void main(String[] args) {
        Map<Integer, String> coleccion = new HashMap();

        coleccion.put(1, "Uno");
        coleccion.put(2, "Uno");
        coleccion.put(3, "Uno");
        coleccion.put(4, "Uno");
        coleccion.put(5, "Uno");
        coleccion.put(6, "Uno");


        for (Integer integer: coleccion.keySet()
             ) {
            System.out.println(integer);
        }

        for (String s: coleccion.values()
             ) {
            System.out.println(s);
        }
    }
}
