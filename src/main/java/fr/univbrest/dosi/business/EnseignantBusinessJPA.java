package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.beans.Enseignant;
import fr.univbrest.dosi.repository.EnseignantRepository;
@Component
public class EnseignantBusinessJPA implements EnseignantBusiness {

	private EnseignantRepository repos;
	@Autowired
	public EnseignantBusinessJPA(EnseignantRepository repos) {
		// TODO Auto-generated constructor stub
		this.repos=repos;
	}
	@Override
	public Enseignant creerEnseignant(Enseignant enseignantACreer) {
		// TODO Auto-generated method stub
		System.out.println("Test");
		return repos.save(enseignantACreer);
	}

	@Override
	public void supprimerEnseignant(Enseignant enseignantASupprimer) {
		// TODO Auto-generated method stub
		repos.delete(enseignantASupprimer);
	}

	@Override
	public void supprimerEnseignant(long id) {
		// TODO Auto-generated method stub
		repos.delete(id);
	}

	@Override
	public List<Enseignant> rechercheEnseignantParNom(String nom) {
		// TODO Auto-generated method stub
		return repos.findBynom(nom);
	}

	@Override
	public Enseignant rechercheEnseignantParId(long id) {
		// TODO Auto-generated method stub
		return repos.findOne(id);
	}

	@Override
	public List<Enseignant> rechercheEnseignantParSexe(String sexe) {
		// TODO Auto-generated method stub
		return repos.findBysexe(sexe);
	}

	@Override
	public List<Enseignant> rechercheEnseignantParVille(String ville) {
		// TODO Auto-generated method stub
		return repos.findByville(ville);
	}

	@Override
	public List<Enseignant> rechercheEnseignantParPays(String pays) {
		// TODO Auto-generated method stub
		return repos.findBypays(pays);
	}

	@Override
	public List<Enseignant> rechercheEnseignantParType(String type) {
		// TODO Auto-generated method stub
		return repos.findBytype(type);
	}

	@Override
	public List<Enseignant> recupererEnseignant() {
		// TODO Auto-generated method stub
		return (List<Enseignant>) repos.findAll();
	}

}
