package co.edu.sena.programming.lesson11.ejemplo11;


import co.edu.sena.programming.lesson11.ejemplo11.util.Finder;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class FindFileTest {

    public static void main(String[] args) {
        String ruta = "D://codigo";
        String busqueda = "miPortafolio.txt";
        Path root = Paths.get(ruta);
        if (!Files.isDirectory(root)) {
            System.out.println(ruta + " must be a directory!");
            System.exit(-1);
        }

        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + busqueda);
        Finder finder = new Finder(root, matcher);
        try {
            Files.walkFileTree(root, finder);
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
        finder.done();
    }
}