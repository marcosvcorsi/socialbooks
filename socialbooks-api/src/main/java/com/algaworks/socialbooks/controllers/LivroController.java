package com.algaworks.socialbooks.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.socialbooks.models.Livro;

@RestController
@RequestMapping("/livros")
public class LivroController {

	
	@GetMapping
	public List<Livro> list() {
		List<Livro> livroList = new ArrayList<Livro>();
		
		livroList.add(new Livro("Teste 1"));
		livroList.add(new Livro("Teste 2"));
		
		return livroList;
	}
}
