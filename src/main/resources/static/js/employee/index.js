let employee = new Object();

$(document).ready(() => {
    getAll();

});

//GET ALL DATA
function getAll() {
    $.ajax({
        url: "/employee/get-all",
        type: "GET",
        success: (employees) => {
            let element = "";
            employees.forEach(data => {
                element = element + `<tr>
                    <td>${data.employeeId}</td>
                    <td>${data.employeeName}</td>
                    <td>${data.birthDate}</td>
                    <td>${data.gender}</td>
                    <td>${data.email}</td>
                    <td>
                        <button sec:authorize="hasAuthority('UPDATE')"
                            class='btn btn-sm btn-primary'
                            data-toggle="modal" 
                            data-target="#exampleModalLongUpdate"
                            onclick="getById('${data.employeeId}')">
                            <i class='fa fa-pencil'></i>
                        </button>
                        <div th:replace="employee/update-modal :: update"></div>
                        
                        <button sec:authorize="hasAuthority('DELETE')"
                            class='btn btn-sm btn-danger' 
                            onclick="onClickDelete('${data.employeeId}')">
                            <i class='fa fa-trash'></i>
                        </button>
                    `;
            });

            $("#tbodyGais").append(element);
            $('#table_id').DataTable();
        }
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
            setForm(res);
        }
    });
}

function setForm(emp) {
    $("#employeeIdUpt").val(emp.employeeId);
    $("#employeeNameUpt").val(emp.employeeName);
    $("#birthDateUpt").val(emp.birthDate);
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
        error: function (errrrrr) {
            setInterval('location.reload()', 1000);
        },
        success: (res) => {
            console.log("Success");
            setInterval('location.reload()', 1000);
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
            setInterval('location.reload()', 1000);
        }
    });
}

//DELETE EMPLOYEE
function deleteEmployee(id) {
    console.log(id);
    $.ajax({
        url: `/employee/${id}`,
        type: 'DELETE',
        success: (res) => {
            console.log(id);
            setInterval('location.reload()', 1000);
        }
    });
}