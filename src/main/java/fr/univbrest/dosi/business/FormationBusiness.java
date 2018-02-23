package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.beans.Formation;

public interface FormationBusiness {

	Formation creerFormation(Formation formationAcreer);
	List<Formation> recupererToutesLesFormations();
	List<Formation> rechercheFormationParNom(String nom);
	Formation rechercheFormationParId(String id);
	void supprimerFormationParId(String Id);
}
