package co.edu.sena.lesson07.colecciones.arreglosArraysList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ejemplo04 {
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

        Iterator i = array.iterator();
        while(i.hasNext()){
            Integer enteroTemporal =(Integer)i.next();
            System.out.println(enteroTemporal);
        }

        for (Integer s:array) {
            System.out.println(s);
        }

        for (int j=0; j<array.size();j++){
            System.out.println(array.get(j));
        }


        array.stream().forEach((Integer x)-> System.out.println(x));

        Integer a = Integer.parseInt("1234123");
        System.out.println(a);

        List<Integer> l = new ArrayList<>(4);

    }
}
