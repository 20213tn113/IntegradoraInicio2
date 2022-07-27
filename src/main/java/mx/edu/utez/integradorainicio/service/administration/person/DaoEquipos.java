package mx.edu.utez.integradorainicio.service.administration.person;
import mx.edu.utez.integradorainicio.model.administration.person.beanEquipos;
import mx.edu.utez.integradorainicio.utility.conexionMysql;
import mx.edu.utez.integradorainicio.utility.conexionMysql2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoEquipos {

    Logger logger = LoggerFactory.getLogger(DaoEquipos.class);

    public List<beanEquipos> consultarEquipos() {
        List<beanEquipos> ListEquipos = new ArrayList<>();
        try (
                Connection con = conexionMysql.getConnection();
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





    public beanEquipos obtenerEquipos(String id_eqo){
        beanEquipos equipos = new beanEquipos();
        try (Connection con = conexionMysql2.getConnection();
             PreparedStatement stm = con.prepareStatement("select * from equipos where id_eqo=?");
        ) {
            stm.setString(1, id_eqo);
            try (ResultSet rs = stm.executeQuery();) {
                while (rs.next()) {

                    equipos.setId_eqo(rs.getString("id_eqo"));
                    equipos.setNombre(rs.getString("nombre"));
                    equipos.setDescripcion(rs.getString("descripcion"));
                    equipos.setMarca(rs.getString("marca"));
                    equipos.setModelo(rs.getString("modelo"));
                    equipos.setN_serie(rs.getString("n_serie"));
                    equipos.setDisponibilidad(rs.getString("disponibilidad"));
                    equipos.setEstado(rs.getString("estado"));

                }

            } catch (Exception e) {
                logger.error(e.getMessage());
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return equipos;
    }

    public boolean updateEquipos(beanEquipos equipos){
        boolean status=false;
        try{
            Connection con=conexionMysql2.getConnection();
            String sql = "UPDATE equipos SET id_eqo=?, nombre=?, descripcion=?, marca=?, modelo=?, n_serie=?, disponibilidad=?, estado=? WHERE id_eqo="+equipos.getId_eqo();

            PreparedStatement pstm=con.prepareStatement(sql);

            pstm.setString(1,equipos.getId_eqo());
            pstm.setString(2,equipos.getNombre());
            pstm.setString(3,equipos.getDescripcion());
            pstm.setString(4,equipos.getMarca());
            pstm.setString(5,equipos.getModelo());
            pstm.setString(6,equipos.getN_serie());
            pstm.setString(7,equipos.getDisponibilidad());
            pstm.setString(8,equipos.getEstado());

            if(pstm.executeUpdate()==1){
                status=true;
            }
            pstm.close();
            con.close();

        }catch (SQLException e){
            logger.error(e.getMessage());

        }
        return status;
    }

}
