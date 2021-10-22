package com.test.api.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.test.api.model.Libro;
import com.test.api.model.Libro.SingleLibro;
import com.test.api.service.LibroService;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

	// Instanciamos los metodos de la clase libroService
	@Autowired
	private LibroService libroService;

	// Metodo para la creacion de nuevo libro
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Libro libro) {
		return ResponseEntity.status(HttpStatus 				// Codigo de estado 200
				.CREATED).body(libroService.save(libro)); 		// Acedemos a nuestro metodo save
	}

	// Detalles del Libro
	@JsonView(SingleLibro.class)
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Integer id) {
		Optional<Libro> OpLibro = libroService.findById(id);
		if (!OpLibro.isPresent()) {
			return ResponseEntity.notFound().build(); 	// 404
		}
		return ResponseEntity.ok(OpLibro); 				// 200
	}

	// Lista de libros sin paginacion 
	@GetMapping
	@JsonView(Libro.BaseLibro.class)
	public List<Libro> readAll() {
		List<Libro> libros = StreamSupport.stream(libroService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		// Metodos de ordenamiento
		libros.sort((o1, o2) -> o1.getTitulo().compareTo(o2.getTitulo())); 							// ABC
		libros.sort((o1, o2) -> o1.getFecha_publicacion().compareTo(o2.getFecha_publicacion())); 	// n>m
		Collections.reverse(libros);
		return libros;
	};

	// Obtener todo con Paginacion pero sin el orden alfabetico
	@GetMapping("/page/{id}")
	@JsonView(Libro.BaseLibro.class)
	public ResponseEntity<?> readAllPage(@PathVariable Integer id) {
		// Recuperamos la identidades tipo Libro utilizando paginacion
		Page<Libro> page = libroService.findAll(PageRequest.of(id, 5));
		for (Libro i : page.getContent()) {
			System.out.println(i.getTitulo());
		}
		return ResponseEntity.ok(page.getContent());
	};

	
	
	// Modificar por Id
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Libro libroParametros, @PathVariable Integer id) {
		Optional<Libro> OpLibro = libroService.findById(id); // Buscamos el usuario
		if (!OpLibro.isPresent()) { // Verificamos si existe
			return ResponseEntity.notFound().build(); // 404
		} else {
			// BeanUtils.copyProperties(usuarioParametros, OpUsuario.get());(Evita guardar
			// parametro por parametro)
			OpLibro.get().setTitulo(libroParametros.getTitulo());
			OpLibro.get().setPortada(libroParametros.getPortada());
			OpLibro.get().setSinopsis(libroParametros.getSinopsis());
			OpLibro.get().setFecha_publicacion(libroParametros.getFecha_publicacion());
			OpLibro.get().setTitulo(libroParametros.getTitulo());
			return ResponseEntity.status(HttpStatus.CREATED).body(libroService.save(OpLibro.get()));
		}
	}
	
	// Metodo para eliminar un libro mediante su Id
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		if (!libroService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			libroService.deleteById(id);
			return new ResponseEntity<>("{\"status\" : \"Eliminado correctamente\"}", HttpStatus.OK);
		}
	}
}
