package com.prueba.springboot.app.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.springboot.app.businesslogic.MutantesBL;
import com.prueba.springboot.app.dto.RequestMutantsDTO;

@RestController
@RequestMapping
@Validated
@Service
public class MutantesController {
	
	@Autowired
	MutantesBL mutantesBL;
	
	@PostMapping(path="/mutant", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getMutant(@RequestBody RequestMutantsDTO requestDTO){
		
		
		if(mutantesBL.isMutant(requestDTO.getDna())) {
			return ResponseEntity.ok("True, is mutant");
		}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
		
	}

}
