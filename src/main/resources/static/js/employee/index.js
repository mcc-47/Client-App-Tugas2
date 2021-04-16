let employee = new Object();
let table = null;

$(document).ready(() => {
    $("#loginForm").submit(e => {
        e.preventDefault();
        validationForm(login);
//        login();
    });
    
    getAll();
    
    $("#createForm").submit(e => {
        e.preventDefault();
        validationForm(createEmployee);
//        createEmployee();
    });
    
    $("#update").submit(e => {
        e.preventDefault();
        validationForm(updateEmployee);
//        updateEmployee();
    });
    
});

//GET ALL DATA
function getAll() {
    table = $('#tableId').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/employee/get-all",
            datatype: "json",
            dataSrc: ""
        },
        columns: [
            {
                data: "employeeId", name: "ID", autoWidth: true
            },
            {
                data: "employeeName", name: "Employee Name", autoWidth: true
            },
            {
                data: "birthDate", name: "Birth Date", autoWidth: true
            },
            {
                data: "gender", name: "Gender", autoWidth: true
            },
            {
                data: "email", name: "Email", autoWidth: true
            },
            {
                render: (data, type, row, meta) => {
                    return `
                        <button sec:authorize="hasAuthority('UPDATE')"
                            class='btn btn-sm btn-primary'
                            data-toggle="modal" 
                            data-target="#exampleModalLongUpdate"
                            onclick="getById('${row.employeeId}')">
                            <i class='fa fa-pencil'></i>
                        </button>
                        <button sec:authorize="hasAuthority('DELETE')"
                            class='btn btn-sm btn-danger' 
                            onclick="onClickDelete('${row.employeeId}')">
                            <i class='fa fa-trash'></i>
                        </button>
                        <div th:replace="employee/update-modal :: update"></div>
                    `;
                }
            }
        ]
    });
}


//GET BY ID
function getById(id) {
    console.log(id);
    $.ajax({
        url: `/employee/${id}`,
        type: 'GET',
        success: (res) => {
            console.log(res);
            console.log(res.employeeName);
            console.log(res.birthDate);
            setForm(res);
        }
    });
}

function setForm(emp) {
    $("#employeeIdUpt").val(emp.employeeId);
    $("#employeeNameUpt").val(emp.employeeName);
    $("#birthDateUpt").val(moment(emp.birthDate).format('YYYY[-]MM[-]DD'));
    $("#genderUpt").val(emp.gender);
    $("#emailUpt").val(emp.email);
}

//CREATE EMPLOYEE
function createEmployee() {
    employee = {
        employeeId: $("#employeeId").val(),
        employeeName: $("#employeeName").val(),
        birthDate: $("#birthDate").val(),
        gender: $("#gender").val(),
        email: $("#email").val()
    };
    console.log(employee);
    
    $.ajax({
        url: `/employee`,
        type: 'POST',
        data: JSON.stringify(employee),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: (res) => {
            createSuccessAlert();
            console.log("Success");
            table.ajax.reload();
            $("#exampleModalLong").modal("hide");
            document.getElementById("createForm").reset();
        },
        error: function (err) {
            errorAlert();
        }
    });
}

//UPDATE EMPLOYEE
function updateEmployee(){
    employee = {
        employeeId: $("#employeeIdUpt").val(),
        employeeName: $("#employeeNameUpt").val(),
        birthDate: $("#birthDateUpt").val(),
        gender: $("#genderUpt").val(),
        email: $("#emailUpt").val()
    };
    console.log(employee);
    
    $.ajax({
        url: `/employee/${employee.employeeId}`,
        type: 'PUT',
        data: JSON.stringify(employee),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: (res) => {
            console.log("Success");
            table.ajax.reload();
            updateSuccessAlert();
            $("#exampleModalLongUpdate").modal("hide");
        },
        error: function (err) {
            errorAlert();
        }
    });
}

//DELETE EMPLOYEE
function deleteEmployee(id) {
    $.ajax({
        url: `/employee/${id}`,
        type: 'DELETE',
        success: (res) => {
            table.ajax.reload();
            deleteSuccessAlert();
        }
    });
}

//LOGIN BUTTON
function login() {
    auth = {
        userName: $("#userName").val(),
        userPassword: $("#userPassword").val()
    };
    console.log(auth);
    
    $.ajax({
        url: `/login`,
        type: 'POST',
        data: JSON.stringify(auth),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: (res) => {
            console.log(res);
            if (res===true) {
            loginSuccess();
            console.log("Success");
            window.location.replace("/dashboard");
            } else {
            errorAlert();
            window.location.replace("/login?error");
            }
        },
        error: function (err) {
            errorAlert();
            window.location.replace("/login?error");
        }
    });
}

//FORM VALIDATION
function validationForm(action) {
    var forms = document.getElementsByClassName('needs-validation');
    var validation = Array.prototype.filter.call(forms, function (form) {
        if (form.checkValidity()) {
            action();
        }
        form.classList.add('was-validated');
    });
}
