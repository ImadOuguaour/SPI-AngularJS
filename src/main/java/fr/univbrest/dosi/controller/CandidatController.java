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
import fr.univbrest.dosi.business.CandidatBusiness;

@RestController
@CrossOrigin(origins = "http://localhost:5500", maxAge=3600)
@RequestMapping("/candidats")
public class CandidatController {

	private CandidatBusiness business;

	@Autowired
	public CandidatController(CandidatBusiness business) {
		this.business = business;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Candidat saveCandidat(@RequestBody Candidat candidat) {
		return business.creerCandidat(candidat);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Candidat> recupererCandidats() {
		return business.recupererCandidats();
	}

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public Candidat recupererCandidatParId(@PathVariable String id) {
		return business.rechercheCandidatParId(id);
	}

	@RequestMapping(value = "/nom/{nom}", method = RequestMethod.GET)
	public List<Candidat> recupererCandidatParNom(@PathVariable String nom) {
		return business.rechercheCandidatParNom(nom);
	}

	@RequestMapping(value = "/nomUniversite/{nomUniversite}", method = RequestMethod.GET)
	public List<Candidat> recupererCandidatParNomUniversite(@PathVariable String nomUniversite) {
		return business.rechercheCandidatParUniv(nomUniversite);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void supprimerCandidat(@RequestBody Candidat candidat) {
		business.supprimerCandidat(candidat);
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
	public void supprimerCandidatParId(@PathVariable String id) {
		 business.supprimerCandidat(id);
	}
}
