<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="jakarta.servlet.ServletException , java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

			 out.println("<p>Type mime de la requête :" + request.getContentType() + "</p>");
			out.println("<p>Protocole de la requête :" + request.getProtocol() + "</p>" );
			out.println("<p>Adresse IP du client :" + request.getRemoteAddr() + "</p>");
			
			out.println("<p>Nom du client :" + request.getRemoteHost() + "</p>");
			out.println("<p>Nom du serveur qui a reçu la requête :" + request.getServerName() + "</p>");
			out.println("<p>Port du serveur qui a reçu la requête :" + request.getServerPort() + "</p>");
			
			out.println("<p>scheme :" + request.getScheme() + "</p>");
			
			
			Enumeration<String> paramNames = request.getParameterNames();
			
					while(paramNames.hasMoreElements()){
						String paramName = paramNames.nextElement();
						String paramValue = request.getParameter(paramName);
					    out.println("<p> parametre : " + paramName +" | "+ " valeur :" + paramValue + "</p>");
					
						
					}

%>
 
</body>
</html>