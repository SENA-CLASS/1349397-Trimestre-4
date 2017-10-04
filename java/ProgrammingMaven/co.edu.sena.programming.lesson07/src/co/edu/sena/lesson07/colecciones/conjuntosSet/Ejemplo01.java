package co.edu.sena.lesson07.colecciones.conjuntosSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ejemplo01{
    public static void main(String[] args) {
        Set<String> conjunto = new TreeSet<>();

        conjunto.add("pedro");
        conjunto.add("juan");
        conjunto.add("alberto");
        conjunto.add("julian");
        conjunto.add("tejedor");

        for (String a:conjunto
             ) {
            System.out.println(a);
        }





    }
}
