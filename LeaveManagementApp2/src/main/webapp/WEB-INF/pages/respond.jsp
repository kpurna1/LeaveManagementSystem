<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Respond to Leave Request</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body class="response-page-bg">

<div class="response-overlay">

    <div class="response-container">

        <h1 class="page-title">Leave Request Review</h1>

        <frm:form action="update" modelAttribute="lev">

            <div class="response-grid">

                <div class="field-group">
                    <label>Leave ID</label>
                    <frm:input path="leave_id" readonly="true"/>
                </div>

                <div class="field-group">
                    <label>Employee ID</label>
                    <frm:input path="employeeId" readonly="true"/>
                </div>

                <div class="field-group">
                    <label>Employee Name</label>
                    <input type="text" value="${name}" readonly>
                </div>

                <div class="field-group">
                    <label>Employee Role</label>
                    <input type="text" value="${role}" readonly>
                </div>

                <div class="field-group">
                    <label>Start Date</label>
                    <frm:input path="startDate" readonly="true"/>
                </div>

                <div class="field-group">
                    <label>End Date</label>
                    <frm:input path="endDate" readonly="true"/>
                </div>

                <div class="field-group full-width">
                    <label>Status</label>
                    <select name="status">
                        <option value="PENDING">PENDING</option>
                        <option value="ACCEPTED">ACCEPT</option>
                        <option value="REJECTED">REJECT</option>
                    </select>
                </div>

                <div class="field-group full-width">
                    <label>Reason</label>
                    <frm:textarea path="reason" rows="5" readonly="true"/>
                </div>

            </div>

            <button type="submit" class="approve-btn">
                Send Mail
            </button>

        </frm:form>
	<a href="login3" class="back-btn">
            Back to Dashboard
        </a>
	
    </div>

</div>

</body>
</html>