// function selectCategory(data){
//         let category = $(data).attr('data-category');
//         sessionStorage.category = category;
//         fetchProductsByCategory(sessionStorage.category)
//     }
// function fetchProducts() {
//     $.ajax({
//         type: "GET",
//         url: "/shoppingcartmvcapplication/dashboard",
//         headers: {'category':'SPORTS'},
//         dataType: 'json',
//         success: function (product) {
//             $.each(product, function(index, product) {
//                 var row = "<tr>" +
//                     "<td>" + (index + 1) + "</td>" +
//                     "<td>" + product.name + "</td>" +
//                     "<td>" + product.price + "</td>" +
//                     "<td>" + product.quantity + "</td>" +
//                     "<td>" + product.expiryDate + "</td>" +
//                     "<td><button onclick='addToCart(" + product.id + ")'>add to cart</button></td>" +
//                     "</tr>";
//                 $("#product").append(row);
//             });
//         },
//         error: function () {
//             alert("Error fetching products");
//         }
//     });
// }
// $(document).ready(function (){
//     var userId= sessionStorage.getItem('userId');
//     if(userId) {
//         addproduct(userId);
//     }
// })


function onCategoryChange() {
    var category = $("#productCategory").val();
    sessionStorage.setItem("category", category);
    if (category) {
        fetchProductsByCategory(category);
    }
}
function fetchProductsByCategory(category) {
   // var storedCategory = sessionStorage.getItem("category");
   // category = storedCategory || category;

    let header = {
        category: category,
    };
    $.ajax({
        type: "GET",
        url: "/shoppingcartmvcapplication/dashboard/data",
        dataType: 'json',
        headers: header,
        success: function (products) {
            sessionStorage.setItem("products", JSON.stringify(products));
            displayProducts(products);

            window.location.href = "/shoppingcartmvcapplication/dashboard";
        },
        error: function () {
            alert("Error fetching products");
        }
    });
}

function displayStoredProducts() {
    var storedProducts = sessionStorage.getItem("products");

    if (storedProducts) {
        var products = JSON.parse(storedProducts);
        displayProducts(products);
    }
}

function displayProducts(products) {
    $("#product").empty();  // Clear existing rows
    $.each(products, function (index, product) {
        var row = "<tr>" +
            "<td>" + (index + 1) + "</td>" +
            "<td>" + product.name + "</td>" +
            "<td>" + product.price + "</td>" +
            "<td>" + product.quantity + "</td>" +
            "<td>" + product.expiryDate + "</td>" +
          //  "<td><button onclick='removeproduct(\"" + product.name + "\")'>remove product</button></td>" +
            "<td><button onclick='addproduct(\"" + product.id + "\")'>Add To cart</button></td>" +
            "</tr>";
            "</tr>";
        $("#product").append(row);
    });
}
$(document).ready(function () {
    displayStoredProducts();
});



// function removeproduct(name) {
//     var confirmation = confirm("Are you sure you want to remove the product?");
//
//     if (confirmation) {
//         $.ajax({
//             type: "GET",
//             url: "/shoppingcartmvcapplication/removeproduct/" + name,
//             success: function (response) {
//                 alert("Product removed successfully!");
//             },
//             error: function () {
//                 alert("Error removing product");
//             }
//         });
//     }
// }


function addproduct(productId) {
    var quantity = prompt("Enter quantity for the product:", "1");
    var userId = sessionStorage.getItem("userId");
    if (quantity != null) {
        var productData = {
            userId:userId,
            productId: productId,
            quantity: quantity
        };

        $.ajax({
            type: "POST",
            url: "/shoppingcartmvcapplication/addtocart",
            contentType: "application/json",
            data: JSON.stringify(productData),
            headers: {
                "userId": userId,
                "productId":productId,
                "quantity":quantity
            },
            success: function (response) {
                alert("Product added to cart successfully!");
            },
            error: function (error) {
                alert("Error adding product to cart");
            }
        });
    }
}
function displayUserDteail() {
    var email = sessionStorage.getItem("email");
    var password = sessionStorage.getItem("password");
    var userId = sessionStorage.getItem("userId");

    if (email !== null && password !== null) {
        var credentialData = {
            email: email,
            password: password
        };

        $.ajax({
            type: "POST",
            url: "/shoppingcartmvcapplication/displayUserDteail",
            contentType: "application/json",
            data: JSON.stringify(credentialData),
            dataType: "json",
            success: function (response) {
                //alert("Fetching data successfully");
                // sessionStorage.setItem("userId", response.userId);
               // sessionStorage.getItem("userId");
                showUserDetails(response);
            },
            error: function (error) {
                alert("Error fetching data" + error);
            }
        });
    } else {
        alert("Username or password is null.");
    }
}
function showUserDetails(userData) {
    var userDetails = `
        First Name: ${userData.firstname}
        Last Name: ${userData.lastname}
        Email: ${userData.email}
        Mobile Number: ${userData.mobileNo}
    `;
    alert(userDetails);
}
function displayCart() {
    window.location.href ="/shoppingcartmvcapplication/showCart";
}
