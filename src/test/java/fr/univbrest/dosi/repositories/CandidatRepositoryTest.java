package fr.univbrest.dosi.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.beans.Candidat;
import fr.univbrest.dosi.repository.CandidatRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class CandidatRepositoryTest {

	@Autowired
	CandidatRepository candidatRepo;

	@Before
	public void setup() {
		Candidat candidat1 = new Candidat("12", "Kergoat", "29200", "imad@gmail.com", "Ouguaour", "Imad",
				"M", "UBO");
		Candidat candidat2 = new Candidat("13", "Kergoat", "29200", "imado@gmail.com", "test", "test", "M",
				"UBO");
		candidatRepo.save(candidat1);
		candidatRepo.save(candidat2);
	}

	@Test
	public void doitCompterLesCandidats() {
		long resultat = candidatRepo.count();

		assertThat(resultat).isEqualTo(2);
	}

	@Test
	public void doitRechercherParNomFormation() {
		List<Candidat> resultat = candidatRepo.findByNom("Ouguaour");
		assertThat(resultat).hasSize(1);

	}

	@Test
	 public void doitRechercherParUniversiteOrigine() {
		 List<Candidat> resultat = candidatRepo.findByuniversiteOrigine("UBO");
		 assertThat(resultat).hasSize(2);
	 }

}