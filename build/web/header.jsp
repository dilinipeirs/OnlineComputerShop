<%-- 
    Document   : header
    Created on : Jun 19, 2018, 11:30:33 PM
    Author     : dilin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div align="right">
    <form action="HeaderController">
        <input type="button" name="action" value="home"/>
        <%="Welcome "+request.getSession().getAttribute("user")+"! "%> 

        <input type = "button" name = "action" value = "logout" /> 
    </form> 
</div >
