<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String user = (String) (session.getAttribute("user"));
    String pass = (String) (session.getAttribute("pass"));
    if (user!= null & pass != null){
        System.out.println("sesion: usuario: "+ user+ " pass: "+pass) ;

%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>InterfazADMIN</title>
    <link rel="stylesheet" href="css/estilos.css">
    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous"> -->
    <link rel="stylesheet" href="css/estilosSanciones.css">
    <link rel="stylesheet" href="css/menuestilo2.css">
    <link rel="stylesheet" href="css/estilos.css">
    <script src="bootstrap-5.2.0-beta1-dist/js/bootstrap.esm.min.js.map"></script>
</head>
<body>
<center>
    <header>
        <div class="logo">
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Logo-utez.png/300px-Logo-utez.png"
                 class="logo-img">
            <h2 id="h12" class="logo-nombre">Sistema de Préstamos</h2>
        </div>
        <nav>


            <%--@declare id="country"--%><a href="cerrarSesion" class="nav-link">Cerrar Sesión</a>
            <!-- <a href="#" class="nav-link">Horario</a> -->
            <label for="country" class="form-label"></label>

        </nav>
    </header>
    <div class="${clase}" role="alert">
        <h4>${mensaje}</h4>
    </div>

    <section>

        <div>

            <P id="div1">Consultar Inventario</P>
            <img id="img1"
                 src="img/inventario.png"
                 alt="">
            <a id="a1" href="getEquipos">Acceder</a>

        </div>

        <div>
            <P id="div1">Realizar Préstamo</P>
            <img id="img1"
                 src="img/realipres.jpg"
                 alt="">
            <a id="a1" href="menu.jsp">Acceder</a>
        </div>
        <div>
            <P id="div1">Historial de Sanciones</P>
            <img id="img1"
                 src="img/sancion.jpg"
                 alt="">
            <a id="a1" href="sanciones.jsp">Acceder</a>
        </div>
        <div>
            <P id="div1">Reservaciones Vigentes</P>
            <img id="img1"
                 src="img/reservas.png"
                 alt="">
            <a id="a1" href="reservas.jsp">Acceder</a>
        </div>
    </section>
</center>


</body>

<% }else{
    System.out.println("No hay sesión iniciada!");
    request.getRequestDispatcher("index.jsp").forward(request,response);

}
%>