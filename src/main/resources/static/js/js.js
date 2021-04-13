//data table   ----------------------------
$(document).ready(function() {
    $('#example').DataTable();
} );


//form validation---------------------------
(function () {
    'use strict';
    window.addEventListener('load', function () {
        

        var forms = document.getElementsByClassName('needs-validation');

        var validation = Array.prototype.filter.call(forms, function (form) {
            form.addEventListener('submit', function (event) {
                if (form.checkValidity() === false ) {
                    event.preventDefault();
                    event.stopPropagation();
                    Swal.fire({
            icon: 'error',
            title: 'Error...',
            text: 'Please Insert Field!',
            footer: '<a href>Why do I have this issue?</a>'
            })
                }else {
                 
                form.classList.add('was-validated');
                 Swal.fire({
            icon: 'success',
            title: 'Success...',
            text: 'Please Insert Field!',
            footer: '<a href>Why do I have this issue?</a>'
            
            })
            }}, false);
        });
    }, false);
})();

//delete----------
function deletealert(){

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
                    );
            
        }
    })
}
//////
 function insertalert(){
        var id=$("id").val();
        var kab=$("kab").val();
        var districtname=$("districtname").val();
        var provinceid=$("provinceid").val();
    
        if(id==''||kab==''||distriname==''||provinceid==''){
            Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Something went wrong!',
            footer: '<a href>Why do I have this issue?</a>'
            })
        }else{
            Swal.fire({
            icon: 'success',
            title: 'Oops...',
            text: 'Something went wrong!',
            footer: '<a href>Why do I have this issue?</a>'
            })
        }
        }
