package mx.edu.utez.integradorainicio.service.administration.person;
import mx.edu.utez.integradorainicio.model.administration.person.beanEquipos;
import mx.edu.utez.integradorainicio.utility.conexionMysql2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoEquipos {

    Logger logger = LoggerFactory.getLogger(DaoPerson.class);

    public List<beanEquipos> consultarEquipos() {
        List<beanEquipos> ListEquipos = new ArrayList<>();
        try (
                Connection con = conexionMysql2.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM equipos;");
        ) {
            while (rs.next()) {
                beanEquipos equipos = new beanEquipos();

                equipos.setId_eqo(rs.getString("id_eqo"));
                equipos.setNombre(rs.getString("nombre"));
                equipos.setDescripcion(rs.getString("descripcion"));
                equipos.setMarca(rs.getString("marca"));
                equipos.setModelo(rs.getString("modelo"));
                equipos.setN_serie(rs.getString("n_serie"));
                equipos.setDisponibilidad(rs.getString("disponibilidad"));
                equipos.setEstado(rs.getString("estado"));

                ListEquipos.add(equipos);

            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        for (int i=0; i<=ListEquipos.size()-1;i++){
            System.out.println(ListEquipos.get(i).getNombre());
        }
        return ListEquipos;

    }
}
