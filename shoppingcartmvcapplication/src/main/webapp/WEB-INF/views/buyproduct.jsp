<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Shopping Cart</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

    <style>
        body {
            text-align: center;
        }

        #btnDisplaymycart, #productCategory {
            margin-top: 20px;
        }

        #productCategory {
            margin-left: 10px;
        }

        #categoryHeading {
            margin-top: 20px;
        }
    </style>
</head>
<body>

<h1>Dashboard</h1>

<button id="btnDisplaymycart" type="button" onclick="displayCart()">My Cart</button>

<div>
    <h2 id="categoryHeading">Buy Product</h2>
    <label for="productCategory">Category:</label>
    <select id="productCategory" name="productCategory" onchange="onCategoryChange()">
        <option value="" disabled selected>Search product</option>
        <option value="STATIONARY">Stationary</option>
        <option value="COSMETIC">Cosmetic</option>
        <option value="ELECTRONICS">Electronics</option>
        <option value="CLOTHING">Clothing</option>
        <option value="SPORTS">Sports</option>
    </select>
</div>

<script src="<c:url value="/resources/support/js/appjs/dashboard.js"/>"></script>
</body>
</html>
