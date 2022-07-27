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
        String id_eqo2;
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


        switch (peticion){
            case "actualizar":
                id_eqo2=request.getParameter("id_eqo2");
                id_eqo=request.getParameter("id_eqo");
                nombre=request.getParameter("nombre");
                descripcion=request.getParameter("descripcion");
                marca=request.getParameter("marca");
                modelo=request.getParameter("modelo");
                n_serie=request.getParameter("n_serie");
                disponibilidad=request.getParameter("disponibilidad");
                estado=request.getParameter("estado");

                idEquipoString = request.getParameter("id_eqo2")!=null?request.getParameter("id_eqo2"):"0";

                String idEquipos = idEquipoString;

                System.out.println("IdEquipos: "+idEquipos);
                System.out.println("Actualiza id_eqo: "+id_eqo);
                System.out.println("Actualiza nombre: "+nombre);
                System.out.println("Actualiza descripcion: "+descripcion);
                System.out.println("Actualiza marca: "+marca);
                System.out.println("Actualiza modelo: "+modelo);
                System.out.println("Actualiza n_serie: "+n_serie);
                System.out.println("Actualiza disponibilidad: "+disponibilidad);
                System.out.println("Actualiza estado: "+estado);




                equipos = new beanEquipos(idEquipos,nombre,descripcion,marca,modelo,n_serie,disponibilidad,estado);

                if(new DaoEquipos().updateEquipos(equipos)){
                    mensaje="Usuario actualizado correctamente!";
                    request.setAttribute("mensaje","Usuario actualizado correctamente!");
                    System.out.println("El usuario ha sido modificado");
                    dispatcher =request.getRequestDispatcher("admin.jsp");
                    request.getRequestDispatcher(mensaje);
                }else{
                    mensaje="Error al actualizar el usuario!";
                    request.setAttribute("mensaje","Error al actualizar el usuario!");
                    dispatcher =request.getRequestDispatcher("admin.jsp");
                    request.getRequestDispatcher(mensaje);
                }
                doGet(request,response);
                break;

            default:
                break;

        }
        request.setAttribute("mensaje",mensaje);
        request.setAttribute("clase",clase);
        dispatcher.forward(request,response);

    }



    }

