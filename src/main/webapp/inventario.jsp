<%@ page import="java.util.List" %>
<%@ page import="mx.edu.utez.integradorainicio.model.administration.person.beanEquipos" %>
<%@ page import="mx.edu.utez.integradorainicio.service.administration.person.DaoEquipos" %>



<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 04/07/2022
  Time: 01:07 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>



<%
    String user = (String) (session.getAttribute("user"));
    String pass = (String) (session.getAttribute("pass"));
    if (user!= null & pass != null){
        System.out.println("sesion: usuario: "+ user+ " pass: "+pass) ;

%>
<html>
<head>
        <title>Inventario</title>

        <link rel="stylesheet" href="css/estilosinventario.css">
        <link rel="stylesheet" href="css/estilosheader.css ">
        <link rel="stylesheet" href="css/estilos_index.css">
        <script src="inventario.js"></script>
</head>
<body>
<header>
    <div class="logo">
        <img src="img/logo-utez.png" class="logo-img">
        <h2 class="logo-nombre">Sistema de Préstamos</h2>
    </div>
    <nav>
        <a href="#" class="nav-link" >Inicio</a>
        <a href="#" class="nav-link">Cerrar Sesión</a>
    </nav>
</header>

<div class="${clase}" role="alert">
    <h4>${mensaje}</h4>
</div>


<table  border="1">
    <thead>
    <tr>
        <th>#</th>
        <th>Id_Equipo</th>
        <th>Nombre</th>
        <th>Descripcion</th>
        <th>Marca</th>
        <th>Modelo</th>
        <th>Numero de serie</th>
        <th>Disponibilidad</th>
        <th>Estado</th>
        <th>Acción</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="equipo" items="${listEquipos}" varStatus="status">
        <tr>

            <td><c:out value="${status.count}"></c:out></td>
            <td><c:out value="${equipo.id_eqo}"></c:out></td>
            <td><c:out value="${equipo.nombre}"></c:out></td>
            <td><c:out value="${equipo.descripcion}"></c:out></td>
            <td><c:out value="${equipo.marca}"></c:out></td>
            <td><c:out value="${equipo.modelo}"></c:out></td>
            <td><c:out value="${equipo.n_serie}"></c:out></td>
            <td><c:out value="${equipo.disponibilidad}"></c:out></td>
            <td><c:out value="${equipo.estado}"></c:out></td>

            <td>
                <h5>
                    <form action="ServletSesion" method="post">
                        <input type="hidden" value="eliminar" name="accion"/>
                        <input type="hidden" name="id" value="${person.id}"/>
                        <input type="submit" value="Eliminar"/>
                    </form>

                    <a href="<c:url value = "/getEquipo?id=${equipos.id_eqo}"/>"> <input type="submit" value="Modificar"/> </a></h5>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>







</body>
</html>

<% }else{
    System.out.println("No hay sesión iniciada!");
    request.getRequestDispatcher("index.jsp").forward(request,response);

}
%>