package mx.edu.utez.integradorainicio.controller.administration.person;

import mx.edu.utez.integradorainicio.model.administration.person.beanEquipos;
import mx.edu.utez.integradorainicio.model.administration.person.beanPrestamo;
import mx.edu.utez.integradorainicio.model.administration.person.beanPerson;
import mx.edu.utez.integradorainicio.service.administration.person.DaoEquipos;
import mx.edu.utez.integradorainicio.service.administration.person.DaoPerson;
import mx.edu.utez.integradorainicio.service.administration.person.DaoPrestamo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletEquipos", urlPatterns = "/ServletEquipos")
public class ServletEquipos extends HttpServlet {
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

        int id_prestamoInt =0;

        String idEquipoString;
        String mensaje="";
        String clase="";
        String peticion=request.getParameter("accion");
        RequestDispatcher dispatcher=null;
        HttpSession sesionLogin;
        beanEquipos equipos;
        beanEquipos equipos2;
        String peticion2="";
        String caja ="";
        beanEquipos eq=new beanEquipos();
        String idS = "";

        switch (peticion) {
            case "actualizar":
                id2 = request.getParameter("id");
                id_eqo = request.getParameter("id_eqo");
                nombre = request.getParameter("nombre");
                descripcion = request.getParameter("descripcion");
                marca = request.getParameter("marca");
                modelo = request.getParameter("modelo");
                n_serie = request.getParameter("n_serie");
                disponibilidad = request.getParameter("disponibilidad");
                estado = request.getParameter("estado");

                idEquipoString = request.getParameter("id") != null ? request.getParameter("id") : "0";

                int idEquipos = Integer.parseInt(idEquipoString);

                equipos = new beanEquipos(idEquipos, id_eqo, nombre, descripcion, marca, modelo, n_serie, disponibilidad, estado);

                if (new DaoEquipos().updateEquipos(equipos)) {
                    mensaje = "Equipo actualizado correctamente!";
                    request.setAttribute("mensaje", "Equipo actualizado correctamente!");
                    System.out.println("El Equipo ha sido modificado");
                    dispatcher = request.getRequestDispatcher("admin.jsp");
                    request.getRequestDispatcher(mensaje);
                } else {
                    mensaje = "Error al actualizar el Equipo!";
                    request.setAttribute("mensaje", "Error al actualizar el usuario!");
                    dispatcher = request.getRequestDispatcher("admin.jsp");
                    request.getRequestDispatcher(mensaje);
                }
                doGet(request, response);
                break;

            case "eliminar":
                idEquipoString = request.getParameter("id") != null ? request.getParameter("id") : "0";
                int id = Integer.parseInt(idEquipoString);
                beanEquipos equipos1 = new beanEquipos();
                System.out.println("ID LLEGO: " + id);
                equipos1.setId(id);
                DaoEquipos daoEquipos = new DaoEquipos();

                if (daoEquipos.deleteEquipos(equipos1)) {
                    mensaje = "Usuario eliminado correctamente!";
                    request.setAttribute("mensaje", "Usuario eliminado correctamente!");
                    System.out.println("El usuario ha sido eliminado");
                    dispatcher = request.getRequestDispatcher("admin.jsp");
                    request.getRequestDispatcher(mensaje);

                } else {
                    mensaje = "Error al eliminar el usuario!";
                    request.setAttribute("mensaje", "Error al eliminar el usuario!");
                    dispatcher = request.getRequestDispatcher("admin.jsp");
                    request.getRequestDispatcher(mensaje);
                }
                doGet(request, response);
                break;


            case "registrar":


                id_eqo = request.getParameter("id_eqo");
                nombre = request.getParameter("nombre");
                descripcion = request.getParameter("descripcion");
                marca = request.getParameter("marca");
                modelo = request.getParameter("modelo");
                n_serie = request.getParameter("n_serie");
                disponibilidad = request.getParameter("disponibilidad");
                estado = request.getParameter("estado");

                equipos = new beanEquipos(id_eqo, nombre, descripcion, marca, modelo, n_serie, disponibilidad, estado);
                if (new DaoEquipos().registrarEquipos(equipos) == true) {
                    mensaje = "Equipo registrado correctamente!";
                    request.setAttribute("mensaje", "Equipo registrado correctamente!");
                    System.out.println("El Equipo ha sido registrado");
                    dispatcher = request.getRequestDispatcher("admin.jsp");
                    request.getRequestDispatcher(mensaje);
                } else {
                    mensaje = "Error al registrar el Equipo!";
                    request.setAttribute("mensaje", "Error al registrar el Equipo!");
                    dispatcher = request.getRequestDispatcher("admin.jsp");
                    request.getRequestDispatcher(mensaje);
                }
                doGet(request, response);
                break;

            case "consultaFiltro":
                int cont = 0;
                String valor = "";
                valor = request.getParameter("valor");
                String id_prestamo = request.getParameter("id_prestamo");
                String dispo = "S";
                //System.out.println("Este es el valor que llego: "+valor);
                List<beanEquipos> ListaDao = new DaoEquipos().consultarFiltro();
                //List<beanEquipos> ListEquipos1 = new DaoEquipos().consultarEquipos();
                List<beanEquipos> ListEquipos3 = new ArrayList<>();
                for (int i = 0; i < ListaDao.size(); i++) {
                    beanEquipos temporal = ListaDao.get(i);
                    //System.out.println("El nombre que sale: "+temporal.getNombre());
                    String valor1 = temporal.getNombre();
                    String valorDispo = temporal.getDisponibilidad();
                    String valorDispo2 = "S";
                    if (valor1.equals(valor)) {
                        if (valorDispo.equals(valorDispo2)) {

                            // System.out.println("PASO");
                            beanEquipos equipos5 = new beanEquipos();
                            equipos5.setId(temporal.getId());
                            equipos5.setId_eqo(temporal.getId_eqo());
                            equipos5.setNombre(temporal.getNombre());
                            equipos5.setDescripcion(temporal.getDescripcion());
                            equipos5.setMarca(temporal.getMarca());
                            equipos5.setModelo(temporal.getModelo());
                            equipos5.setN_serie(temporal.getN_serie());
                            equipos5.setDisponibilidad(temporal.getDisponibilidad());
                            equipos5.setEstado(temporal.getEstado());
                            ListEquipos3.add(equipos5);

                        }
                    }
                }


                request.setAttribute("id_prestamo", id_prestamo);
                request.setAttribute("valor", valor);
                request.setAttribute("ListEquipos", ListEquipos3);
                dispatcher = request.getRequestDispatcher("seleccion.jsp");

                break;

            case "prueba":

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

                dispatcher = request.getRequestDispatcher("menu.jsp");


                break;


            case "seleccion":

                String id_prestamo1 = request.getParameter("id_prestamo");
                int id_prestamos = Integer.parseInt(id_prestamo1);


                System.out.println("Imprimo: " + id_prestamos);


                caja = request.getParameter("id");
                id = Integer.parseInt(caja);

                if (new DaoEquipos().registrarlista(id_prestamos, id) == true) {
                }

                // id = id_prestamos;
                String dispo1 = "N";
                //beanEquipos equipos6 = new beanEquipos(id);
                //if (new DaoEquipos().updateDispo(equipos6) ==true)


                System.out.println("Imprimo id_eqo: " + id);
                if (new DaoEquipos().updateDispo2(id, dispo1) == true) {
                    System.out.println("Paso true");

                } else {
                    System.out.println("Pso False");
                }

                //esta linea envia el id del prestamo
                request.setAttribute("id_prestamo", id_prestamo1);
                //request.setAttribute("valor",valor);
                //
                peticion2 = "mostrar";
                //dispatcher =request.getRequestDispatcher("seleccion.jsp");
                break;

            case "volver":
                valor = request.getParameter("valor");
                String id_prestamo2 = request.getParameter("id_prestamo");


                List<beanEquipos> ListaDao3 = new DaoEquipos().consultarFiltro();
                //List<beanEquipos> ListEquipos1 = new DaoEquipos().consultarEquipos();

                for (int i = 0; i < ListaDao3.size(); i++) {
                    beanEquipos temporal = ListaDao3.get(i);

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
                    if (valor1.equals("BOCINAS")) {
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


                request.setAttribute("id_prestamo", id_prestamo2);

                dispatcher = request.getRequestDispatcher("menu.jsp");


                break;


            case "terminar":
                String id_prestamo9 = request.getParameter("id_prestamo");
                valor = request.getParameter("valor");

                id = Integer.parseInt(id_prestamo9);
                System.out.println("Llego el id: " + id);
                List<beanPrestamo> listaPrestamo = new DaoEquipos().list(id);
                List<beanEquipos> ListaEquipos = new ArrayList<>();

                //List<beanEquipos> ListaEquipos = new DaoEquipos().consultarFiltro();
                //List<beanEquipos> ListEquipos1 = new DaoEquipos().consultarEquipos();

                for (int i = 0; i < listaPrestamo.size(); i++) {
                    beanPrestamo temporal = listaPrestamo.get(i);
                    id = Integer.parseInt(temporal.getId_eqo());
                    System.out.println("Trato con esta ID: " + id);
                    beanEquipos eqs = new DaoEquipos().obtenerEquipos(id);
                    System.out.println("Imprimo el id eqs: " + eqs.getId());
                    ListaEquipos.add(eqs);
                }


                request.setAttribute("id_prestamo", id_prestamo9);
                request.setAttribute("valor", valor);
                request.setAttribute("ListEquipos", ListaEquipos);
                dispatcher = request.getRequestDispatcher("prestamoFinal.jsp");

                break;

            case "borrarseleccion":
                id_prestamo9 = request.getParameter("id_prestamo");
                valor = request.getParameter("valor");
                id2 = request.getParameter("id");

                id_prestamoInt = Integer.parseInt(id_prestamo9);
                id = Integer.parseInt(id2);

                boolean da = new DaoEquipos().deleteSeleccion(id,id_prestamoInt);
                boolean da1 = new DaoEquipos().updateDispo3(id);


                List<beanPrestamo> listaPrestamo1 = new DaoEquipos().list(id_prestamoInt);
                ListaEquipos = new ArrayList<>();


                for (int i = 0; i < listaPrestamo1.size(); i++) {
                    beanPrestamo temporal = listaPrestamo1.get(i);
                    id = Integer.parseInt(temporal.getId_eqo());
                    System.out.println("Trato con esta ID: " + id);
                    beanEquipos eqs = new DaoEquipos().obtenerEquipos(id);
                    System.out.println("Imprimo el id eqs: " + eqs.getId());
                    ListaEquipos.add(eqs);

                }

                request.setAttribute("id_prestamo", id_prestamoInt);
                request.setAttribute("valor", valor);
                request.setAttribute("ListEquipos", ListaEquipos);
                dispatcher = request.getRequestDispatcher("prestamoFinal.jsp");


                break;
            default:
                break;

        }


        switch (peticion2){
            case "mostrar":
                String valor = request.getParameter("valor");
                valor = request.getParameter("valor");
                String id_prestamo = request.getParameter("id_prestamo");

                id_eqo = request.getParameter("id_eqo2");
                String dispo = "S";
                System.out.println("Este es el valor que llego: "+valor);
                List<beanEquipos> ListaDao = new DaoEquipos().consultarFiltro();
                //List<beanEquipos> ListEquipos1 = new DaoEquipos().consultarEquipos();
                List<beanEquipos> ListEquipos3 = new ArrayList<>();
                for (int i = 0; i < ListaDao.size(); i++) {
                    beanEquipos temporal = ListaDao.get(i);
                    //System.out.println("El nombre que sale: "+temporal.getNombre());
                    String valor1 = temporal.getNombre();
                    String valorDispo = temporal.getDisponibilidad();
                    String valorDispo2 = "S";
                    if (valor1.equals(valor)){
                        if (valorDispo.equals(valorDispo2)){

                            //System.out.println("PASO");
                            beanEquipos equipos5 = new beanEquipos();
                            equipos5.setId(temporal.getId());
                            equipos5.setId_eqo(temporal.getId_eqo());
                            equipos5.setNombre(temporal.getNombre());
                            equipos5.setDescripcion(temporal.getDescripcion());
                            equipos5.setMarca(temporal.getMarca());
                            equipos5.setModelo(temporal.getModelo());
                            equipos5.setN_serie(temporal.getN_serie());
                            equipos5.setDisponibilidad(temporal.getDisponibilidad());
                            equipos5.setEstado(temporal.getEstado());
                            ListEquipos3.add(equipos5);

                        }
                    }
                }


                request.setAttribute("valor",valor);
                request.setAttribute("ListEquipos",ListEquipos3);
                request.setAttribute("id_prestamo",id_prestamo);

                dispatcher =request.getRequestDispatcher("seleccion.jsp");

                break;
        }






        request.setAttribute("mensaje",mensaje);
        request.setAttribute("clase",clase);
        dispatcher.forward(request,response);
    }



    }
