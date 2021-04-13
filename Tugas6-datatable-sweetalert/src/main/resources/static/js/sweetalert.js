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
        confirmButtonText: 'Yes, Update!'
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

