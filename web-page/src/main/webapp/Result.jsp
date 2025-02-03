<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Entry List</title>
    <style>
        body {
            background-color: #f0f8ff;
            font-family: 'Arial', sans-serif;
        }
        .menu {
            width: 100%;
            background-color: #4caf50;
            overflow: auto;
            text-align: center;
            padding: 10px 0;
        }
        .menu a {
            padding: 14px 16px;
            text-decoration: none;
            color: white;
            text-align: center;
            font-size: 18px;
        }
        .menu a:hover {
            background-color: #45a049;
            color: white;
        }
        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: #fffdfd;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: center;
        }
        th {
            background-color: #add8e6;
            color: #333;
        }
        td {
            color: #555;
        }
        h2 {
            text-align: center;
            color: #4caf50;
        }
    </style>
</head>
<body>
    <div class="menu">
        <a href="index.jsp">Home</a>
    </div>
    <h2>Milk Details</h2>
    <table>
        <tr>
            <th>DATE</th>
            <th>TIME</th>
            <th>Milk Price</th>
            <th>Quantity in leter</th>
            <th>Total Amount</th>
        </tr>
        <c:forEach var="milk" items="${list}">
            <tr>
                <td>${milk.data}</td>
                <td>${milk.time}</td>
                <td>${milk.price}</td>
                <td>${milk.quantity}</td>
                <td>${milk.totalamount}</td>
            </tr>
        </c:forEach>
        <tr cellspacing=3>
            <td colspan="4"><h3>Grand Total</h3></td>
            <td><h3>${grand}</h3></td>
        </tr>
    </table>
</body>
</html>
