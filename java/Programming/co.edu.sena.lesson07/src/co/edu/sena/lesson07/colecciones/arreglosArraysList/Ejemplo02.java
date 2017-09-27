package co.edu.sena.lesson07.colecciones.arreglosArraysList;

public class Ejemplo02 {
    public static void main(String[] args) {
        //clasico algotimo de burbuja

        int [] array = new int[10];
        array[0]=123;
        array[1]=345;
        array[2]=345;
        array[3]=175;
        array[4]=17;
        array[5]=13;
        array[6]=12777;
        array[7]=17;
        array[8]=177377;
        array[9]=2345;
        // ordenamiento de burbuja
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    int burbuja = array[i];
                    array[i]= array[j];
                    array[j]=burbuja;
                }

            }
        }

        for (Integer a:array
             ) {
            System.out.println(a);
        }


    }
}
