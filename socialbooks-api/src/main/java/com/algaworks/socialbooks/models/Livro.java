package com.algaworks.socialbooks.models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class Livro {

	private Long id;
	
	private String nome;
	
	private LocalDate publicacao;
	
	private String editora;
	
	private String resumo;
	
	private List<Comentario> cometarios;
	
	private String autor;
	
	public Livro() {}
	
	public Livro(String nome) {
		this.nome = nome;
	}
}
