package com.foodweb.api.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.foodweb.api.entities.Produto;
import com.foodweb.api.entities.Restaurante;
import com.foodweb.api.entities.Cliente;

public class ProdutoDoRestaurantePK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// Variáveis
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "restaurante_id")
	private Restaurante restaurante;

	// Getters e Setters
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	// Hash Code e Equals
	@Override
	public int hashCode() {
		return Objects.hash(produto, restaurante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoDoRestaurantePK other = (ProdutoDoRestaurantePK) obj;
		return Objects.equals(produto, other.produto) && Objects.equals(restaurante, other.restaurante);
	}

}
