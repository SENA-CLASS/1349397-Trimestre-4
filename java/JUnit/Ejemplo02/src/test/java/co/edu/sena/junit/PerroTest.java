package co.edu.sena.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PerroTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("aqui estoy en el antes");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("estoy despues de la prueba");
    }

    @Test
    public void getColorTest() {
        System.out.println("estoy probando el metodo getColor()");
        Perro p1 = new Perro();
        p1.setColor("negro");
        assertEquals("los dos colores no son iguales", p1.getColor(), "negro");
    }

    @Test
    public void setColorTest() {
        System.out.println("estoy probando el metodo setColor");
        Perro p1 = new Perro();
        p1.setColor("negro");
        assertEquals("los dos colores no son iguales", p1.getColor(), "negro");
    }

    @Test
    public void arregloPerros(){
        Perro p1 = new Perro();
        Perro p2 = new Perro();
        Perro p3 = new Perro();
        Perro p4 = new Perro();
        Perro p5 = new Perro();
        List<Perro> arreglo = new ArrayList<>();
        arreglo.add(p1);
        arreglo.add(p2);
        arreglo.add(p3);
        arreglo.add(p4);
        arreglo.add(p5);
        assertEquals("la cantidad de perros no es correcta",arreglo.size(),3);


    }

}