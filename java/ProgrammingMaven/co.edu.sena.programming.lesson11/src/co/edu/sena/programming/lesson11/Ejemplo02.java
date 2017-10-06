package co.edu.sena.programming.lesson11;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Ejemplo02 {
    public static void main(String[] args) {


        // Open the file to write to
        Path path =
                Paths.get("D:\\ejemplosNIO2\\pagina.html");
        URI u = URI.create("https://www.google.com.co/?gfe_rd=cr&dcr=0&ei=83_XWcqFL7HI8Afj8YqwCA");
        try (InputStream in = u.toURL().openStream()) {
            Files.copy(in, path, REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println("Exception: " + e);
        }
    }
}
