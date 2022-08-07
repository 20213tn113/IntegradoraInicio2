function modificarEquipos() {

    var id = document.getElementById("id").value;
    var id_eqo = document.getElementById("id_eqo").value;
    var nombre = document.getElementById("nombre").value;
    var descripcion = document.getElementById("descripcion").value;
    var marca = document.getElementById("marca").value;
    var modelo = document.getElementById("modelo").value;
    var n_serie = document.getElementById("n_serie").value;
    var disponibilidad = document.getElementById("disponibilidad").value;
    var estado = document.getElementById("estado").value;

    if(nombre =="" || id_eqo =="" || descripcion =="" || marca =="" || modelo =="" || n_serie ==""){

        Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Por favor llene todos los campos',
        })

    }else {

        Swal.fire({
            title: 'Confirmar Actualizar!',
            text: "",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            cancelButtonText: 'Cancelar',
            confirmButtonText: 'Si, Modificar'
        }).then((result) => {
            if (result.isConfirmed) {

                updateEquipos(id, id_eqo, nombre, descripcion, marca, modelo, n_serie,disponibilidad,estado);
                Swal.fire(
                    'Actualizado!',
                    'Se han actualizado correctamente',
                    'success'
                );
                setTimeout(function () {
                    parent.location.href = "getEquipos";
                }, 1000)
            }
        })


    }
}

function updateEquipos(id,id_eqo,nombre,descripcion,marca,modelo,n_serie,disponibilidad,estado){

    var url="ServletEquipos?accion=actualizar&id="+id+"&id_eqo="+id_eqo+"&nombre="+nombre+"&descripcion="+descripcion+"&marca="+marca+"&modelo="+modelo+"&n_serie="+n_serie+"&disponibilidad="+disponibilidad+"&estado="+estado;
    console.log("Actualizado");
    $.ajax({
        type: 'POST',
        url: url,
        async: true,
        success:function(r){

        }
    })


}