package co.edu.sena.lesson07;

import java.util.HashSet;
import java.util.Set;

public class Ejemplo02 {
    public static void main(String[] args) {
        ClaseGenerica<Float, Integer, Boolean> objeto = new ClaseGenerica<>();

        objeto.setAtributoNumero1(4.5F);
        objeto.setAtributoNumero2(5);
        objeto.setAtributoNumero3(true);

        System.out.println(objeto.toString());


        String [] arreglo = new String[10];
        arreglo[0]="hola";
        arreglo[1]="hola";
        arreglo[2]="hola";
        arreglo[3]="hola";


        Arreglos.imprimir(arreglo);

        Integer [] arreglo2 = new Integer[10];
        arreglo2[0]=1;
        arreglo2[1]=2;
        arreglo2[2]=3;
        arreglo2[3]=4;


        Arreglos.imprimir(arreglo2);

        Set<String>conjunto = new HashSet<>();
        conjunto.add("hola3");
        conjunto.add("hola");
        conjunto.add("hola2");
        conjunto.add("hola");

        Arreglos.imprimir2(conjunto);






    }
}
