<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clients Page</title>
    </head>
    <body>
        <h1>Liste Clients</h1>
        <%@include file="partialAuth.jspf" %>
        <a href="createclient.html">Créér client</a><br>
      
        <table>
            <thead><th>ID</th><th>nom</th><th>prenom</th><th>age</th><th colspan="2"></th></thead>
                <c:forEach var="client" items="${listeclients}" >
                    <tr><td>${client.id}</td><td>${client.nom}</td><td>${client.prenom}</td><td>${client.age}</td>
                        <td><a href="modifyclient.html?id=${client.id}">Mod</a></td>
                        <td><a href="supprimeclient.html?id=${client.id}">X</a></td>
                    </tr>
            </c:forEach>
        </table>        
    </body>
</html>
