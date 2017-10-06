package co.edu.sena.programming.lesson11;

import java.nio.charset.Charset;
import java.util.Map;

public class Ejemplo05 {
    public static void main(String[] args) {
        Map<String, Charset> listadoCharset = Charset.availableCharsets();

        for (String nombreCs:listadoCharset.keySet()
                ) {
            System.out.println("key: "+nombreCs);
            System.out.println("value : "+listadoCharset.get(nombreCs));
        }
    }
}
