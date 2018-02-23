package fr.univbrest.dosi.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.beans.Formation;
import fr.univbrest.dosi.repository.FormationRepository;

@Component
public class FormationBusinessJPA implements FormationBusiness {

	private FormationRepository formationRepository;
	
	@Autowired
	public FormationBusinessJPA(FormationRepository formationRepository) {
		this.formationRepository=formationRepository;
	}
	
	@Override
	public Formation creerFormation(Formation formationAcreer) {
		formationAcreer.setDebutAccreditation(new Date());
		formationAcreer.setFinAccreditation(new Date());
		
		return formationRepository.save(formationAcreer);
		
	}

	@Override
	public List<Formation> recupererToutesLesFormations() {
		
		return (List<Formation>) formationRepository.findAll();
	}

	@Override
	public List<Formation> rechercheFormationParNom(String nom) {
		// TODO Auto-generated method stub
		return formationRepository.findByNomFormation(nom);
	}

	@Override
	public Formation rechercheFormationParId(String id) {
		// TODO Auto-generated method stub
		return formationRepository.findOne(id);
	}

	@Override
	public void supprimerFormationParId(String id) {
		// TODO Auto-generated method stub
		if(formationRepository.findOne(id) != null) {
			formationRepository.delete(id);
		}
		else {
			System.out.println("non");
		}
		
	}

	
}
