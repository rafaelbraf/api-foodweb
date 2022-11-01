package com.foodweb.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodweb.api.entities.Restaurante;
import com.foodweb.api.services.RestauranteService;

@RestController
@RequestMapping(value = "/login-restaurante")
public class LoginResource {
	
	@Autowired
	RestauranteService restauranteService;
	
	@PostMapping
	public ResponseEntity<Restaurante> loginRestaurante(@RequestBody Restaurante restaurante) {
		Restaurante restauranteEncontrado = restauranteService.encontraRestaurantePorEmailESenha(restaurante.getEmail(), restaurante.getSenha());
		return ResponseEntity.ok().body(restauranteEncontrado);
	}

}
