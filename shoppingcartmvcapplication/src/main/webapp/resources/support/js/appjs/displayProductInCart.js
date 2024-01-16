$(document).ready(function() {
    var userId = sessionStorage.getItem("userId");

    $.ajax({
        type: "GET",
        url: "/shoppingcartmvcapplication/cart/products",
        contentType: "application/json",
        headers: {
            "userId": userId
        },
        success: function (products) {
            var tableBody = $("#products");
            tableBody.empty();
            products.forEach(function (product) {
                var row = "<tr>" +
                    "<td>" + product.name + "</td>" +
                    "<td>" + product.price + "</td>" +
                    "<td>" + product.quantity + "</td>" +
                    "<td>" + product.category + "</td>" +
                    "<td>" + product.expiryDate + "</td>" +
                    "<td class='action-buttons'>" +
                    "<i class='fas fa-plus action-button' onclick='increaseQuantity(\"" + product.id + "\")'></i>" +
                    "<i class='fas fa-minus action-button' onclick='decreaseQuantity(\"" + product.id + "\")'></i>" +
                    "<i class='fas fa-trash-alt action-button' onclick='deleteProduct(\"" + product.id + "\")'></i>" +
                    "</td>" +
                    "</tr>";
                tableBody.append(row);
            });
        },
        error: function (error) {
            console.error("Error fetching products in cart:", error);
            alert("Error fetching products in cart");
        }
    });


    function increaseQuantity(productId) {

    }

    function decreaseQuantity(productId) {

    }

    function deleteProduct(productId) {
    }
});