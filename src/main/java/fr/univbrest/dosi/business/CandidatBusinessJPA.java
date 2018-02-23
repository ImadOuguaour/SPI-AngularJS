package fr.univbrest.dosi.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.beans.Candidat;
import fr.univbrest.dosi.repository.CandidatRepository;
@Component
public class CandidatBusinessJPA implements CandidatBusiness {

	private CandidatRepository repos ;
	
	@Autowired
	public CandidatBusinessJPA(CandidatRepository repos) {
		this.repos=repos;
	}
	
	@Override
	public Candidat creerCandidat(Candidat candidatACreer) {
		candidatACreer.setDateNaissance(new Date());
		candidatACreer.setDateReponseCandidat(new Date());
		return repos.save(candidatACreer);	
	}

	@Override
	public void supprimerCandidat(Candidat candidatASupprimer) {
		// TODO Auto-generated method stub
		repos.delete(candidatASupprimer);
		
	}

	@Override
	public List<Candidat> rechercheCandidatParUniv(String universite) {
		return repos.findByuniversiteOrigine(universite);
	}

	@Override
	public List<Candidat> rechercheCandidatParNom(String nom) {
		return repos.findByNom(nom);
	}

	@Override
	public void supprimerCandidat(String noCandidat) {
		// TODO Auto-generated method stub
		repos.delete(noCandidat);
		
	}

	@Override
	public List<Candidat> recupererCandidats() {
		// TODO Auto-generated method stub
		return (List<Candidat>) repos.findAll();
	}

	@Override
	public Candidat rechercheCandidatParId(String id) {
		// TODO Auto-generated method stub
		return repos.findOne(id);
	}

}
