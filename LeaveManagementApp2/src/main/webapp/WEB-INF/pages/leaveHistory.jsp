<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leave History</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body class="history-page-bg">

<div class="history-overlay">

    <div class="history-container">

        <c:choose>

            <c:when test="${!empty leaveHistory}">

                <h1 class="page-title">Leave History</h1>

                <table class="leave-table">

                    <thead>
                        <tr>
                            <th>Leave ID &nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th>Start Date &nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th>End Date &nbsp; &nbsp;&nbsp;&nbsp;</th>
                            <th>Status</th>
                            <th>Reason</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="lev" items="${leaveHistory}">
                            <tr>
                                <td>${lev.leave_id}</td>
                                <td>${lev.startDate}</td>
                                <td>${lev.endDate}</td>
                                <td>
                                    <span class="status-badge ${lev.status}">
                                        ${lev.status}
                                    </span>
                                </td>
                                <td>${lev.reason}</td>
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>

            </c:when>

            <c:otherwise>

                <h1 class="no-records">
                    No Leave Records Found
                </h1>

            </c:otherwise>

        </c:choose>

        <a href="login2" class="back-btn">
            Back to Dashboard
        </a>

    </div>

</div>

</body>
</html>