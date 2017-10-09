package co.edu.sena.programming.lesson11.ejemplo10;

import co.edu.sena.programming.lesson11.ejemplo10.util.PrintTree;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WalkFileTreeTest {

    public static void main(String[] args) {
        String ruta= "D://Temp//";

        Path path = Paths.get(ruta);
        if (!Files.isDirectory(path)) {
            System.out.println(ruta + " must be a directory!");
            System.exit(-1);
        }
        try {
            Files.walkFileTree(path, new PrintTree());
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}