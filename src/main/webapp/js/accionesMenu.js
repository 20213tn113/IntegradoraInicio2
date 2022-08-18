function desplegarEquipos(){

    var cant = 0;
    //alert("llego: "+cant + " llego el valor: "+valor);
    let cantidad = parseInt(cant);

    if (cantidad == 0){
        Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'No hay equipos disponibles',
        })
    }else{


        parent.location.href = "seleccion.jsp";

    }



}



function mostrar(valor){

    var url = "ServletEquipos?accion=consultaFiltro&valor="+valor;

    console.log("Mostrar");
    $.ajax({
        type: 'POST',
        url: url,
        async: true,
        success: function(r){

        }
    });

}