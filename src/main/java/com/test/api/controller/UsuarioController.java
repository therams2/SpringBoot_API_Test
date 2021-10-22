package com.test.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.test.api.model.Usuario;
import com.test.api.model.Usuario.BaseUser;
import com.test.api.service.UsuarioService;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	// Inyeccion de independencias
	@Autowired
	private UsuarioService usuarioService;

	// Registro de nuevo usuario
	@PostMapping("/signup")											// Con estas anotaciones se dispara el metodo perteneciente a los metodos  Post/Get/Put
	public ResponseEntity<?> create(@RequestBody Usuario usuario) { // La anotacion requestBody recupera el body del  request y lo instancia en un objeto de la clase Usuario
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		
		String hash=argon2.hash(1,	1024, 1, usuario.getPassword()); // iteracion, uso de memoria, paralelismo
		usuario.setPassword(hash);
		return ResponseEntity.status(HttpStatus.CREATED) 			// Codigo de estado 200
				.body(usuarioService.save(usuario)); 				// Acedemos a nuestro metodo save
	}
	
	//	 Verificamos si el usuario existe en la base de datos y si su contraseña es correcta
	@JsonView(BaseUser.class)
	@PostMapping("/signin")													
	public ResponseEntity<?> login(@RequestBody Usuario usuario) { 
		Usuario OpUsuario = usuarioService.findEmail(usuario.getEmail());
		if (OpUsuario == null) {
			return ResponseEntity.notFound().build().ok("No existe"); // 404
		}
		else {
			String passwordHashed = OpUsuario.getPassword();
			System.out.print(passwordHashed);
			Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
			boolean passwordSecure = argon2.verify(passwordHashed,usuario.getPassword());
			if(passwordSecure) {
				return ResponseEntity.ok("Usuario Logeado Correctamente");
				
			}else {
				return	ResponseEntity.ok("Las password no coinciden");
			}
		}
	}
	
	// Get a un usuario
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Integer id) {
		Optional<Usuario> OpUsuario = usuarioService.findById(id);
		if (!OpUsuario.isPresent()) {
			return ResponseEntity.notFound().build(); // 404
		}
		return ResponseEntity.ok(OpUsuario); // 200
	}
	
	// Editar un Usuario mediante su ID
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Usuario usuarioParametros, @PathVariable Integer id) {
		Optional<Usuario> OpUsuario = usuarioService.findById(id); 		// Buscamos el usuario
		if (!OpUsuario.isPresent()) { 									// Verificamos si existe
			return ResponseEntity.notFound().build(); 					// 404
		} else {
			// BeanUtils.copyProperties(usuarioParametros, OpUsuario.get());(Evita guardar
			// parametro por parametro)
			OpUsuario.get().setUsername(usuarioParametros.getUsername());
			OpUsuario.get().setEmail(usuarioParametros.getEmail());
			OpUsuario.get().setPassword(usuarioParametros.getPassword());
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(OpUsuario.get()));
		}
	}
	
	// 	Elimina a un usuario mediante su Id
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		if (!usuarioService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			usuarioService.deleteById(id);
			return new ResponseEntity<>("{\"status\" : \"Eliminado correctamente\"}", HttpStatus.OK);
		}
	}
}
