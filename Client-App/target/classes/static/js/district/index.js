let district = new Object();
let table = null;

$(document).ready(() => {
    getAll();
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
                data: "districtId", name: "District Id", autoWidth: true
            },
            {
                data: "kotakab", name: "Kota_Kabupaten", autoWidth: true
            },
            {
                data: "districtName", name: "District Name", autoWidth: true
            },

            {
                data: "provinceId.provinceName", name: "Province Name", autoWidth: true
            },
            {
                render: (data, type, row, meta) => {
                    return `
                        <button 
                            class='btn btn-sm btn-primary'
                            data-toggle="modal" 
                            data-target="#form-update"
                            onclick="getById('${row.districtId}')" sec:authorize="hasRole('ADMIN')">
                            
                            <i class='fas fa-sm fa-pencil-alt'></i> Update
                        </button>
                        <button class='btn btn-sm btn-danger' onclick="deleteById('${row.districtId}')">
                            <i class='fas fa-sm fa-trash'></i> Delete
                        </button>
                    `;
                }
            }
        ]
    });
}

function getById(id) {
    $.ajax({
        url: `/district/${id}`,
        type: 'GET',
        success: (res) => {
            setForm(res);
        }
    });
}

function create() {
    district = {
        districtId: $("#district-id").val(),
        kotakab: $("#kota-kab").val(),
        districtName: $("#district-name").val(),
        provinceId: {
            provinceId: $("#province-id").val()
        }

    };
    $.ajax({
        url: "/district",
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(district),
        success: (res) => {
            table.ajax.reload();
            successAlert("District Created");
            $("#form-add").modal("hide");
        },
        error: (err) => {
            errorAlert("District failed created");
        }
    });
}



function setForm(data) {
    $("#districtId").val(data.districtId);
    $("#kotakab").val(data.kotakab);
    $("#districtName").val(data.districtName);
    $("#provinceId").val(data.provinceId);
}

function update() {
    district = {
        districtId: $("#districtId").val(),
        kotakab: $("#kotakab").val(),
        districtName: $("#districtName").val(),
        provinceId: {
            provinceId: $("#provinceId").val()
        }
    };

    let id = $("#districtId").val();
    $.ajax({
        url: `/district/${id}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(district),
        success: (res) => {
            table.ajax.reload();
            successAlert("District Updated");
            $("#form-update").modal("hide");
        },
        error: (err) => {
            errorAlert("District failed updated");
        }
    });
}

function deleteById(id) {

    questionAlert("Are you sure?", "Do you want to delete this data?", function()  {
        $.ajax({
            url: `/district/${id}`,
            type: 'DELETE',
            
            success: (res) => {
                errorAlert("District failed deleted");
            },
            error: (err) => {
                table.ajax.reload();
                successAlert("District sucess deleted");
            }
        });
    });
}