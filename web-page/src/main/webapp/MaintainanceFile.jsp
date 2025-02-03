<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Form with Top Menu</title>
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
            background-color: #f5f5f5;
            width: 100%;
            color: #333333;
        }

        .navbar {
            width: 100%;
            background-color: #ffffff;
            border-bottom: 2px solid #e0e0e0;
            overflow: hidden;
        }

        .navbar a,
        .navbar form input {
            float: right;
            display: block;
            color: #333333;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
            transition: color 0.3s ease;
            border: none;
            background: none;
        }

        .navbar a:hover,
        .navbar form input:hover {
            background-color: #e0e0e0;
            color: #000;
        }

        .navbar form {
            float: right;
            display: block;
            text-align: center;
            padding: 0;
            margin: 0;
        }

        .container {
            padding: 20px;
            display: flex;
            justify-content: space-between;
            align-items: flex-start;
            width: 100%;
            max-width: 1200px;
        }

        .form-container {
            max-width: 450px;
            width: 90%;
            padding: 30px;
            background-color: #ffffff;
            border-radius: 15px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            color: #333333;
            position: sticky;
            top: 20px;
        }

        h1 {
            text-align: center;
            color: #4caf50;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            color: #333333;
        }

        .form-group select,
        .form-group input {
            width: 100%;
            padding: 15px;
            border: 1px solid #cccccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 14px;
            background-color: #ffffff;
            color: #333333;
        }

        .form-group input[type="range"] {
            width: calc(100% - 50px);
            display: inline-block;
        }

        .dial-output {
            display: inline-block;
            width: 50px;
            text-align: center;
            color: #333333;
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
            margin-bottom: 10px;
        }

        button:hover {
            background-color: #45a049;
        }

        .table-container {
            max-width: 600px;
            width: 100%;
            margin-left: 20px;
            max-height: 500px;
            overflow-y: auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #cccccc;
            text-align: left;
            padding: 10px;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <a href="OwnerRegister.jsp">Add</a>
        <a href="index.jsp">Login</a>
        <form method="get" action="alldata">
            <input type="submit" value="DATA">
        </form>
    </div>
    <div class="container">
        <div class="table-container">
            <c:if test="${not empty list}">
                <h2>Milk Records</h2>
                <table>
                    <tr>
                        <th>Name</th>
                        <th>Date</th>
                        <th>Time</th>
                        <th>Milk Price</th>
                        <th>Quantity (L)</th>
                        <th>Total Amount</th>
                    </tr>
                    <c:forEach var="milk" items="${list}">
                        <tr>
                            <td>${milk.userName}</td>
                            <td>${milk.data}</td>
                            <td>${milk.time}</td>
                            <td>${milk.price}</td>
                            <td>${milk.quantity}</td>
                            <td>${milk.totalamount}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
        <div class="form-container">
            <h2>${result}</h2>
            <h1>Input Form</h1>
            <form method="post" action="entry">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <select id="name" name="name">
                        <c:forEach var="name" items="${names}">
                            <option value="${name}">${name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="quantity">Quantity:</label>
                    <input type="number" id="quantity" name="quantity" step="0.1">
                </div>
                <div class="form-group">
                    <label for="amount">Amount:</label>
                    <input type="range" id="amount" name="amount" min="0" max="100" step="0.1" oninput="updateAmountValue(this.value)">
                    <output id="amountValue" class="dial-output">50.0</output>
                </div>
                <button type="submit">Submit</button>
            </form>
        </div>
    </div>

    <script>
        function updateAmountValue(value) {
            document.getElementById('amountValue').value = value;
        }
    </script>
</body>
</html>
