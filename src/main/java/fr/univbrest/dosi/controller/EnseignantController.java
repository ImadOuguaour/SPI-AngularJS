package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.beans.Candidat;
import fr.univbrest.dosi.beans.Enseignant;
import fr.univbrest.dosi.business.EnseignantBusiness;

@RestController
@CrossOrigin(origins = "http://localhost:5500", maxAge=3600)
@RequestMapping("/enseignants")
public class EnseignantController {

	private EnseignantBusiness business;
	@Autowired
	public EnseignantController(EnseignantBusiness business) {
		this.business=business;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Enseignant saveCandidat(@RequestBody Enseignant enseignant) {
		return business.creerEnseignant(enseignant);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void supprimerEnseignant(@RequestBody Enseignant enseignant) {
		business.supprimerEnseignant(enseignant);
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
	public void supprimerEnseignantParId(@PathVariable long id) {
		 business.supprimerEnseignant(id);
	}
	
	@RequestMapping(value = "/nom/{nom}", method = RequestMethod.GET)
	public List<Enseignant> recupererEnseignantParNom(@PathVariable String nom) {
		return business.rechercheEnseignantParNom(nom);
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public Enseignant recupererEnseignantParId(@PathVariable long id) {
		return business.rechercheEnseignantParId(id);
	}
	
	@RequestMapping(value = "/sexe/{sexe}", method = RequestMethod.GET)
	public List<Enseignant> recupererEnseignantParSexe(@PathVariable String sexe) {
		return business.rechercheEnseignantParSexe(sexe);
	}
	
	@RequestMapping(value = "/type/{type}", method = RequestMethod.GET)
	public List<Enseignant> recupererEnseignantParType(@PathVariable String type) {
		return business.rechercheEnseignantParType(type);
	}
	
	@RequestMapping(value = "/pays/{pays}", method = RequestMethod.GET)
	public List<Enseignant> recupererEnseignantParPays(@PathVariable String pays) {
		return business.rechercheEnseignantParPays(pays);
	}
	
	@RequestMapping(value = "/ville/{ville}", method = RequestMethod.GET)
	public List<Enseignant> recupererEnseignantParVille(@PathVariable String ville) {
		return business.rechercheEnseignantParVille(ville);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Enseignant> recupererCandidats() {
		return business.recupererEnseignant();
	}
}
