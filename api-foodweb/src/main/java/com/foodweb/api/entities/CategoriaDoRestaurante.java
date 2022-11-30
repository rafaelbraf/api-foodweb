package com.foodweb.api.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.foodweb.api.entities.pk.CategoriaDoRestaurantePK;

@Entity
@Table(name = "categorias_dos_restaurantes")
public class CategoriaDoRestaurante implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CategoriaDoRestaurantePK id = new CategoriaDoRestaurantePK();

	public CategoriaDoRestaurante() {
		
	}
	
	public Restaurante getRestaurante() {
		return id.getRestaurante();
	}
	
	public void setRestaurante(Restaurante restaurante) {
		id.setRestaurante(restaurante);
	}
	
	public Categoria getCategoria() {
		return id.getCategoria();
	}
	
	public void setCategoria(Categoria categoria) {
		id.setCategoria(categoria);
	}

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
		CategoriaDoRestaurante other = (CategoriaDoRestaurante) obj;
		return Objects.equals(id, other.id);
	}

}
