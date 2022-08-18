package mx.edu.utez.integradorainicio.service.administration.person;

import mx.edu.utez.integradorainicio.model.administration.person.beanEquipos;
import mx.edu.utez.integradorainicio.model.administration.person.beanPrestamo;
import mx.edu.utez.integradorainicio.utility.conexionMysql;
import mx.edu.utez.integradorainicio.utility.conexionMysql2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPrestamo {

    Logger logger = LoggerFactory.getLogger(DaoPrestamo.class);



    public boolean updateEquipos(beanEquipos equipos){
        boolean status=false;
        try{
            Connection con=conexionMysql2.getConnection();
            String sql = "UPDATE equipos SET id_eqo=?, nombre=?, descripcion=?, marca=?, modelo=?, n_serie=?, disponibilidad=?, estado=? WHERE id="+equipos.getId();

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


    public boolean deleteEquipos (beanEquipos equipos1){
        boolean status=false;
        try{
            Connection con=conexionMysql2.getConnection();
            //String sql="DELETE FROM equipos WHERE id="+equipos1.getId();
            String sql="UPDATE equipos SET status=0 WHERE id="+equipos1.getId();

            PreparedStatement pstm=con.prepareStatement(sql);
            if(pstm.executeUpdate()==1){
                status=true;
            }
            pstm.close();
            con.close();
        }catch(SQLException e){
            logger.error(e.getMessage());
        }

        return  status;
    }


    public boolean registrarlista(int id_pres, String id_eqo) {
        try (Connection con = conexionMysql2.getConnection()) {
            try (PreparedStatement pstm = con.prepareStatement("insert into lista(id_prestamo,id_eqo) values(?,?)")) {

                pstm.setInt(1,id_pres);
                pstm.setString(1,id_eqo);

                return pstm.executeUpdate() == 1;

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return false;
    }




    public List<beanEquipos> consultarFiltro() {
        List<beanEquipos> ListEquipos = new ArrayList<>();
        try (
                Connection con = conexionMysql.getConnection();
                Statement stm = con.createStatement();
                //ResultSet rs = stm.executeQuery("SELECT * FROM equipos where nombre =? and disponibilidad=?");
               // ResultSet rs = stm.executeQuery("SELECT * FROM equipos where nombre =? and disponibilidad="+'S');


                ResultSet rs = stm.executeQuery("SELECT * FROM equipos where status=1;");

                //rs.getString(1,nombre);
                //rs.getString(2,disponibilidad)
        ) {
            while (rs.next()) {

                beanEquipos equipos = new beanEquipos();
                equipos.setId(rs.getInt("id"));
                equipos.setId_eqo(rs.getString("id_eqo"));
                equipos.setNombre(rs.getString("nombre"));
                equipos.setDescripcion(rs.getString("descripcion"));
                equipos.setMarca(rs.getString("marca"));
                equipos.setModelo(rs.getString("modelo"));
                equipos.setN_serie(rs.getString("n_serie"));
                equipos.setDisponibilidad(rs.getString("disponibilidad"));
                equipos.setEstado(rs.getString("estado"));

                //System.out.println(equipos.getNombre());
                ListEquipos.add(equipos);

            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }


        return ListEquipos;

    }






}
