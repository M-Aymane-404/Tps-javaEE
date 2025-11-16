package com;

public class Etudiant {
	private String nom;
	private String prenom;
	private double note;

	  public Etudiant(String nom, String prenom, float note) {
	        this.nom = nom;
	        this.prenom = prenom;
	        this.note = note;
	    }
	  public Etudiant() {
	       
	    }
	  
	  public String getNom() {
			return nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public double getNote() {
		    return note;
		}
		
		public void setNom(String nom) {
			this.nom = nom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public void setNote(double note) {
			this.note = note;
		}
	
}
