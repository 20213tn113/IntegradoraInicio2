package mx.edu.utez.integradorainicio.service.administration.person;

import mx.edu.utez.integradorainicio.model.administration.person.beanEquipos;
import mx.edu.utez.integradorainicio.model.administration.person.beanPrestamo;
import mx.edu.utez.integradorainicio.utility.conexionMysql;
import mx.edu.utez.integradorainicio.utility.conexionMysql2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoMostrarReservas {
    public static List<beanPrestamo> ListReservas() {
        List<beanPrestamo> ListReservas =new ArrayList<>();
        try (Connection con = conexionMysql2.getConnection()) {
            try (
                    Statement stm = con.createStatement();
                    ResultSet rs = stm.executeQuery("SELECT * FROM modelo_prestamo;");
            ) {
                while (rs.next()) {
                    beanPrestamo reservas = new beanPrestamo();
                    reservas.setId_prestamo(Integer.parseInt(rs.getString("id_prestamo")));
                    reservas.setMatricula(rs.getString("matricula"));
                    reservas.setHora_inicio(rs.getString("hora_inicio"));
                    reservas.setHora_final(rs.getString("hora_final"));

                    ListReservas.add(reservas);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListReservas;
    }
}
