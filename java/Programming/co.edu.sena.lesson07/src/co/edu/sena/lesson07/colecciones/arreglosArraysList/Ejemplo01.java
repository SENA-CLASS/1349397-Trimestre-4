package co.edu.sena.lesson07.colecciones.arreglosArraysList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ejemplo01 {
    public static void main(String[] args) {
        List<String> array =new ArrayList<>();
        array.add("uno");
        array.add("dos");
        array.add("tres");

        for (String o:array
             ) {
            System.out.println(o);
        }

        array.add(1,"nuevoUno");

        for (String o:array
                ) {
            System.out.println(o);
        }


        String [] arreglito = new String[3];
        arreglito[0]="uno";
        arreglito[1]= "dos";
        arreglito[2]= "tres";

        for (String a:arreglito
             ) {
            System.out.println(a);
        }

       arreglito= add(1,arreglito,"unoNuevo");

        for (String a:arreglito
                ) {
            System.out.println(a);
        }

        List<String> array2 = new ArrayList<>();
        array2.add("1");
        array2.add("2");
        array2.add("3");


        array.addAll(array2);
        for (String a:array2
             ) {
            System.out.println(a);
        }

        array.clear();
        System.out.println("---------");
        for (String a:array
                ) {
            System.out.println(a);
        }





    }

    /**
     *  Metthod implements add element into array classic index posistion
     * @param indice the index position add element
     * @param arregloViejo array
     * @param nuevoElemento new element array
     * @return new array with new element into index position
     */
    public static String[] add(int indice, String[] arregloViejo, String nuevoElemento){
        String [] arregloNuevo = new String[arregloViejo.length+1];
        int indiceArregloViejo=0;
        for (int i=0; i<arregloNuevo.length;i++
             ) {
            if(indice!=i){
                arregloNuevo[i]=arregloViejo[indiceArregloViejo];
                indiceArregloViejo++;
            }else{
                arregloNuevo[i]=nuevoElemento;
            }
        }
        return arregloNuevo;
    }
}
