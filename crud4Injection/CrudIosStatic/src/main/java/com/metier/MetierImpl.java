package com.metier;

import com.dao.IDao;

import java.sql.SQLException;
import java.util.List;

import  com.presentation.Client;
 
public class MetierImpl implements IMetier {
		private IDao dao;
		
		
		public MetierImpl() {
			
		}
		
		public void setDao(IDao dao) {
	        this.dao = dao;
 	    }
		
	
		
		public List<Client> getClients(String moteCle) throws SQLException{
 			return dao.getClients(moteCle);
		}

		@Override
		public boolean AddClient(String nom, String prenom, int age) {
			return dao.AddClient(nom, prenom, age);
			
		}

		@Override
		public boolean DeleteClient(int id) {
			return dao.DeleteClient(id);
			
		}

		@Override
		public Client FindClientById(int id) {
			return dao.FindClientById(id);
			
		}

		@Override
		public boolean EditClient(int id, String nom, String prenom, int age) {
			return dao.EditClient(id,nom, prenom, age);
			
		}

		 
		

	 

		 
		
		 
		
}
