<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sleek Registration Page</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
            background-image: url('http://wallpapercave.com/wp/UQYb06y.jpg');
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            background-repeat: no-repeat;
            width: 100%;
            color: #ffffff;
        }

        .menu-bar {
            width: 100%;
            background-color: rgba(34, 34, 34, 0.8);
            display: flex;
            justify-content: flex-end;
            padding: 10px 20px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
        }

        .menu-bar a {
            margin-left: 20px;
            color: #bbbbbb;
            text-decoration: none;
            font-weight: bold;
            transition: color 0.3s ease;
        }

        .menu-bar a:hover {
            color: #ffffff;
        }

        .form-container {
            background-color: rgba(255, 255, 255, 0.1);
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
            width: 90%;
            max-width: 400px;
            margin-top: 50px;
            margin-right:500px;
            backdrop-filter: blur(10px);
            color: #333333;
        }

        h2 {
            margin-bottom: 20px;
            color: #4caf50;
            text-align: center;
        }

        .input-group {
            margin-bottom: 20px;
        }

        input {
            width: 100%;
            padding: 15px;
            border: 1px solid #cccccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 14px;
            background-color: rgba(255, 255, 255, 0.8);
            color: #333333;
        }

        input::placeholder {
            color: #aaaaaa;
        }

        input:focus {
            border-color: #888888;
            outline: none;
        }

        button {
            width: 100%;
            padding: 15px;
            background-color: #4caf50;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #45a049;
        }

        .error-message {
            color: red;
            text-align: center;
            display: none;
            font-weight: bold;
        }

        .toggle-link {
            text-align: center;
            margin-top: 10px;
        }

        .toggle-link a {
            color: #4caf50;
            text-decoration: none;
            font-weight: bold;
            transition: color 0.3s ease;
        }

        .toggle-link a:hover {
            color: #388e3c;
        }
    </style>
</head>
<body>
    <div class="menu-bar">
        <a href="index.jsp">Login</a>
        <a href="Owner.jsp">Owner</a>
    </div>
    <div class="form-container">
        <h2>Register</h2>
        ${message}
        <form method="post" action="regist" onsubmit="return validateForm()">
            <div class="input-group">
                <input type="text" placeholder="Username" name="name" required>
            </div>
            <div class="input-group">
                <input type="email" placeholder="Email" name="email" required>
            </div>
            <div class="input-group">
                <input type="password" placeholder="Password" name="password" id="password" required>
            </div>
            <div class="input-group">
                <input type="password" placeholder="Confirm Password" name="confirmPassword" id="confirmPassword" required>
            </div>
            <div class="input-group">
                <input type="submit" value="submit"></input>
            </div>
            <p class="error-message" id="errorMessage"></p>
        </form>
        <p class="toggle-link">Already have an account? <a href="index.jsp">Login here</a></p>
    </div>
    <script>
        function validateForm() {
            var password = document.getElementById("password").value;
            var confirmPassword = document.getElementById("confirmPassword").value;
            var errorMessage = document.getElementById("errorMessage");

            if (password !== confirmPassword) {
                errorMessage.textContent = "Passwords do not match.";
                errorMessage.style.display = "block";
                return false;
            }
            if (password.length < 5) {
                errorMessage.textContent = "Please add minimum 5 characters password";
                errorMessage.style.display = "block";
                return false;
            }
            errorMessage.style.display = "none";
            return true;
        }
    </script>
</body>
</html>
