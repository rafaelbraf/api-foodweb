package com.foodweb.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.foodweb.api.entities.Produto;
import com.foodweb.api.repositories.ProdutoRepository;
import com.foodweb.api.services.exceptions.DataBaseException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.get();
	}
	
	public Produto insert(Produto produto) {
		try {
			return produtoRepository.save(produto);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}		
	}

}