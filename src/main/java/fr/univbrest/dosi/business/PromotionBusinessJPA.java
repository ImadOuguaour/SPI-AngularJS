package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.beans.Promotion;
import fr.univbrest.dosi.beans.PromotionPK;
import fr.univbrest.dosi.repository.PromotionRepository;

@Component
public class PromotionBusinessJPA implements PromotionBusiness {

	private PromotionRepository repos;
	
	@Autowired
	public PromotionBusinessJPA(PromotionRepository repos) {
		this.repos=repos;
	}
	@Override
	public Promotion creerPromotion(Promotion promotionACreer) {
		// TODO Auto-generated method stub
		return repos.save(promotionACreer);
	}

	@Override
	public void supprimerPromotion(Promotion promotionASupprimer) {
		// TODO Auto-generated method stub
		repos.delete(promotionASupprimer);
	}

	@Override
	public void supprimerPromotion(PromotionPK id) {
		// TODO Auto-generated method stub
		repos.delete(id);
	}

	@Override
	public List<Promotion> rechercheSigle(String sigle) {
		// TODO Auto-generated method stub
		return repos.findBysiglePromotion(sigle);
	}


	@Override
	public Promotion recherchePromotionParId(PromotionPK id) {
		// TODO Auto-generated method stub
		return repos.findOne(id);
	}

	@Override
	public List<Promotion> recupererPromotions() {
		// TODO Auto-generated method stub
		return (List<Promotion>) repos.findAll();
	}

}
