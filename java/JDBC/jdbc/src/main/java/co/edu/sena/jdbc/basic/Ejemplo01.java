package co.edu.sena.jdbc.basic;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejemplo01 {
    public static void main(String[] args) throws java.sql.SQLException  {
        //Class.forName("com.mysql.jdbc.Driver"); // esto no es necesario desde la version jdbc 4.0 pero ojo se de be tener el driver
        String url = "jdbc:mysql://localhost:4306?database=observador_de_proyectos";
        String usuarioBaseDatos= "pepito";
        String passwordDatabase = "123456789";

        Connection conexion=null;


        try {
            conexion = DriverManager.getConnection(url,usuarioBaseDatos,passwordDatabase);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conexion!=null){
                conexion.close();
            }
        }


    }
}
