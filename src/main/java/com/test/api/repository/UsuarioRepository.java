package com.test.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.api.model.Usuario;

// La Clase JpaRepository ya nos Devuelve Todos lo Metodos Necesarios de un Crud
@Repository		
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{	// CurdRepository no permite paginacion del lado del servidor
	Usuario findByEmail(String email);
}
