package com.test.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.test.api.model.Usuario;

public interface UsuarioService {
	//Metodos de un crud
	public Iterable<Usuario> findAll();
	public Page<Usuario>findAll(Pageable pageable);
	public Optional<Usuario> findById(Integer id);
	public Usuario findEmail(String email);
	public Usuario save(Usuario usuario);
	public void deleteById(Integer id);
}
