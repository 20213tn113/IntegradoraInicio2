function insertarEquipos(){


    var id_eqo = document.getElementById("id_eqo").value;
    var nombre = document.getElementById("nombre").value;
    var descripcion = document.getElementById("descripcion").value;
    var marca = document.getElementById("marca").value;
    var modelo = document.getElementById("modelo").value;
    var n_serie = document.getElementById("n_serie").value;
    var disponibilidad = document.getElementById("disponibilidad").value;
    var estado = document.getElementById("estado").value;

    //Conversion a mayusculas

    id_eqo = id_eqo.toUpperCase();
    nombre = nombre.toUpperCase();
    descripcion = descripcion.toUpperCase();
    marca = marca.toUpperCase();
    modelo = modelo.toUpperCase();
    n_serie = n_serie.toUpperCase();
    disponibilidad = disponibilidad.toUpperCase();
    estado = estado.toUpperCase();


    if(nombre =="" || id_eqo =="" || descripcion =="" || marca =="" || modelo =="" || n_serie ==""){

        Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Por favor llene todos los campos',
        })

    }else {



        Swal.fire({
            title: '¿Desea agregar el equipo?',
            text: "",
            icon: 'question',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            cancelButtonText: 'Cancelar',
            confirmButtonText: 'Si, Agregar'
        }).then((result) => {
            if (result.isConfirmed) {

                insertEquipos( id_eqo, nombre, descripcion, marca, modelo, n_serie,disponibilidad,estado);
                Swal.fire(
                    'Equipo Agregado!',
                    'Se ha agregado correctamente',
                    'success'
                );
                setTimeout(function () {
                    parent.location.href = "getEquipos";
                }, 1000)

            }
        })


    }
}

function insertEquipos(id_eqo,nombre,descripcion,marca,modelo,n_serie,disponibilidad,estado){

  var url="ServletEquipos?accion=registrar&id_eqo="+id_eqo+"&nombre="+nombre+"&descripcion="+descripcion+"&marca="+marca+"&modelo="+modelo+"&n_serie="+n_serie+"&disponibilidad="+disponibilidad+"&estado="+estado;

   //var url = "ServletEquiposSolicitar?accion=/consutlarEquipos2&id_eqo="+id_eqo;

    console.log("Agregado");
    $.ajax({
        type: 'POST',
        url: url,
        async: true,
        success: function(r){

        }
    });

}

function validarId_eqo(){
    var id_eqo = document.getElementById("id_eqo").value;
    id_eqo = id_eqo.toUpperCase();
    var n_serie = document.getElementById("n_serie").value;
    n_serie = n_serie.toUpperCase();

    var id_eqo2 = document.getElementsByName('id_eqo2[]');
    var n_serie2 = document.getElementById("n_serie2[]");

    const button = document.getElementById('insertEquipos');
    var bande = 0;


    for (i = 0; i < id_eqo2.length; i++) {
        if (id_eqo == id_eqo2[i].value ) {
            Swal.fire(
                'Error',
                'El registro ya se encuentra en la BD',
                'error'
            );
            console.log(id_eqo2[i].value);
            console.log("Errorr!! son igualees");
            //document.getElementById("insertEquipos").disabled=true;
            button.disabled = true;
            bande = 1;
        }
    }

    for (i = 0; i < n_serie2.length; i++) {
        if (n_serie == n_serie2[i].value ) {
            Swal.fire(
                'Error',
                'El registro ya se encuentra en la BD',
                'error'
            );
            console.log(n_serie2[i].value);
            console.log("Errorr!! son igualees");
            //document.getElementById("insertEquipos").disabled=true;
            button.disabled = true;
            bande = 1;
        }
    }

    if(bande == 0){
        console.log("Paso Falso");
        //document.getElementById("insertEquipos").disabled=false;
        button.disabled = false;
    }




}




function caja(){
    Swal.fire(
        'Equipo Agregado!',
        'Se ha agregado correctamente',
        'success'
    );
    setTimeout(function () {
        parent.location.href = "getEquipos";
    }, 1000)
}