<%-- 
    Document   : EditItemJsp
    Created on : Jun 11, 2018, 9:06:27 PM
    Author     : dilin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <h1>Edit Item Details</h1>
        <form method="POST" action="ItemController">
            Item Code : <input type="text" name="code"/><br/>
            Item Description : <input type="text" name="desc"/><br/>
            Unit Price (Rs.) : <input type="text" name="price"/><br/>
            Qty on Hand : <input type="number" name="qty"/><br/>
            <input type="submit" name="action" value="Edit"/>
        </form>
        <%@include file="footer.jsp" %>
    </body>
</html>
