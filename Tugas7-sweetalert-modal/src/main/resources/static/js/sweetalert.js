//untuk update dan insert
function onClickUpdated() {
        event.preventDefault();
        let form = $('form');
        console.log(form);
        swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes!'
    }).then((result) => {
        if (result.isConfirmed) {
            swal.fire(
                    'Updated!',
                    'Your file has been updated.',
                    );
            form.submit();
        }
    });
}

 //logout
        function OnClickLogout(){
        event.preventDefault();
        Swal.fire({
          title: 'Are you sure?',
          text: "You won't exit from this web",
          icon: 'warning',
          showCancelButton: true,
          confirmButtonColor: '#3085d6',
          cancelButtonColor: '#d33',
          confirmButtonText: 'Yes!'
        }).then((result) => {
          if(result.isConfirmed) {
            Toast.fire({
                icon:'access',
                title:'process logout from your account!!',
            })
            setTimeout(function(){
                window.location.href="/logout"
            },2000);
        }
    })
        }
        
        const Toast=Swal.mixin({
            toast:true,
            position: 'top-end',
            showConfirmButton:false,
            time:2000,
            timerProgressBar: true,
            didOpen:(toast)=>{
                toast.addEventListener('mouseenter',Swal.stopTimer)
                toast.addEventListener('mouseleave',Swal.resumeTimer)
            }
        })

//Logout
$(document).on('click', '#btn-logout', function (e) {
    e.preventDefault();
    let link = $(this).attr('href')
    Swal.fire({
        title: 'Are you sure?',
//            text: "You won't be able to revert this!",
        toast: true,
        icon: 'warning',
        position: 'top-end',
//        width: '350px',
//                height:'900px',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes'
    }).then((result) => {
        if (result.isConfirmed) {
            window.location = link;
        }
    });
});
