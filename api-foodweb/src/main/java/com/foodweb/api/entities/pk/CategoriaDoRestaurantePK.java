package com.foodweb.api.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.foodweb.api.entities.Categoria;
import com.foodweb.api.entities.Restaurante;

public class CategoriaDoRestaurantePK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "restaurante_id")
	private Restaurante restaurante;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, restaurante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaDoRestaurantePK other = (CategoriaDoRestaurantePK) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(restaurante, other.restaurante);
	}

}
