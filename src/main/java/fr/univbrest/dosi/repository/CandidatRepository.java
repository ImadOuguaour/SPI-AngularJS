package fr.univbrest.dosi.repository;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.beans.Candidat;

import java.util.List;

public interface CandidatRepository extends CrudRepository<Candidat,String> {
	List<Candidat> findByNom(String nom);
	List<Candidat> findByuniversiteOrigine(String universiteOrigine);
}
