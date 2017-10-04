package co.edu.sena.lesson07.colecciones.clasesAyuda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ejemplo01 {
    public static void main(String[] args) {
        Perro p1 = new Perro();
        p1.setNombre("rintintin");
        Perro p2 = new Perro();
        p2.setNombre("misi");
        Perro p3 = new Perro();
        p3.setNombre("firulais");
        Perro p4 = new Perro();
        p4.setNombre("pili");
        Perro p5 = new Perro();
        p5.setNombre("pluto");
        Perro p6 = new Perro();
        p6.setNombre("luki");

        List<Perro> lista = new ArrayList<>();

        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);

        List<Perro> lista2 = new ArrayList<>();
        lista2.addAll(lista);


        for (Perro p:lista
             ) {
            System.out.println(p.toString());
        }

        Collections.sort(lista, new Comparator<Perro>() {
            @Override
            public int compare(Perro o1, Perro o2) {
                if(o1.getNombre().compareTo(o2.getNombre())==0){
                    return 0;
                }else if(o1.getNombre().compareTo(o2.getNombre())>=1){
                    return 1;
                }else{
                    return -1;
                }


            }
        });
        System.out.println("-------------------------------------------------");

        for (Perro p:lista
                ) {
            System.out.println(p.toString());
        }

        System.out.println("--------lista2----------------------------------------");


        for (Perro p:lista2
                ) {
            System.out.println(p.toString());
        }

        Collections.sort(lista2);
        System.out.println("----Lista 32 ordenada");
        for (Perro p:lista2
                ) {
            System.out.println(p.toString());
        }





    }
}
