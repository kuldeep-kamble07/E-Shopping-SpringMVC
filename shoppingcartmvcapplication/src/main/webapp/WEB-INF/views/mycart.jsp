<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Cart</title>
    <!-- Include your CSS or any other necessary resources -->
    <style>
        body{
            font-family: Arial;
            margin: 20px;
        }
        h1{
            text-align: center;
            color: #333333;
        }
        table{
            width:70%;
            margin-left:15%;
            margin-right:15%;
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
    </style>
</head>
<body>
<h1>Your Cart</h1>
<table>
    <thead>
    <tr>
        <th>Product Name</th>
        <th>Quantity</th>
        <!-- Add more columns as needed -->
    </tr>
    </thead>
    <tbody>
    <!-- Loop through cartItems -->

    </tbody>
</table>
</body>
</html>
