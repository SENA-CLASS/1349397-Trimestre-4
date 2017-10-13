package co.edu.sena.jdbc.basic.interfacestatement;

import java.sql.*;

public class Ejemplo01 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:4306?database=observador_de_proyectos";
        String usuarioBaseDatos= "pepito";
        String passwordDatabase = "123456789";

        Connection conexion=null;
        Statement sentencia= null;

        try {
            conexion = DriverManager.getConnection(url,usuarioBaseDatos,passwordDatabase);
            sentencia = conexion.createStatement();

            ResultSet rs = sentencia.executeQuery("SELECT * FROM observador_de_proyectos.aprendiz;");




        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(sentencia!=null)
                sentencia.close();
            if(conexion!=null){
                conexion.close();
            }
        }
    }
}
