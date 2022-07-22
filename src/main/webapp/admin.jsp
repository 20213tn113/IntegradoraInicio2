<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>InterfazADMIN</title>
    <link rel="stylesheet" href="css/estilos.css">
    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous"> -->
    <link rel="stylesheet" href="css/headerestilo2.css">
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


            <%--@declare id="country"--%><a href="#" class="nav-link">Inicio</a>
            <!-- <a href="#" class="nav-link">Horario</a> -->
            <label for="country" class="form-label"></label>
            <select class="form-select" id="Horario">
                <option value="n" selected disabled>Horarios</option>
                <option value="n">8:00 a.m.</option>
                <option value="t">8:00 p.m.</option>
            </select>
        </nav>
    </header>

    <h1> BIENVENIDA ADMINSTRADOR </h1>
    <section>

        <div>

            <P id="div1">Consultar Inventario</P>
            <img id="img1"
                 src="img/inventario.png"
                 alt="">
            <a id="a1">Acceder</a>

        </div>

        <div>
            <P id="div1">Realizar Préstamo</P>
            <img id="img1"
                 src="img/realipres.jpg"
                 alt="">
            <a id="a1">Acceder</a>
        </div>
        <div>
            <P id="div1">Historial de Sanciones</P>
            <img id="img1"
                 src="img/sancion.jpg"
                 alt="">
            <a id="a1">Acceder</a>
        </div>
        <div>
            <P id="div1">Reservaciones Vigentes</P>
            <img id="img1"
                 src="img/reservas.png"
                 alt="">
            <a id="a1">Acceder</a>
        </div>
    </section>
</center>


</body>