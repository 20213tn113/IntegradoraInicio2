package mx.edu.utez.integradorainicio.controller.administration.person;

import mx.edu.utez.integradorainicio.model.administration.person.beanEquipos;
import mx.edu.utez.integradorainicio.model.administration.person.beanPrestamo;
import mx.edu.utez.integradorainicio.service.administration.person.DaoEquipos;
import mx.edu.utez.integradorainicio.service.administration.person.DaoLista;
import mx.edu.utez.integradorainicio.service.administration.person.DaoReservar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletReservar")
public class ServletReservar extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matricula= request.getParameter("matricula");
        String nombre= request.getParameter("nombre");
        String apellido= request.getParameter("apellido");
        String correo= request.getParameter("correo");
        String rol= request.getParameter("rol");
        String fecha= request.getParameter("fecha");
        String hora_inicio= request.getParameter("hora_inicio");
        String hora_final= request.getParameter("hora_final");
        System.out.println("HORA "+hora_inicio);
        int var1 = 0;
        int var2 = 0;
        int var3 = 0;
        int var4 = 0;
        int var5 = 0;
        int var6 = 0;
        int var7 = 0;
        int var8 = 0;
        int var9 = 0;
        int var10 = 0;
        int var11 = 0;
        int var12 = 0;

        //DAORESERVAR-METODO Prestatario
        beanPrestamo user = new beanPrestamo(matricula,nombre,apellido,correo,rol);

        boolean bandera2= new DaoReservar().prestatario(user);
        if(bandera2){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
        request.setAttribute("prestatario",user);

        //DAORESERVAR-METODO RegistrarReserva
        if(new DaoReservar().registrarReserva(matricula,hora_inicio, hora_final)!=false){
            System.out.println("true");
        }else {
            System.out.println("false");
        }

         beanPrestamo prestaDatos = new DaoReservar().idReserva(matricula, hora_inicio);

        System.out.println("El id que se genero es esto: "+prestaDatos.getId_prestamo());
        request.setAttribute("id_prestamo",prestaDatos.getId_prestamo());


        List<beanEquipos> ListaDao1 = new DaoEquipos().consultarFiltro();
        //List<beanEquipos> ListEquipos1 = new DaoEquipos().consultarEquipos();

        for (int i = 0; i < ListaDao1.size(); i++) {
            beanEquipos temporal = ListaDao1.get(i);

            // System.out.println("El nombre que sale: "+temporal.getNombre());

            String valor1 = temporal.getNombre();
            String valorDispo = temporal.getDisponibilidad();
            String valorDispo2 = "S";
            if (valor1.equals("SWITCH")) {
                if (valorDispo.equals(valorDispo2)) {
                    var1 = var1 + 1;
                }
            }
            if (valor1.equals("ROUTER")) {
                if (valorDispo.equals(valorDispo2)) {
                    var2 = var2 + 1;
                }
            }
            if (valor1.equals("LAPTOP")) {
                if (valorDispo.equals(valorDispo2)) {
                    var3 = var3 + 1;
                }
            }
            if (valor1.equals("IPAD")) {
                if (valorDispo.equals(valorDispo2)) {
                    var4 = var4 + 1;
                }
            }
            if (valor1.equals("TABLET")) {
                if (valorDispo.equals(valorDispo2)) {
                    var5 = var5 + 1;
                }
            }
            if (valor1.equals("CELULAR")) {
                if (valorDispo.equals(valorDispo2)) {
                    var6 = var6 + 1;
                }
            }
            if (valor1.equals("TELEFONO")) {
                if (valorDispo.equals(valorDispo2)) {
                    var7 = var7 + 1;
                }
            }
            if (valor1.equals("PUNTO DE ACCESO")) {
                if (valorDispo.equals(valorDispo2)) {
                    var8 = var8 + 1;
                }
            }
            if (valor1.equals("BOCINA")) {
                if (valorDispo.equals(valorDispo2)) {
                    var9 = var9 + 1;
                }
            }
            if (valor1.equals("CPU")) {
                if (valorDispo.equals(valorDispo2)) {
                    var10 = var10 + 1;
                }
            }

            if (valor1.equals("VIDEO PROYECTOR DIGITAL")) {
                if (valorDispo.equals(valorDispo2)) {
                    var11 = var11 + 1;
                }
            }
            if (valor1.equals("HERRAMIENTAS")) {
                if (valorDispo.equals(valorDispo2)) {
                    var12 = var12 + 1;
                }
            }
        }

        request.setAttribute("sw1", var1);
        request.setAttribute("rou", var2);
        request.setAttribute("lap", var3);
        request.setAttribute("ipad", var4);
        request.setAttribute("table", var5);
        request.setAttribute("celu", var6);
        request.setAttribute("tele", var7);
        request.setAttribute("pun", var8);
        request.setAttribute("boci", var9);
        request.setAttribute("cpu", var10);
        request.setAttribute("vpd", var11);
        request.setAttribute("herra", var12);



        //solo listar
        RequestDispatcher view = getServletContext().getRequestDispatcher("/menu.jsp");
        view.forward(request,response);
    }

}
