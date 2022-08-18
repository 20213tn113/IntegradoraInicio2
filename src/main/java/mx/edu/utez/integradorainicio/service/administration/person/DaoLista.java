package mx.edu.utez.integradorainicio.service.administration.person;

import mx.edu.utez.integradorainicio.utility.conexionMysql2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoLista {
    public List<String> CrearLista() {
        ArrayList <String> ListPrestamo =new ArrayList<>();

        try {
            Connection con = conexionMysql2.getConnection();
            PreparedStatement ps;
            //ENLISTAR TODOS LOS ID_PRESTAMO
            ps = con.prepareStatement("select id_prestamo from modelo_prestamo");
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {
                ListPrestamo.add(rs.getString("id_prestamo"));

            }
            con.close();
        } catch (Exception ex) {

        }
        for (int i=0; i<ListPrestamo.size();i++){
            System.out.println(ListPrestamo.get(i));
        }
        return ListPrestamo;
    }
}
