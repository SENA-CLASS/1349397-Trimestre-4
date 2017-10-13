package co.edu.sena.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.Properties;

public class Ejemplo05 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:4306?database=observador_de_proyectos";

        Properties propiedades = new Properties();
        propiedades.put("user","pepito");
        propiedades.put("password","123456789");

        Connection conexion=null;


        try {
            conexion = DriverManager.getConnection(url, propiedades);




        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conexion!=null){
                conexion.close();
            }
        }
    }
}
