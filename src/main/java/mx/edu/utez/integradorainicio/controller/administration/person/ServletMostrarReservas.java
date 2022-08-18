package mx.edu.utez.integradorainicio.controller.administration.person;
import mx.edu.utez.integradorainicio.model.administration.person.beanPrestamo;
import mx.edu.utez.integradorainicio.service.administration.person.DaoMostrarReservas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "ServletMostrarReservas",urlPatterns ={ "/getReservas","/ServletMostrarReservas"})
public class ServletMostrarReservas extends HttpServlet {
        Logger logger = Logger.getLogger("ServletListaReservas");

        String action;
        String urlRedirect="/getReservas";
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            action = request.getServletPath();
            logger.log(Level.INFO,"GET: "+action);
            switch (action){
                case "/getReservas":
                    List<beanPrestamo> ListReservas = new DaoMostrarReservas().ListReservas();
                    request.setAttribute("ListReservas",ListReservas);
                    urlRedirect="reservas.jsp";
                    break;
            }
            request.getRequestDispatcher(urlRedirect).forward(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }
    }
