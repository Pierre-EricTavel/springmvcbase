<%-- 
    Document   : enterclient
    Created on : Jul 22, 2019, 12:52:12 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form:form action="updateclient.html" method="post">
             <form:label path="nom">Saisir nom</form:label> <form:input type="text" path="nom"/><br>
            <form:label path="prenom">Saisir prenom</form:label> <form:input type="text" path="prenom"/><br>
            <form:label path="age">Saisir age</form:label> <form:input type="number" path="age"/><br>
            <input type="submit" value="Envoi">
        </form:form>
    </body>
</html>
