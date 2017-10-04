package co.edu.sena.lesson08;

public class Ejemplo05 {
    public static void main(String[] args) {

        String saludar = "hola"; //objeto en la heap
        System.out.println(saludar);
        System.out.println(saludar+" mundo");// objeto nuevo en la heap



        StringBuilder sb = new StringBuilder(); // objeto de la heap
        sb.append("hola mundo");
        sb.append("hola mundo");

        sb.insert(0, "carrro");

        System.out.println(sb);

    }
}
