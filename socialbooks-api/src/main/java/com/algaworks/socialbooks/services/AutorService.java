package com.algaworks.socialbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.models.Autor;
import com.algaworks.socialbooks.repositories.AutorRepository;
import com.algaworks.socialbooks.services.exceptions.NotFoundException;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;
	
	public Autor save(Autor autor) {
		return autorRepository.save(autor);
	}
	
	public Autor get(Long id) {
		Optional<Autor> op = autorRepository.findById(id);
		
		if(!op.isPresent()) {
			throw new NotFoundException("Autor não encontrado");
		}
				
		return op.get();
	}
	
	public List<Autor> findAll() {
		return autorRepository.findAll();
	}
}
