package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import fr.univbrest.dosi.beans.Promotion;
import fr.univbrest.dosi.beans.PromotionPK;
import fr.univbrest.dosi.repository.PromotionRepository;

public class PromotionBusinessTest {

	PromotionBusinessJPA business;
	PromotionRepository repos;
	Promotion p1, p2, p3, p4, p5;

	@Before
	public void setup() {
		p1 = new Promotion(new PromotionPK("2012-2013", "f1"), new Date(), "DOSI");
		p2 = new Promotion(new PromotionPK("2012-2013", "f2"), new Date(), "ISI");
		p3 = new Promotion(new PromotionPK("2014-2015", "f3"), new Date(), "GL");
		p4 = new Promotion(new PromotionPK("2015-2016", "f1"), new Date(), "DOSI");
		p5 = new Promotion(new PromotionPK("2016-2017", "f1"), new Date(), "DOSI");

		ArrayList<Promotion> data = new ArrayList<>();
		data.add(p1);
		data.add(p2);
		data.add(p3);
		data.add(p4);
		data.add(p5);
		repos = new PromotionRepositoryList(data);
		business = new PromotionBusinessJPA(repos);
	}

	@Test
	public void doitCreerPromotion() {
		Promotion p = new Promotion(new PromotionPK("2017-2018", "f1"), null, "DOSI");
		Promotion resultat = business.creerPromotion(p);
		assertThat(repos.count()).isEqualTo(6);
	}

	@Test
	public void doitSupprimerPromotion() {
		Promotion p = new Promotion(new PromotionPK("2012-2013", "f1"), null, "DOSI");
		business.supprimerPromotion(p);
		assertThat(repos.count()).isEqualTo(4);
	}

	@Test 
	public void doitRechercheParSigle() {
		List<Promotion> resultats=business.rechercheSigle("DOSI");
		assertThat(resultats).hasSize(3);
	}
	
	@Test
	public void doitRechercheParId() {
		PromotionPK id=new PromotionPK("2012-2013", "f1");
		Promotion resultat=business.recherchePromotionParId(id);
		assertThat(resultat.getSiglePromotion()).isEqualTo("DOSI");
	}
	
	@Test
	public void doitRechercherTout() {
		List<Promotion> resultats=business.recupererPromotions();
		assertThat(resultats).hasSize(5);
	}
	
	public class PromotionRepositoryList implements PromotionRepository {
		List<Promotion> data;

		public PromotionRepositoryList(ArrayList<Promotion> data) {
			// TODO Auto-generated constructor stub
			this.data = data;
		}

		@Override
		public <S extends Promotion> S save(S entity) {
			// TODO Auto-generated method stub
			data.add(entity);
			return entity;
		}

		@Override
		public <S extends Promotion> Iterable<S> save(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Promotion findOne(PromotionPK id) {
			// TODO Auto-generated method stub
			for(Promotion p : data) {
				if(p.getId().equals(id)) {
					return p;	
				}
			}
			return null;
		}

		@Override
		public boolean exists(PromotionPK id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Promotion> findAll() {
			// TODO Auto-generated method stub
			return data;
		}

		@Override
		public Iterable<Promotion> findAll(Iterable<PromotionPK> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public void delete(PromotionPK id) {
			// TODO Auto-generated method stub

		}

		@Override
		public void delete(Promotion entity) {
			// TODO Auto-generated method stub
			if (data.contains(entity)) {
				data.remove(entity);
				System.out.println("Supprimé");
			} else {
				System.out.println("Object doesn't exist");
			}

		}

		@Override
		public void delete(Iterable<? extends Promotion> entities) {
			// TODO Auto-generated method stub

		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub

		}

		@Override
		public List<Promotion> findBysiglePromotion(String siglePromotion) {
			// TODO Auto-generated method stub
			return data.stream().filter(element -> element.getSiglePromotion().equals(siglePromotion)).collect(Collectors.toList());
		}
	}

}
