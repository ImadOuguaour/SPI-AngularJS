package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.beans.Enseignant;

public interface EnseignantBusiness {

	public Enseignant creerEnseignant(Enseignant enseignantACreer);
	public void supprimerEnseignant(Enseignant enseignantASupprimer);
	public void supprimerEnseignant(long id );	
	public List<Enseignant> rechercheEnseignantParNom(String nom);
	public Enseignant rechercheEnseignantParId(long id);
	public List<Enseignant> rechercheEnseignantParSexe(String sexe);
	public List<Enseignant> rechercheEnseignantParVille(String ville);
	public List<Enseignant> rechercheEnseignantParPays(String pays);
	public List<Enseignant> rechercheEnseignantParType(String type);
	public List<Enseignant> recupererEnseignant();
}
