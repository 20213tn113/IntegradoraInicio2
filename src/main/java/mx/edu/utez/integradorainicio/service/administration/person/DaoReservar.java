package mx.edu.utez.integradorainicio.service.administration.person;

import mx.edu.utez.integradorainicio.model.administration.person.beanPrestamo;
import mx.edu.utez.integradorainicio.utility.conexionMysql2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaoReservar {
    static Logger logger = LoggerFactory.getLogger(DaoReservar.class);

    public boolean prestatario(beanPrestamo user) {
        boolean condicion=false;
        try (Connection con = conexionMysql2.getConnection()) {
            try (
                    PreparedStatement pstm = con.prepareStatement("insert into usuario_prestamo (matricula, nombre, apellido, correo, rol) values (?,?,?,?,?)");
            ) {
                pstm.setString(1, user.getMatricula());
                pstm.setString(2, user.getNombre());
                pstm.setString(3, user.getApellido());
                pstm.setString(4, user.getCorreo());
                pstm.setString(5, user.getRol());
                System.out.println(user.getMatricula());
                System.out.println(user.getRol());
                pstm.executeUpdate();
                condicion=true;
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return condicion;
    }

    public boolean registrarReserva(String matricula, String hora_inicio, String hora_final) {
        boolean condicion=false;
        try (Connection con = conexionMysql2.getConnection()) {
            try (
                    PreparedStatement pstm = con.prepareStatement("insert into modelo_prestamo (matricula, hora_inicio, hora_final) values (?,?,?)");
                    //PreparedStatement pstm = con.prepareStatement("insert into modelo_prestamo (matricula, hora_inicio, hora_final) values ("+matricula+","+hora_inicio+","+hora_final+")");
            ) {

                pstm.setString(1, matricula);
                pstm.setString(2, hora_inicio);
                pstm.setString(3, hora_final);
                System.out.println(hora_inicio);
                System.out.println(hora_final);
                condicion=true;
                pstm.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return condicion;
    }


    public beanPrestamo   idReserva(String matricula,String hora_inicio) {
        boolean condicion=false;
        beanPrestamo prestaDatos = new beanPrestamo();
        try (Connection con = conexionMysql2.getConnection()) {
            try (
                    PreparedStatement pstm = con.prepareStatement("SELECT * from modelo_prestamo where matricula LIKE '%"+matricula+"%' or hora_inicio LIKE '%"+hora_inicio+"%'");
            ) {
                ResultSet rs = pstm.executeQuery();
                while(rs.next()){
                    prestaDatos.setId_prestamo(rs.getInt("id_prestamo"));
                }

                condicion=true;


            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return prestaDatos;
    }


}
