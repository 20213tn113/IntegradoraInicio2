<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String user = (String) (session.getAttribute("user"));
    String pass = (String) (session.getAttribute("pass"));
    if (user!= null & pass != null){
        System.out.println("sesion: usuario: "+ user+ " pass: "+pass) ;

%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/estilos.css">


    <!--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">-->
    <link rel="stylesheet" href="css/estilosSanciones.css">


    <script src="bootstrap-5.2.0-beta1-dist/js/bootstrap.esm.min.js.map"></script>


</head>

<body>

<header>
    <div class="logo">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Logo-utez.png/300px-Logo-utez.png"
             class="logo-img">
        <h2 id="h12" class="logo-nombre">Reservaciones Actuales/Vigentes</h2>
    </div>
    <nav>
        <%--@declare id="country"--%><a href="admin.jsp" class="nav-link">Regresar</a>
        <!-- <a href="#" class="nav-link">Horario</a> -->
        <label for="country" class="form-label"></label>

    </nav>
</header>

<div>
    <html>

    <form> Busqueda: <input id="txtBusqueda" type="text" onkeyup="Buscar();" /></form>
    <table id="reservas">

        <tr>
            <th>Fecha</th>
            <th>Correo</th>
            <th>Nombre</th>
            <th>Equipo</th>
            <th>Cantidad</th>
            <th>Hora-Inicio</th>
            <th>Hora-Final</th>
            <th>Estatus de Entrega</th>
            <th>Observaciones</th>
        </tr>
        <tr>
            <td>13/junio/2022</td>
            <td>20213tn063@utez.edu.mx</td>
            <td>Jahaira Gomez Rebolledo</td>
            <td>Router</td>
            <td>4</td>
            <td>13:00</td>
            <td>15:00</td>
            <td><select name="estatus" id="est">
                <option value="p">Pendiente</option>
                <option value="n">No Entregado</option>
                <option value="t">Entrega Tardia</option>
                <option value="e">Entregado</option>
            </select>
            </td>
            <td><select name="observa" id="obs">
                <option value="b">Buen Estado</option>
                <option value="m">Equipo Dañado</option>
            </select>
            </td>
            <td><input type="button" value="Eliminar" /></td>

        </tr>
        <tr class="alt">
            <td>Larry Page</td>
            <td>Google</td>
            <td>https://www.google.com.co</td>
            <td><input type="button" value="Eliminar" /></td>
        </tr>
        <tr>
            <td>Peter Thiel</td>
            <td>PayPal</td>
            <td>https://www.paypal.com</td>
            <td><input type="button" value="Eliminar" /></td>
        </tr>
        <tr class="alt">
            <td>Bill Gates</td>
            <td>Microsoft</td>
            <td>www.microsoft.com</td>
            <td><input type="button" value="Eliminar" /></td>
        </tr>

    </table>
    <script type="text/javascript">// < ![CDATA[
    function Eliminar(i) {
        document.getElementsByTagName("table")[0].setAttribute("id", "tableid");
        document.getElementById("tableid").deleteRow(i);
    }
    function Buscar() {
        var tabla = document.getElementById('reservas');
        var busqueda = document.getElementById('txtBusqueda').value.toLowerCase();
        var cellsOfRow = "";
        var found = false;
        var compareWith = "";
        for (var i = 1; i < tabla.rows.length; i++) {
            cellsOfRow = tabla.rows[i].getElementsByTagName('td');
            found = false;
            for (var j = 0; j < cellsOfRow.length && !found; j++) {
                compareWith = cellsOfRow[j].innerHTML.toLowerCase(); if (busqueda.length == 0 || (compareWith.indexOf(busqueda) > -1)) {
                    found = true;
                }
            }
            if (found) {
                tabla.rows[i].style.display = '';
            } else {
                tabla.rows[i].style.display = 'none';
            }
        }
    }
    // ]]></script>

    <!-- https://byspel.com/filtrar-tabla-html-con-javascript/ -->

    </html>

</div>

<section class="botones">
    <input type="button" id="add" value="Modificar">
    <input type="button" id="add" value="Actualizar">
</section>



</body>

</html>

<% }else{
    System.out.println("No hay sesión iniciada!");
    request.getRequestDispatcher("index.jsp").forward(request,response);

    }
%>
