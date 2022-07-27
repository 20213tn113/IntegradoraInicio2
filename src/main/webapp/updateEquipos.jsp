<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 22/07/2022
  Time: 05:20 p. m.
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
</head>
<body>

<form action="ServletEquipos" method="post">
    <fieldset>
        <legend>Actualización de usuario</legend>
        <p><label>Id de Equipo:</label> <input type="text" name="id_eqo" value="${equipos.id_eqo}"/></p>
        <p><label>Nombre:</label> <input type="text" name="nombre" value="${equipos.nombre}"/></p>
        <p><label>Descripción:</label> <input type="text" name="descripcion" value="${equipos.descripcion}"/></p>
        <p><label>Marca:</label> <input type="text" name="marca" value="${equipos.marca}"/></p>
        <p><label>Modelo:</label> <input type="text" name="modelo" value="${equipos.modelo}"/></p>
        <p><label>Numero de Serie:</label> <input type="text" name="n_serie" value="${equipos.n_serie}"/></p>
        <p><label>Disponibilidad:</label> <input type="text" name="disponibilidad" value="${equipos.disponibilidad}"/></p>
        <p><label>Estado de Equipo:</label> <input type="text" name="estado" value="${equipos.estado}"/></p>
        <input type="hidden" value="actualizar" name="accion"/>
        <input type="hidden" name="id" value="${equipos.id}"/>
        <input type="submit" value="Actualizar Datos"/>
    </fieldset>
</form>
</body>
</html>
<% }else{
    System.out.println("No hay sesión iniciada!");
    request.getRequestDispatcher("index.jsp").forward(request,response);

}
%>