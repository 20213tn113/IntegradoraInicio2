
function validacionLogin(){

    let user = document.getElementById("user").value;
    let pass = document.getElementById("pass").value;

    if (user==""||pass==""){
        Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Por favor llene todos los campos',
        })
    }else{
        iniciarSesion(user,pass);




    }




}

function iniciarSesion(user,pass){
    var url="ServletSesion?accion=inicioSesion&user="+user+"&pass="+pass;
    console.log("iniciado");
    $.ajax({
        type: 'POST',
        url: url,
        async: true,
        success: function(r){

        }

    });


}

function caja(){
    Swal.fire({
        icon: 'error',
        title: 'Error',
        text: 'Datos incorrectos',
        confirmButtonColor: '#023059',
        confirmButtonText: 'Intentar de Nuevo',

    });
    setTimeout(function () {
        parent.location.href = "getEquipos";
    }, 1000)
}