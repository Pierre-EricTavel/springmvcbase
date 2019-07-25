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
        <h1>Logout page</h1>
        <h2>You're logged out</h2>
         <a href="clients.html">Clients</a><br> 
        Login again?<br>
        <form action="login.html" method="POST">
           User: <input name="username"/><br>
           Password: <input name="password" type="password"/><br>
            <input  type="submit" value="Login"/>    
        </form>
    </body>
</html>
