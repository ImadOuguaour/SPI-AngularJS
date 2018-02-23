package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.beans.Candidat;

public interface CandidatBusiness {

	public Candidat creerCandidat(Candidat candidatACreer);
	public void supprimerCandidat(Candidat candidatASupprimer);
	public void supprimerCandidat(String noCandidat);	
	public List<Candidat> rechercheCandidatParUniv(String universite);
	public List<Candidat> rechercheCandidatParNom(String nom);
	public Candidat rechercheCandidatParId(String id);
	public List<Candidat> recupererCandidats();
}