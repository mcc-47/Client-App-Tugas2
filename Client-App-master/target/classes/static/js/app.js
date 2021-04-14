// tabel
$(document).ready(function () {
    $('#table_id').DataTable();
});

// validation setiap form
$(document).ready(function () {
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
});

//login
$(document).ready(function () {
    $("#loginForm").click(function () { // hides all element H1
        var username = $("#username").val();
        var password = $("#password").val();

        if (username == '' || password == '') {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'Something went wrong!',
                footer: '<a href>Why do I have this issue?</a>'
            })
        } else {
            Swal.fire({
                icon: 'success',
                title: 'Okay',
                text: 'Login Success',
                footer: '<a href>Why do I have this issue?</a>'
            })
        }
    });
});

// logout di header
$(document).ready(function () {
    $("#logoutButton").on("click", function () {
        Swal.fire({
            title: 'Are you sure to logout?',
            text: "You have to log in again!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, I am sure!'
        }).then((result) => {
            if (result.value === true) {
                $('#logoutform').submit()
            }
        })
    });
});

//insert
$(document).ready(function () {
    $("#insertForm").click(function () { // hides all element H1
        var phone = $(".phone").val();
        var linkedin = $(".linkedin").val();

        if (phone == '' || linkedin == '') {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'All data must be filled!',
            })
        } else {
            Swal.fire({
                icon: 'success',
                title: 'Okay',
                text: 'Create Data Success',
            })
        }
    });
});

//delete di index.html
function deleteData() {
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire(
                    'Deleted!',
                    'Your file has been deleted.',
                    'success'
                    )
        }
    })
}