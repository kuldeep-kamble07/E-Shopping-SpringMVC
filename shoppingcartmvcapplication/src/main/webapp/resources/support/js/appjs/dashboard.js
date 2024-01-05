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


function fetchProductsByCategory(category) {
    $.ajax({
        type: "GET",
        url: "/shoppingcartmvcapplication/dashboard/data",
        headers: {
            "Content-Type": 'application/json',
            "category": category
        },
        dataType: 'json',
        success: function (products) {
            displayProducts(products);
        },
        error: function () {
            alert("Error fetching products");
        }
    });
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
            "<td><button onclick='removeproduct(\"" + product.name + "\")'>remove product</button></td>" +
            "</tr>";
            "</tr>";
        $("#product").append(row);
    });
}



function removeproduct(name) {
    var confirmation = confirm("Are you sure you want to remove the product?");

    if (confirmation) {
        $.ajax({
            type: "GET",
            url: "/shoppingcartmvcapplication/removeproduct/" + name,
            success: function (response) {
                alert("Product removed successfully!");
            },
            error: function () {
                alert("Error removing product");
            }
        });
    }
}


// function removeproduct(productId) {
//     var quantity = prompt("Enter quantity for the product:", "1");
//
//     if (quantity != null) {
//         var productData = {
//             id: productId,
//             quantity: quantity
//         };
//
//         $.ajax({
//             type: "POST",
//             url: "/shoppingcartmvcapplication/add",
//             contentType: "application/json",
//             data: JSON.stringify(productData),
//             success: function (response) {
//                 alert("Product added to cart successfully!");
//             },
//             error: function () {
//                 alert("Error adding product to cart");
//             }
//         });
//     }
// }
