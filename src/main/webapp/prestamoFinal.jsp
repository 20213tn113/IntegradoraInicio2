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
    <title>Seleccione su equipo</title>

    <link rel="stylesheet" href="css/estilosinventario.css">
    <link rel="stylesheet" href="css/estilosbotones.css">
    <link rel="stylesheet" href="css/estilosheader.css ">
    <link rel="stylesheet" href="css/sweetalert2.min.css">

</head>
<body>
<header>
    <div class="logo">
        <img src="img/logo-utez.png" class="logo-img">
        <h2 id="h12">Seleccione su Equipo</h2>
    </div>
    <nav>
        <form action="ServletEquipos" method="post">
            <input class="boton4" value="Terminar Prestamo" type="button" onclick="FinalizarPrestamo()">
            <input type="hidden" value="volver" name="accion"/>
            <input type="hidden" name="valor" id="valor" value="SWITCH"/>
            <input type="hidden"  value="${id_prestamo}" id="id_prestamo" name="id_prestamo"/>
            <input type="hidden" value="${valor}"  id="valor" name="valor" />
            <input  class="boton4" type="submit" value="Volver"/>
        </form>


    </nav>
</header>

<div class="${clase}" role="alert">
    <h4>${mensaje}</h4>
</div>

<div class="acciones">

    <label id="text1">  Buscar:</label>   <input   type="text" class="form-control pull-right" style="width:20%" id="search" >

</div>




<div id="divScroll">


    <table border="1" id="mytable">
        <thead>
        <tr>

            <th>Id_Equipo</th>
            <th>Nombre</th>
            <th>Descripción</th>
            <th>Marca</th>
            <th>Modelo</th>
            <th>Número de serie</th>
            <th>Disponibilidad</th>
            <th>Estado</th>
            <th >Acción</th>
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
                <td  >
                    <c:choose>
                        <c:when test="${equipos.disponibilidad=='S'}">
                            Si

                        </c:when>
                        <c:otherwise>
                            No

                        </c:otherwise>
                    </c:choose>
                </td>

                <td>
                    <c:choose>
                        <c:when test="${equipos.estado=='F'}">
                            Funcional

                        </c:when>
                        <c:otherwise>
                            No Funcional

                        </c:otherwise>
                    </c:choose>
                </td>


                <td>



                        <form action="ServletEquipos" method="post">
                            <input type="hidden" value="borrarseleccion" name="accion"/>
                            <input type="hidden" value="${equipos.id}" id="id" name="id">
                            <input type="hidden"  value="${id_prestamo}" id="id_prestamo" name="id_prestamo"/>
                            <input type="hidden" value="${valor}"  id="valor" name="valor" />
                            <button class="borrar" type="submit" value="Seleccionar" > <ion-icon name="trash-sharp" size="small" ></ion-icon></button>
                        </form>


                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

<!--Escrip de busqueda dinamica -->

<script>
    // Write on keyup event of keyword input element
    $(document).ready(function(){
        $("#search").keyup(function(){
            _this = this;
            // Show only matching TR, hide rest of them
            $.each($("#mytable tbody tr"), function() {
                var conta;
                if($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1)
                    $(this).hide();
                else
                    $(this).show();
            });
        });
    });
</script>




<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="js/accionesInventario.js"></script>
<script src="js/sweetalert2.all.min.js"></script>
<script src="js/accionesprestamoFinal.js"></script>




</body>
</html>

<% }else{
    System.out.println("No hay sesión iniciada!");
    request.getRequestDispatcher("index.jsp").forward(request,response);

}
%>