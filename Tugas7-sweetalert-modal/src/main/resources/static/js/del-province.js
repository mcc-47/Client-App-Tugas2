$(document).ready(function(){
	fetch();
 
	$(document).on('click', '.delete_product', function(){
		var id = $(this).data('id');
 
		swal.fire({
		  	title: 'Are you sure?',
		  	text: "You won't be able to revert this!",
		  	icon: 'warning',
		  	showCancelButton: true,
		  	confirmButtonColor: '#3085d6',
		  	cancelButtonColor: '#d33',
		  	confirmButtonText: 'Yes, delete it!',
		}).then((result) => {
		  	if (result.value){
		  		$.ajax({
			   	url: 'province.html?action=delete',
			    	type: 'GET',
			       	data: 'id='+id,
			       	dataType: 'json'
			    })
			    .done(function(response){
			     	swal.fire('Deleted!', response.message, response.status);
					fetch();
			    })
			    .fail(function(){
			     	swal.fire('Oops...', 'Something went wrong with ajax !', 'error');
			    });
		  	}
 
		})
 
	});
});
 
function fetch(){
	$.ajax({
		method: 'GET',
		url: 'ProvinceController.java',
		dataType: 'json',
		success: function(response){
			$('#delete').html(response);
		}
	});
}