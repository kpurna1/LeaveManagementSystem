<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employees</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body class="employees-page-bg">

<div class="history-overlay">

    <div class="history-container">

        <c:choose>

            <c:when test="${!empty allEmps}">

                <h1 class="page-title">
                    Employee Details
                </h1>

                <table class="leave-table">

                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Leaves Remaining</th>
                            <th>Role</th>
                            <th>Email</th>
                            <th>Joined Date</th>
                        </tr>
                    </thead>

                    <tbody>

                        <c:forEach var="emp" items="${allEmps}">

                            <tr>
                                <td>${emp.id}</td>
                                <td>${emp.name}</td>

                                <td>
                                    <span class="balance-badge">
                                        ${emp.leaveBalance}
                                    </span>
                                </td>

                                <td>${emp.role}</td>
                                <td>${emp.email}</td>
                                <td>${emp.joinedOn}</td>
                            </tr>

                        </c:forEach>

                    </tbody>

                </table>

            </c:when>

            <c:otherwise>

                <h1 class="no-records">
                    No Employees Found
                </h1>

            </c:otherwise>

        </c:choose>

        <a href="login3" class="back-btn">
             Back to Dashboard
        </a>

    </div>

</div>

</body>
</html>