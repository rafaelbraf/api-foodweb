package com.foodweb.api.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.foodweb.api.entities.Cliente;
import com.foodweb.api.services.ClienteService;

@RestController
@RequestMapping(value = "/usuarios")
public class ClienteResource {
	
	@Autowired
	private ClienteService usuarioService;

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){		
		List<Cliente> listaDeClientes = usuarioService.findAll();		
		return ResponseEntity.ok().body(listaDeClientes);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Cliente usuario = usuarioService.findById(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente usuario) {
		usuario = usuarioService.insert(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(usuario);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		usuarioService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> updateById(@PathVariable Long id, @RequestBody Cliente usuario) {
		usuario = usuarioService.update(id, usuario);
		return ResponseEntity.ok().body(usuario);
	}
	
}
