package com.test.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.test.api.model.Libro;


// Administramos las identidades de la clase Libro
@Repository	
public interface LibroRepository extends JpaRepository<Libro, Integer> {

}



