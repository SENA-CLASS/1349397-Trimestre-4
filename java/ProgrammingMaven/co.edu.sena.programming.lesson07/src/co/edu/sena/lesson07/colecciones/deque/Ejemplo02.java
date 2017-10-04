package co.edu.sena.lesson07.colecciones.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Ejemplo02 {
    public static void main(String[] args) {
        Deque<Integer> pila = new ArrayDeque<>();
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);
        pila.push(6);
        pila.push(7);
        pila.push(8);
        pila.push(9);
        pila.push(10);

        for (Integer i:pila
             ) {
            System.out.println(i);
        }
        System.out.println("---------------------");

        pila.pop();
        pila.pop();
        pila.pop();


        for (Integer i:pila
                ) {
            System.out.println(i);
        }


    }
}
