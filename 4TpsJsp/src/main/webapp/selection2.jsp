	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1" errorPage="erreur.jsp"%>
	<!DOCTYPE html>
	<html>
		<body>
			<form method="POST" action="selection2.jsp">
				Choisissez une couleur
				<p>
					<input type="radio" name="couleur" value="rouge" />Rouge<br />
					<input type="radio" name="couleur" value="bleu" />Bleu<br />
					<input type="radio" name="couleur" value="vert" />Vert<br />
					<input type="radio" name="couleur" value="orange" />Orange<br />
					
				</p>
				<input type="submit" value="Envoyer">
			</form>
			
			
		<%
			String methode = request.getMethod();
			
			if ("POST".equals(methode)) {
				String color = request.getParameter("couleur");
				 if ("orange".equals(color)){ 
					 
					 throw new Exception("Cette couleur n'est pas belle");
					 
						 
					 }
				
				 if (color != null && !color.isEmpty()) {
							%>
							
					 <p> Vous avez choisi la couleur est : <%= color %><p>
				<% }else{ %>
					 <p>il faut choisi un couleur <p>
				   <%  } 
		    }  %>
			 
			</body>
	</html>