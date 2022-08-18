<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="css/estilosheader.css">
    <link rel="stylesheet" href="css/estilosUpdateEquipos.css">
    <link rel="stylesheet" href="css/sweetalert2.min.css">

</head>
<body>

<header>
    <div class="logo">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Logo-utez.png/300px-Logo-utez.png"
             alt="">
        <h2 id="h12">MODIFICAR EQUIPO</h2>
    </div>
    <nav>
        <a href="getEquipos" class="nav-link">Regresar</a>
    </nav>
</header>

<div class="principal">


        <fieldset>
            <h2><label>Actualización de Equipo</label></h2>

            <p><label>Id de Equipo: </label> <input type="text" id="id_eqo" name="id_eqo" value="${equipos.id_eqo}"/></p>
            <p><label>Nombre: </label> <input type="text" id="nombre" name="nombre" value="${equipos.nombre}"/></p>
            <p><label>Descripción: </label> <input type="text" id="descripcion" name="descripcion" value="${equipos.descripcion}"/></p>
            <p><label>Marca: </label> <input type="text" id="marca" name="marca" value="${equipos.marca}"/></p>
            <p><label>Modelo: </label> <input type="text" id="modelo" name="modelo" value="${equipos.modelo}"/></p>
            <p><label>Numero de Serie: </label> <input type="text"  id="n_serie" name="n_serie" value="${equipos.n_serie}"/></p>

            <p><label>Disponibilidad: </label>
                <select id="disponibilidad" name="disponibilidad">
                <option
                        <c:choose>
                            <c:when test="${equipos.disponibilidad=='S'}">
                                selected

                            </c:when>
                        </c:choose>
                        value="S">SI</option>

                <option
                        <c:choose>
                            <c:when test="${equipos.disponibilidad=='N'}">
                                selected

                            </c:when>
                        </c:choose>
                        value="N">NO</option>

            </select></p>


            <p><label>Estado de Equipo:  </label>

                <select id="estado" name="estado">

                    <option
                            <c:choose>
                                <c:when test="${equipos.estado=='F'}">
                                    selected

                                </c:when>
                            </c:choose>
                            value="F">Funcional</option>

                    <option
                            <c:choose>
                                <c:when test="${equipos.estado=='N'}">
                                    selected

                                </c:when>
                            </c:choose>
                            value="N">NO Funcional</option>

                </select>
            </p>

            <input type="hidden" value="actualizar" name="accion"/>
            <input type="hidden" id="id" name="id" value="${equipos.id}"/>

            <input id="updateEquipos" class="boton" type="button" onclick="modificarEquipos()" value="Actualizar Datos">

        </fieldset>

</div>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="js/accionesUpdateEquipo.js"></script>
<script src="js/sweetalert2.all.min.js"></script>




</body>
</html>
<% }else{
    System.out.println("No hay sesión iniciada!");
    request.getRequestDispatcher("index.jsp").forward(request,response);

}
%>