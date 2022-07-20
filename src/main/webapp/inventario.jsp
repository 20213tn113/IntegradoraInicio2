<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 04/07/2022
  Time: 01:07 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
        <title>Inventario v0.1</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>
        <link rel="stylesheet" href="css/estilosinventario.css">
        <link rel="stylesheet" href="css/estilosheader.css ">
        <link rel="stylesheet" href="css/estilos_index.css">
        <script src="inventario.js"></script>
</head>
<body>
<header>
    <div class="logo">
        <img src="img/logo-utez.png" class="logo-img">
        <h2 class="logo-nombre">Sistema de Préstamos</h2>
    </div>
    <nav>
        <a href="#" class="nav-link" >Inicio</a>
        <a href="#" class="nav-link">Cerrar Sesión</a>
    </nav>
</header>



<div class="contenedor" ng-app="InventarioApp" ng-controller="InventarioCtrl">

    <table class="controles">
        <tr>
            <th colspan="4" class="celdaControles celdaTitulo">Sistema de gestión de inventarios</th>
        </tr>
        <tr>
            <td colspan="2" class="celdaControles celdaLabelSelector">Visualizar categoría</td>
            <td colspan="2" class="celdaControles">
                <select class="selector-categoria" ng-model="categoria" ng-options="cat for cat in listaCategorias" ng-change="actualizaCategoria()">
                </select>
            </td>
        </tr>
        <tr>
            <td class="celdaControles celdaBusqueda"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></td>
            <td class="celdaControles celdaFiltroRef">
                <input ng-model="filterRef" placeholder="Referencia" />
            </td>
            <td class="celdaControles celdaFiltroDesc">
                <input ng-model="filterDesc" placeholder="Descripción" />
            </td>
            <td class="celdaControles celdaCrear"><span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span></td>
        </tr>
    </table>

    <table class="resultados">
        <tr ng-repeat="item in listaItems | filter:{ref:filterRef, desc:filterDesc}">

            <td class="celdaResultados celdaRef">[{{item.ref}}]</td>
            <td class="celdaResultados celdaDesc">{{item.desc}}</td>
            <td class="celdaResultados celdaOpc">
                <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
                <span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span>
            </td>
        </tr>
    </table>
</div>
<script src="inventario.js"></script>
</body>
</html>
