package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.beans.Promotion;
import fr.univbrest.dosi.beans.PromotionPK;


public interface PromotionBusiness {

	public Promotion creerPromotion(Promotion promotionACreer);
	public void supprimerPromotion(Promotion promotionASupprimer);
	public void supprimerPromotion(PromotionPK id );	
	public List<Promotion> rechercheSigle(String sigle);
	public Promotion recherchePromotionParId(PromotionPK id);
	public List<Promotion> recupererPromotions();
}
