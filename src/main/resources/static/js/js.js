//data table   ----------------------------
$(document).ready(function() {
    $('#example').DataTable();
} );
//////////
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
        
$('#exampleModal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget) // Button that triggered the modal
    var recipient = button.data('whatever') // Extract info from data-* attributes
    // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
    // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
    var modal = $(this)
    modal.find('.modal-title').text('New message to ' + recipient)
    modal.find('.modal-body input').val(recipient)
})

////
function cobadelete(){
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

function sukses(){
   
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

Toast.fire({
    icon: 'success',
    title: 'Signed in successfully'
})
}