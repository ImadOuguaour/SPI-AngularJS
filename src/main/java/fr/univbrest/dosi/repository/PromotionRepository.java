package fr.univbrest.dosi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.beans.Promotion;
import fr.univbrest.dosi.beans.PromotionPK;

public interface PromotionRepository extends CrudRepository<Promotion, PromotionPK> {

	public List<Promotion> findBysiglePromotion(String siglePromotion);
}
