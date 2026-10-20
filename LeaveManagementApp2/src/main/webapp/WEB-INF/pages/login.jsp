<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="css/style.css">
</head>
<body class="login-page">

<div class="login-container">

    <h1 class="page-title">Employee Login</h1>

    <c:if test="${not empty msg}">
        <h3 class="message">${msg}</h3>
    </c:if>

    <c:if test="${not empty response}">
        <h3 class="message">${response}</h3>
    </c:if>

    <form action="login1" method="post" class="login-form">

        <div class="form-group">
            <label>Email</label>
            <input type="email" name="emailId" required/>
        </div>

        <div class="form-group">
            <label>Password</label>
            <input type="password" name="password" required/>
        </div>

        <input type="submit" value="Login" class="btn-primary">

        <p class="register-link">
            New Employee?
            <a href="empRegister">Register</a>
        </p>

    </form>

</div>

</body>
</html>