package com.foodweb.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.foodweb.api.entities.Produto;
import com.foodweb.api.entities.Restaurante;
import com.foodweb.api.repositories.RestauranteRepository;
import com.foodweb.api.services.exceptions.DataBaseException;
import com.foodweb.api.services.exceptions.ResourceNotFoundException;

@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	public List<Restaurante> findAll() {
		return restauranteRepository.findAll();
	}
	
	public Restaurante encontraRestaurantePorEmailESenha(String email, String password) {
		Optional<Restaurante> restaurante = restauranteRepository.encontraRestaurantePorEmailESenha(email, password);
		return restaurante.orElseThrow(() -> new ResourceNotFoundException(email, "E-mail não cadastrado: "));
	}
	
	public Restaurante insert(Restaurante restaurante) {
		try {
			return restauranteRepository.save(restaurante);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("E-mail já cadastrado.");
		}
	}
	
	public List<Produto> findProductsByRestaurante(Long idRestaurante) {
		return restauranteRepository.findProductsByRestaurante(idRestaurante);
	}

}
