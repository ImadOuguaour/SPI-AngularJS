package fr.univbrest.dosi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.beans.Enseignant;

public interface EnseignantRepository extends CrudRepository<Enseignant, Long> {

	public List<Enseignant> findBynom(String nom);
	public List<Enseignant> findBysexe(String sexe);
	public List<Enseignant> findByville(String ville);
	public List<Enseignant> findBypays(String pays);
	public List<Enseignant> findBytype(String type);
}
