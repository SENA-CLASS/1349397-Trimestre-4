package co.edu.sena.programming.lesson11;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.StringTokenizer;

public class Ejemplo04 {
    public static void main(String[] args) {
        Path ruta2 = Paths.get("D:\\ejemplosNIO2\\ejemplo.txt");

        try {
            Charset cs = Charset.defaultCharset();
            System.out.println(cs.name());
            BufferedReader reader = Files.newBufferedReader(ruta2, cs);// abre el archivo en ruta2 en formato por default de la JVM

            long lineas = reader.lines().count();
            System.out.println("lineas: " + lineas);
            long lineaActual = 1;
            String contenidoLinea;

            reader = Files.newBufferedReader(ruta2, cs);
            while (lineaActual <= lineas - 1) {
                contenidoLinea = reader.readLine();
                contenidoLinea=fillTokenEmptyFofLine(contenidoLinea);
                StringTokenizer tokens = new StringTokenizer(contenidoLinea, ",");

                while (tokens.hasMoreTokens()) {

                    String t = tokens.nextToken();

                    System.out.println(t);

                }

                lineaActual++;
            }
            reader.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static String fillTokenEmptyFofLine(String line) {
        String newLine = line;
        if (line.length() > 1 && line.contains("," + ",")) {
            int a = 0;
            int b = 1;
            newLine = String.valueOf(line.charAt(a));

            while (b < line.length()) {
                if (line.charAt(a) == line.charAt(b) && String.valueOf(line.charAt(a)).equals(",")) {
                    newLine += "N/A";
                }
                newLine += String.valueOf(line.charAt(b));
                a++;
                b++;
            }

        }
        return newLine;
    }
}
