package com.test.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.api.model.Usuario;
import com.test.api.repository.UsuarioRepository;

@Service
public class UsuarioServiceStart implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(Integer id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id);
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(usuario);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario  findEmail(String email) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByEmail(email);
	}

}



