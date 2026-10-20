<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ page import="java.time.LocalDate" %>

<%
    Integer id=(Integer)session.getAttribute("id");
    String tomorrow = LocalDate.now().plusDays(1).toString();
    request.setAttribute("tomorrow", tomorrow);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Apply Leave</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body class="leave-page-bg">

<div class="leave-overlay">

    <div class="leave-container">

        <h1 class="page-title">Leave Application</h1>

        <frm:form action="apply" method="post" modelAttribute="leave">

            <div class="form-group">
                <label>Employee ID</label>
                <frm:input path="employeeId"
                           value="${id}"
                           readonly="true"/>
            </div>

            <div class="form-group">
                <label>Start Date</label>
                <frm:input path="startDate"
                           type="date"
                           min="${tomorrow}"
                           required="required"/>
            </div>

            <div class="form-group">
                <label>End Date</label>
                <frm:input path="endDate"
                           type="date"
                           min="${tomorrow}"
                           required="required"/>
            </div>

            <div class="form-group">
                <label>Reason</label>
                <frm:textarea path="reason"
                              rows="5"
                              required="required"/>
            </div>

            <input type="submit"
                   value="Apply Leave"
                   class="btn-primary">

        </frm:form>

        <a href="login2" class="back-btn">Back to Dashboard</a>

    </div>

</div>

</body>
</html>