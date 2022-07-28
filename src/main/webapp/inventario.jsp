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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



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

</head>
<body>
<header>
    <div class="logo">
        <img src="img/logo-utez.png" class="logo-img">
        <h2 id="h12">Inventario</h2>
    </div>
    <nav>
        <a href="admin.jsp" class="nav-link" >Regresar</a>
    </nav>
</header>

<div class="${clase}" role="alert">
    <h4>${mensaje}</h4>
</div>

<div id="divScroll">


    <table border="1">
        <thead>
        <tr>

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
        <c:forEach var="equipos" items="${ListEquipos}" varStatus="status">
            <tr>


                <td><c:out value="${equipos.id_eqo}"></c:out></td>
                <td><c:out value="${equipos.nombre}"></c:out></td>
                <td><c:out value="${equipos.descripcion}"></c:out></td>
                <td><c:out value="${equipos.marca}"></c:out></td>
                <td><c:out value="${equipos.modelo}"></c:out></td>
                <td><c:out value="${equipos.n_serie}"></c:out></td>
                <td><c:out value="${equipos.disponibilidad}"></c:out></td>
                <td><c:out value="${equipos.estado}"></c:out></td>

                <td>
                    <h5>
                        <form action="ServletEquipos" method="post">
                            <input type="hidden" value="eliminar" name="accion"/>
                            <input type="hidden" name="id" value="${equipos.id}"/>
                            <input class="boton" type="submit" value="Eliminar"/>
                        </form>

                        <a class="boton" href="<c:url value = "/getEquipo?id=${equipos.id}"/>"> <input class="boton" type="submit" value="Modificar"/> </a></h5>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>






</body>
</html>

<% }else{
    System.out.println("No hay sesión iniciada!");
    request.getRequestDispatcher("index.jsp").forward(request,response);

}
%>