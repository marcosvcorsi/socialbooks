package com.algaworks.socialbooks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.socialbooks.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
