<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<a href="personne?action=add">Add</a>
<table border="1" width="90%">
    <tr>
        <th>Id</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Age</th>
    </tr>

 <c:forEach items="${personnes}" var="p">
        <tr>
            <td>${p.id} </td>
            <td> ${ p.getNom() }    </td>
            <td> ${ p.getPrenom() }    </td>
            <td> ${ p.getAge()  }   </td>
             <td>
               <a href="?action=delete&id=${p.id}">delete</a>
             </td>
        </tr>
  </c:forEach>
</table>
</body>
</html>
