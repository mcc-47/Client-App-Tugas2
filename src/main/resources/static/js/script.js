//VALIDATING FORM
function validationForm(action) {
    var forms = document.querySelectorAll('.needs-validation');

    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
            .forEach(function (form) {
                    if (form.checkValidity()) {
                        action();
                    };
                    form.classList.add('was-validated');
                });
}

//Modal
$('#myModal').on('shown.bs.modal', function () {
  $('#myInput').trigger('focus');
});

//ALERT
function login() {
    $.ajax({
        url:`/login`,
        type: "GET",
        success:(res) => {
            setForm(res);
            alertSmall('success', 'Login Success');
        }
    });
}

const Toast = Swal.mixin({
    toast: true,
    position: 'top-end',
    showConfirmButton: false,
    timer: 1500,
    timerProgressBar: true,
    didOpen: (toast) => {
        toast.addEventListener('mouseenter', Swal.stopTimer)
        toast.addEventListener('mouseleave', Swal.resumeTimer)
    }
});


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

            });
            setTimeout(function () {
                window.location.href = "/logout";
            }, 1500);
        }
    });
}
//
//function insertAlert() {
//    Toast.fire({
//                icon: 'success',
//                title: 'Insert District Success!'
//            })
//}

//ALERT TEMPLATE CONFIRM
function alertConfirm(titleText, bodyText, iconType, confirmText, iconIfConfirm, titleIfConfirm, actionIfConfirm) {
    Swal.fire({
        title: titleText,
        text: bodyText,
        icon: iconType,
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: confirmText
    }).then((result) => {
        if (result.isConfirmed) {
            Toast.fire({
                icon: iconIfConfirm,
                title: titleIfConfirm
            });
        actionIfConfirm();
        }
    });
}

//ALERT TEMPLATE SMALL ALERT
function alertSmall(iconType, titleText) {
    Toast.fire({
                icon: iconType,
                title: titleText
            });
}
