let post = new Object();
let table = null;
let id = 0;

$(document).ready(() => {
    getAll();
    
    $("#postForm").submit((e) => {
        e.preventDefault();
        formValidation(this.id ? update : create);
    });
});

function getAll() {
    table = $('#postTable').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/post/get-all",
            datatype: "json",
            dataSrc: ""
        },
        columns: [
            {
                data: "userId", name: "User Id", autoWidth: true
            },
            {
                data: "title", name: "Title", autoWidth: true
            },
            {
                data: "body", name: "Body", autoWidth: true
            },
            {
                render: (data, type, row, meta) => {
                    return `
                        <button 
                            class='btn btn-sm btn-primary'
                            data-bs-toggle="modal" 
                            data-bs-target="#postModal"
                            onclick="getById('${row.id}')"
                        >
                            <i class='fas fa-sm fa-pencil-alt'></i>
                        </button>
                        <button class='btn btn-sm btn-danger' onclick='deleteById(${row.id})'>
                            <i class='fas fa-sm fa-trash'></i>
                        </button>
                    `;
                }
            }
        ]
    });
}

function getById(id) {
    this.id = id;
    $.ajax({
        url: `/post/${id}`,
        type: 'GET',
        success: (res) => {
            setForm(res);
        }
    });
}

function create() {
    post = {
        title: $("#title").val(),
        userId: $("#userId").val(),
        body: $("#body").val()
    };

    $.ajax({
        url: "/post",
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(post),
        success: (res) => {
            table.ajax.reload();
            successAlert("Employee Created");
            $("#postModal").modal("hide");
        },
        error: (err) => {
            errorAlert("Employee failed created");
        }
    });
}

function update() {
    post = {
        title: $("#title").val(),
        userId: $("#userId").val(),
        body: $("#body").val()
    };

    $.ajax({
        url: `/post/${this.id}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(post),
        success: (res) => {
            table.ajax.reload();
            successAlert("Employee updated");
            $("#postModal").modal("hide");
        },
        error: (err) => {
            errorAlert("Employee failed updated");
        }
    });
}

function deleteById(id) {
    questionAlert("Are you sure?", "Do you want to delete this data?", () => {
        $.ajax({
            url: `/post/${id}`,
            type: 'DELETE',
            success: (res) => {
                successAlert("Post deleted");
            },
            error: (err) => {
                errorAlert("Employee failed deleted");
            }
        });
    });
}

function setForm(data) {
    $("#userId").val(data.userId);
    $("#title").val(data.title);
    $("#body").val(data.body);
}

function resetForm() {
    this.id = 0;
    $("#userId").val("");
    $("#title").val("");
    $("#body").val("");
}