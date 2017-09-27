package co.edu.sena.lesson07.colecciones.conjuntosSet;

import java.util.Set;
import java.util.TreeSet;

public class Ejemplo02 {
    public static void main(String[] args) {
        Cliente c1 = new Cliente();
        c1.setNumeroDocumento("12345");
        c1.setTipoDocumento("CC");

        Cliente c2 = new Cliente();
        c2.setNumeroDocumento("123456");
        c2.setTipoDocumento("CC");

        Cliente c3 = new Cliente();
        c3.setNumeroDocumento("123");
        c3.setTipoDocumento("CC");

        Cliente c4 = new Cliente();
        c4.setNumeroDocumento("1234666");
        c4.setTipoDocumento("CC");

        Cliente c5 = new Cliente();
        c5.setNumeroDocumento("123");
        c5.setTipoDocumento("TI");


        Set<Cliente> listadoClientes = new TreeSet<>();
        listadoClientes.add(c1);
        listadoClientes.add(c2);
        listadoClientes.add(c3);
        listadoClientes.add(c4);
        listadoClientes.add(c5);

        for (Cliente c:listadoClientes
             ) {
            System.out.println(c);
        }



    }
}
