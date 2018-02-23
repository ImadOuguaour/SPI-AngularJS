package fr.univbrest.dosi.repository;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.beans.Formation;

import java.util.List;

public interface FormationRepository extends CrudRepository<Formation, String> {

	List<Formation> findByNomFormation(String nomFormation);
}
