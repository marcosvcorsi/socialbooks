package com.algaworks.socialbooks.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.models.Comentario;
import com.algaworks.socialbooks.models.Livro;
import com.algaworks.socialbooks.repositories.ComentarioRepository;
import com.algaworks.socialbooks.repositories.LivroRepository;
import com.algaworks.socialbooks.services.exceptions.NotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	public Livro save(Livro livro) {
		return livroRepository.save(livro);
	}
	
	public List<Livro> findAll() {
		return livroRepository.findAll();
	}
	
	public Livro findById(Long id) {
		Optional<Livro> optional = livroRepository.findById(id);
		
		if(!optional.isPresent()) {
			throw new NotFoundException("O livro não pode ser encontrado");			
		}
		
		return optional.get();
	}
	
	public void delete(Long id) {
		try {
			livroRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("O livro não pode ser encontrado");
		}
	}
	
	public Livro update(Livro livro) {
		checkIfExists(livro);
		
		return livroRepository.save(livro);
	}
	
	private void checkIfExists(Livro livro) {
		findById(livro.getId());
	}
	
	public Comentario saveComentario(Long idLivro, Comentario comentario) {
		Livro livro = findById(idLivro);
		
		comentario.setData(LocalDateTime.now());
		comentario.setLivro(livro);
		
		return comentarioRepository.save(comentario);
	}
	
	public List<Comentario> listComentarios(Long idLivro) {
		Livro livro = findById(idLivro);
		
		return livro.getComentarios();
	}
}
