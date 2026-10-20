<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Dashboard</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body class="employee-home-bg">

<div class="dashboard-overlay">

    <div class="dashboard-container">

        <h1 class="dashboard-title">Employee Dashboard</h1>

        <c:if test="${not empty resp}">
            <h3 class="dashboard-message">${resp}</h3>
        </c:if>

        <div class="dashboard-menu">

            <a href="leave" class="dashboard-card">
                Apply for Leave
            </a>

            <a href="view" class="dashboard-card">
                View Leave History
            </a>

            <a href="viewStatus" class="dashboard-card">
                Check Leave Status
            </a>

            <a href="logout" class="dashboard-card logout-card">
                Logout
            </a>

        </div>

    </div>

</div>

</body>
</html>