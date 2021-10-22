package com.test.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.api.model.Comentario;
import com.test.api.model.AuxComentario;
import com.test.api.model.Reseña;
import com.test.api.model.Usuario;
import com.test.api.service.ComentarioService;

@RestController
@RequestMapping("/api/comentarios")
public class ComentariosController {

	@Autowired
	private ComentarioService comentarioService;

	// Unico metodo para crear un nuevo comentario
	@PostMapping
	public ResponseEntity<?> create(@RequestBody AuxComentario comentario) {

		Usuario usuario = new Usuario();
		usuario.setId(comentario.getUsuario_id());
		Reseña reseña = new Reseña();
		reseña.setId(comentario.getReseña_id());
		Comentario comentarioObj = new Comentario();
		comentarioObj.setUsuario(usuario);
		comentarioObj.setReseña(reseña);
		comentarioObj.setComentario(comentario.getComentario());
		return ResponseEntity.status(HttpStatus.CREATED).body(comentarioService.save(comentarioObj));
	}
	
	

}
