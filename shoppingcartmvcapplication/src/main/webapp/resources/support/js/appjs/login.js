function loginUser() {
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;

    sessionStorage.setItem("email", email);
    sessionStorage.setItem("password", password);

    var userData = {
        "email": email,
        "password": password
    };

    $.ajax({
        type: "POST",
        url: "/shoppingcartmvcapplication/login",
        contentType: "application/json",
        data: JSON.stringify(userData),
        success: function (response) {
            if (response === "Login Successfully !") {
                alert("Login successfully!");
            } else {
                alert("User not exist!");
            }
        },
        error: function (error) {
            alert("Login failed. Please check your username and password.");
        }
    });
}