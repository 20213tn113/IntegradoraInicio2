package mx.edu.utez.integradorainicio.controller.administration.person;

import mx.edu.utez.integradorainicio.model.administration.person.beanEquipos;

import mx.edu.utez.integradorainicio.model.administration.person.beanPerson;
import mx.edu.utez.integradorainicio.service.administration.person.DaoEquipos;
import mx.edu.utez.integradorainicio.service.administration.person.DaoPerson;

import javax.servlet.RequestDispatcher;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ServletEquipos",urlPatterns ={ "/getEquipos","/getEquipo"})
public class ServletEquipos extends HttpServlet {

    Logger logger = Logger.getLogger("ServletPerson");
    String action;
    String urlRedirect = "/getEquipos";


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        logger.log(Level.INFO,"GET: "+action);

        switch (action){
            case "/getEquipo":
                List<beanEquipos> ListEquipos = new DaoEquipos().consultarEquipos();
                request.setAttribute("ListEquipos",ListEquipos);
                urlRedirect="inventario.jsp";
                break;

            default:
                List<beanEquipos> ListEquipos1 = new DaoEquipos().consultarEquipos();
                request.setAttribute("ListEquipos",ListEquipos1);
                urlRedirect="inventario.jsp";
                break;
        }
        request.getRequestDispatcher(urlRedirect).forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }



}