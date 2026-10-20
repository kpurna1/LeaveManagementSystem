<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Registration</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body class="login-page">

<div class="register-container">

    <h1 class="page-title">Employee Registration</h1>

    <frm:form action="empReg" method="post" modelAttribute="emp" class="register-form">

        <div class="form-group">
            <label>Name</label>
            <frm:input path="name" required="required"/>
        </div>

        <div class="form-group">
            <label>Email</label>
            <frm:input path="email" required="required"/>
        </div>

        <div class="form-group">
            <label>Password</label>
            <frm:password path="password" required="required"/>
        </div>

        <div class="form-group">
            <label>Role</label>
            <frm:input path="role" required="required"/>
        </div>

        <input type="submit" value="Register" class="btn-primary"/>

    </frm:form>

</div>

</body>
</html>