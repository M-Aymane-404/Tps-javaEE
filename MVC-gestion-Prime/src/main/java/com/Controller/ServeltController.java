package com.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Period;

import com.Model.PrimeModel;

/**
 * Servlet implementation class ServeltController
 */
@WebServlet("*.do")

public class ServeltController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeltController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		if ("/acceuil.do".equals(path)) {
			 request.getRequestDispatcher("/vue/index.html").forward(request, response);
			 
		}else if("/calculer.do".equals(path)) {
			//dao
			String url_db =  "jdbc:mysql://localhost:3306/employe_db";
			String user_db = "root";
			String pwd_db = "";
			int id = Integer.parseInt( request.getParameter("id"));
			String nom ="";
			String prenom ="";
			Date date_debut= null;
			double salaire = 0;
					
			
			
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(url_db, user_db,pwd_db);
				
				PreparedStatement ps = conn.prepareStatement("select * from employe where id = ?");
				ps.setInt(1, id);

 				ResultSet rs = ps.executeQuery();
 				while(rs.next()){
 					nom = rs.getString("nom");
 					prenom = rs.getString("prenom");
 					salaire = rs.getDouble("salaire");
 					date_debut = rs.getDate("date_debut");

 				}
 				
 				//metier
 				double prime = 0;
 				Period p = Period.between(LocalDate.parse(date_debut.toString()), LocalDate.now());
 				prime = salaire + (p.getYears()*500) ;
 				
 				//presentation
 				
 				PrimeModel primeModel1 = new PrimeModel();
 				primeModel1.setNom(nom);
 				primeModel1.setPrenom(prenom);
 				primeModel1.setPrime(prime);
 				request.setAttribute("pm", primeModel1);
 				 request.getRequestDispatcher("/vue/resultat.jsp").forward(request, response);

	 
				
			}catch(Exception e){
				PrintWriter out = response.getWriter();

				out.println( e.getMessage()) ;
				
			}
			
		}else {
			
			
			 request.getRequestDispatcher("/vue/404.html").forward(request, response);

			 
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
