<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="en">

<head>
    <title>Login Page</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f4f4;
        }

        .container {
            background-color: #fff;
            padding: 50px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
        }
        h2{
            text-align: center;
        }
    </style>
</head>

<body>
<div class="container">
    <h2>Login</h2>
    <form id="loginForm" method="post">
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required autocomplete="email">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required autocomplete="current-password">

        </div>
        <div class="form-group">
            <button type="submit" onclick="loginUser()">Login</button>
        </div>
    </form>
</div>
<script src="<c:url value="/resources/support/js/appjs/login.js"/>"></script>
</body>

</html>

