package com.test.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.api.model.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer>{
	

}
