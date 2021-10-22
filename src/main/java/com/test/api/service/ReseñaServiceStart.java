package com.test.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.api.model.Reseña;

import com.test.api.repository.ReseñaRepository;
@Service
public class ReseñaServiceStart implements ReseñaService {
	@Autowired
	private ReseñaRepository reseñaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Reseña> findAll() {
		// TODO Auto-generated method stub
		return reseñaRepository.findAll();
	}

}
