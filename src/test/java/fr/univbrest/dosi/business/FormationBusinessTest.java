package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.univbrest.dosi.beans.Formation;
import fr.univbrest.dosi.repository.FormationRepository;

public class FormationBusinessTest {

	FormationBusinessJPA business;
	
	@Test
	public void doitCreerFormation() {
		FormationRepository repos=new FormationRpositoryList();
		business=new FormationBusinessJPA(repos);
		Formation formation=new Formation("33", "M2", "O", BigDecimal.valueOf(2.0), "DOSI");
		Formation resultat=business.creerFormation(formation);
		assertThat(resultat.getDebutAccreditation()).isCloseTo(new Date(), 500);
		assertThat(repos.count()).isEqualTo(1);
	}

	
	class FormationRpositoryList implements FormationRepository{
		private List<Formation> data;
		public FormationRpositoryList() {
			data=Lists.newArrayList();
		}
		@Override
		public long count() {
			return data.size();
		}
		@Override
		public void delete(String arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void delete(Formation arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void delete(Iterable<? extends Formation> arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean exists(String arg0) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public Iterable<Formation> findAll() {
			return data;
		}
		@Override
		public Iterable<Formation> findAll(Iterable<String> arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Formation findOne(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public <S extends Formation> S save(S entity) {
			data.add(entity);
			
			return entity;
		}
		@Override
		public <S extends Formation> Iterable<S> save(Iterable<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public List<Formation> findByNomFormation(String nomFormation) {
			// TODO Auto-generated method stub
			return null;
		}
	}

}
