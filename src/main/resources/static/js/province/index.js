let post = new Object();

$(document).ready(() => {
    getAll();
    
    $("#insertprovince").submit(e => {
        e.preventDefault();
        formValidation(create);
    });
    
    $("#updateprovince").submit(e=>{
        e.preventDefault();
        formValidation(update);
    })
});

function getAll() {
    table = $('#myTable').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/province/get-all",
            datatype: "json",
            dataSrc: ""
        },
        columns: [
            {
                data: "provinceId", name: "Province ID", autoWidth: true
            },
            {
                data: "provinceName", name: "Province Name", autoWidth: true
            },
            {
                render: (data, type, row, meta) => {
                    return `
                        <button 
                            class='btn btn-sm ' style="background-color:#0e9aa7;color:#ffffff"
                            data-toggle="modal" 
                            data-target="#tambah2"
                            onclick="getById('${row.provinceId}')"
                        >
                             <i class='far fa-edit'></i>
                        </button>
                    
                    
                        <button class='btn btn-sm btn-warning' style="color:#ffffff" onclick=del('${row.provinceId}')>
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
        url: `/province/${id}`,
        type: 'GET',
        success: (res) => {
            setForm(res);
        }
    });
}

function create() {
    $.ajax({
       url: `/province/add`,
       type: "POST",
       data: JSON.stringify({
            provinceId: $('#provinceId1').val(),
            provinceName: $('#provinceName1').val()
       }),
       
       contentType:'application/json; charset=UTF-8',
       success:(res)=>{
            table.ajax.reload();
            successAlert("Province Created");
            console.log(res);
            $("#tambah1").modal("hide");
       },
       error : (err)=>{
           errorAlert("Province Failed to Created");
           console.log(err);
       }
    })
    
}

function update() {
    $.ajax({
       url: `/province/`+$('#provinceId').val(),
       type: "PUT",
       data: JSON.stringify({
            provinceId: $('#provinceId').val(),
             provinceName: $('#provinceName').val()
       }),
       
       contentType:'application/json; charset=UTF-8',
       success:(res)=>{
           table.ajax.reload();
            successAlert("Province Updated")
           console.log(res);
           $("#tambah2").modal("hide");
       },
       error : (err)=>{
           errorAlert("Province Failed to Created");
           console.log(err);
       }
    })
    
}

function del(id) {
    questionAlert("Are you sure?", "Do you want to delete this data?", () => {
        $.ajax({
            url: `/province/${id}`,
            type: 'DELETE',
            success: (res) => {
                table.ajax.reload();
                console.log(res);
                successAlert("Province deleted");
            },
            error: (err) => {
                errorAlert("Province Failed deleted");
            }
        });
    });
}

function setForm(data) {
    $("#provinceId").val(data.provinceId);
    $("#provinceName").val(data.provinceName);
   
}
