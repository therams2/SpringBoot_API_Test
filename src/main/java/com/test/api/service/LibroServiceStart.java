package com.test.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.api.model.Libro;
import com.test.api.repository.LibroRepository;

@Service
public class LibroServiceStart implements LibroService{

	@Autowired
	private LibroRepository libroRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Libro> findAll() {
		// TODO Auto-generated method stub
		return libroRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Libro> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return libroRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Libro> findById(Integer id) {
		// TODO Auto-generated method stub
		return libroRepository.findById(id);
	}
	@Transactional
	@Override
	public Libro save(Libro libro) {
		// TODO Auto-generated method stub
		return libroRepository.save(libro);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		libroRepository.deleteById(id);
	}

}
