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
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.value === true) {
                $('#logoutform').submit()
            }
        })
    });
});


//delete di index.html
function cobadelete() {
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

//$("#addForm").on("submit", function(e) {
//  e.preventDefault(); // cancel submission
//  window.location.replace("http://localhost:8080/contacts");
////  alert("this could redirect to login.php"); 
//});


////$(document).ready(function () {
//    $("#inputForm").click(function(){ // hides all element H1
//        $(this).hide(); // hides the current element
//    });
//});

// Example starter JavaScript for disabling form submissions if there are invalid fields

//$(document).ready(function () {
//    $("#loginForm").click(function () {
//        var username = $("#username").val();
//        var password = $("#password").val();
//
//        if (username == '' || password == '') {
//            swal({
//                title: "Fields Empty!!",
//                text: "Please check the missing field!!",
//                icon: "warning",
//                button: "Ok",
//            });
//        } else {
//
//        }
//    });
//});




