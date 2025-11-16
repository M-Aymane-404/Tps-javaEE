package com.dao;

import java.sql.SQLException;
import java.util.List;

import  com.presentation.Client;
import com.unite.DbConnection;

public interface IDao  {
	
	public List<Client> getClients(String moteCle) throws SQLException;
	public boolean AddClient(String nom , String prenom , int age);
	public boolean DeleteClient(int id);
	public Client FindClientById(int id );
	public boolean EditClient(int id, String nom , String prenom , int age);



}
