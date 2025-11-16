package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet("/UserInfo")
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
     
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
 		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>");
		
		out.println("<p>Type mime de la requête :" + request.getContentType() + "</p>");
		out.println("<p>Protocole de la requête :" + request.getProtocol() + "</p>" );
		out.println("<p>Adresse IP du client :" + request.getRemoteAddr() + "</p>");
		
		out.println("<p>Nom du client :" + request.getRemoteHost() + "</p>");
		out.println("<p>Nom du serveur qui a reçu la requête :" + request.getServerName() + "</p>");
		out.println("<p>Port du serveur qui a reçu la requête :" + request.getServerPort() + "</p>");
		
		out.println("<p>scheme :" + request.getScheme() + "</p>");
		 out.println("<h2>Liste des parametres</h2>");
	        out.println("<ul>");
	        

	        Enumeration<String> paramNames = request.getParameterNames();
	        
	        while (paramNames.hasMoreElements()) {
	            String paramName = paramNames.nextElement();
	            String paramValue = request.getParameter(paramName);
	            out.println("<p> parametre : "+ paramName +"|"+ "valeur:" + paramValue + "</p>");
	        }
 
		out.println("</body>\r\n"
				+ "</html>");
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
