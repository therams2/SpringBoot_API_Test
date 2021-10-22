package com.test.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.api.model.Comentario;
import com.test.api.repository.ComentarioRepository;

@Service
public class ComentarioServiceStart implements ComentarioService {

	@Autowired
	private ComentarioRepository comentarioRepository;
	
	public Comentario save(Comentario comentario) {
		return comentarioRepository.save(comentario);
	}
}
