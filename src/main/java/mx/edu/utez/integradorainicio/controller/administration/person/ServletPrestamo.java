package mx.edu.utez.integradorainicio.controller.administration.person;


import mx.edu.utez.integradorainicio.model.administration.person.beanEquipos;
import mx.edu.utez.integradorainicio.service.administration.person.DaoEquipos;
import mx.edu.utez.integradorainicio.model.administration.person.beanEquipos;
import mx.edu.utez.integradorainicio.service.administration.person.DaoPrestamo;
import mx.edu.utez.integradorainicio.model.administration.person.beanPrestamo;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletPrestamo", urlPatterns = "/ServletPrestamo")
public class ServletPrestamo extends HttpServlet {
    String urlRedirect = "/getEquipos";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id2;
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
        beanEquipos equipos;
        beanEquipos equipos2;


        switch (peticion){

            case "seleccion":

                String id_prestamos1 = request.getParameter("id_prestamo");
                int id_prestamos = Integer.parseInt(id_prestamos1);
                 String id4 = request.getParameter("id");

                System.out.println("Imprimo: "+id_prestamos);
                System.out.println("Imprimo id_eqo: "+id4);

                new DaoPrestamo().registrarlista(id_prestamos,id4);



                //esta linea envia el id del prestamo
                request.setAttribute("id_prestamo",id_prestamos);
                //

                mensaje="Error al actualizar el Equipo!";
                request.setAttribute("mensaje","Error al actualizar el usuario!");
                dispatcher =request.getRequestDispatcher("seleccion.jsp");
                request.getRequestDispatcher(mensaje);
                break;




            default:
                break;

        }
        request.setAttribute("mensaje",mensaje);
        request.setAttribute("clase",clase);
        dispatcher.forward(request,response);

    }



    }
