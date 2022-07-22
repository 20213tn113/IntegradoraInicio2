<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/headerestilo2.css">

    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
         integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous"> -->
    <link rel="stylesheet" href="css/estilosheader.css">
    <script src="bootstrap-5.2.0-beta1-dist/js/bootstrap.esm.min.js.map"></script>
</head>
<body>
<header>
    <div class="logo">
        <img src="img/logo-utez.png" class="logo-img">
        <h2 id="h12" class="logo-nombre">Sistema de Préstamos</h2>
    </div>
    <nav>
        <a href="#" class="nav-link" >Inicio</a>
        <a href="#" class="nav-link">Cerrar Sesión</a>
    </nav>

</header>

<div>
    <html>
    <h1>HISTORIAL DE SANCIONADOS</h1>
    <form>Busqueda: <input id="txtBusqueda" type="text" onkeyup="Buscar();" /></form>
    <table id="sanciones">
        <tbody>
        <tr>
            <th>Fecha</th>
            <th>Correo</th>
            <th>Nombre</th>
            <th>Razon/Motivo</th>
            <th>Sancion</th>
        </tr>
        <tr>
            <td>13/junio/2022</td>
            <td>20213tn063@utez.edu.mx</td>
            <td>Jahaira Gomez Rebolledo</td>
            <td><select name="motivo" id="mot">
                <option value="p">Pendiente</option>
                <option value="n">No Entregado</option>
                <option value="t">Entrega Tardia</option>
            </select>
            </td>
            <td><select name="sancion" id="san">
                <option value="dias">8 dias inhabil</option>
                <option value="reporte">Reporte a Direccion</option>
            </select>
            </td>

        </tr>
        <tr class="alt">
            <td>13/junio/2022</td>
            <td>https://www.google.com.co</td>
            <td>Larry Page</td>
            <td><input type="button" value="Eliminar" /></td>
        </tr>
        <tr>
            <td>13/junio/2022</td>
            <td>https://www.paypal.com</td>
            <td>Peter Thiel</td>
            <td><input type="button" value="Eliminar" /></td>
        </tr>
        <tr class="alt">
            <td>13/junio/2022</td>
            <td>www.microsoft.com</td>
            <td>Bill Gates</td>
            <td><input type="button" value="Eliminar" /></td>
        </tr>
        </tbody>
    </table>
    <script type="text/javascript">// < ![CDATA[
    function Eliminar(i) {
        document.getElementsByTagName("table")[0].setAttribute("id", "tableid");
        document.getElementById("tableid").deleteRow(i);
    }
    function Buscar() {
        var tabla = document.getElementById('sanciones');
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




</body>
</html>
