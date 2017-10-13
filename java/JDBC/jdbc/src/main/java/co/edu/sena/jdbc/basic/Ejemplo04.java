package co.edu.sena.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLWarning;

public class Ejemplo04 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:4306?database=observador_de_proyectos";
        String usuarioBaseDatos= "pepito";
        String passwordDatabase = "123456789";

        Connection conexion=null;


        try {
            conexion = DriverManager.getConnection(url,usuarioBaseDatos,passwordDatabase);

            SQLWarning warning = conexion.getWarnings();
            while(warning!=null){
                System.out.println("SQLState : "+warning.getSQLState()+"\n");
                System.out.println("Mensaje : "+warning.getMessage()+"\n");
                System.out.println("Código de error: "+warning.getErrorCode()+"\n");
                System.out.println( "\n" );
                warning = warning.getNextWarning();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conexion!=null){
                conexion.close();
            }
        }

    }
}
