//VALIDATION FOR LOGIN
(function () {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  var forms = document.querySelectorAll('.form-signin')

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

//VALIDATING FORM TEMPLATE
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

//MODAL
$('#myModal').on('shown.bs.modal', function () {
  $('#myInput').trigger('focus');
});

//ALERT TEMPLATE CONFIRM
function alertConfirm(titleText, bodyText, iconType, confirmText, actionIfConfirm) {
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
            actionIfConfirm();
        }
    });
}

//FOR ALERT
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

//ALERT TEMPLATE SMALL ALERT
function alertSmall(iconType, titleText) {
    Toast.fire({
                icon: iconType,
                title: titleText
            });
}

//LOGOUT
function logout() {
    alertConfirm("Are You Sure Want to Logout?", "", "warning", "Yes", () => {
        $.ajax({
            url: `/logout`,
            type: 'GET',
            success: () => {
                alertSmall("success", "Logout Success");
                setTimeout(function () {
                    window.location.href = "/logout";
                }, 1500);
            }
        });
    });
}