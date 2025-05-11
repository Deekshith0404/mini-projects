<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration Portal</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        :root {
            --primary: #4361ee;
            --primary-dark: #3a56d4;
            --secondary: #3f37c9;
            --accent: #4895ef;
            --light: #f8f9fa;
            --dark: #212529;
            --gray: #6c757d;
            --success: #4cc9f0;
            --danger: #f72585;
            --warning: #f8961e;
            --info: #4895ef;
            --transition: all 0.3s ease;
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            color: var(--dark);
            min-height: 100vh;
            line-height: 1.6;
        }

        /* Navigation */
        .navbar {
            background: rgba(255, 255, 255, 0.9);
            backdrop-filter: blur(10px);
            box-shadow: 0 2px 15px rgba(0, 0, 0, 0.1);
            padding: 1rem 2rem;
            position: sticky;
            top: 0;
            z-index: 1000;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .logo {
            font-size: 1.5rem;
            font-weight: 700;
            color: var(--primary);
            text-decoration: none;
            display: flex;
            align-items: center;
        }

        .logo i {
            margin-right: 10px;
            color: var(--accent);
        }

        .nav-links {
            display: flex;
            gap: 1.5rem;
        }

        .nav-links a {
            color: var(--dark);
            text-decoration: none;
            font-weight: 500;
            transition: var(--transition);
            position: relative;
        }

        .nav-links a:hover {
            color: var(--primary);
        }

        .nav-links a::after {
            content: '';
            position: absolute;
            bottom: -5px;
            left: 0;
            width: 0;
            height: 2px;
            background: var(--primary);
            transition: var(--transition);
        }

        .nav-links a:hover::after {
            width: 100%;
        }

        /* Main Container */
        .main-container {
            max-width: 1200px;
            margin: 2rem auto;
            padding: 0 2rem;
        }

        /* Form Container */
        .form-container {
            background: rgba(255, 255, 255, 0.95);
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
            padding: 2.5rem;
            margin-bottom: 3rem;
            transition: var(--transition);
        }

        .form-container:hover {
            box-shadow: 0 15px 40px rgba(0, 0, 0, 0.15);
        }

        .form-header {
            text-align: center;
            margin-bottom: 2rem;
            position: relative;
        }

        .form-header h1 {
            font-size: 2.2rem;
            color: var(--primary);
            margin-bottom: 0.5rem;
        }

        .form-header p {
            color: var(--gray);
        }

        .form-header::after {
            content: '';
            position: absolute;
            bottom: -15px;
            left: 50%;
            transform: translateX(-50%);
            width: 80px;
            height: 4px;
            background: var(--accent);
            border-radius: 2px;
        }

        /* Form Elements */
        .form-grid {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 1.5rem;
            margin-bottom: 1.5rem;
        }

        .form-group {
            margin-bottom: 1.5rem;
        }

        .form-group.full-width {
            grid-column: span 2;
        }

        label {
            display: block;
            margin-bottom: 0.5rem;
            font-weight: 500;
            color: var(--dark);
        }

        .input-wrapper {
            position: relative;
        }

        .input-wrapper i {
            position: absolute;
            left: 15px;
            top: 50%;
            transform: translateY(-50%);
            color: var(--gray);
        }

        input[type="text"],
        input[type="email"],
        input[type="tel"],
        input[type="password"],
        select {
            width: 100%;
            padding: 12px 15px 12px 40px;
            border: 1px solid #ddd;
            border-radius: 8px;
            font-size: 1rem;
            transition: var(--transition);
            background-color: rgba(245, 245, 245, 0.5);
        }

        input:focus,
        select:focus {
            border-color: var(--accent);
            outline: none;
            box-shadow: 0 0 0 3px rgba(67, 97, 238, 0.2);
        }

        .radio-group {
            display: flex;
            gap: 1.5rem;
            margin-top: 0.5rem;
        }

        .radio-option {
            display: flex;
            align-items: center;
        }

        .radio-option input {
            margin-right: 8px;
            accent-color: var(--primary);
        }

        /* Buttons */
        .button-group {
            display: flex;
            gap: 1rem;
            justify-content: center;
            margin-top: 2rem;
        }

        .btn {
            padding: 12px 30px;
            border: none;
            border-radius: 8px;
            font-size: 1rem;
            font-weight: 600;
            cursor: pointer;
            transition: var(--transition);
            display: flex;
            align-items: center;
            gap: 8px;
        }

        .btn i {
            font-size: 1rem;
        }

        .btn-primary {
            background-color: var(--primary);
            color: white;
        }

        .btn-primary:hover {
            background-color: var(--primary-dark);
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(67, 97, 238, 0.3);
        }

        .btn-secondary {
            background-color: var(--success);
            color: white;
        }

        .btn-secondary:hover {
            background-color: #3ab5d9;
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(76, 201, 240, 0.3);
        }

        .btn-warning {
            background-color: var(--warning);
            color: white;
            display: none;
        }

        .btn-warning:hover {
            background-color: #e68a19;
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(248, 150, 30, 0.3);
        }

        /* User Data Section */
        .data-section {
            background: rgba(255, 255, 255, 0.95);
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
            padding: 2.5rem;
            display: none;
        }

        .section-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 1.5rem;
            padding-bottom: 1rem;
            border-bottom: 1px solid #eee;
        }

        .section-header h2 {
            color: var(--primary);
            font-size: 1.8rem;
        }

        .user-cards {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(350px, 1fr));
            gap: 1.5rem;
        }

        .user-card {
            background: white;
            border-radius: 10px;
            padding: 1.5rem;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.05);
            transition: var(--transition);
            border: 1px solid #eee;
        }

        .user-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
            border-color: var(--accent);
        }

        .user-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 1rem;
            padding-bottom: 1rem;
            border-bottom: 1px dashed #eee;
        }

        .user-name {
            font-weight: 600;
            color: var(--primary);
            font-size: 1.2rem;
        }

        .user-gender {
            background: var(--accent);
            color: white;
            padding: 3px 10px;
            border-radius: 20px;
            font-size: 0.8rem;
            font-weight: 500;
        }

        .user-details p {
            margin-bottom: 0.5rem;
            display: flex;
            align-items: center;
        }

        .user-details i {
            width: 25px;
            color: var(--gray);
            font-size: 0.9rem;
        }

        .user-actions {
            display: flex;
            justify-content: flex-end;
            margin-top: 1rem;
            gap: 0.5rem;
        }

        .btn-sm {
            padding: 8px 15px;
            font-size: 0.9rem;
            border-radius: 6px;
        }

        .btn-edit {
            background-color: var(--accent);
            color: white;
        }

        .btn-edit:hover {
            background-color: #3d85d5;
        }

        .btn-delete {
            background-color: var(--danger);
            color: white;
        }

        .btn-delete:hover {
            background-color: #e5177b;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .form-grid {
                grid-template-columns: 1fr;
            }

            .form-group.full-width {
                grid-column: span 1;
            }

            .navbar {
                flex-direction: column;
                padding: 1rem;
            }

            .nav-links {
                margin-top: 1rem;
                width: 100%;
                justify-content: space-around;
            }

            .user-cards {
                grid-template-columns: 1fr;
            }
        }

        /* Animations */
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(20px); }
            to { opacity: 1; transform: translateY(0); }
        }

        .fade-in {
            animation: fadeIn 0.5s ease-out forwards;
        }
        .user-table {
                    width: 100%;
                    border-collapse: collapse;
                    margin-top: 20px;
                }

                .user-table th, .user-table td {
                    padding: 12px;
                    text-align: left;
                    border-bottom: 1px solid #ddd;
                }

                .user-table th {
                    background-color: var(--primary);
                    color: white;
                }

                .user-table tr:nth-child(even) {
                    background-color: #f2f2f2;
                }

                .user-table tr:hover {
                    background-color: #e9e9e9;
                }

                .action-btn {
                    padding: 6px 12px;
                    border: none;
                    border-radius: 4px;
                    cursor: pointer;
                    margin-right: 5px;
                }

                .edit-btn {
                    background-color: var(--accent);
                    color: white;
                }

                .delete-btn {
                    background-color: var(--danger);
                    color: white;
                }

                #result {
                    color: green;
                    margin: 10px 0;
                    font-weight: 500;
                }
    </style>
