package co.edu.sena.lesson07.colecciones.conjuntosSet;

import java.util.*;

public class Ejemplo03 {
    public static void main(String[] args) {
        Cliente c1 = new Cliente();
        c1.setNumeroDocumento("12345");
        c1.setTipoDocumento("CC");
        c1.setPrimerNombre("juan");

        Cliente c2 = new Cliente();
        c2.setNumeroDocumento("123456");
        c2.setTipoDocumento("CC");
        c2.setPrimerNombre("pedro");

        Cliente c3 = new Cliente();
        c3.setNumeroDocumento("123");
        c3.setTipoDocumento("CC");
        c3.setPrimerNombre("julian");

        Cliente c4 = new Cliente();
        c4.setNumeroDocumento("1234666");
        c4.setTipoDocumento("CC");
        c4.setPrimerNombre("cristian");

        Cliente c5 = new Cliente();
        c5.setNumeroDocumento("123");
        c5.setTipoDocumento("TI");
        c5.setPrimerNombre("tejedor");


        List<Cliente> listadoClientes = new ArrayList<>();
        listadoClientes.add(c1);
        listadoClientes.add(c2);
        listadoClientes.add(c3);
        listadoClientes.add(c4);
        listadoClientes.add(c5);

        listadoClientes.sort(new Comparator<Cliente>() {
            @Override
            public int compare(Cliente o1, Cliente o2) {
                if(o1.getPrimerNombre().compareTo(o2.getPrimerNombre())==0)
                return 0;
                else if(o1.getPrimerNombre().compareTo(o2.getPrimerNombre())>=1){
                    return 1;
                }else
                    return -1;
            }
        });

        for (Cliente c:listadoClientes
                ) {
            System.out.println(c);
        }
    }
}
