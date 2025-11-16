package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 import  com.presentation.Client;
 import com.unite.SingleTonConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DaoImpl implements IDao {
	

	 Connection conn= SingleTonConnection.getConn();

	 
	 public DaoImpl() { 
 	 }
	 
	
 
	 
	@Override
	public List<Client> getClients(String moteCle) throws SQLException {
 		if(moteCle == null){
			moteCle="";
		}
 		
 		List<Client> clients = new ArrayList<Client>();
 		
 		
 		 
 		 try {
 		
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
 		
		return clients;
 		 }catch (Exception e) {
 	        e.printStackTrace();
 	        return null;
 	    }
		
	}

	@Override
	public boolean AddClient(String nom , String prenom , int age) {
		
		boolean isClientAdd = false ; 
		
		 
		try {
			PreparedStatement ps = conn.prepareStatement("insert into client (nom, prenom, age) values(?,?,?)");
			ps.setString(1,nom);
			ps.setString(2,prenom);
			ps.setInt(3,age);
			int n = ps.executeUpdate();
			if(n>0) {
				isClientAdd = true;
				
			} 
			 
		}catch (Exception e) {
 	        e.printStackTrace();
 	        
 	    }
		return isClientAdd;
		
		 
		
	}

	@Override
	public boolean DeleteClient(int id) {
		boolean isClientDelete = false ; 

		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM client where idClient = ?");
			
			ps.setInt(1,id);
			int n = ps.executeUpdate();
			if(n>0) {
				isClientDelete = true;
				
			} 

		} catch (SQLException e) {
 			e.printStackTrace();
		}
		return isClientDelete ;
		
	}
	
	
	
	
	
	
	
	@Override
	public Client FindClientById(int id) {
		
		Client c = null ;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM client where idClient = ?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				  c = new Client();

				c.setIdClient(rs.getInt("idClient"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setAge(rs.getInt("age"));
 				
			}
		} catch (SQLException e) {
 			e.printStackTrace();
 		}
		return c;
		
		
		
 		 
		
		
	}

	@Override
	public boolean EditClient(int id, String nom , String prenom , int age) {
		boolean isClientEdit = false ;
		
 		  try {
			  PreparedStatement ps = conn.prepareStatement("UPDATE client SET nom=?, prenom=?, age=? WHERE idClient=?");
			 ps.setString(1, nom);
	           ps.setString(2, prenom);
	           ps.setInt(3, age);
	           ps.setInt(4, id);

	           int n = ps.executeUpdate();
	           if(n>0) {
	        	   isClientEdit = true;
					
				} 
		  } catch (SQLException e) {
 			e.printStackTrace();
		  }
 			return isClientEdit ;

	          
		
	}
	
	


		
	}

 

	 
 
	
	


