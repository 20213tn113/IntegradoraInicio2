function validarEliminar(id2){
    //alert("ID DE LLEGADA"+id2);
    Swal.fire({
        title: 'Confirmar Eliminar!',
        text: "Esta acción no se podrá deshacer",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        cancelButtonText: 'Cancelar',
        confirmButtonText: 'Si, Eliminar'
    }).then((result) => {
        if (result.isConfirmed) {
            //var id = document.getElementById("id").value;
            var id = parseInt(id2);
            deleteUser(id);
                Swal.fire(
                    'Eliminado!',
                    'El equipo ha sido eliminado',
                    'success'
                );
                setTimeout(function (){
                    parent.location.href="getEquipos";
                }, 1000)
        }
    })
}


function deleteUser(id){
    var url="ServletEquipos?accion=eliminar&id="+id;
    console.log("Eliminado");
    $.ajax({
        type: 'POST',
        url: url,
        async: true,
        success: function(r){

        }
    });

}