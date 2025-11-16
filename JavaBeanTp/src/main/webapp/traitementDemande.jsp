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



 
 

<jsp:useBean id="etu" class="com.Etudiant" scope="request"/>

 <jsp:setProperty name="etu" property="nom"/>
 
    <jsp:setProperty name="etu" property="prenom"/> 
   	
   	
   	
   	
   	
   	
	<jsp:forward page="/TraitementServlet" />
</body>
</html>