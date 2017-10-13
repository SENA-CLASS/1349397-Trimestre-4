package co.edu.sena.jdbc.basic.interfacestatement;

import java.sql.*;

public class Ejemplo02 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:4306?database=observador_de_proyectos";
        String usuarioBaseDatos= "pepito";
        String passwordDatabase = "123456789";

        Connection conexion=null;
        Statement sentencia= null;

        try {
            conexion = DriverManager.getConnection(url,usuarioBaseDatos,passwordDatabase);
            sentencia = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            conexion.setAutoCommit(false);


            int r2 = sentencia.executeUpdate("INSERT INTO `observador_de_proyectos`.`cliente`\n" +
                    "(`tipo_documento`,\n" +
                    "`numero_documento`,\n" +
                    "`primer_nombre`,\n" +
                    "`segundo_nombre`,\n" +
                    "`primer_apellido`,\n" +
                    "`segundo_apellido`)\n" +
                    "VALUES\n" +
                    "('CC',\n" +
                    "'12345678',\n" +
                    "'pruebita',\n" +
                    "'pruebita',\n" +
                    "'pruebita',\n" +
                    "'pruebita'\n" +
                    ");");
            ResultSet rs = sentencia.executeQuery("SELECT * FROM observador_de_proyectos.aprendiz1;");
            conexion.commit();

            System.out.println("se insertaron "+r2+" registros" );




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
