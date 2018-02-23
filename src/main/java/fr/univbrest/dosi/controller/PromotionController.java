package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.beans.Promotion;
import fr.univbrest.dosi.beans.PromotionPK;
import fr.univbrest.dosi.business.PromotionBusiness;

@RestController
@CrossOrigin(origins = "http://localhost:5500", maxAge=3600)
@RequestMapping("/promotions")
public class PromotionController {

	private PromotionBusiness business;
	@Autowired
	public PromotionController(PromotionBusiness business) {
		this.business=business;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Promotion savePromotion(@RequestBody Promotion promotion) {
		return business.creerPromotion(promotion);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Promotion> recupererPromotions() {
		return business.recupererPromotions();
	}
	
	
	@RequestMapping(value = "/sigle/{sigle}", method = RequestMethod.GET)
	public List<Promotion> recupererPromotionParSigle(@PathVariable String sigle) {
		return business.rechercheSigle(sigle);
	}
	
	@RequestMapping(value = "/annee/{annee}/codeFormation/{codeFormation}", method = RequestMethod.GET)
	public Promotion recupererPromotionParId(@PathVariable String annee,@PathVariable String codeFormation) {
		PromotionPK id=new PromotionPK();
		id.setAnneeUniversitaire(annee);
		id.setCodeFormation(codeFormation);
		return business.recherchePromotionParId(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void supprimerPromotion(@RequestBody Promotion promotion) {
		business.supprimerPromotion(promotion);
	}
	
	@RequestMapping(value="/annee/{annee}/codeFormation/{codeFormation}",method = RequestMethod.DELETE)
	public void supprimerPromotion(@PathVariable String annee,@PathVariable String codeFormation ) {
		PromotionPK id=new PromotionPK();
		id.setAnneeUniversitaire(annee);
		id.setCodeFormation(codeFormation);
		business.supprimerPromotion(id);
	}
	
	

}
