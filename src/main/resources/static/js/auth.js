


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

