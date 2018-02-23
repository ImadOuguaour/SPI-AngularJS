package fr.univbrest.dosi.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PROMOTION database table.
 * 
 */
@Entity
@NamedQuery(name="Promotion.findAll", query="SELECT p FROM Promotion p")
public class Promotion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PromotionPK id;

	private String commentaire;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_RENTREE")
	private Date dateRentree;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_REPONSE_LALP")
	private Date dateReponseLalp;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_REPONSE_LP")
	private Date dateReponseLp;

	@Column(name="LIEU_RENTREE")
	private String lieuRentree;

	@Column(name="NB_MAX_ETUDIANT")
	private BigDecimal nbMaxEtudiant;

	@Column(name="NO_ENSEIGNANT")
	private BigDecimal noEnseignant;

	@Column(name="PROCESSUS_STAGE")
	private String processusStage;

	@Column(name="SIGLE_PROMOTION")
	private String siglePromotion;

	public Promotion() {
	}
	

	public Promotion(PromotionPK id, Date dateRentree,  
			String siglePromotion) {
		super();
		this.id = id;
		this.dateRentree = dateRentree;
		this.siglePromotion = siglePromotion;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nbMaxEtudiant == null) ? 0 : nbMaxEtudiant.hashCode());
		result = prime * result + ((siglePromotion == null) ? 0 : siglePromotion.hashCode());
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
		Promotion other = (Promotion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nbMaxEtudiant == null) {
			if (other.nbMaxEtudiant != null)
				return false;
		} else if (!nbMaxEtudiant.equals(other.nbMaxEtudiant))
			return false;
		if (siglePromotion == null) {
			if (other.siglePromotion != null)
				return false;
		} else if (!siglePromotion.equals(other.siglePromotion))
			return false;
		return true;
	}


	public PromotionPK getId() {
		return this.id;
	}

	public void setId(PromotionPK id) {
		this.id = id;
	}

	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Date getDateRentree() {
		return this.dateRentree;
	}

	public void setDateRentree(Date dateRentree) {
		this.dateRentree = dateRentree;
	}

	public Date getDateReponseLalp() {
		return this.dateReponseLalp;
	}

	public void setDateReponseLalp(Date dateReponseLalp) {
		this.dateReponseLalp = dateReponseLalp;
	}

	public Date getDateReponseLp() {
		return this.dateReponseLp;
	}

	public void setDateReponseLp(Date dateReponseLp) {
		this.dateReponseLp = dateReponseLp;
	}

	public String getLieuRentree() {
		return this.lieuRentree;
	}

	public void setLieuRentree(String lieuRentree) {
		this.lieuRentree = lieuRentree;
	}

	public BigDecimal getNbMaxEtudiant() {
		return this.nbMaxEtudiant;
	}

	public void setNbMaxEtudiant(BigDecimal nbMaxEtudiant) {
		this.nbMaxEtudiant = nbMaxEtudiant;
	}

	public BigDecimal getNoEnseignant() {
		return this.noEnseignant;
	}

	public void setNoEnseignant(BigDecimal noEnseignant) {
		this.noEnseignant = noEnseignant;
	}

	public String getProcessusStage() {
		return this.processusStage;
	}

	public void setProcessusStage(String processusStage) {
		this.processusStage = processusStage;
	}

	public String getSiglePromotion() {
		return this.siglePromotion;
	}

	public void setSiglePromotion(String siglePromotion) {
		this.siglePromotion = siglePromotion;
	}

}