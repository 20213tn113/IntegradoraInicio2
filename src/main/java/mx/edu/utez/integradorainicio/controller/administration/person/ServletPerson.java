package mx.edu.utez.integradorainicio.controller.administration.person;


import mx.edu.utez.integradorainicio.model.administration.person.beanPerson;
import mx.edu.utez.integradorainicio.service.administration.person.DaoPerson;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "ServletPerson", urlPatterns = "/ServletPerson")
public class ServletPerson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mensaje="";
        String clase="";
        String peticion=request.getParameter("accion");
        RequestDispatcher dispatcher=null;
        HttpSession sesionLogin;

        switch (peticion){
            case "inicioSesion":
                sesionLogin =request.getSession(true);
                beanPerson usuario = new beanPerson(request.getParameter("user"), request.getParameter("pass"));
                DaoPerson daoUsuario=new DaoPerson();
                usuario=daoUsuario.consultaLogin(usuario);
                System.out.println(request.getParameter("user"));
                System.out.println(request.getParameter("pass"));
                if(usuario !=null){
                    sesionLogin.setAttribute("user", usuario.getUser());
                    sesionLogin.setAttribute("pass",usuario.getPass());
                    sesionLogin.setAttribute("id",usuario.getId());
                    mensaje="Bienvenido al sistema " + usuario.getUser();
                    dispatcher =request.getRequestDispatcher("menu.jsp");
                    request.getRequestDispatcher(mensaje);

                }else{
                    System.out.println("No se encontró en la BD!");
                    mensaje = "Datos incorrectos, verifica tu usuario y/o contraseña.";
                    clase="alert alert-danger";
                    dispatcher=request.getRequestDispatcher("index.jsp");
                    request.getRequestDispatcher(mensaje);

                }

                break;
            case "cerrarSesion":
                break;
            default:
                break;

        }
        request.setAttribute("mensaje",mensaje);
        request.setAttribute("clase",clase);
        dispatcher.forward(request,response);

    }
}
