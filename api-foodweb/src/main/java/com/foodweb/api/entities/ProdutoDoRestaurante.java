package com.foodweb.api.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.foodweb.api.entities.pk.ProdutoDoRestaurantePK;

@Entity
@Table(name = "produtos_do_restaurante")
public class ProdutoDoRestaurante implements Serializable {
	
	private static final long serialVersionUID = 1L;

	// Variáveis
	@EmbeddedId
	private ProdutoDoRestaurantePK id = new ProdutoDoRestaurantePK();
	
	// Construtores
	public ProdutoDoRestaurante() {
		
	}

	public ProdutoDoRestaurante(Produto produto, Restaurante restaurante) {
		super();
		id.setProduto(produto);
		id.setRestaurante(restaurante);
	}
	
	// Getters e Setters
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}
	
	public Restaurante getRestaurante() {
		return id.getRestaurante();
	}
	
	public void setUsuario(Restaurante restaurante) {
		id.setRestaurante(restaurante);
	}

	// Hash Code e Equals
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoDoRestaurante other = (ProdutoDoRestaurante) obj;
		return Objects.equals(id, other.id);
	}
	
}
