<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>registro</title>
    <link rel="stylesheet" href="css/estilosheader.css">
    <link rel="stylesheet" href="css/estiloformulario.css.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

</head>
<body>
<header>
    <div class="logo">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Logo-utez.png/300px-Logo-utez.png" alt="">
        <h2 id="h12">PRESTAMOS DE EQUIPO</h2>
    </div>
    <nav>
        <a href="#" class="nav-link">Inicio</a>

    </nav>
</header>



<center> <h2>REGISTRO</h2></center>

<div class="${clase}" role="alert">
    <h4>${mensaje}</h4>
</div>

<section id="seccion1">
    <form class="form-control bg-dark bg-opacity-50" action="ServletUsuario" method="post">

        <div class="col-md-4">
            <label class="form-label">Matricula: *</label>
            <input type="text" class="form-control is-valid" name="matricula" required>
            <div class="valid-feedback">
                Looks good!
            </div>
        </div>

        <div class="col-md-4">
            <label class="form-label">Nombre: *</label>
            <input type="text" class="form-control is-valid" name="nombre" required>
            <div class="valid-feedback">
                Looks good!
            </div>
        </div>

        <div class="col-md-4">
            <label for="validationServer01" class="form-label">Apellido: *</label>
            <input type="text" class="form-control is-valid" name="apellido" required>
            <div class="valid-feedback">
                Looks good!
            </div>
        </div>

        </div>
        <div class="col-md-4">
            <label class="form-label">Correo: *</label>
            <div class="input-group has-validation">
                <span class="input-group-text" id="inputGroupPrepend3">@</span>
                <input type="text" class="form-control" name="correo">
                <div id="validationServerUsernameFeedback" class="invalid-feedback">

                </div>
            </div>
        </div>

        <div class="col-md-3">
            <label class="form-label">Cantidad: *</label>
            <select class="form-select" name="cantidad">

                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="0">...</option>


            </select>
            <div id="validationServer04Feedback" class="invalid-feedback">
                seleccciones una cantidad.
            </div>


        </div>
        <div class="col-md-3">
            <label for="validationServer05" class="form-label">Fecha: *</label>
            <input type="datetime-local" class="form-control" id="validationServer05" aria-describedby="validationServer05Feedback" required>
            <div id="validationServer05Feedback" class="invalid-feedback">

                Proporcione una fecha.
            </div>
        </div>
        <div class="col-md-3">
            <label for="validationServer05" class="form-label">Hora-inico: *</label>
            <input type="datetime-local" class="form-control" id="validationServer05" aria-describedby="validationServer05Feedback" required>
            <div id="validationServer05Feedback" class="invalid-feedback">
                Proporcione una hora de incio.
            </div>
        </div>
        </div>
        </div>
        <div class="col-md-3">
            <label for="validationServer05" class="form-label">Hora-final: *</label>
            <input type="datetime-local" class="form-control" id="validationServer05" aria-describedby="validationServer05Feedback" required>
            <div id="validationServer05Feedback" class="invalid-feedback">
                Proporcione una hora final.
            </div>
        </div>
        <div class="col-12">
            <div class="form-check">
                <label class="form-check-label" for="invalidCheck3">

                    **NOTA** <BR>
                    Para entregar el/los dispositivos prestados unicamente se tendra tolerancia de 15 minutos a la hora que usted indique en el presente formulario despues de eso se considerara entrega tardia y sera acredor a una sancion. <br>
                    <input class="form-check-input" type="checkbox" value="" id="invalidCheck3" aria-describedby="invalidCheck3Feedback" required>

                    Agree to terms and conditions
                </label>
                <div id="invalidCheck3Feedback" class="invalid-feedback">
                    You must agree before submitting.
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <label class="form-label">Rol: *</label>
            <input type="text" class="form-control is-valid" name="rol" required>
            <div class="valid-feedback">
                Looks good!
            </div>
        </div>

        <div class="col-12">
            <input type="hidden" value="reservar" name="action">
            <button class="btn btn-primary" type="submit">RESERVAR</button>
        </div>
    </form>
</section>


</body>
</html>
