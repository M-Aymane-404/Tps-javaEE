package com.presentation;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import  com.presentation.Client;
import com.dao.DaoImpl;
import com.dao.IDao;
import com.metier.IMetier;
import com.metier.MetierImpl;
 import com.unite.SingleTonConnection;
 import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class ServletController
 */
 
@WebServlet("*.do")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
 
 	private IMetier metier;


    @Override
    public void init() throws ServletException {
        // *** STATIC INJECTION ***
        // Get the single, pre-built instance from our static factory
    	
    	
   
        
    	
    	
    	try {
    		
             ApplicationContext ctx = new AnnotationConfigApplicationContext("com");

             this.metier = ctx.getBean(IMetier.class);

        } catch (Exception e) {
             e.printStackTrace();
         }
    	
    	
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		
		
		if("/clients.do".equals(path)) {
			String moteCle = request.getParameter("motCle")	;
			List<Client> clients ;
			try {
				  clients = metier.getClients(moteCle);
				  request.setAttribute("pm", clients);
			} catch (SQLException e) {
 				e.printStackTrace();
 			}
			request.getRequestDispatcher("/vue/Dashbord.jsp").forward(request, response);

			
		}else if("/addClient.do".equals(path)) {
			if("POST".equals(request.getMethod())){
				 
				try{
					
					
					
					String nom = request.getParameter("nom");
					String prenom = request.getParameter("prenom");
					int age = Integer.parseInt(request.getParameter("age"));
					
					boolean isAdd =metier.AddClient(nom, prenom, age);
					if (isAdd == true) {
					response.sendRedirect("clients.do");  
					return;
					}else {
						response.sendRedirect("addClient.do");  

					}
					 
			        
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
			 
			
			
			
			
			
			if("POST".equals(request.getMethod())){
			try{
				
				boolean isDelete = metier.DeleteClient(clientId);
				if (isDelete == true){
					response.sendRedirect("clients.do");
			        return;
				}
				
				
			}catch(Exception e){
				
				PrintWriter out = response.getWriter();
				out.println( e.getMessage());
				
			}
			}else {
				try{
					 
					Client c = new Client();
					c = metier.FindClientById(clientId);
					 
					
					request.setAttribute("pm",c);
					request.getRequestDispatcher("/vue/deleteClient.jsp").forward(request, response);

		 

					
				}catch(Exception e){
					
					PrintWriter out = response.getWriter();
					out.println( e.getMessage());
					
				}
			}
			
		}else if("/EditClient.do".equals(path)) {
			 
			   int id = Integer.parseInt(request.getParameter("idClient"));
			 
				
				


			 

			  
			   if ("POST".equals(request.getMethod())) {
			       try {
			           
			           String newNom = request.getParameter("nom");
			           String newPrenom = request.getParameter("prenom");
			           int newAge = Integer.parseInt(request.getParameter("age"));
			           boolean isEdit =	metier.EditClient(id, newNom, newPrenom, newAge);
			          if(isEdit == true) {

  
			           response.sendRedirect("clients.do");  
			           return;
			            
			          } 
			       }catch(Exception e){
						
						PrintWriter out = response.getWriter();
						out.println( e.getMessage());
						
					}
			   }else {
				   try{
					 
						Client c = new Client();
						 c = metier.FindClientById(id);
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
		doGet(request, response);
	 
	}

}
