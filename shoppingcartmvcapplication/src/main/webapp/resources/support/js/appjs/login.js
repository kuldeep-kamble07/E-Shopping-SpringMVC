function loginUser() {
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;

    var userData = {
        "email": email,
        "password": password
    };

    $.ajax({
        type: "POST",
        url: "/shoppingcartmvcapplication/login",
        contentType: "application/json",
        data: JSON.stringify(userData),
        success: function (userDto) {
            if (userDto && userDto.userId) {
                // Store user details in session storage
                sessionStorage.setItem("userId", userDto.userId);
                alert("Login successfully!");
                window.location.href = "/shoppingcartmvcapplication/buyproduct";
            } else {
                alert("User not exist!");
            }
        },
        error: function (error) {
            alert("Login failed. Please check your username and password.");
        }
    });
}

