package com.test.api.service;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.test.api.model.Libro;


public interface LibroService {
	
	//Metodos necesarios para buscar en la bd o hacer operaciones
	
	public Iterable<Libro> findAll();
	
	public Page<Libro>findAll(Pageable pageable);
	
	public Optional<Libro> findById(Integer id);
	
	public Libro save(Libro libro);
	
	public void deleteById(Integer id);
	
}
