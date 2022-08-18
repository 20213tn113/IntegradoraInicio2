function FinalizarPrestamo(){
    Swal.fire({
        title: '¿Desea Terminar su Prestamo?',
        text: "",
        icon: 'question',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        cancelButtonText: 'No',
        confirmButtonText: 'Sí'
    }).then((result) => {
        if (result.isConfirmed) {

            Swal.fire(
                'Prestamo Finalizado!',
                'Se ha hecho correctamente',
                'success'
            );
            setTimeout(function () {
                parent.location.href = "admin.jsp";
            }, 1000)

        }
    })
}