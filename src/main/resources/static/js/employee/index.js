let employee = new Object();

$(document).ready(() => {
    getAll();

//    $("form").submit(e => {
//        e.preventDefault();
//        create();
//    });
});

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
                        <button 
                            class='btn btn-sm btn-primary'
                            data-toggle="modal" 
                            data-target="#exampleModalLongUpdate"
                            onclick="getById('${data.employeeId}')">
                            <i class='fa fa-pencil'></i>
                        </button>
                        <div th:replace="employee/update-modal :: update"></div>
                        
                        <button 
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
    $("#employeeId").val(emp.employeeId);
    $("#employeeName").val(emp.employeeName);
    $("#birthDate").val(emp.birthDate);
    $("#email").val(emp.email);
}

function deleteEmployee(id) {
    console.log(id);
    $.ajax({
        url: `/employee/${id}`,
        type: 'DELETE',
        success: () => {
            console.log(id);
            $(parent).remove();
        }
    });
}