<html>
<body>
<%@page import="java.util.*, src.main.Model.Personne" %>

<%
List<Personne> list = (List<Personne>) request.getAttribute("personnes");
%>

<table border="1" width="90%">
    <tr>
        <th>Id</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Age</th>
    </tr>

    <%
      for(Personne p : list){
    %>
        <tr>
            <td> <%=  p.getId()  %>   </td>
            <td> <%=  p.getNom()  %>    </td>
            <td> <%=  p.getPrenom()  %>    </td>
            <td> <%=  p.getAge()  %>    </td>
        </tr>
    <%
    }
    %>
</table>
</body>
</html>
