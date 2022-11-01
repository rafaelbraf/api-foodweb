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
import com.foodweb.api.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> listaDecategorias = produtoService.findAll();		
		return ResponseEntity.ok().body(listaDecategorias);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		Produto produto = produtoService.findById(id);
		return ResponseEntity.ok().body(produto);
	}
	
	@PostMapping
	public ResponseEntity<Produto> insert(@RequestBody Produto produto) {
		produto = produtoService.insert(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(produto);
	}
	
}
