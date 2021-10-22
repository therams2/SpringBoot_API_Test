package com.test.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.api.model.Reseña;
@Repository	
public interface  ReseñaRepository  extends JpaRepository<Reseña, Integer>{

}
