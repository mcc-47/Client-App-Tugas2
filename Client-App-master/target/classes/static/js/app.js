// Example starter JavaScript for disabling form submissions if there are invalid fields
(function () {
    'use strict';
    window.addEventListener('load', function () {
// Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.getElementsByClassName('needs-validation');
// Loop over them and prevent submission
        var validation = Array.prototype.filter.call(forms, function (form) {
            form.addEventListener('submit', function (event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);
})();

$(document).ready(function () {
    $('#table_id').DataTable();
});

Swal.fire('Any fool can use a computer')

//const tombol = document.querySelector('#login');
//const a = tombol.addEventListener('click', function () {
//    Swal.mixin({
//        toast: true,
//        position: 'top-end',
//        showConfirmButton: false,
//        timer: 3000,
//        timerProgressBar: true,
//        didOpen: (toast) => {
//            toast.addEventListener('mouseenter', Swal.stopTimer)
//            toast.addEventListener('mouseleave', Swal.resumeTimer)
//        }
//    })
//});
//
//
//
//Toast.fire({
//    icon: 'success',
//    title: 'Signed in successfully'
//})