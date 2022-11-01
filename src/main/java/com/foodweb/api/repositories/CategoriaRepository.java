package com.foodweb.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodweb.api.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	

}
