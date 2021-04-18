let district = new Object();
let table = null;

$(document).ready(() => {
    getAll();

    $("#insertdistrict").submit(e => {
        e.preventDefault();
        formValidation(create);

    });

    $("#updatedistrict").submit(e => {
        e.preventDefault();
        formValidation(update);
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
                data: "districtId", name: "district Id", autoWidth: true
            },
            {
                data: "kab", name: "Kota / Kabupaten", autoWidth: true
            },
            {
                data: "districtName", name: "District Name", autoWidth: true
            },
            {
                render: (data, type, row, meta) => {
                    return `
                        <button 
                            class='btn btn-sm ' style="background-color:#0e9aa7;color:#ffffff"
                            data-toggle="modal" 
                            data-target="#tambah2"
                            onclick="getById('${row.districtId}')"
                        >
                            <i class='far fa-edit'></i>
                        </button>
                    
                    
                        <button class='btn btn-sm btn-warning' style="color:#ffffff" onclick=del('${row.districtId}')>
                            <i class='far fa-trash-alt'></i>
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
    $.ajax({
        url: `/district/add`,
        type: "POST",
        data: JSON.stringify({
            districtId: $('#districtId1').val(),
            districtName: $('#districtName1').val(),
            kab: $('#kab1').val(),
            provinceId: $('#provinceId1').val()
        }),

        contentType: 'application/json; charset=UTF-8',
        success: (res) => {
            table.ajax.reload();
            successAlert("District Created");
            console.log(res);
            $("#tambah1").modal("hide");
        },
        error: (err) => {
            errorAlert("District Failed to Created");
            console.log(err);
        }
    })

}

function update() {
    $.ajax({
        url: `/district/` + $('#districtId').val(),
        type: "PUT",
        data: JSON.stringify({
            districtId: $('#districtId').val(),
            districtName: $('#districtName').val(),
            kab: $('#kab').val(),
            provinceId: $('#provinceId').val()
        }),

        contentType: 'application/json; charset=UTF-8',
        success: (res) => {
            table.ajax.reload();
            console.log(res);
            successAlert("District Edited");
            $("#tambah2").modal("hide");
        },
        error: (err) => {
            errorAlert("District Failed to Updated");
            console.log(err);
        }
    })

}
function del(id) {
    questionAlert("Are you sure?", "Do you want to delete this data?", () => {
        $.ajax({
            url: `/district/${id}`,
            type: 'DELETE',
            success: (res) => {
                table.ajax.reload();
                console.log(res);
                successAlert("District deleted");
            },
            error: (err) => {
                errorAlert("District Failed to Deleted");
            }
        });
    });
}


function setForm(data) {
    $("#districtId").val(data.districtId);
    $("#kab").val(data.kab);
    $("#districtName").val(data.districtName);
    $("#provinceId").val(data.provinceId);
}

