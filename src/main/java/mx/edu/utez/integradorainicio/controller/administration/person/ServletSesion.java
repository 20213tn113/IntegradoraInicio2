package mx.edu.utez.integradorainicio.controller.administration.person;

import mx.edu.utez.integradorainicio.model.administration.person.beanPerson;
import mx.edu.utez.integradorainicio.service.administration.person.DaoPerson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletSesion", urlPatterns = "/ServletSesion")
public class ServletSesion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pass;
        String name;
        String user;
        String idPersonString;
        String mensaje="";
        String validar ="";
        String clase="";
        String peticion=request.getParameter("accion");
        RequestDispatcher dispatcher=null;
        HttpSession sesionLogin;
        beanPerson usuario;

        switch (peticion){
            case "inicioSesion":
                sesionLogin =request.getSession(true);
                usuario = new beanPerson(request.getParameter("user"), request.getParameter("pass"));
                DaoPerson daoUsuario=new DaoPerson();
                usuario=daoUsuario.consultaLogin(usuario);

                System.out.println("ID2:"+request.getParameter("iduser"));
                System.out.println("User: "+request.getParameter("user"));
                System.out.println("Pass: "+ request.getParameter("pass"));
                //System.out.println("Name: "+usuario.getName());


                if(usuario !=null){
                    sesionLogin.setAttribute("user", usuario.getUser());
                    sesionLogin.setAttribute("pass",usuario.getPass());
                    sesionLogin.setAttribute("id",usuario.getId());
                    sesionLogin.setAttribute("name", usuario.getName());
                    mensaje="Bienvenido al sistema: " + usuario.getName();
                    validar = "T";
                    dispatcher =request.getRequestDispatcher("admin.jsp");
                    request.getRequestDispatcher(mensaje);


                }else{
                    System.out.println("No se encontró en la BD!");
                    mensaje = "Datos incorrectos, verifica tu usuario y/o contraseña.";
                    clase="alert alert-danger";
                    dispatcher=request.getRequestDispatcher("admin.jsp");
                    validar="F";
                    request.getRequestDispatcher(mensaje);

                }
                doGet(request,response);


                break;
            case "registrar":
                pass=request.getParameter("pass");
                user=request.getParameter("user");
                name=request.getParameter("name");
                System.out.println("nombre: " + name);
                System.out.println("user: " + user);
                System.out.println("pass: " + pass);

                usuario=new beanPerson(name,user,pass);
                if(new DaoPerson().registrarUser(usuario)){
                    mensaje="Usuario registrado correctamente!";
                    request.setAttribute("mensaje","Usuario registrado correctamente!");
                    System.out.println("El usuario ha sido registrado");
                    dispatcher =request.getRequestDispatcher("menu.jsp");
                    request.getRequestDispatcher(mensaje);
                }else{
                    mensaje="Error al registrar el usuario!";
                    request.setAttribute("mensaje","Error al registrar el usuario!");
                    dispatcher =request.getRequestDispatcher("menu.jsp");
                    request.getRequestDispatcher(mensaje);
                }
                doGet(request,response);
                break;


            case "actualizar":
                pass=request.getParameter("pass");
                user=request.getParameter("user");
                name=request.getParameter("name");
                idPersonString = request.getParameter("id")!=null?request.getParameter("id"):"0";
                int idPerson = Integer.parseInt(idPersonString);
                System.out.println("actualiza nombre: " + name);
                System.out.println("actualiza user: " + user);
                System.out.println("actualiza pass: " + pass);

                usuario=new beanPerson(idPerson,name,user,pass);
                if(new DaoPerson().updateUser(usuario)){
                    mensaje="Usuario actualizado correctamente!";
                    request.setAttribute("mensaje","Usuario actualizado correctamente!");
                    System.out.println("El usuario ha sido modificado");
                    dispatcher =request.getRequestDispatcher("menuprincipal.jsp");
                    request.getRequestDispatcher(mensaje);
                }else{
                    mensaje="Error al actualizar el usuario!";
                    request.setAttribute("mensaje","Error al actualizar el usuario!");
                    dispatcher =request.getRequestDispatcher("menuprincipal.jsp");
                    request.getRequestDispatcher(mensaje);
                }
                doGet(request,response);
                break;

            case "eliminar":
                idPersonString  = request.getParameter("id")!=null?request.getParameter("id"):"0";
                int id  = Integer.parseInt(idPersonString);
                beanPerson person=new beanPerson();
                person.setId(id);
                DaoPerson daoUser=new DaoPerson();

                if(daoUser.deleteUser(person)){
                    mensaje="Usuario eliminado correctamente!";
                    request.setAttribute("mensaje","Usuario eliminado correctamente!");
                    System.out.println("El usuario ha sido eliminado");
                    dispatcher =request.getRequestDispatcher("menuprincipal.jsp");
                    request.getRequestDispatcher(mensaje);

                }else{
                    mensaje="Error al eliminar el usuario!";
                    request.setAttribute("mensaje","Error al eliminar el usuario!");
                    dispatcher =request.getRequestDispatcher("menuprincipal.jsp");
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
