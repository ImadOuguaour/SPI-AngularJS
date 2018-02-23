package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.beans.Formation;
import fr.univbrest.dosi.business.FormationBusiness;


@RestController
@CrossOrigin(origins = "http://localhost:5500", maxAge=3600)
@RequestMapping("/formations")
public class FormationController {
	
	private FormationBusiness business;
	@Autowired
	public FormationController(FormationBusiness business) {
		this.business=business;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Formation creerFormation(@RequestBody Formation formationAcreer) {
		return business.creerFormation(formationAcreer);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Formation> recupererToutesLesFormation(){
		return business.recupererToutesLesFormations();
	}
	
	@RequestMapping(value="/nom/{nom}", method=RequestMethod.GET)
	public List<Formation> recupererLaFormationAvecLeNom(@PathVariable String nom) {
		System.out.println(nom);
		return business.rechercheFormationParNom(nom);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Formation recupererLaFormationAvecID(@PathVariable String id) {
		return business.rechercheFormationParId(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void supprimerFormationParId(@PathVariable String id) {
		 business.supprimerFormationParId(id);
	}
}
