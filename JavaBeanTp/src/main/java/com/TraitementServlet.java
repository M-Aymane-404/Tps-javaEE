package com;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class TraitementServlet
 */
@WebServlet("/TraitementServlet")
public class TraitementServlet extends HttpServlet {
 
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Etudiant etu = (Etudiant) request.getAttribute("etu");
		
		
		
		double note = (float) Math.random() * 10; 
		 note = note + 10 ;
		   note = Math.round(note * 100.0) / 100.0;
		   
		   
		   
		   etu.setNote(note);
		   
		   request.getRequestDispatcher("reponse.jsp").forward(request, response);

		   
		 
		   
		   

	}

}
