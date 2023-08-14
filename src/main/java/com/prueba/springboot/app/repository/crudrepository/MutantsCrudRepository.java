package com.prueba.springboot.app.repository.crudrepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prueba.springboot.app.ui.model.Mutants;

@Repository
public interface MutantsCrudRepository extends CrudRepository<Mutants, Integer> {
	
	

}
