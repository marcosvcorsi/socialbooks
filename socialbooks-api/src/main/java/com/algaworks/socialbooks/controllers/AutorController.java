package com.algaworks.socialbooks.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.socialbooks.models.Autor;
import com.algaworks.socialbooks.services.AutorService;

@RestController
@RequestMapping("autores")
public class AutorController {

	@Autowired
	private AutorService autorService;
	
	@GetMapping(produces = {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE,
	})
	public ResponseEntity<List<Autor>> list() {
		return ResponseEntity.ok(autorService.findAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Autor> get(@PathVariable Long id) {
		Autor autor = autorService.get(id);
		
		return ResponseEntity.ok(autor);
	}
	
	@PostMapping
	public ResponseEntity<Autor> save(@Valid @RequestBody Autor autor) {
		autor = autorService.save(autor);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(autor.getId()).toUri();
		
		return ResponseEntity.created(uri).body(autor);
	}
}
