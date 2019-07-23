<%-- 
    Document   : enterclient
    Created on : Jul 22, 2019, 12:52:12 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit client</title>
    </head>
    <body>
        <form:form action="updateclient.html" method="post" accept-charset="UTF-8" modelAttribute="client">
            <form:input type="hidden" path="id" />
            <spring:bind path="nom">
                <form:label path="nom">Saisir nom</form:label> <form:input type="text" path="nom"/> <form:errors path="nom"/>
            </spring:bind>
            <br>
            <form:label path="prenom">Saisir prenom</form:label> <form:input type="text" path="prenom"/><br>
            <form:label path="age">Saisir age</form:label> <form:input type="number" path="age"/><br>
            <input type="submit" value="Envoi">
        </form:form>
    </body>
</html>
