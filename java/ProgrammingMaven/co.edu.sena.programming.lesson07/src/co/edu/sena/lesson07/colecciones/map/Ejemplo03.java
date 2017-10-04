package co.edu.sena.lesson07.colecciones.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Ejemplo03 {
    public static void main(String[] args) {
        Location l1 = new Location();
        l1.setLatitud(4.5881282);
        l1.setLongitud(-74.1061333);

        InformationLocation i1 = new InformationLocation();
        i1.setNombre("SENA Centro de Gestión Industrial");
        i1.setDireccion("\n" +
                "Cl. 15 #3142, Bogotá, Colombia");
        i1.setTelefono("+57 1 5925555");

        Location l2 = new Location();
        l2.setLatitud(4.5900641);
        l2.setLongitud(74.1000642);

        InformationLocation i2 = new InformationLocation();
        i2.setNombre("SENA Centro de Tecnologías para Construcción y las Maderas");
        i2.setDireccion("\n" +
                "Cra. 18a #2-18 sur, Bogotá, Colombia");
        i2.setTelefono("+57 1 5461600");



        Map<Location, InformationLocation> senasBogota = new TreeMap<>();
        senasBogota.put(l2,i2);
        senasBogota.put(l1,i1);


        for (Location location:senasBogota.keySet()
                ) {
            System.out.println(location.toString());
        }

        System.out.println(senasBogota.get(l1).getNombre());


    }
}
