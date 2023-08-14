package com.prueba.springboot.app.businesslogic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.springboot.app.repository.MutantsRepository;
import com.prueba.springboot.app.ui.model.Mutants;


@Service
public class MutantesBL {
	
	@Autowired
	MutantsRepository mutantsRepository;
	
	public Boolean isMutant(String[] dna) {
		
		List<String> secuencias = Arrays.asList("AAAA","TTTT","CCCC","GGGG");
		char[][] dnaMatriz = new char[dna.length][dna.length];
		List<String> resultados = new ArrayList<>();
		
		//Convierto a matriz
		for (int i=0; i < dna.length; i++) {
			  dnaMatriz[i] = dna[i].toCharArray();
			}
		
		resultados.addAll(Arrays.asList(dna));
		getVertical(dnaMatriz, resultados);
		getDiagonal(dnaMatriz, resultados);
		long mutante = resultados.stream().filter(r->secuencias.stream().filter(s->r.contains(s)).count()>0).count();		
		if(mutante>1) {
			Mutants mutants = new Mutants();
			String dnaString = "";
			for(int i=0;i<dna.length;i++) {
				dnaString+= dna[i];
			}
			mutants.setAdn(dnaString);
			mutantsRepository.saveMutants(mutants);
		}
		return mutante>1;
	}
	
	
	private void getVertical(char[][] dnaArray,List<String> resultados) {
		
		String fila = null;
		for (int x=0; x < dnaArray.length; x++) {
			  fila="";
			  for (int y=0; y < dnaArray.length; y++) {
				  fila += ""+dnaArray[y][x];
			  }
			  resultados.add(fila);
		}
				
	}
	
	private void getDiagonal(char[][] dnaArray, List<String> resultados) {
		
		
		//Diagonales
		String fila = null;
		int k=0;
		for (int x=0; k < dnaArray.length; x++) {
			fila="";
			for (int y=0; y < dnaArray[x].length; y++) {
				  k = x+y;
				  if(k>=dnaArray.length) {
					  break;
				  }
				  fila += ""+dnaArray[y][k];	  
			 }
	    resultados.add(fila);
		}
		
		//Contradiagonales
        /*k=0;
		for (int x=dnaArray.length-k; x > 0; x--) {
			fila="";
			for (int y=0; y < dnaArray[x].length; y++) {
				  fila += ""+dnaArray[x][y];	  
			 }
	    resultados.add(fila);
	    k=k-1;
		}*/
	}
}
