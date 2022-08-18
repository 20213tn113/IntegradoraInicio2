<%@ page import="mx.edu.utez.integradorainicio.service.administration.person.DaoEquipos" %>
<%@ page import="mx.edu.utez.integradorainicio.model.administration.person.beanEquipos" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 27/06/2022
  Time: 01:25 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String user = (String) (session.getAttribute("user"));
    String pass = (String) (session.getAttribute("pass"));
    if (user!= null & pass != null){
        System.out.println("sesion: usuario: "+ user+ " pass: "+pass) ;

%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/estilosmenu.css">
    <link rel="stylesheet" href="css/estilosheader.css">
    <link rel="stylesheet" href="css/sweetalert2.min.css">
</head>

<body>
<header>
    <div class="logo">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Logo-utez.png/300px-Logo-utez.png"
             alt="">
        <h2 id="h12">MENÚ PRESTAMOS DE EQUIPO</h2>
    </div>
    <nav>

        <form action="ServletEquipos" method="post">
            <a href="admin.jsp" class="nav-link">Cancelar Prestamo</a>
            <input type="hidden" value="terminar" name="accion"/>
            <input type="hidden"  value="${id_prestamo}" id="id_prestamo" name="id_prestamo"/>
            <input class="botonHe1" type="submit" value="Finalizar Seleccion"/>
        </form>


        <!-- <a href="#" class="nav-link">Horario</a> -->
    </nav>
</header>

<!--
CUADRO DE BUSQUEDA DE DISPOSITIVOS POR ALGO ESCRITO
<div style="padding-left: 20px">
    <label id="text1">  Buscar:</label>   <input value="" type="text" class="form-control pull-right" style="width:20%" id="search" placeholder="Ingrese un dato...">
    <button>Buscar en esta categoria</button>
</div>
-->


<section>
    <div>
        <P id="div1">SWITCHES</P>

        <img id="img1"
             src="img/switch.jpeg"
             alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES <LABEL>${sw1}</LABEL> </p>
        <p id="div4">Solicítalo</p>
        <form action="ServletEquipos" method="post">
            <input type="hidden" value="consultaFiltro" name="accion"/>
            <input type="hidden" name="valor" id="valor" value="SWITCH"/>
            <input type="hidden"  value="${id_prestamo}" id="id_prestamo" name="id_prestamo"/>
            <input id="a1" type="submit" value="Escoger"
                    <c:choose>
                        <c:when test="${sw1=='0'}">
                            disabled="true"
                        </c:when>
                    </c:choose>
            />
        </form>


    </div>
    <div>
        <P id="div1">ROUTER</P>
        <img id="img1"
             src="img/router.jpeg"
             alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES <LABEL>${rou}</LABEL></p>
        <p id="div4">Solicítalo</p>
        <form action="ServletEquipos" method="post">
            <input type="hidden" value="consultaFiltro" name="accion"/>
            <input type="hidden" name="valor" id="valor" value="ROUTER"/>
            <input type="hidden"  value="${id_prestamo}" id="id_prestamo" name="id_prestamo"/>
            <input id="a1" type="submit" value="Escoger"
                    <c:choose>
                        <c:when test="${rou=='0'}">
                            disabled="true"
                        </c:when>
                    </c:choose>
            />
        </form>
      <!--  <a id="a1">Escoger</a> -->
    </div>
    <div>
        <P id="div1">LAPTOP</P>
        <img id="img1" src="img/computadora.jpeg" alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES <LABEL>${lap}</LABEL> </p>
        <p id="div4">Solicítalo</p>
        <form action="ServletEquipos" method="post">
            <input type="hidden" value="consultaFiltro" name="accion"/>
            <input type="hidden" name="valor" id="valor" value="LAPTOP"/>
            <input type="hidden"  value="${id_prestamo}" id="id_prestamo" name="id_prestamo"/>
            <input id="a1" type="submit" value="Escoger"
                    <c:choose>
                        <c:when test="${lap=='0'}">
                            disabled="true"
                        </c:when>
                    </c:choose>
            />
        </form>

    </div>
    <div>
        <P id="div1">IPAD</P>
        <img id="img1"
             src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZJciH7cM83hw35SuVyyrJ4KdjeadcCRBw7g&usqp=CAU"
             alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES <LABEL>${ipad}</LABEL> </p>
        <p id="div4">Solicítalo</p>
        <form action="ServletEquipos" method="post">
            <input type="hidden" value="consultaFiltro" name="accion"/>
            <input type="hidden" name="valor" id="valor" value="IPAD"/>
            <input type="hidden"  value="${id_prestamo}" id="id_prestamo" name="id_prestamo"/>
            <input id="a1" type="submit" value="Escoger"
                    <c:choose>
                        <c:when test="${ipad=='0'}">
                            disabled="true"
                        </c:when>
                    </c:choose>
            />
        </form>
    </div>

</section>
<section>
    <div>
        <P id="div1">TABLET</P>
        <img id="img1" src="https://m.media-amazon.com/images/I/61nONxSFUnL._AC_SY355_.jpg" alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES <LABEL>${table}</LABEL>  </p>
        <p id="div4">Solicítalo</p>
        <form action="ServletEquipos" method="post">
            <input type="hidden" value="consultaFiltro" name="accion"/>
            <input type="hidden" name="valor" id="valor" value="TABLET"/>
            <input type="hidden"  value="${id_prestamo}" id="id_prestamo" name="id_prestamo"/>
            <input id="a1" type="submit" value="Escoger"
                    <c:choose>
                        <c:when test="${table=='0'}">
                            disabled="true"
                        </c:when>
                    </c:choose>
            />
        </form>
    </div>
    <div>
        <P id="div1">CELULAR</P>
        <img id="img1" src="https://mejores10.com/images/10001198/2995/1498217448_5490.jpg" alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES <LABEL>${celu}</LABEL> </p>
        <p id="div4">Solicítalo</p>
        <form action="ServletEquipos" method="post">
            <input type="hidden" value="consultaFiltro" name="accion"/>
            <input type="hidden" name="valor" id="valor" value="CELULAR"/>
            <input type="hidden"  value="${id_prestamo}" id="id_prestamo" name="id_prestamo"/>
            <input id="a1" type="submit" value="Escoger"
                    <c:choose>
                        <c:when test="${celu=='0'}">
                            disabled="true"
                        </c:when>
                    </c:choose>
            />
        </form>
    </div>
    <div>
        <P id="div1">TELÉFONO</P>
        <img id="img1" src="https://myrealmobile.com/images/thumbs/0001257_big-button-speakerphone.jpeg" alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES <LABEL>${tele}</LABEL> </p>
        <p id="div4">Solicítalo</p>
        <form action="ServletEquipos" method="post">
            <input type="hidden" value="consultaFiltro" name="accion"/>
            <input type="hidden" name="valor" id="valor" value="TELEFONO"/>
            <input type="hidden"  value="${id_prestamo}" id="id_prestamo" name="id_prestamo"/>
            <input id="a1" type="submit" value="Escoger"
                    <c:choose>
                        <c:when test="${tele=='0'}">
                            disabled="true"
                        </c:when>
                    </c:choose>
            />
        </form>
    </div>
    <div>
        <P id="div1">PUNTO DE ACCESO</P>
        <img id="img1" src="https://www.comunicacionesinalambricashoy.com/imagenes/2016/10/Netgear-WAC104.jpg"
             alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES <LABEL>${pun}</LABEL> </p>
        <p id="div4">Solicítalo</p>
        <form action="ServletEquipos" method="post">
            <input type="hidden" value="consultaFiltro" name="accion"/>
            <input type="hidden" name="valor" id="valor" value="PUNTO DE ACCESO"/>
            <input type="hidden"  value="${id_prestamo}" id="id_prestamo" name="id_prestamo"/>
            <input id="a1" type="submit" value="Escoger"
                    <c:choose>
                        <c:when test="${pun=='0'}">
                            disabled="true"
                        </c:when>
                    </c:choose>
            />
        </form>
    </div>

</section>
<section>
    <div>
        <P id="div1">BOCINAS</P>
        <img id="img1"
             src="http://cdn.shopify.com/s/files/1/0428/3357/6102/products/techzonebocinasinalambricasbluetoothtzboctws01_1200x1200.jpg?v=1618411052"
             alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES <LABEL>${boci}</LABEL> </p>
        <p id="div4">Solicítalo</p>
        <form action="ServletEquipos" method="post">
            <input type="hidden" value="consultaFiltro" name="accion"/>
            <input type="hidden" name="valor" id="valor" value="BOCINAS"/>
            <input type="hidden"  value="${id_prestamo}" id="id_prestamo" name="id_prestamo"/>
            <input id="a1" type="submit" value="Escoger"
                    <c:choose>
                        <c:when test="${boci=='0'}">
                            disabled="true"
                        </c:when>
                    </c:choose>
            />
        </form>
    </div>
    <div>
        <P id="div1">CPU</P>
        <img id="img1" src="https://definicion.mx/wp-content/uploads/2013/06/CPU.jpg" alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES <LABEL>${cpu}</LABEL></p>
        <p id="div4">Solicítalo</p>
        <form action="ServletEquipos" method="post">
            <input type="hidden" value="consultaFiltro" name="accion"/>
            <input type="hidden" name="valor" id="valor" value="CPU"/>
            <input type="hidden"  value="${id_prestamo}" id="id_prestamo" name="id_prestamo"/>
            <input id="a1" type="submit" value="Escoger"
                    <c:choose>
                        <c:when test="${cpu=='0'}">
                            disabled="true"
                        </c:when>
                    </c:choose>
            />
        </form>
    </div>
    <div>
        <P id="div1">VIDEO PROYECTOR DIGITAL</P>
        <img id="img1" src="img/proyectordigital.png "alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES <LABEL>${vpd}</LABEL> </p>
        <p id="div4">Solicítalo</p>
        <form action="ServletEquipos" method="post">
            <input type="hidden" value="consultaFiltro" name="accion"/>
            <input type="hidden" name="valor" id="valor" value="VIDEO PROYECTOR DIGITAL"/>
            <input type="hidden"  value="${id_prestamo}" id="id_prestamo" name="id_prestamo"/>
            <input id="a1" type="submit" value="Escoger"
                    <c:choose>
                        <c:when test="${vpd=='0'}">
                            disabled="true"
                        </c:when>
                    </c:choose>
            />
        </form>
    </div>

    <div>
        <P id="div1">kIT HERRAMIENTAS</P>
        <img id="img1" src="https://i.linio.com/p/68e8bb1927919329374aa9cc07f8dff0-product.jpg" alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES <LABEL>${herra}</LABEL> </p>
        <p id="div4">Solicítalo</p>
        <form action="ServletEquipos" method="post">
            <input type="hidden" value="consultaFiltro" name="accion"/>
            <input type="hidden" name="valor" id="valor" value="KIT HERRAMIENTAS"/>
            <input type="hidden"  value="${id_prestamo}" id="id_prestamo" name="id_prestamo"/>
            <input id="a1" type="submit" value="Escoger"
                    <c:choose>
                        <c:when test="${herra=='0'}">
                            disabled="true"
                        </c:when>
                    </c:choose>
            />
        </form>
    </div>

</section>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="js/accionesMenu.js"></script>
<script src="js/sweetalert2.all.min.js"></script>

</body>
</html>

<% }else{
    System.out.println("No hay sesión iniciada!");
    request.getRequestDispatcher("index.jsp").forward(request,response);

}
%>