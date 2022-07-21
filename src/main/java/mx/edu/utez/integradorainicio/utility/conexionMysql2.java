package mx.edu.utez.integradorainicio.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionMysql2 {
    private static String ipAddress="localhost";
    private static String dbName="bd_integradora";
    private static String user="root";
    private static String password="root";
    private static String portservice="3306";
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error de Base de Datos");
            e.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:mysql://"
                + ipAddress + ":" + portservice + "/"
                + dbName, user, password);
    }
    public static void main(String[] args) throws SQLException {
        Connection con = getConnection();
        System.out.println("Conexión realizada con Exito!: " + con);
        con.close();
    }
}
