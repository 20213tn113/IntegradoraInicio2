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

    <form action="ServletEquipos" method="post">
        <fieldset>
            <legend>Agregar nuevo equipo</legend>
            <p><label>Id de Equipo:</label> <input type="text" name="id_eqo" /></p>
            <p><label>Nombre:</label> <input type="text" name="nombre" /></p>
            <p><label>Descripción:</label> <input type="text" name="descripcion" /></p>
            <p><label>Marca:</label> <input type="text" name="marca" /></p>
            <p><label>Modelo:</label> <input type="text" name="modelo" /></p>
            <p><label>Numero de Serie:</label> <input type="text" name="n_serie" /></p>
            <p><label>Disponibilidad:</label> <input type="text" name="disponibilidad"/></p>
            <p><label>Estado de Equipo:</label> <input type="text" name="estado" /></p>

            <input type="hidden" value="registrar" name="accion">
            <input type="submit" value="Registrar Equipo"/>
        </fieldset>
    </form>
</div>
</body>
</html>

<% }else{
    System.out.println("No hay sesión iniciada!");
    request.getRequestDispatcher("index.jsp").forward(request,response);

    }
%>