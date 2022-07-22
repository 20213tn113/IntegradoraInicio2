<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LOGIN</title>
    <link rel="stylesheet" href="css/estilos_index.css">
    <link rel="stylesheet" href="css/header_index.css">
</head>

<body>
<header>
    <div class="logo">
        <img src="img/logo-utez.png">
        <h2 id="h2">PRESTAMOS DE EQUIPO</h2>
    </div>
    <nav>
        <a href="bienvenida.jsp" class="nav-link">Inicio</a>
    </nav>
</header>


<div id="div4">
    <img id="img1" src="img/halcon.jpg" alt="">

    <form class="form-control bg-dark bg-opacity-50" action="ServletSesion" method="post">
        <div id="div2">
            <label for="user">Usuario: </label>
            <input type="text"  id="user" name="user" placeholder="Usuario" >
        </div>
        <div id="div3">
            <label for="pass">Contraseña</label>
            <input type="password"  id="pass" name="pass" placeholder="Password">
            <input type="hidden" value="inicioSesion" name="accion">
        </div>
        <div >
            <button class="div5" type="submit"  >Iniciar</button>
        </div>
    </form>


    <div class="${clase}" role="alert">
        <h4 class="h41">${mensaje}</h4>
    </div>
</div>


</body>
</html>