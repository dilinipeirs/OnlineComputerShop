<%-- 
    Document   : AdminDashboard
    Created on : Jun 11, 2018, 8:39:41 PM
    Author     : dilin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
    <center>
        <h1>Welcome to Online Computer Shop!!</h1>
        <br/>
        <h3>Manage Inventory</h3>
        <a href="AddItemJsp.jsp">Enter Items to Inventory</a><br/>
        <a href="EditItemJsp.jsp">Edit Item Details</a><br/>
        <a href="RemoveItemJsp.jsp">Remove from Inventory</a><br/>
        <a href="ViewStockController">View Inventory</a><br/>
        <br/><br/>
        <h3>Manage Users</h3>
        <a href="AddUserJsp.jsp">Register Users to the System</a><br/>
        <a href="EditUserJsp.jsp">Edit User Details</a><br/>
        <a href="RemoveUserJsp.jsp">Remove User from System</a><br/>
        <a href="ViewUsersController">View Users</a><br/>
    </center>
    <br/>
    <br/>
    <br/>
    <%@include file="footer.jsp" %>

</body>
</html>
