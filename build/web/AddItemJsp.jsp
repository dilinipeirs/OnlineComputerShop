<%-- 
    Document   : AddItemJsp
    Created on : Jun 11, 2018, 8:53:01 PM
    Author     : dilin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add to Inventory</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <h1>Add to Inventory</h1>
        <form method="POST" action="ItemController">
            Item Code : <input type="text" name="code"/><br/>
            Item Description : <input type="text" name="desc"/><br/>
            Unit Price (Rs.) : <input type="text" name="price"/><br/>
            Qty on Hand : <input type="number" name="qty"/><br/>
            <input type="submit" name="action" value="Add"/>
        </form>
        <%@include file="footer.jsp" %>
    </body>
</html>
