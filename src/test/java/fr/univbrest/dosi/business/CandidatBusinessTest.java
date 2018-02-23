package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import fr.univbrest.dosi.beans.Candidat;
import fr.univbrest.dosi.repository.CandidatRepository;

public class CandidatBusinessTest {

	CandidatBusinessJPA business;
	CandidatRepository repos;
	Candidat c1, c2, c3, c4, c5;

	@Before
	public void setup() {
		c1 = new Candidat("1", "ker", "29200", "imad@gmail.com", "Ouguaour", "Imad", "M", "UBO");
		c2 = new Candidat("2", "ker", "29200", "imad@gmail.com", "Lamhaddar", "Halim", "M", "UBO");
		c3 = new Candidat("3", "ker", "29200", "imad@gmail.com", "Ouguaour", "Zaid", "M", "FSSM");
		c4 = new Candidat("4", "ker", "29200", "imad@gmail.com", "Serhiri", "Aicha", "F", "UBO");
		c5 = new Candidat("5", "ker", "29200", "imad@gmail.com", "Ouguaour", "Reda", "M", "UBO");
		ArrayList<Candidat> data = new ArrayList<Candidat>();
		data.add(c1);
		data.add(c2);
		data.add(c3);
		data.add(c4);
		data.add(c5);
		repos = new CandidatRepositoryList(data);
		business = new CandidatBusinessJPA(repos);
	}

	@Test
	public void doitCreerCandidat() {

		Candidat candidat = new Candidat("6", "ker", "29200", "imad@gmail.com", "Ouguaour", "Imad", "M", "UBO");
		Candidat resultat = business.creerCandidat(candidat);
		assertThat(resultat.getDateNaissance()).isBefore(new Date());
		assertThat(resultat.getCodePostal()).isEqualTo("29200");
		assertThat(repos.count()).isEqualTo(6);

	}

	@Test
	public void doitRechercherParNom() {
		List<Candidat> resultats = business.rechercheCandidatParNom("Ouguaour");
		assertThat(resultats.size()).isEqualTo(3);
		assertThat(resultats).containsExactly(c1, c3, c5);
	}

	@Test
	public void doitRechercherParUniversite() {
		List<Candidat> resultats1 = business.rechercheCandidatParUniv("UBO");
		assertThat(resultats1.size()).isEqualTo(4);
		List<Candidat> resultats2 = business.rechercheCandidatParUniv("FSSM");
		assertThat(resultats2.size()).isEqualTo(1);
	}

	@Test
	public void doitSupprimer() {
		Candidat candidat = new Candidat("1", "ker", "29200", "imad@gmail.com", "Ouguaour", "Imad", "M", "UBO");
		business.supprimerCandidat(candidat);
		assertThat(repos.count()).isEqualTo(4);
		business.supprimerCandidat("4");
		assertThat(repos.count()).isEqualTo(3);

	}

	public class CandidatRepositoryList implements CandidatRepository {
		List<Candidat> data;

		public CandidatRepositoryList() {
			data = Lists.newArrayList();
		}

		public CandidatRepositoryList(List<Candidat> donnee) {
			data = donnee;
		}

		@Override
		public long count() {
			return data.size();
		}

		@Override
		public void delete(String noCandidat) {
			for (Candidat c : data) {
				if (c.getNoCandidat().equals(noCandidat)) {
					data.remove(c);
					System.out.println("Bien supprimé");
				} else {
					System.out.println("non Supprimé");
				}
			}
		}

		@Override
		public void delete(Candidat entity) {
			// TODO Auto-generated method stub
			
			if (data.remove(entity)) {
				System.out.println("Bien supprimé");
			} else {
				System.out.println("Non supprimé");
			}
		}

		@Override
		public void delete(Iterable<? extends Candidat> arg0) {
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
		public Iterable<Candidat> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Candidat> findAll(Iterable<String> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Candidat findOne(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Candidat> S save(S entity) {
			// TODO Auto-generated method stub
			data.add(entity);
			return entity;
		}

		@Override
		public <S extends Candidat> Iterable<S> save(Iterable<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Candidat> findByNom(String nom) {
//			List<Candidat> candidats = new ArrayList();
//			for (Candidat c : data) {
//				if (c.getNom().equals(nom)) {
//					candidats.add(c);
//				}
//			}
//			return candidats;
			return data.stream().filter(candidat -> candidat.getNom().equalsIgnoreCase(nom)).collect(Collectors.toList());
		}

		@Override
		public List<Candidat> findByuniversiteOrigine(String universiteOrigine) {
			List<Candidat> candidats = new ArrayList();
			for (Candidat c : data) {
				if (c.getUniversiteOrigine().equals(universiteOrigine)) {
					candidats.add(c);
				}
			}
			return candidats;
		}

	}
}
