package com.foodweb.api.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.foodweb.api.entities.Produto;
import com.foodweb.api.entities.Restaurante;
import com.foodweb.api.services.RestauranteService;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteResource {

	@Autowired
	private RestauranteService restauranteService;
	
	@GetMapping
	public ResponseEntity<List<Restaurante>> findAll() {
		List<Restaurante> listaDeRestaurantes = restauranteService.findAll();
		return ResponseEntity.ok().body(listaDeRestaurantes);
	}
	
	@GetMapping(value = "/{idrestaurante}")
	public ResponseEntity<Restaurante> encontraRestaurantePorId(@PathVariable("idrestaurante") Long idRestaurante) {
		Restaurante restaurante = restauranteService.encontraRestaurantePorId(idRestaurante);
		return ResponseEntity.ok().body(restaurante);
	}
	
	@GetMapping(value = "/{idrestaurante}/produtos")
	public ResponseEntity<List<Produto>> encontraProdutosDoRestaurante(@PathVariable("idrestaurante") Long restauranteId) {
		List<Produto> listaDeProdutosDoRestaurante = restauranteService.encontraProdutosPorRestaurante(restauranteId);
		return ResponseEntity.ok().body(listaDeProdutosDoRestaurante);
	}
	
	@PostMapping
	public ResponseEntity<Restaurante> insert(@RequestBody Restaurante restaurante) {
		restaurante = restauranteService.inserir(restaurante);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(restaurante.getId()).toUri();
		return ResponseEntity.created(uri).body(restaurante);
	}
	
}
