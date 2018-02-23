package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import fr.univbrest.dosi.beans.Enseignant;
import fr.univbrest.dosi.repository.EnseignantRepository;

public class EnseignantBusinessTest {

	EnseignantBusinessJPA business;
	EnseignantRepository repos;
	Enseignant e1, e2, e3, e4, e5;

	@Before
	public void setup() {
		e1 = new Enseignant(1, "29200", "Ouguaour", "Imad","M","France","Brest","ECH");
		e2 = new Enseignant(2, "29200", "Belaadel", "Kawtar","F","France","Brest","INT");
		e3 = new Enseignant(3, "29200", "Ouguaour", "Hassan","M","Maroc","Marrakech","ECH");
		e4 = new Enseignant(4, "29200", "Lamhaddar", "Halim","M","Maroc","Marrakech","ECH");
		e5 = new Enseignant(5, "29200", "Serhiri", "Aicha","F","Maroc","Marrakech","ECH");

		ArrayList<Enseignant> data = new ArrayList<>();
		data.add(e1);
		data.add(e2);
		data.add(e3);
		data.add(e4);
		data.add(e5);
		repos = new EnseignantRepositoryList(data);
		business = new EnseignantBusinessJPA(repos);
	}

	@Test
	public void doitCreerEnseignant() {
		Enseignant ens = new Enseignant(6, "29200", "Ouguaour", "Imad","M","Maroc","Marrakech","ECH");
		Enseignant resultat = business.creerEnseignant(ens);
		assertThat(resultat.getNom()).isEqualTo("Ouguaour");
		assertThat(repos.count()).isEqualTo(6);
	}

	@Test
	public void doitSupprimerEnseignant() {
		// Suppression d'aun objet passé en paramètre
		Enseignant ens = new Enseignant(2, "29200", "Belaadel", "Kawtar","M","Maroc","Marrakech","ECH");
		business.supprimerEnseignant(ens);
		assertThat(repos.count()).isEqualTo(4);
		// Suppression d'un objet en passant l'ID d'objet
		business.supprimerEnseignant(4);
		assertThat(repos.count()).isEqualTo(3);
	}

	@Test
	public void doitRechercheParNom() {
		List<Enseignant> resultats = business.rechercheEnseignantParNom("Ouguaour");
		assertThat(resultats).hasSize(2);
	}
	
	@Test
	public void doitRechercheParId() {
		Enseignant resultat=business.rechercheEnseignantParId(1);
		assertThat(resultat.getNom()).isEqualTo("Ouguaour");
	}
	
	@Test
	public void doitRechercheParSexe() {
		List<Enseignant> resultats=business.rechercheEnseignantParSexe("M");
		assertThat(resultats).hasSize(3);
	}

	@Test
	public void doitRechercheParPays() {
		List<Enseignant> resultats=business.rechercheEnseignantParPays("France");
		assertThat(resultats).hasSize(2);
	}
	
	@Test
	public void doitRechercheParVille() {
		List<Enseignant> resultats=business.rechercheEnseignantParVille("Marrakech");
		assertThat(resultats).hasSize(3);
	}
	
	@Test
	public void doitRechercheParType() {
		List<Enseignant> resultats=business.rechercheEnseignantParType("INT");
		assertThat(resultats).hasSize(1);
		List<Enseignant> resultats2=business.rechercheEnseignantParType("ECH");
		assertThat(resultats2).hasSize(4);
	}
	
	@Test
	public void doitRecupererTout() {
		List<Enseignant> resultats=business.recupererEnseignant();
		assertThat(resultats).hasSize(5);
		assertThat(resultats.get(0).getNom()).isEqualTo("Ouguaour");
	}
	
	public class EnseignantRepositoryList implements EnseignantRepository {
		private List<Enseignant> data;
		public EnseignantRepositoryList(List<Enseignant> data) {
			// TODO Auto-generated constructor stub
			this.data = data;
		}

		@Override
		public <S extends Enseignant> S save(S entity) {
			// TODO Auto-generated method stub
			System.out.println("hani");
			data.add(entity);
			return entity;
		}

		@Override
		public <S extends Enseignant> Iterable<S> save(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Enseignant findOne(Long id) {
			// TODO Auto-generated method stub
			for(Enseignant e : data) {
				if(e.getNoEnseignant()==id) {
					return e;
				}
			}
			return null;
		}

		@Override
		public boolean exists(Long id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Enseignant> findAll() {
			// TODO Auto-generated method stub
			return data;
		}

		@Override
		public Iterable<Enseignant> findAll(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public void delete(Long id) {
			// TODO Auto-generated method stub
			for (Enseignant e : data) {
				if (e.getNoEnseignant() == id) {
					data.remove(e);
					System.out.println("Supprimé");
					System.out.println(e.getNom());
				} else {
					System.out.println("Non supprimé");
				}
			}
		}

		@Override
		public void delete(Enseignant entity) {
			// TODO Auto-generated method stub
			if (data.contains(entity)) {
				data.remove(entity);
				System.out.println("Bien Supprimé");
			} else {
				System.out.println("objet doesn't exist");
			}
		}

		@Override
		public void delete(Iterable<? extends Enseignant> entities) {
			// TODO Auto-generated method stub

		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub

		}

		@Override
		public List<Enseignant> findBynom(String nom) {
			// TODO Auto-generated method stub
			return data.stream().filter(element -> element.getNom().matches(nom)).collect(Collectors.toList());

		}

		@Override
		public List<Enseignant> findBysexe(String sexe) {
			// TODO Auto-generated method stub
			return data.stream().filter(element -> element.getSexe().equals(sexe)).collect(Collectors.toList());
		}

		@Override
		public List<Enseignant> findByville(String ville) {
			// TODO Auto-generated method stub
			return data.stream().filter(element -> element.getVille().equals(ville)).collect(Collectors.toList());
		}

		@Override
		public List<Enseignant> findBypays(String pays) {
			// TODO Auto-generated method stub
			return data.stream().filter(element -> element.getPays().equals(pays)).collect(Collectors.toList());
		}

		@Override
		public List<Enseignant> findBytype(String type) {
			// TODO Auto-generated method stub
			return data.stream().filter(element -> element.getType().equals(type)).collect(Collectors.toList());
		}
	}
}
