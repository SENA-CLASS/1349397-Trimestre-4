package co.edu.sena.jdbc.basic.interfaceconection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejemplo01 implements java.io.Serializable {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:4306?database=observador_de_proyectos";
        String databaseUser= "pepito";
        String passwordDatabase = "123456789";
        Connection conexion=null;

        try {
            conexion = DriverManager.getConnection(url,databaseUser,passwordDatabase);
            System.out.println("si esta activo el autocommit del rdbms: "+conexion.getAutoCommit());
            System.out.println("estado de la conexión:"+ !conexion.isClosed());
            System.out.println("verifica si la base de datos es de solo lectura:"+ conexion.isReadOnly());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conexion!=null){
                conexion.close();
                System.out.println("estado de la conexión:"+ !conexion.isClosed());
            }
        }
    }
}
