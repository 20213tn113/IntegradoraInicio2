package mx.edu.utez.integradorainicio.controller.administration.person;

import mx.edu.utez.integradorainicio.model.administration.person.beanUsuario;
import mx.edu.utez.integradorainicio.service.administration.person.DaoUsuario;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "ServletUsuario", urlPatterns = "/ServletUsuario")
public class ServletUsuario extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }


        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String mensaje="";
            String clase="";
            String peticion=request.getParameter("action");
            RequestDispatcher dispatcher=null;
            switch (peticion){
                case "reservar":
                    String matricula=request.getParameter("matricula");
                    String nombre=request.getParameter("nombre");
                    String apellido=request.getParameter("apellido");
                    String correo=request.getParameter("correo");
                    String rol=request.getParameter("rol");

                    beanUsuario usuariopres=new beanUsuario(matricula,nombre,apellido,correo,rol);
                    if(new DaoUsuario().reservar(usuariopres)){
                        mensaje = "Reservacion Exitosa";
                        clase="alert alert-success";
                        System.out.println("Reservacion Exitosa");
                        dispatcher=request.getRequestDispatcher("formulario.jsp");
                        request.getRequestDispatcher(mensaje);
                    }else{
                        request.setAttribute("mensaje", "Error en la reserva!");
                        mensaje = "Error en la Reserva.";
                        clase="alert alert-danger";
                        dispatcher=request.getRequestDispatcher("formulario.jsp");
                        request.getRequestDispatcher(mensaje);
                    }
                    doGet(request,response);
                    break;
            }
        }
    }
