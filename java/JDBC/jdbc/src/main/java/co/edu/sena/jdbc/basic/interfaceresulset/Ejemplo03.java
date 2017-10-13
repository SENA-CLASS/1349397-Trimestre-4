package co.edu.sena.jdbc.basic.interfaceresulset;

import java.sql.*;

public class Ejemplo03 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:4306?database=observador_de_proyectos";
        String usuarioBaseDatos = "pepito";
        String passwordDatabase = "123456789";

        Connection conexion = null;
        Statement sentencia = null;

        try {
            conexion = DriverManager.getConnection(url, usuarioBaseDatos, passwordDatabase);
            sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);


            ResultSet rs = sentencia.executeQuery("SELECT * FROM observador_de_proyectos.cliente;");

            rs.moveToInsertRow();

            rs.updateString(1,"CC");// esto no lo esta implemantado en el driver de fabricante
            rs.updateString(2,"987654321");// esto no lo esta implemantado en el driver de fabricante
            rs.updateString(3,"prueba");// esto no lo esta implemantado en el driver de fabricante
            rs.updateString(4,"prueba");// esto no lo esta implemantado en el driver de fabricante
            rs.updateString(5,"prueba");// esto no lo esta implemantado en el driver de fabricante
            rs.updateString(6,"prueba");// esto no lo esta implemantado en el driver de fabricante
            rs.insertRow();

            rs.last();
            System.out.println("tipo documento: " + rs.getString(1));
            System.out.println("numero documento: " + rs.getString(2));
            System.out.println("priemr nombre: " + rs.getString(3));
            System.out.println("segundo nombre: " + rs.getString(4));
            System.out.println("Primer apellido: " + rs.getString(5));
            System.out.println("segundo apellido: " + rs.getString(6));
            System.out.println("posicion en el resulset: "+rs.getRow());
            System.out.println("----------------------------------------");



            //rs.insertRow();









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
