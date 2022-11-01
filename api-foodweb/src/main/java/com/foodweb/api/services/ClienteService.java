package com.foodweb.api.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.foodweb.api.entities.Cliente;
import com.foodweb.api.repositories.ClienteRepository;
import com.foodweb.api.services.exceptions.DataBaseException;
import com.foodweb.api.services.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository usuarioRepository;
	
	public List<Cliente> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> usuario = usuarioRepository.findById(id);
		return usuario.orElseThrow(() -> new ResourceNotFoundException(id, "Usuário não encontrado. ID: "));
	}
	
	public Cliente findByEmailAndPassword(String email, String password) {
		Optional<Cliente> usuario = usuarioRepository.findByEmailAndPassword(email, password);			
		return usuario.orElseThrow(() -> new ResourceNotFoundException(email, "E-mail não cadastrado: "));		
	}
	
	public Cliente insert(Cliente usuario) {
		try {
			return usuarioRepository.save(usuario);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("E-mail já cadastrado");
		}
	}
	
	public void deleteById(Long id) {
		try {
			usuarioRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id, "Usuário não encontrado para deletar. ID: ");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
		
	}
	
	public Cliente update(Long id, Cliente usuario) {
		try {
			Cliente entity = usuarioRepository.getReferenceById(id);
			atualizarDados(entity, usuario);
			return usuarioRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id, "Usuário não encontrado para ser atualizado. ID: ");
		}		
	}

	private void atualizarDados(Cliente entity, Cliente usuario) {
		entity.setNome(usuario.getNome());
		entity.setEmail(usuario.getEmail());
		entity.setTelefone(usuario.getTelefone());
		entity.setEndereco(usuario.getEndereco());
	}

}
