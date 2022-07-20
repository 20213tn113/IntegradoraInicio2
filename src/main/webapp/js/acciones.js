function revisar() {
    var admin = document.getElementById ("usuario").value;
    var contrasena = document.getElementById ("contrasena").value;

    if (contrasena == "admin" && admin=="admin"){
        swal.fire(
            'Bienvenido!',
            '',
            'success'
        )
    } else {
        Swal.fire({
            icon: 'error',
            title: 'TUS DATOS SON INCORRECTOS...',
            text: '',
            footer: '<a href=""></a>'
        })


    }
}