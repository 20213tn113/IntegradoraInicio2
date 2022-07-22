<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/estilos.css">

    <!-- link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous"> -->
    <link rel="stylesheet" href="css/headerestilo2.css">
    <script src="bootstrap-5.2.0-beta1-dist/js/bootstrap.esm.min.js.map"></script>
</head>

<body>

<header>
    <div class="logo">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Logo-utez.png/300px-Logo-utez.png" class="logo-img">
        <h2 id="h12" class="logo-nombre">Sistema de Préstamos</h2>
    </div>
    <nav>
        <%--@declare id="country"--%><a href="#" class="nav-link" >RESERVAR AQUI</a>
        <a href="index.jsp" class="nav-link">INICIAR SESION</a>
        <!-- <a href="#" class="nav-link">Horario</a> -->
        <label for="country" class="form-label"></label>
        <select class="form-select" id="Horario">
            <option value="n" selected disabled>Horarios</option>
            <option value="n">8:00 a.m.</option>
            <option value="t">8:00 p.m.</option>
        </select>
    </nav>
</header>


<section id="section1">
    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
        <div id="carrusel-contenido">
            <div id="carrusel-caja">
                <div class="carrusel-elemento">
                    <img class="imagenes" src="img/utez.jpg" >
                </div>
                <div class="carrusel-elemento">
                    <img class="imagenes" src="img/utez1.png">
                </div>
                <div class="carrusel-elemento">
                    <img class="imagenes" src="img/utez2.jpg">
                </div>
            </div>
        </div>
    </div>
</section>



</body>
</html>
