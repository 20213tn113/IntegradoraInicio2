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


    console.log("Agregado");
    $.ajax({
        type: 'POST',
        url: url,
        async: true,
        success: function(r){

        }
    });



}