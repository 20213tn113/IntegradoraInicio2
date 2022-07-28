package mx.edu.utez.integradorainicio.controller.administration.person;

import mx.edu.utez.integradorainicio.model.administration.person.beanEquipos;
import mx.edu.utez.integradorainicio.service.administration.person.DaoEquipos;
import mx.edu.utez.integradorainicio.service.administration.person.DaoPerson;

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


        switch (peticion){
            case "actualizar":
                id2= request.getParameter("id");
                id_eqo=request.getParameter("id_eqo");
                nombre=request.getParameter("nombre");
                descripcion=request.getParameter("descripcion");
                marca=request.getParameter("marca");
                modelo=request.getParameter("modelo");
                n_serie=request.getParameter("n_serie");
                disponibilidad=request.getParameter("disponibilidad");
                estado=request.getParameter("estado");

                idEquipoString = request.getParameter("id")!=null?request.getParameter("id"):"0";

                int idEquipos = Integer.parseInt(idEquipoString);

                System.out.println("ID PRUEBA: "+id2);
                System.out.println("IdEquipos que llego: "+idEquipos);
                System.out.println("Actualiza id_eqo: "+id_eqo);
                System.out.println("Actualiza nombre: "+nombre);
                System.out.println("Actualiza descripcion: "+descripcion);
                System.out.println("Actualiza marca: "+marca);
                System.out.println("Actualiza modelo: "+modelo);
                System.out.println("Actualiza n_serie: "+n_serie);
                System.out.println("Actualiza disponibilidad: "+disponibilidad);
                System.out.println("Actualiza estado: "+estado);


                equipos = new beanEquipos(idEquipos,id_eqo,nombre,descripcion,marca,modelo,n_serie,disponibilidad,estado);

                if(new DaoEquipos().updateEquipos(equipos)){
                    mensaje="Usuario actualizado correctamente!";
                    request.setAttribute("mensaje","Usuario actualizado correctamente!");
                    System.out.println("El Equipo ha sido modificado");
                    dispatcher =request.getRequestDispatcher("admin.jsp");
                    request.getRequestDispatcher(mensaje);
                }else{
                    mensaje="Error al actualizar el Equipo!";
                    request.setAttribute("mensaje","Error al actualizar el usuario!");
                    dispatcher =request.getRequestDispatcher("admin.jsp");
                    request.getRequestDispatcher(mensaje);
                }
                doGet(request,response);
                break;

            case "eliminar":
                idEquipoString  = request.getParameter("id")!=null?request.getParameter("id"):"0";
                int id  = Integer.parseInt(idEquipoString);
                beanEquipos equipos1=new beanEquipos();
                equipos1.setId(id);
                DaoEquipos daoEquipos=new DaoEquipos();

                if(daoEquipos.deleteEquipos(equipos1)){
                    mensaje="Usuario eliminado correctamente!";
                    request.setAttribute("mensaje","Usuario eliminado correctamente!");
                    System.out.println("El usuario ha sido eliminado");
                    dispatcher =request.getRequestDispatcher("admin.jsp");
                    request.getRequestDispatcher(mensaje);

                }else{
                    mensaje="Error al eliminar el usuario!";
                    request.setAttribute("mensaje","Error al eliminar el usuario!");
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
