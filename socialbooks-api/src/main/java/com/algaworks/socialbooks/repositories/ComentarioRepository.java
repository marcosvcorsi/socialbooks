package com.algaworks.socialbooks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.socialbooks.models.Comentario;
import com.algaworks.socialbooks.models.Livro;

public interface ComentarioRepository extends JpaRepository<Comentario, Long>{


}
