<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="jakarta.tags.core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<jsp:useBean id="etu" type="com.Etudiant" scope="request"/>

<h2>Informations de l'étudiant :</h2>


<p>Nom : <strong><jsp:getProperty name="etu" property="nom"/></strong></p>
<p>Prénom : <strong><jsp:getProperty name="etu" property="prenom"/></strong></p>
<p>Note : <strong><jsp:getProperty name="etu" property="note"/></strong></p>

 	
</body>
</html>