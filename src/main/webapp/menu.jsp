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
</head>

<body>
<header>
    <div class="logo">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Logo-utez.png/300px-Logo-utez.png"
             alt="">
        <h2 id="h12">MENÚ PRESTAMOS DE EQUIPO</h2>
    </div>
    <nav>
        <a href="#">Cerrar Sesión</a>
        <a href="#" class="nav-link">Inicio</a>
        <!-- <a href="#" class="nav-link">Horario</a> -->
        <select name="Horario" id="mot">
            <option value="p">Horario</option>
            <option value="n">8:00 am</option>
            <option value="t">8:00 pm</option>
        </select>
    </nav>
</header>

<section>
    <div>
        <P id="div1">SWITCHES</P>

        <img id="img1"
             src="https://say02.odoo.com/web/image/271-ce880aa4/switch-cisco-20ptos-10gb-24xcobre-10gbaset-4-combo.jpg"
             alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES</p>
        <p id="div4">Solicítalo</p>
        <a id="a1">Escoger</a>
    </div>
    <div>
        <P id="div1">ROUTER</P>
        <img id="img1"
             src="https://say02.odoo.com/web/image/272-5cab5e3e/cisco-isr4321-vsec-k9-isr-4321-router-1-000-mbps-10125252-Gbzo.jpg"
             alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES</p>
        <p id="div4">Solicítalo</p>
        <a id="a1">Escoger</a>
    </div>
    <div>
        <P id="div1">LAPTOP</P>
        <img id="img1" src="https://say02.odoo.com/web/image/273-c5cbebfe/G8-1-300x300.jpg" alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES</p>
        <p id="div4">Solicítalo</p>
        <a id="a1">Escoger</a>
    </div>
    <div>
        <P id="div1">IPAD</P>
        <img id="img1"
             src="https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/refurb-ipad-wifi-spacegray-2018?wid=1144&hei=1144&fmt=jpeg&qlt=90&.v=1582321442322"
             alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES</p>
        <p id="div4">Solicítalo</p>
        <a id="a1">Escoger</a>
    </div>

</section>
<section>
    <div>
        <P id="div1">TABLETA</P>
        <img id="img1" src="https://m.media-amazon.com/images/I/61nONxSFUnL._AC_SY355_.jpg" alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES</p>
        <p id="div4">Solicítalo</p>
        <a id="a1">Escoger</a>
    </div>
    <div>
        <P id="div1">SMARTPHONE</P>
        <img id="img1" src="https://mejores10.com/images/10001198/2995/1498217448_5490.jpg" alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES</p>
        <p id="div4">Solicítalo</p>
        <a id="a1">Escoger</a>
    </div>
    <div>
        <P id="div1">TELÉFONO</P>
        <img id="img1" src="https://myrealmobile.com/images/thumbs/0001257_big-button-speakerphone.jpeg" alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES</p>
        <p id="div4">Solicítalo</p>
        <a id="a1">Escoger</a>
    </div>
    <div>
        <P id="div1">PUNTO DE ACCESO</P>
        <img id="img1" src="https://www.comunicacionesinalambricashoy.com/imagenes/2016/10/Netgear-WAC104.jpg"
             alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES</p>
        <p id="div4">Solicítalo</p>
        <a id="a1">Escoger</a>
    </div>

</section>
<section>
    <div>
        <P id="div1">BOCINAS</P>
        <img id="img1"
             src="http://cdn.shopify.com/s/files/1/0428/3357/6102/products/techzonebocinasinalambricasbluetoothtzboctws01_1200x1200.jpg?v=1618411052"
             alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES</p>
        <p id="div4">Solicítalo</p>
        <a id="a1">Escoger</a>
    </div>
    <div>
        <P id="div1">CPU</P>
        <img id="img1" src="https://definicion.mx/wp-content/uploads/2013/06/CPU.jpg" alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES</p>
        <p id="div4">Solicítalo</p>
        <a id="a1">Escoger</a>
    </div>
    <div>
        <P id="div1">VIDEO PROYECTOR DIGITAL</P>
        <img id="img1"
             src="https://mainframeltda.com/wp-content/uploads/2019/04/Que_es_un_proyector_de_video-1100x825.jpg"
             alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES</p>
        <p id="div4">Solicítalo</p>
        <a id="a1">Escoger</a>
    </div>

    <div>
        <P id="div1">HERAMIENTAS</P>
        <img id="img1" src="https://i.linio.com/p/68e8bb1927919329374aa9cc07f8dff0-product.jpg" alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES</p>
        <p id="div4">Solicítalo</p>
        <a id="a1">Escoger</a>
    </div>

</section>




<section>
    <div>
        <P id="div1">BOCINAS</P>
        <img id="img1"
             src="http://cdn.shopify.com/s/files/1/0428/3357/6102/products/techzonebocinasinalambricasbluetoothtzboctws01_1200x1200.jpg?v=1618411052"
             alt="">
        <p id="div2">CANTIDAD DISPONIBLE</p>
        <p id="div3">UNIDADES</p>
        <p id="div4">Solicítalo</p>
        <a id="a1">Escoger</a>
    </div>
</section>

</body>
</html>

<% }else{
    System.out.println("No hay sesión iniciada!");
    request.getRequestDispatcher("index.jsp").forward(request,response);

}
%>