<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leave Requests</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body class="manager-request-bg">

<div class="history-overlay">

    <div class="history-container">

        <c:if test="${not empty msg}">
            <h3 class="message">${msg}</h3>
        </c:if>

        <c:choose>

            <c:when test="${!empty leaveRequests}">

                <h1 class="page-title">
                    Leave Requests
                </h1>

                <table class="leave-table">

                    <thead>
                        <tr>
                            <th>Leave ID</th>
                            <th>Employee ID</th>
                            <th>Start Date</th>
                            <th>End Date</th>
                            <th>Status</th>
                            <th>Respond</th>
                        </tr>
                    </thead>

                    <tbody>

                        <c:forEach var="lev" items="${leaveRequests}">

                            <tr>

                                <td>${lev.leave_id}</td>
                                <td>${lev.employeeId}</td>
                                <td>${lev.startDate}</td>
                                <td>${lev.endDate}</td>

                                <td>
                                    <span class="status-badge ${lev.status}">
                                        ${lev.status}
                                    </span>
                                </td>

                                <td>

                                    <a href="resp?levno=${lev.leave_id}&no=${lev.employeeId}"
                                       class="action-btn">

                                        Review

                                    </a>

                                </td>

                            </tr>

                        </c:forEach>

                    </tbody>

                </table>

            </c:when>

            <c:otherwise>

                <h1 class="no-records">
                    No Leave Requests Found
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