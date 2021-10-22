package com.test.api.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.test.api.model.Reseña;
import com.test.api.model.Reseña.BaseReseña;
import com.test.api.service.ReseñaService;

@RestController
@RequestMapping("/api/reseñas")
public class ReseñaController {
	
	@Autowired
	private ReseñaService reseñaService;
	// Lista de libros sin paginacion 
	@JsonView(BaseReseña.class)
	@GetMapping
	public List<Reseña> readAll() {
		List<Reseña> reseñas = StreamSupport.stream(reseñaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return reseñas;
	};
}
