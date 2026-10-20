<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leave Status</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body class="status-page-bg">

<div class="history-overlay">

    <div class="history-container">

        <c:choose>

            <c:when test="${!empty leaveStatus}">

                <h1 class="page-title">Leave Status</h1>

                <table class="leave-table">

                    <thead>
                        <tr>
                            <th>Leave ID</th>
                            <th>Start Date</th>
                            <th>End Date</th>
                            <th>Status</th>
                            <th>Reason</th>
                            <th>Action</th>
                        </tr>
                    </thead>

                    <tbody>

                        <c:forEach var="lev" items="${leaveStatus}">

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

                                <td>

                                    <c:if test="${lev.status eq 'PENDING'}">

                                        <form action="cancel" method="post">

                                            <input type="hidden"
                                                   name="leaveId"
                                                   value="${lev.leave_id}">

                                            <button
                                                type="submit"
                                                class="cancel-btn"
                                                onclick="return confirm('Are you sure you want to cancel this leave?')">

                                                Cancel

                                            </button>

                                        </form>

                                    </c:if>

                                </td>

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