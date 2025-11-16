package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;  
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;  

import Model.Client;  


/**
 * Servlet implementation class ServletController
 */
@WebServlet("*.do")
	
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		String url_db =  "jdbc:mysql://localhost:3306/master_db";
		String user_db = "root";
		String pwd_db = "";
		
		if("/clients.do".equals(path)) {
			String moteCle = request.getParameter("motCle")	;
			if(moteCle == null){moteCle="";}

		 
			List<Client> clients = new ArrayList<Client>();
			
			
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(url_db, user_db,pwd_db);
				
				PreparedStatement ps = conn.prepareStatement("select * from client where nom like ?");
				ps.setString(1,"%"+moteCle+ "%");
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					Client c = new Client();
					c.setIdClient(rs.getInt("idClient"));
					c.setNom(rs.getString("nom"));
					c.setPrenom(rs.getString("prenom"));
					c.setAge(rs.getInt("age"));
					clients.add(c);
				}
				
 				request.setAttribute("pm", clients);
				request.getRequestDispatcher("/vue/Dashbord.jsp").forward(request, response);

				
				
				
				
			}catch(Exception e){
				PrintWriter out = response.getWriter();

				out.println( e.getMessage()) ;
				
			}
			
		
		}else if("/addClient.do".equals(path)) {
			if("POST".equals(request.getMethod())){
				 
				try{
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection(url_db, user_db, pwd_db);
					
					String nom = request.getParameter("nom");
					String prenom = request.getParameter("prenom");
					int age = Integer.parseInt(request.getParameter("age"));

					PreparedStatement ps = conn.prepareStatement("insert into client (nom, prenom, age) values(?,?,?)");
					ps.setString(1,nom);
					ps.setString(2,prenom);
					ps.setInt(3,age);
					int n = ps.executeUpdate();
					response.sendRedirect("clients.do");  
					return;
					 
			        
				}catch(Exception e){
					
					PrintWriter out = response.getWriter();
					out.println( e.getMessage());
					
				}
			}else {
				response.sendRedirect("vue/addClient.jsp");
			}
			
		}else if("/DeleteClient.do".equals(path)) {
			
			String client = request.getParameter("idClient");
			int clientId = Integer.parseInt(client);
			String clientName = ""; 
			
			
			
			
			
			if("POST".equals(request.getMethod())){
			try{
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(url_db,user_db,pwd_db);
				PreparedStatement ps = conn.prepareStatement("DELETE FROM client where idClient = ?");
				ps.setInt(1,clientId);
				int n = ps.executeUpdate();
				if (n>0){
					response.sendRedirect("clients.do");
			        return;
				}
				
				
			}catch(Exception e){
				
				PrintWriter out = response.getWriter();
				out.println( e.getMessage());
				
			}
			}else {
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn1 = DriverManager.getConnection(url_db,user_db,pwd_db);
					
					PreparedStatement ps1 = conn1.prepareStatement("SELECT * FROM client where idClient = ?");
					ps1.setInt(1,clientId);
					ResultSet rs = ps1.executeQuery();
					while(rs.next()){
						clientName = rs.getString("nom");
						
					}
					Client c = new Client();
					c.setNom(clientName);
					c.setIdClient(clientId);
					
					request.setAttribute("pm",c);
					request.getRequestDispatcher("/vue/deleteClient.jsp").forward(request, response);

		 

					
				}catch(Exception e){
					
					PrintWriter out = response.getWriter();
					out.println( e.getMessage());
					
				}
			}
			
		}else if("/EditClient.do".equals(path)) {
			 String P_nom =	"" ;
			  String P_prenom = "";
				int P_age = 0;
			   int id = Integer.parseInt(request.getParameter("idClient"));
			 
				
				


			 

			  
			   if ("POST".equals(request.getMethod())) {
			       try {
			           Class.forName("com.mysql.cj.jdbc.Driver");
			           Connection conn = DriverManager.getConnection(url_db, user_db, pwd_db);

			           String newNom = request.getParameter("nom");
			           String newPrenom = request.getParameter("prenom");
			           int newAge = Integer.parseInt(request.getParameter("age"));

			           PreparedStatement ps = conn.prepareStatement(
			               "UPDATE client SET nom=?, prenom=?, age=? WHERE idClient=?"
			           );
			           ps.setString(1, newNom);
			           ps.setString(2, newPrenom);
			           ps.setInt(3, newAge);
			           ps.setInt(4, id);

			           int n = ps.executeUpdate();
 
			           response.sendRedirect("clients.do");  	
			           return;

			       }catch(Exception e){
						
						PrintWriter out = response.getWriter();
						out.println( e.getMessage());
						
					}
			   }else {
				   try{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection(url_db, user_db,pwd_db);
						
						PreparedStatement ps1 = conn.prepareStatement("select * from client where idClient = ?");
						ps1.setInt(1,id);
						ResultSet rs1 = ps1.executeQuery();
						
						while(rs1.next()){
				  			P_nom =	 rs1.getString("nom");
							P_prenom = rs1.getString("prenom");
							P_age = rs1.getInt("age");
				 		}
						
						Client c = new Client();
						c.setNom(P_nom);
						c.setPrenom(P_prenom);
						c.setAge(P_age);
						c.setIdClient(id); // <-- ADD THIS LINE
						request.setAttribute("pm",c);
						request.getRequestDispatcher("/vue/editClient.jsp").forward(request, response);

			 
						
						
						
						
						
					}catch(Exception e){
						
						PrintWriter out = response.getWriter();
						out.println( e.getMessage());
						
					}
			   }
			
		}else {
			
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
