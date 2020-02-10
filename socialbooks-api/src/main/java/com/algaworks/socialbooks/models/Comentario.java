package com.algaworks.socialbooks.models;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comentario {

	private Long id;
	
	private String texto;
	
	private String usuario;
	
	private LocalDate data;
}
