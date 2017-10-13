package co.edu.sena.jdbc.basic.interfaceresulset;

import java.sql.*;

public class Ejemplo04 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:4306?database=observador_de_proyectos";
        String usuarioBaseDatos= "pepito";
        String passwordDatabase = "123456789";

        Connection conexion=null;
        Statement sentencia= null;
        ResultSet rs=null;

        String tipoDocumento= "CC";
        String numeroDocumento="12345678";
        String query = "SELECT * FROM observador_de_proyectos.cliente where tipo_documento='"+tipoDocumento+"' and numero_documento ='"+numeroDocumento+"';";
        System.out.println(query);

        try {
            conexion = DriverManager.getConnection(url,usuarioBaseDatos,passwordDatabase);
            sentencia = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);

            boolean resultado = sentencia.execute(query);



            System.out.println(resultado);
         //   System.out.println(r2);

            if(resultado){
                rs = sentencia.getResultSet();
                while(rs.next()){
                    System.out.println("tipo documento: " + rs.getString(1));
                    System.out.println("numero documento: " + rs.getString(2));
                    System.out.println("priemr nombre: " + rs.getString(3));
                    System.out.println("segundo nombre: " + rs.getString(4));
                    System.out.println("Primer apellido: " + rs.getString(5));
                    System.out.println("segundo apellido: " + rs.getString(6));
                    System.out.println("posicion en el resulset: "+rs.getRow());
                    System.out.println("----------------------------------------");

                }
            }

          /*  boolean r2 = sentencia.execute("INSERT INTO `observador_de_proyectos`.`cliente`\n" +
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


            if(!r2){
                System.out.println("se insertaron  "+sentencia.getUpdateCount());
            }


*/






        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs!=null)
                rs.close();
            if(sentencia!=null)
                sentencia.close();
            if(conexion!=null){
                conexion.close();
            }
        }
    }
}
