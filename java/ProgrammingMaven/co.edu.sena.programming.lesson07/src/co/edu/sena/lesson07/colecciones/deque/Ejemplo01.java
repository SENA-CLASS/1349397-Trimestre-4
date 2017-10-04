package co.edu.sena.lesson07.colecciones.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Ejemplo01 {
    public static void main(String[] args) {
        Deque<Integer> cola = new ArrayDeque<>();
        cola.add(1);
        cola.add(2);
        cola.add(3);
        cola.add(4);
        cola.add(5);
        cola.add(6);
        cola.add(7);
        cola.add(8);

        for (Integer c: cola
             ) {
            System.out.println(c);
        }
        System.out.println("----------------------------------------");
        cola.remove();
        cola.remove();
        cola.remove();

        for (Integer c: cola
                ) {
            System.out.println(c);
        }

    }
}
