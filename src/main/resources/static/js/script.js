(function () {

    'use strict'

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.querySelectorAll('.needs-validation')

    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            })
})()

//SCRIPT DATATABLES
$(document).ready(function () {
    $('#myTable').DataTable();
});


const Toast = Swal.mixin({
    toast: true,
    position: 'top-end',
    showConfirmButton: false,
    timer: 3000,
    timerProgressBar: true,
    didOpen: (toast) => {
        toast.addEventListener('mouseenter', Swal.stopTimer)
        toast.addEventListener('mouseleave', Swal.resumeTimer)
    }
})


//ALERT LOGOUT
function alertLogout() {
    event.preventDefault();
    Swal.fire({
        title: 'Apakah Anda yakin untuk Logout ?',
        text: "Anda Harus login Kembali untuk Melihat User Managament nantinya",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, Logout'
    }).then((result) => {
        if (result.isConfirmed) {
            Toast.fire({
                icon: 'success',
                title: 'Logout Success'

            })
            setTimeout(function () {
                window.location.href = "/logout";
            }, 1500);
        }
    })
}

function insertAlert() {
    Toast.fire({
                icon: 'success',
                title: 'Insert District Success!'

            })
}


//Modal
$('#myModal').on('shown.bs.modal', function () {
  $('#myInput').trigger('focus')
})