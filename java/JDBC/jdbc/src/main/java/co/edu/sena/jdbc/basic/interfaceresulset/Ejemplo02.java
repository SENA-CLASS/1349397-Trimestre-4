package co.edu.sena.jdbc.basic.interfaceresulset;

import java.sql.*;

public class Ejemplo02 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:4306?database=observador_de_proyectos";
        String usuarioBaseDatos = "pepito";
        String passwordDatabase = "123456789";

        Connection conexion = null;
        Statement sentencia = null;

        try {
            conexion = DriverManager.getConnection(url, usuarioBaseDatos, passwordDatabase);
            sentencia = conexion.createStatement();


            ResultSet rs = sentencia.executeQuery("SELECT * FROM observador_de_proyectos.aprendiz;");
            int cont = 0;

            rs.last();

            while (rs.previous()) {
                System.out.println("tipo documento" + rs.getString(1));
                System.out.println("numero documento" + rs.getString(2));
                System.out.println("estado" + rs.getString(3));
                System.out.println("ficha" + rs.getString(4));
                System.out.println("grupo" + rs.getString(5));
                System.out.println("posicion en el resulset"+rs.getRow());
                System.out.println("----------------------------------------");
                cont++;


            }
            System.out.println("los registros son " + cont);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (sentencia != null)
                sentencia.close();
            if (conexion != null) {
                conexion.close();
            }
        }
    }
}
