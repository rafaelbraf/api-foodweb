package com.foodweb.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.foodweb.api.entities.Produto;
import com.foodweb.api.entities.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

	@Query("select r from Restaurante r where r.email = :email and r.senha = :password")
	Optional<Restaurante> encontraRestaurantePorEmailESenha(@Param("email") String email, @Param("password") String password);
	
	@Query("select p from Produto p where p.restaurante.id = :restaurante_id")
	List<Produto> findProductsByRestaurante(@Param("restaurante_id") Long restauranteId);
	
}
