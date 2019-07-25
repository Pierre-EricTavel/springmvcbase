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
        <h1>Edit client</h1>
         <%@include file="partialAuth.jspf" %>
        <form:form action="updateclient.html" method="post" accept-charset="UTF-8" modelAttribute="client">
            <form:input type="hidden" path="id" />
            <spring:bind path="nom">
                <form:label path="nom">Saisir nom</form:label> <form:input type="text" path="nom"/> <form:errors path="nom"/>
            </spring:bind>
            <br> 
            <spring:bind path="prenom">
                <form:label path="prenom">Saisir prenom</form:label> <form:input type="text" path="prenom"/><form:errors path="prenom"/>
            </spring:bind>
            <br>
            <spring:bind path="age">
                <form:label path="age">Saisir age</form:label> <form:input type="number" path="age"/><form:errors path="age"/>
            </spring:bind>
            <br>
            <input type="submit" value="Envoi">
        </form:form>
    </body>
</html>
