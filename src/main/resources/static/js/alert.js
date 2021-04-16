
//ONLY CHECKING ID
function cekId(){
    let del = $('#upd').attr('href');
    console.log(upd);
}

//DELETE BUTTON
function onClickDelete(id){
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText:'Yes, delete it!'
        }).then((result) => {
            if (result.isConfirmed) {
                deleteEmployee(id);
                }
        });
}

//DELETE SUCCESS
function deleteSuccessAlert(){
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
        title: 'deleted'
    })
}

//CREATE SUCCESS
function createSuccessAlert(){
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
        title: 'created'
    })
}

//UPDATE SUCCESS
function updateSuccessAlert(){
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
        title: 'updated'
    })
}

// ERROR
function errorAlert(){
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
        icon: 'error',
        title: 'failed'
    })
}

//LOGOUT BUTTON
function logout(){
    event.preventDefault();
    let out = $('#out').attr('href');
    console.log(out);
    
    Swal.fire({
        position : 'top-end',
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText:'Log out'
        }).then((result) => {
            if (result.isConfirmed) {
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
                    title: 'Signed Out successfully'
                })
                document.location.href = out;
            }
        });
}

//LOGIN BUTTON
function loginSuccess(){
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
      title: 'Signed In successfully'
    })
}
