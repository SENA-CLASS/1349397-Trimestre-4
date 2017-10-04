package co.edu.sena.programming.lesson09;

public class Ejemplo02 {
    public static void main(String[] args) {
        int x = -1;
        if(x>0){
            System.out.println("es mayor");
        }else{
            assert (x==0): "ALGO PASO";
            System.out.println("es negativo");
        }
    }
}
