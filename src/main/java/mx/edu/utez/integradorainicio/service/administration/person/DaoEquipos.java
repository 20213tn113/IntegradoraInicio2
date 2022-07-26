package mx.edu.utez.integradorainicio.service.administration.person;
import mx.edu.utez.integradorainicio.model.administration.person.beanEquipos;
import mx.edu.utez.integradorainicio.model.administration.person.beanPrestamo;
import mx.edu.utez.integradorainicio.model.administration.person.beanPerson;
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
                ResultSet rs = stm.executeQuery("SELECT * FROM equipos where status=1;");
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

                ListEquipos.add(equipos);

            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        return ListEquipos;
    }





    public beanEquipos obtenerEquipos(int id){
        beanEquipos equipos = new beanEquipos();
        try
             (Connection con = conexionMysql2.getConnection();
             PreparedStatement stm = con.prepareStatement("select * from equipos where id=?");
        ) {
            stm.setInt(1, id);
            try (ResultSet rs = stm.executeQuery();) {
                while (rs.next()) {
                    equipos.setId(rs.getInt("id"));
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


    public boolean registrarEquipos(beanEquipos equipos) {
        try (Connection con = conexionMysql2.getConnection()) {
            try (PreparedStatement pstm = con.prepareStatement("insert into equipos(id_eqo,nombre,descripcion,marca,modelo,n_serie,disponibilidad,estado) values(?,?,?,?,?,?,?,?)")) {

                pstm.setString(1,equipos.getId_eqo());
                pstm.setString(2,equipos.getNombre());
                pstm.setString(3,equipos.getDescripcion());
                pstm.setString(4,equipos.getMarca());
                pstm.setString(5,equipos.getModelo());
                pstm.setString(6,equipos.getN_serie());
                pstm.setString(7, equipos.getDisponibilidad());
                pstm.setString(8,equipos.getEstado());

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



    public boolean registrarlista(int id_prestamo,int id) {
        try (Connection con = conexionMysql2.getConnection()) {
            try (PreparedStatement pstm = con.prepareStatement("insert into lista(id_prestamo,id_eqo) values(?,?)")) {

                pstm.setInt(1, id_prestamo);
                pstm.setInt(2,id);

                return pstm.executeUpdate() == 1;

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return false;
    }


    public boolean updateDispo (beanEquipos equipos1){
        boolean status=false;
        try{
            Connection con=conexionMysql2.getConnection();
            //String sql="DELETE FROM equipos WHERE id="+equipos1.getId();

            String sql="UPDATE equipos SET disponibilidad='N' WHERE id="+equipos1.getId();

            System.out.println("El id que llego al Dao: "+equipos1.getId());

            //String sql="UPDATE equipos SET disponibilidad=? WHERE id=?";

            PreparedStatement pstm=con.prepareStatement(sql);
            String dato =  "N";
            pstm.setString(1,dato);
            //pstm.setInt(2,equipos1.getId());

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


    public boolean updateDispo2 (int id,String disponibilidad){
        boolean status=false;
        try{
            Connection con=conexionMysql2.getConnection();
            //String sql="DELETE FROM equipos WHERE id="+equipos1.getId();

            String sql="UPDATE equipos SET disponibilidad='N' WHERE id="+id;

            System.out.println("El id que llego al Dao: "+id);

            //String sql="UPDATE equipos SET disponibilidad=? WHERE id=?";

            PreparedStatement pstm=con.prepareStatement(sql);

            //pstm.setString(1,disponibilidad);
            //pstm.setInt(2,equipos1.getId());

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



        public List<beanPrestamo> list(int id) {
            List<beanPrestamo> ListPrestamo = new ArrayList<>();
            try (
                    Connection con = conexionMysql.getConnection();
                    //Statement stm = con.createStatement();
                    //ResultSet rs = stm.executeQuery("SELECT * FROM equipos where nombre =? and disponibilidad=?");
                    // ResultSet rs = stm.executeQuery("SELECT * FROM equipos where nombre =? and disponibilidad="+'S');
                    PreparedStatement stm = con.prepareStatement("select * from lista where id_prestamo=" + id);
            ) {

                ResultSet rs = stm.executeQuery();

                while (rs.next()) {
                    beanPrestamo pres = new beanPrestamo();
                    pres.setId_eqo(rs.getString("id_eqo"));
                    pres.setId_prestamo(rs.getInt("id_prestamo"));
                    System.out.println("id_eqo: "+rs.getString("id_eqo"));


                    //System.out.println(equipos.getNombre());
                    ListPrestamo.add(pres);

                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            }

            return ListPrestamo;

        }

    public boolean deleteSeleccion (int id,int id_prestamo){
        boolean status=false;
        try{
            Connection con=conexionMysql2.getConnection();
            //String sql="DELETE FROM equipos WHERE id="+equipos1.getId();

            String sql="DELETE FROM lista where id_prestamo ="+id_prestamo+" and  id_eqo ="+id;

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


    public boolean updateDispo3 (int id){
        boolean status=false;
        try{
            Connection con=conexionMysql2.getConnection();
            //String sql="DELETE FROM equipos WHERE id="+equipos1.getId();

            String sql="UPDATE equipos SET disponibilidad='S' WHERE id="+id;

            System.out.println("El id que llego al Dao: "+id);

            //String sql="UPDATE equipos SET disponibilidad=? WHERE id=?";

            PreparedStatement pstm=con.prepareStatement(sql);

            //pstm.setString(1,disponibilidad);
            //pstm.setInt(2,equipos1.getId());

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




    }
