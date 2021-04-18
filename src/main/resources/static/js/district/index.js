$(document).ready(() => {
    getAll();
    
    $("#inputForm").submit(e => {
        e.preventDefault();
        validationForm(insert);
    });
    
    $("#editForm").submit(e => {
        e.preventDefault();
        validationForm(update);
    });
});

function getAll() {
    table = $('#myTable').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/district/get-all",
            datatype: "json",
            dataSrc: ""
        },
        columns: [
            {
                data: "districtId", name: "No", autoWidth: true
            },
            {
                data: "kab", name: "Kota/Kab", autoWidth: true
            },
            {
                data: "districtName", name: "Nama Distrik", autoWidth: true
            },
            {
                data: "provinceId.provinceName", name: "Nama Provinsi", autoWidth: true
            },
            {
                render: (data, type, row, meta) => {
                    return `
                        <button 
                                class='btn btn-sm btn-primary'
                                data-toggle="modal" 
                                data-target="#editModal"
                                onclick="getById('${row.districtId}')"
                            >
                                <i class='fas fa-sm fa-pencil-alt'></i>
                            </button>
                            <button class='btn btn-sm btn-danger' onclick='del(${row.districtId})'>
                                <i class='fas fa-sm fa-trash'></i>
                            </button>
                        `;
                }
            }
        ]
    });
    
    table.on( 'order.dt search.dt', function () {
        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();
}

function getById(id) {
    $.ajax({
        url:`/district/${id}`,
        type: "GET",
        success:(res) => {
            setForm(res);
        }
    });
}

function insert() {
    $.ajax({
        url:'/district/insert',
        type: "POST",
        data: JSON.stringify({districtId: $('#districtIdInsert').val(), kab: $('#kabInsert').val(), 
            districtName: $('#districtNameInsert').val(), provinceId: {provinceId: $('#provinceNameInsert').val()
        }}),
        contentType: 'application/json; charset=UTF-8',
        success: () => {
            table.ajax.reload();
            alertSmall('success', 'Insert Success');
            $('#inputModal').modal('hide');
            resetForm();
        },
        error: () => {
            alertSmall('error', 'Insert Failed');
        }
    });
}

function update() {
    $.ajax({
        url:"/district/update/"+$('#districtIdUpdate').val(),
        type: "PUT",
        data: JSON.stringify({districtId: $('#districtIdUpdate').val(), kab: $('#kabUpdate').val(), districtName: $('#districtNameUpdate').val(), provinceId: {provinceId: $('#provinceNameUpdate').val()
        }}),
        contentType: 'application/json; charset=UTF-8',
        success: () => {
            table.ajax.reload();
            alertSmall('success', 'Edit Success');
            $('#editModal').modal('hide');
            toggleValidation();
        },
        error: () => {
            alertSmall('error', 'Edit Failed');
        }
    });
}

function del(id) {
    alertConfirm('Are you sure want to delete this?', '', 'warning', 'Yes, delete it', 
        function() {$.ajax({
        url:`/district/delete/${id}`,
        type: "DELETE",
        success: () => {
            table.ajax.reload();
            alertSmall('success', 'Delete Success');
        },
        error: () => {
            alertSmall('error', 'Delete Failed');
        }
    });
    });
}

function setForm(data) {
    $('#districtIdUpdate').val(data.districtId);
    $('#kabUpdate').val(data.kab);
    $('#districtNameUpdate').val(data.districtName);
    $('#provinceNameUpdate').val(data.provinceId.provinceId);
}

function resetForm() {
    $('#districtIdInsert').val("");
    $('#kabInsert').val("");
    $('#districtNameInsert').val("");
    $('#provinceNameInsert').val("");
}

//FUNCTION TO CLEAR VALIDATION AFTER CLOSING MODAL
function toggleValidation() {
    var element = document.querySelector(".was-validated");
    
    if(element!==null){
        element.classList.toggle("was-validated");
    }
}