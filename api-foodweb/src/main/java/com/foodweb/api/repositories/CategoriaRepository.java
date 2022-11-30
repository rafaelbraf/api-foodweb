package com.foodweb.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.foodweb.api.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	@Query("select c from Categoria c where c.restaurante.id = :idRestaurante")
	List<Categoria> encontraCategoriasPorRestaurante(@Param("idRestaurante") Long idRestaurante);

}
