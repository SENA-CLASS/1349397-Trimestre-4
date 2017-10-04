package co.edu.sena.lesson07.colecciones.arreglosArraysList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ejemplo03 {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(4352);
        array.add(4);
        array.add(2);
        array.add(5235);
        array.add(3456);
        array.add(4567);
        array.add(435);
        array.add(42);
        array.add(4);
        array.add(43);

        array.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

       // lambda array.sort((Integer o1, Integer o2) ->  o1-o2 );

        for (Integer a:array
             ) {
            System.out.println(a);
        }

    }
}
