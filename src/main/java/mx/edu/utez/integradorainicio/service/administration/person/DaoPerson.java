package mx.edu.utez.integradorainicio.service.administration.person;


import mx.edu.utez.integradorainicio.model.administration.person.beanPerson;
import mx.edu.utez.integradorainicio.utility.conexionMysql2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoPerson {
    Logger logger = LoggerFactory.getLogger(DaoPerson.class);
    public beanPerson consultaLogin (beanPerson usuario){
        beanPerson login=null;
        try{
            Connection con= conexionMysql2.getConnection();
            String sqlLogin="SELECT * FROM usuarios_sesion WHERE user=? AND pass=?;";
            PreparedStatement ps=con.prepareStatement(sqlLogin);
            ps.setString(1,usuario.getUser());
            ps.setString(2,usuario.getPass());
            ResultSet res= ps.executeQuery();
            if(res.next()){
                login=new beanPerson(res.getInt("iduser"),
                        res.getString("user"), res.getString("pass"));
                System.out.println(res.getInt("iduser"));
                System.out.println(res.getString("user"));
                System.out.println(res.getString("pass"));
            }

        }catch(Exception e){
            e.printStackTrace();
            //logger.error(e.getMessage());
        }

        return login;
    }



}

