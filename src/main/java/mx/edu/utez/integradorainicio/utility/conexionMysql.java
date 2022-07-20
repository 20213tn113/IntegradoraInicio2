package mx.edu.utez.integradorainicio.utility;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexionMysql {
    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection("jdbc:mysql://localhost:3308/bd_integradora", "root", "root");
    }
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(conexionMysql.class);
        try {
            logger.info("Abriendo conexion");
            Connection con = conexionMysql.getConnection();
            logger.info("Conexión establecida");
            con.close();
            logger.info("Conexion Finalizada");
        } catch (Exception e) {
            logger.info("Error en la Conexion");
            logger.error(e.getMessage());
        }
    }
}
