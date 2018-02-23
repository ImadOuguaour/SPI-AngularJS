package fr.univbrest.dosi.beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ENSEIGNANT database table.
 * 
 */
@Entity
@NamedQuery(name="Enseignant.findAll", query="SELECT e FROM Enseignant e")
public class Enseignant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NO_ENSEIGNANT")
	private long noEnseignant;

	private String adresse;

	@Column(name="CODE_POSTAL")
	private String codePostal;

	@Column(name="EMAIL_PERSO")
	private String emailPerso;

	@Column(name="EMAIL_UBO")
	private String emailUbo;

	private String mobile;

	private String nom;

	private String pays;

	private String prenom;

	private String sexe;

	private String telephone;

	@Column(name="TYPE")
	private String type;

	private String ville;

	public Enseignant() {
	}
	
	

	public Enseignant(long noEnseignant, String codePostal, String nom, String prenom,String sexe,String pays,
			String ville, String type) {
		super();
		this.noEnseignant = noEnseignant;
		this.codePostal = codePostal;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe=sexe;
		this.pays=pays;
		this.ville=ville;
		this.type=type;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (noEnseignant ^ (noEnseignant >>> 32));
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enseignant other = (Enseignant) obj;
		if (noEnseignant != other.noEnseignant)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}



	public long getNoEnseignant() {
		return this.noEnseignant;
	}

	public void setNoEnseignant(long noEnseignant) {
		this.noEnseignant = noEnseignant;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getEmailPerso() {
		return this.emailPerso;
	}

	public void setEmailPerso(String emailPerso) {
		this.emailPerso = emailPerso;
	}

	public String getEmailUbo() {
		return this.emailUbo;
	}

	public void setEmailUbo(String emailUbo) {
		this.emailUbo = emailUbo;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}