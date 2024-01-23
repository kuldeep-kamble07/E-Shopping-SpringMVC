<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Cart</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            font-family: Arial;
            margin: 20px;
        }

        h1 {
            text-align: center;
            color: #333333;
        }

        table {
            width: 70%;
            margin-left: 15%;
            margin-right: 15%;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid black;
            padding: 8px 12px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        .action-buttons {
            display: flex;
            gap: 30px;
            align-items: center;
            justify-content: center;
        }
        .action-button {
            cursor: pointer;
            padding: 10px 10px;
            font-size: 16px;
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 20px;
        }

    </style>
</head>
<body>
<h1>My Cart</h1>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Category</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody id="products">

    </tbody>
</table>
<div class="action-button">
    <button onclick="submitCart()">Submit</button>
    <button onclick="discardCart()">Discard</button>
</div>
<script src="<c:url value="/resources/support/js/appjs/displayProductInCart.js"/>"></script>

</body>
</html>
