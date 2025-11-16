package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Servlet implementation class SimpleServlet3
 */
@WebServlet("/SimpleServlet3")
public class SimpleServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>");	
		out.println( "<form action=\"\" method=\"Post\" >\r\n"
				+ "nombre1 : <input type=\"number\" name=\"val1\"> <br><br>\r\n"
				+ "nombre2 : <input type=\"number\" name=\"val2\"><br><br>\r\n"
				+ "<p><input type=\"submit\" value=\"Enregistrer\"></p>\r\n"
				+ "</form>");
	        
	        
            out.println("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		  String val1 = request.getParameter("val1");
	        String val2 = request.getParameter("val2");
	        int a = Integer.parseInt(val1);
	           int b = Integer.parseInt(val2);
	           int somme = a + b;
	     
		PrintWriter out = response.getWriter();
 		
		try {
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>");	
	 
	        
		  
           
            out.println("<p> la somme de "+a+" et "+b+" est : "+ somme+"</p>");
        	out.println( "<form action=\"\" method=\"Post\" >\r\n"
    				+ "nombre1 : <input type=\"number\" name=\"val1\"> <br><br>\r\n"
    				+ "nombre2 : <input type=\"number\" name=\"val2\"><br><br>\r\n"
    				+ "<p><input type=\"submit\" value=\"Enregistrer\"></p>\r\n"
    				+ "</form>");
            out.println("</body></html>");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
