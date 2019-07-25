<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login page</h1>
        <%@include file="partialAuth.jspf" %><br>
       
        ${errorMsg}<br>
        <form action="login.html" method="POST">
            User: <input name="username" value="admin"/><br>
           Password: <input name="password" type="password" value="Pa$$w0rd"/><br>
            <input  type="submit" value="Login"/>    
        </form>
    </body>
</html>
