<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Owner Registration Form</title>
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
            background-image: url('https://static.vecteezy.com/system/resources/previews/026/998/865/non_2x/cute-animal-on-nature-ai-image-free-photo.jpg');
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            background-repeat: no-repeat;
            width: 100%;
            color: #ffffff;
        }

        .container {
            background-color: rgba(255, 255, 255, 0.1);
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
            width: 90%;
            max-width: 400px;
            margin-top: 50px;
            backdrop-filter: blur(10px);
            color: #333333;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #4caf50;
        }

        input[type="text"], input[type="password"], input[type="email"] {
            width: 100%;
            padding: 15px;
            margin: 10px 0;
            border: 1px solid #cccccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 14px;
            background-color: rgba(255, 255, 255, 0.8);
            color: #333333;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: white;
            border: none;
            padding: 15px;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
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
    <div class="container">
        <h2>Owner Registration Form</h2>
        ${result}
        <form id="regForm" method="post" action="owner" onsubmit="return validateForm()">
            <input type="text" id="name" placeholder="Full Name" name="name" required>
            <input type="email" id="email" placeholder="Email" name="email" required>
            <input type="password" id="password" placeholder="Password" name="password" required>
            <input type="password" id="confirm_password" placeholder="Confirm Password" name="conpass" required>
            <input type="submit" value="submit">
            <p class="error-message" id="errorMessage"></p>
        </form>
        <p class="toggle-link">Have an account? <a href="Owner.jsp">Login here</a></p>
    </div>
    <script>
        function validateForm() {
            var password = document.getElementById("password").value;
            var confirmPassword = document.getElementById("confirm_password").value;
            var errorMessage = document.getElementById("errorMessage");

            if (password !== confirmPassword) {
                errorMessage.textContent = "Passwords do not match.";
                errorMessage.style.display = "block";
                return false;
            }
            if (password.length < 5) {
                errorMessage.textContent = "Please add a minimum 5 characters password.";
                errorMessage.style.display = "block";
                return false;
            }
            errorMessage.style.display = "none";
            return true;
        }
    </script>
</body>
</html>
