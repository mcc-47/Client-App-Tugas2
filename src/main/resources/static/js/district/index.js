function login() {
    $.ajax({
        url:`/login`,
        type: "GET",
        success:(res) => {
            setForm(res);
            alertSmall('success', 'Login Success')
        }
    });
}

$(document).ready(() => {
    getAll();
    
    
});

function getAll() {
    $.ajax({
        url: "/district/get-all",
        type:"GET",
        success:(res) => {
            let element='';
            res.forEach(data => {
                element = element + `<tr>
                    <td class="counterCell"></td>
                    <td>${data.kab}</td>
                    <td>${data.districtName}</td>
                    <td>${data.provinceId.provinceName}</td>
                    <td>
                        <button type="button" class="btn btn-warning fas fa-edit mr-2 p-2" 
                                    data-toggle="modal" data-target="#edit-district"
                                    onclick="getById('${data.districtId}')"
                                    >Modal</button>
                        <button class='btn btn-sm btn-danger'>
                            <i class='fas fa-sm fa-trash'></i>
                        </button>
                        <button type="button" class="btn btn-danger fas fa-trash-alt mr-2 p-2" 
                                    onclick="del('${data.districtId}')"></button>
                    </td>
                    `;
            });
            $("table tbody").append(element);
            $('#myTable').DataTable();
        }
    });
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

function setForm(data) {
    $('#districtIdUpdate').val(data.districtId);
    $('#kabUpdate').val(data.kab);
    $('#districtNameUpdate').val(data.districtName);
    $('#provinceNameUpdate').val(data.provinceId.provinceName);
}

function insert() {
    $.ajax({
        url:'/district/insert',
        type: "POST",
        data: JSON.stringify({districtId: $('#districtIdInsert').val(), kab: $('#kabInsert').val(), 
            districtName: $('#districtNameInsert').val(), provinceId: {provinceId: $('#provinceIdInsert').val()
        }}),
        contentType: 'application/json; charset=UTF-8',
        success: (res) => {
            console.log(res);
            alertSmall('success', 'Insert Success');
        },
        error: (err) => {
            console.log(err);
            alertSmall('error', 'Insert Failed');
        }
    })
}

function update() {
    $.ajax({
        url:"/district/update/"+$('#districtIdUpdate').val(),
        type: "PUT",
        data: JSON.stringify({districtId: $('#districtIdUpdate').val(), kab: $('#kabUpdate').val(), districtName: $('#districtNameUpdate').val(), provinceId: {provinceId: $('#provinceIdUpdate').val()
        }}),
        contentType: 'application/json; charset=UTF-8',
        success: (res) => {
            console.log(res);
            alertSmall('success', 'Edit Success')
        },
        error: (err) => {
            console.log(err);
            alertSmall('error', 'Edit Failed')
        }
    })
}

function del(id) {
    alertConfirm('Are you sure want to delete this?', '', 'warning', 'Yes, delete it', 'success', 'Delete Success',
        function() {$.ajax({
        url:`/district/delete/${id}`,
        type: "DELETE",
        success: (res) => {
            console.log(res);
        },
        error: (err) => {
            console.log(err);
            alertSmall('error', 'Delete Failed')
        }
    })}
    )
    
}