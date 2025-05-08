<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
      <form action ="personne?action=save" method="post">
            <label>Nom</label>
            <input type="text" name="nom">
            <label>Prenom</label>
            <input type="text" name="prenom">
            <label>Age</label>
            <input type="text" name="age">
            <button type="submit"> ADD </button>
       </form>
</body>
</html>
