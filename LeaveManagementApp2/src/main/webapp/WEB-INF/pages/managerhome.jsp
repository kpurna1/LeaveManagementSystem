<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager Dashboard</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body class="manager-home-bg">

<div class="dashboard-overlay">

    <div class="dashboard-container">

        <h1 class="dashboard-title">Manager Dashboard</h1>

        <div class="dashboard-menu">

            <a href="ViewLeaves" class="manager-card">
                View Leave Requests
            </a>

            <a href="ViewEmps" class="manager-card">
                View Employees
            </a>

            <a href="logout" class="manager-card manager-logout">
                Logout
            </a>

        </div>

    </div>

</div>

</body>
</html>