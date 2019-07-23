<%-- 
    Document   : enterclient
    Created on : Jul 22, 2019, 12:52:12 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib    uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit client</title>
    </head>
    <body>
       <c:out value="${command.nom}" /> <c:out value="${command.prenom}" /> va être supprimé!
         <form:form action="deleteclient.html" method="post" accept-charset="UTF-8">
            <form:input type="hidden" path="id" />
            <input type="submit" value="Confirmez?">
        </form:form>
    </body>
</html>
