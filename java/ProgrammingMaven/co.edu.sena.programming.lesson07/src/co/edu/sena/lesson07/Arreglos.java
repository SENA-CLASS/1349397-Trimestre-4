package co.edu.sena.lesson07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Arreglos {

    public static  <T> void imprimir(T[] arreglo){
        for (T valor:arreglo
             ) {
            System.out.println(valor);
        }
    }

    public static <E> void imprimir2(Set<E> arreglo){
        for (E valor:arreglo
             ) {
            System.out.println(valor);
        }

    }
}
