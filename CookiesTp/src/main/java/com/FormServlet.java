package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/HTML");
		Cookie[] cookies = request.getCookies();
		String couleurFond = null;
		String couleurPolice = null;
		String typeLivre = null;
		String nb = null;
		
		if (cookies != null) {
			
		for(int i=0;i<cookies.length;i++) {
			
			
		if(cookies[i].getName().equals("couleurFond")) {
			couleurFond=cookies[i].getValue();
		}
		
		if(cookies[i].getName().equals("couleurPolice")) {
			couleurPolice=cookies[i].getValue();
			}
		
		if(cookies[i].getName().equals("typeLivre")) {
			typeLivre=cookies[i].getValue();
			}
		
		if(cookies[i].getName().equals("nb")) {
			nb=cookies[i].getValue();
			}
		
		
		}
		
		
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body style=\"background-color:"+ couleurFond+ ";\">");	
		
	 
	            out.println("<p style=\"color:" +couleurPolice+ " ;\"  align=\"center\"> Fond coleur : " + couleurFond + "</p>");
	            out.println("<p style=\"color:" +couleurPolice+ ";\"  align=\"center\"> la couleur de la police  : " + couleurPolice + "</p>");
	            out.println("<p style=\"color:" +couleurPolice+ ";\"  align=\"center\"> Type de Livres préféré : " + typeLivre + "</p>");
	            out.println("<p style=\"color:" +couleurPolice +";\"  align=\"center\"> Nombre préféré : " + nb + "</p>");
	        
	        
	        
		 
            
		
		}else {
			
			out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>Insert title here</title>\r\n"
					+ "</head>\r\n"
					+ "<body>");		
			
		    out.println( "<form action=\"\" method=\"POST\">\r\n"
    				+ "			couleur de fond :<select name=\"couleurFond\" id=\"couleurFond\">\r\n"
    				+ "						    <option value=\"white\">Blanc</option>\r\n"
    				+ "						    <option value=\"red\">Rouge</option>\r\n"
    				+ "						    <option value=\"blue\">Bleu</option>\r\n"
    				+ "						    <option value=\"green\">Vert</option>\r\n"
    				+ "						    <option value=\"yellow\">Jaune</option>\r\n"
    				+ "						    <option value=\"black\">Noir</option>\r\n"
    				+ "						</select>\r\n"
    				+ "						<br><br>"
    				+ "		la couleur de la police de caractère  : <select name=\"couleurPolice\" id=\"couleurPolice\">\r\n"
    				+ "									    <option value=\"black\">Noir</option>\r\n"
    				+ "									    <option value=\"white\">Blanc</option>\r\n"
    				+ "									    <option value=\"red\">Rouge</option>\r\n"
    				+ "									    <option value=\"blue\">Bleu</option>\r\n"
    				+ "									    <option value=\"green\">Vert</option>\r\n"
    				+ "									    <option value=\"yellow\">Jaune</option>\r\n"
    				+ "									</select>\r\n"
    				+ "									<br><br>"
    				+ "		votre type de livres préféré  : <input type=\"text\" name=\"typeLivre\"><br><br>\r\n"
    				+ "		votre nombre préféré. : <input type=\"number\" name=\"nb\"><br><br>\r\n"
    				+ "		\r\n"
    				+ "		<input type=\"submit\" value=\"Enregistrer\">\r\n"
    				+ "</form>");
			
		}
		
  		
            
            
            
            
            
            
            
        
            
            out.println("</body></html>");	
            
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String couleurFond = request.getParameter("couleurFond");
		String couleurPolice = request.getParameter("couleurPolice");
		String typeLivre = request.getParameter("typeLivre");
		String nb = request.getParameter("nb");

		response.addCookie( new Cookie("couleurFond",couleurFond));
		response.addCookie( new Cookie("couleurPolice",couleurPolice));
		response.addCookie(new Cookie("typeLivre",typeLivre));
		response.addCookie(new Cookie("nb",nb));
		
		response.sendRedirect("FormServlet");


 	}

}
