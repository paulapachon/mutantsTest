package com.prueba.springboot.app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prueba.springboot.app.repository.crudrepository.MutantsCrudRepository;
import com.prueba.springboot.app.repository.domainrepository.MutantsDomainRepository;
import com.prueba.springboot.app.ui.model.Mutants;

@Repository
public class MutantsRepository implements MutantsDomainRepository {
	
	@Autowired
	MutantsCrudRepository crudRepository;

	@Override
	public void saveMutants(Mutants mutants) {
		crudRepository.save(mutants);
	}

}
