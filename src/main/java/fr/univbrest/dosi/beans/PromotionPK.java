package fr.univbrest.dosi.beans;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PROMOTION database table.
 * 
 */
@Embeddable
public class PromotionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ANNEE_UNIVERSITAIRE")
	private String anneeUniversitaire;

	@Column(name="CODE_FORMATION", insertable=false, updatable=false)
	private String codeFormation;

	public PromotionPK() {
	}
	
	
	public PromotionPK(String anneeUniversitaire, String codeFormation) {
		super();
		this.anneeUniversitaire = anneeUniversitaire;
		this.codeFormation = codeFormation;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PromotionPK other = (PromotionPK) obj;
		if (anneeUniversitaire == null) {
			if (other.anneeUniversitaire != null)
				return false;
		} else if (!anneeUniversitaire.equals(other.anneeUniversitaire))
			return false;
		if (codeFormation == null) {
			if (other.codeFormation != null)
				return false;
		} else if (!codeFormation.equals(other.codeFormation))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anneeUniversitaire == null) ? 0 : anneeUniversitaire.hashCode());
		result = prime * result + ((codeFormation == null) ? 0 : codeFormation.hashCode());
		return result;
	}
}