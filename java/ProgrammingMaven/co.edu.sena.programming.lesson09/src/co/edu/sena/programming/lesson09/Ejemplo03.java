package co.edu.sena.programming.lesson09;

import java.util.Scanner;

public class Ejemplo03 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int edad = teclado.nextInt();

        if(edad>=18){
            System.out.println("es mayor de edad");
        }else{
            assert (edad>0):"Edad no valida";// buena practica para probar posibles errores
            System.out.println("es menor de edad");
        }


    }
}
