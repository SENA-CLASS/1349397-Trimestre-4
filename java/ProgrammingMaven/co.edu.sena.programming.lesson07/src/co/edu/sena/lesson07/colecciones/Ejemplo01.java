package co.edu.sena.lesson07.colecciones;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class Ejemplo01 {
    public static void main(String[] args) {

        Collection<Boolean> arreglo = new ArrayList<>();
        arreglo.add(true);
        arreglo.add(false);

        Set<String> colleccionSinRepetidos = new HashSet<>();
        colleccionSinRepetidos.add("asd");
        colleccionSinRepetidos.add("asd");
        colleccionSinRepetidos.add("asd");
        colleccionSinRepetidos.add("asd");
        colleccionSinRepetidos.add("asd");

        for (String objeto:colleccionSinRepetidos
             ) {
            System.out.println(objeto);
        }



    }
}
