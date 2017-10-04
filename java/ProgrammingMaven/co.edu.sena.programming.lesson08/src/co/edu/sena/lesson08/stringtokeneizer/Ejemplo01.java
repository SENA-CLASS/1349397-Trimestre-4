package co.edu.sena.lesson08.stringtokeneizer;

import java.util.StringTokenizer;

public class Ejemplo01 {
    public static void main(String[] args) {

        String linea = "CC;123456789;hernando;enrique;moreno;moreno";


        StringTokenizer st = new StringTokenizer(linea,";");

        System.out.println(st.countTokens());

        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());

        }


    }
}
