package fr.univbrest.dosi.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the CANDIDAT database table.
 * 
 */
@Entity
@NamedQuery(name="Candidat.findAll", query="SELECT c FROM Candidat c")
public class Candidat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NO_CANDIDAT")
	private String noCandidat;

	private String adresse;

	@Column(name="ANNEE_UNIVERSITAIRE")
	private String anneeUniversitaire;

	@Column(name="CODE_FORMATION")
	private String codeFormation;

	@Column(name="CODE_POSTAL")
	private String codePostal;

	@Column(name="CONFIRMATION_CANDIDAT")
	private String confirmationCandidat;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_NAISSANCE")
	private Date dateNaissance;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_REPONSE_CANDIDAT")
	private Date dateReponseCandidat;

	private String email;

	@Column(name="LIEU_NAISSANCE")
	private String lieuNaissance;

	@Column(name="LISTE_SELECTION")
	private String listeSelection;

	private String mobile;

	private String nationalite;

	private String nom;

	@Column(name="PAYS_ORIGINE")
	private String paysOrigine;

	private String prenom;

	@Column(name="SELECTION_NO_ORDRE")
	private BigDecimal selectionNoOrdre;

	private String sexe;

	private String telephone;

	@Column(name="UNIVERSITE_ORIGINE")
	private String universiteOrigine;

	private String ville;

	public Candidat() {
	}
	
	

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((codePostal == null) ? 0 : codePostal.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((noCandidat == null) ? 0 : noCandidat.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((sexe == null) ? 0 : sexe.hashCode());
		result = prime * result + ((universiteOrigine == null) ? 0 : universiteOrigine.hashCode());
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
		Candidat other = (Candidat) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (codePostal == null) {
			if (other.codePostal != null)
				return false;
		} else if (!codePostal.equals(other.codePostal))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (noCandidat == null) {
			if (other.noCandidat != null)
				return false;
		} else if (!noCandidat.equals(other.noCandidat))
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
		if (sexe == null) {
			if (other.sexe != null)
				return false;
		} else if (!sexe.equals(other.sexe))
			return false;
		if (universiteOrigine == null) {
			if (other.universiteOrigine != null)
				return false;
		} else if (!universiteOrigine.equals(other.universiteOrigine))
			return false;
		return true;
	}





	public Candidat(String noCandidat, String adresse, String codePostal, String email, String nom, String prenom,
			String sexe, String universiteOrigine) {
		super();
		this.noCandidat = noCandidat;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.universiteOrigine = universiteOrigine;
	}



	public String getNoCandidat() {
		return this.noCandidat;
	}

	public void setNoCandidat(String noCandidat) {
		this.noCandidat = noCandidat;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getAnneeUniversitaire() {
		return this.anneeUniversitaire;
	}

	public void setAnneeUniversitaire(String anneeUniversitaire) {
		this.anneeUniversitaire = anneeUniversitaire;
	}

	public String getCodeFormation() {
		return this.codeFormation;
	}

	public void setCodeFormation(String codeFormation) {
		this.codeFormation = codeFormation;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getConfirmationCandidat() {
		return this.confirmationCandidat;
	}

	public void setConfirmationCandidat(String confirmationCandidat) {
		this.confirmationCandidat = confirmationCandidat;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Date getDateReponseCandidat() {
		return this.dateReponseCandidat;
	}

	public void setDateReponseCandidat(Date dateReponseCandidat) {
		this.dateReponseCandidat = dateReponseCandidat;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLieuNaissance() {
		return this.lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getListeSelection() {
		return this.listeSelection;
	}

	public void setListeSelection(String listeSelection) {
		this.listeSelection = listeSelection;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNationalite() {
		return this.nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPaysOrigine() {
		return this.paysOrigine;
	}

	public void setPaysOrigine(String paysOrigine) {
		this.paysOrigine = paysOrigine;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public BigDecimal getSelectionNoOrdre() {
		return this.selectionNoOrdre;
	}

	public void setSelectionNoOrdre(BigDecimal selectionNoOrdre) {
		this.selectionNoOrdre = selectionNoOrdre;
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

	public String getUniversiteOrigine() {
		return this.universiteOrigine;
	}

	public void setUniversiteOrigine(String universiteOrigine) {
		this.universiteOrigine = universiteOrigine;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}