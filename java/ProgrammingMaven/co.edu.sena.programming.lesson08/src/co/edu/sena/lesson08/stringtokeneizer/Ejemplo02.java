package co.edu.sena.lesson08.stringtokeneizer;

import java.util.StringTokenizer;

public class Ejemplo02 {
    public static void main(String[] args) {
        String linea = "CC;123456789;;hernando;enrique;moreno;moreno";


        String[] st = linea.split(";");

        System.out.println(st.length);

        for (String s:st
             ) {
            System.out.println(s);
        }
    }
}
