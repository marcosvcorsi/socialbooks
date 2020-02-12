package com.algaworks.socialbooks.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.socialbooks.models.Comentario;
import com.algaworks.socialbooks.models.Livro;
import com.algaworks.socialbooks.services.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroService livroService;
	
	@GetMapping
	public ResponseEntity<List<Livro>> list() {
		List<Livro> livroList = livroService.findAll();
		
		return ResponseEntity.ok(livroList);
	}
	
	@PostMapping
	public ResponseEntity<Livro> save(@RequestBody Livro livro) {
		livro = livroService.save(livro);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(livro.getId()).toUri();
		
		return ResponseEntity.created(uri).body(livro);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Livro> get(@PathVariable Long id) {
		Livro livro =  livroService.findById(id);
		
		return ResponseEntity.ok(livro);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		livroService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro livro) {
		livro.setId(id);
			
		livro = livroService.update(livro);
		
		return ResponseEntity.ok(livro);
	}
	
	@PostMapping("{id}/comentarios")
	public ResponseEntity<Comentario> addComment(@PathVariable("id") Long livroId, @RequestBody Comentario comentario) {
		comentario = livroService.saveComentario(livroId, comentario);
	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		
		return ResponseEntity.created(uri).body(comentario);
	}
	
	@GetMapping("{id}/comentarios")
	public ResponseEntity<List<Comentario>> listComments(@PathVariable("id") Long livroId) {
		List<Comentario> comentarioList = livroService.listComentarios(livroId);
		
		return ResponseEntity.ok(comentarioList);
	}
}