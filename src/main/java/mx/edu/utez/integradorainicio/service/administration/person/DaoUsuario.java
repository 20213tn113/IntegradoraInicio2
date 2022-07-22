package mx.edu.utez.integradorainicio.service.administration.person;

import mx.edu.utez.integradorainicio.model.administration.person.beanUsuario;
import mx.edu.utez.integradorainicio.service.administration.person.DaoUsuario;
import mx.edu.utez.integradorainicio.utility.conexionMysql;
import mx.edu.utez.integradorainicio.utility.conexionMysql2;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoUsuario {
    public boolean reservar(beanUsuario user) {
        try (Connection con = conexionMysql2.getConnection()) {
            try (
                    PreparedStatement pstm = con.prepareStatement("insert into usuario_prestamo (matricula, nombre, apellido, correo, rol) values (?,?,?,?,?)")
            ) {
                pstm.setString(1, user.getMatricula());
                pstm.setString(2, user.getNombre());
                pstm.setString(3, user.getApellido());
                pstm.setString(4, user.getCorreo());
                pstm.setString(5, user.getRol());
                return pstm.executeUpdate() == 1;
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
