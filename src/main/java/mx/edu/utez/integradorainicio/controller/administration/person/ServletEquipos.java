package mx.edu.utez.integradorainicio.controller.administration.person;

import mx.edu.utez.integradorainicio.model.administration.person.beanEquipos;
import mx.edu.utez.integradorainicio.service.administration.person.DaoEquipos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletEquipos", urlPatterns = "/ServletEquipos")
public class ServletEquipos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String id_eqo;
         String nombre;
         String descripcion;
         String marca;
         String modelo;
         String n_serie;
         String disponibilidad;
         String estado;


        String idEquipoString;
        String mensaje="";
        String clase="";
        String peticion=request.getParameter("accion");
        RequestDispatcher dispatcher=null;
        HttpSession sesionLogin;
        beanEquipos equipo;




    }

}