</head>
<body>
     <!-- Navigation Bar -->
     <nav class="navbar">
         <a href="#" class="logo">
             <i class="fas fa-user-plus"></i>
             <span>UserPortal</span>
         </a>
         <div class="nav-links">
             <a href="#"><i class="fas fa-home"></i> Home</a>
             <a href="viewUsers"><i class="fas fa-users"></i> Users</a>
             <a href="#"><i class="fas fa-cog"></i> Settings</a>
             <a href="#"><i class="fas fa-question-circle"></i> Help</a>
         </div>
     </nav>

     <!-- Main Content -->
     <div class="main-container">
         <!-- Registration Form -->
         <div class="form-container fade-in">
             <div class="form-header">
                 <h1>User Registration Form</h1>
                 <div id="result">${result}</div>
                 <p>Please fill in all the required fields</p>
             </div>

             <form id="registrationForm" action="save" method="post">
            <div class="form-grid">
                    <div class="form-group">
                        <label for="name">Full Name</label>
                        <div class="input-wrapper">
                            <i class="fas fa-user"></i>
                            <input type="text" id="name" name="name" placeholder="John Doe" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email">Email Address</label>
                        <div class="input-wrapper">
                            <i class="fas fa-envelope"></i>
                            <input type="email" id="email" name="email" placeholder="john@example.com" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="mobile">Mobile Number</label>
                        <div class="input-wrapper">
                            <i class="fas fa-phone"></i>
                            <input type="tel" id="mobile" name="mobile" placeholder="+91 84478 52890" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="city">City</label>
                        <div class="input-wrapper">
                            <i class="fas fa-city"></i>
                            <select id="city" name="city" required>
                                <option value="" disabled selected>Select your city</option>
                                <option value="Bangalore">Bangalore</option>
                                <option value="Mysore">Mysore</option>
                                <option value="Madikeri">Madikeri</option>
                                <option value="Mangalore">Mangalore</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group full-width">
                        <label>Gender</label>
                        <div class="radio-group">
                            <div class="radio-option">
                                <input type="radio" id="male" name="gender" value="male" checked>
                                <label for="male">Male</label>
                            </div>
                            <div class="radio-option">
                                <input type="radio" id="female" name="gender" value="female">
                                <label for="female">Female</label>
                            </div>
                            <div class="radio-option">
                                <input type="radio" id="other" name="gender" value="other">
                                <label for="other">Other</label>
                            </div>
                            <div class="radio-option">
                                <input type="radio" id="prefer-not-to-say" name="gender" value="prefer not to say">
                                <label for="prefer-not-to-say">Prefer not to say</label>
                            </div>
                        </div>
                    </div>
                </div>
                 <div class="button-group">
                     <button type="submit" id="saveBtn" class="btn btn-primary">
                         <i class="fas fa-save"></i> Submit
                     </button>
                     <a href="viewUsers" class="btn btn-secondary">
                         <i class="fas fa-eye"></i> View Users
                     </a>
                     <button type="button" id="updateBtn" class="btn btn-warning">
                         <i class="fas fa-sync-alt"></i> Update
                     </button>
                 </div>
             </form>
         </div>

         <!-- User Data Section - Displayed when coming from viewUsers link -->
         <!-- User Data Section - Displayed when coming from viewUsers link -->
         <c:if test="${not empty userlist}">
                 <table class="user-table">
                     <thead>
                         <tr>
                             <th>Name</th>
                             <th>Email</th>
                             <th>Mobile</th>
                             <th>City</th>
                             <th>Gender</th>
                             <th>Actions</th>
                         </tr>
                     </thead>
                     <tbody>
                         <c:forEach var="user" items="${userlist}">
                             <tr>
                                 <td>${user.name}</td>
                                 <td>${user.email}</td>
                                 <td>${user.mobile}</td>
                                 <td>${user.city}</td>
                                 <td>${user.gender}</td>
                                 <td>
                                     <form action="updatepage" method="post" style="display:inline;">
                                         <input type="hidden" name="id" value="${user.id}">
                                         <button type="submit" class="action-btn edit-btn">
                                             <i class="fas fa-edit"></i> Edit
                                         </button>
                                     </form>
                                 </td>
                             </tr>
                         </c:forEach>
                     </tbody>
                 </table>
         </c:if>
     </div>
 </body>
</html>