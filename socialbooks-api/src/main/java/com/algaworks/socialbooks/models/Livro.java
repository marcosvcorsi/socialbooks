package com.algaworks.socialbooks.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private LocalDate publicacao;
	
	private String editora;
	
	private String resumo;
	
	@OneToMany(mappedBy = "livro")
	private List<Comentario> comentarios;
	
	private String autor;
	
	public Livro() {}
	
	public Livro(String nome) {
		this.nome = nome;
	}
}
