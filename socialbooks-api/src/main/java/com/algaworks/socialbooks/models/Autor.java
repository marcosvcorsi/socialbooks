package com.algaworks.socialbooks.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Campo nome não pode ser vazio!")
	private String nome;
	
	@NotNull(message = "Campo nascimento é obrigatório!")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate nascimento;
	
	private String nacionalidade;
	

	@OneToMany(mappedBy = "autor")
	@JsonIgnore
	private List<Livro> livros;
}
