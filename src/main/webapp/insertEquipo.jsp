<%@ page import="mx.edu.utez.integradorainicio.service.administration.person.DaoEquipos" %>
<%@ page import="mx.edu.utez.integradorainicio.model.administration.person.beanEquipos" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 28/07/2022
  Time: 11:13 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String user=(String)(session.getAttribute("user"));
    String pass=(String)(session.getAttribute("pass"));
    if(user != null && pass !=null){
        System.out.println("sesión: usuario: " + user + " pass: " +pass);

%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/estilosheader.css">
    <link rel="stylesheet" href="css/estilosInsertEquipo.css">
    <link rel="stylesheet" href="css/sweetalert2.min.css">

</head>
<body>

<header>
    <div class="logo">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Logo-utez.png/300px-Logo-utez.png"
             alt="">
        <h2 id="h12">AGREGAR EQUIPO</h2>
    </div>
    <nav>
        <a href="getEquipos" class="nav-link">Regresar</a>
    </nav>
</header>



<div class="principal">


    <div class="${clase}" role="alert">
        <h4>${jsonData}</h4>
    </div>

            <%

        DaoEquipos dao= new DaoEquipos();
        beanEquipos u = new beanEquipos();
        List<beanEquipos> uno = dao.consultarEquipos();
        for (int i = 0; i < uno.size(); i++) {
            //Guardo temporalmente al celular en posición i
            beanEquipos temporal = uno.get(i);
            //Creo un arreglo con el tamaño que es el numero de columnas
            String[] fila = new String[9];
            //Asigno valor a cada una de las posiciones de mi arreglo
            fila[0] = temporal.getId() +"";
            fila[1] = temporal.getId_eqo() + "";
            fila[2] = temporal.getNombre() + "";
            fila[3] = temporal.getDescripcion() + "";
            fila[4] = temporal.getMarca() + "";
            fila[5] = temporal.getModelo() + "";
            fila[6] = temporal.getN_serie() + "";
            fila[7] = temporal.getDisponibilidad() + "";
            fila[8] = temporal.getEstado() + "";

    %>
            <input type="hidden" name="id_eqo2[]" id="id_eqo2[]" value="<%=fila[1]%>">
            <input type="hidden" name="n_serie2[]" id="n_serie2[]" value="<%=fila[6]%>">
            <%
        }

    %>


        <fieldset>

            <h2><label>Agregar de Equipo</label></h2>

            <p><label>Id de Equipo:</label> <input onchange="validarId_eqo()" type="text" name="id_eqo" id="id_eqo" /></p>
            <p><label>Nombre:</label> <input type="text" name="nombre" id="nombre"/></p>
            <p><label>Descripción:</label> <input type="text" name="descripcion" id="descripcion" /></p>
            <p><label>Marca:</label> <input type="text" name="marca" id="marca" /></p>
            <p><label>Modelo:</label> <input type="text" name="modelo"  id="modelo"/></p>
            <p><label>Número de Serie:</label> <input onchange="validarId_eqo()" type="text" name="n_serie" id="n_serie"/></p>
            <p><label>Disponibilidad:</label>
                <select name="disponibilidad" id="disponibilidad">
                    <option value="S">Si disponible</option>
                    <option value="N">NO disponible</option>
                </select>
            </p>

            <p><label>Estado:</label>
                <select name="estado" id="estado">
                    <option value="F">Funcional</option>
                    <option value="N">No Funcional</option>
                </select>
            </p>



            <input type="hidden" value="registrar" name="accion">

            <input id="insertEquipos" class="boton" type="button" value="Registrar Equipo" onclick="insertarEquipos()" />
        </fieldset>

    <div class="${clase}" role="alert">
        <h4>${mensaje}</h4>
    </div>


</div>




<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="js/accionesInsertEquipo.js"></script>
<script src="js/sweetalert2.all.min.js"></script>


</body>
</html>

<% }else{
    System.out.println("No hay sesión iniciada!");
    request.getRequestDispatcher("index.jsp").forward(request,response);

    }
%>