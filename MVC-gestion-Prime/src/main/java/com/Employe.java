package com;

public class Employe {
	private int id ;
	private String nom;
	private String prenom;
	private String date_debut;

	private int Salaire  ;

	
	public void Employe() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}
	public int getSalaire() {
		return Salaire;
	}
	public void setSalaire(int salaire) {
		Salaire = salaire;
	}
	
	
	
}
