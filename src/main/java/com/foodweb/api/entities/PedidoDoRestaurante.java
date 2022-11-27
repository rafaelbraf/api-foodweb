package com.foodweb.api.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.foodweb.api.entities.pk.PedidoDoRestaurantePK;

@Entity
@Table(name = "pedidos_dos_restaurantes")
public class PedidoDoRestaurante implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PedidoDoRestaurantePK id = new PedidoDoRestaurantePK();

	public PedidoDoRestaurante() {
		
	}
	
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	public Restaurante getRestaurante() {
		return id.getRestaurante();
	}
	
	public void setRestaurante(Restaurante restaurante) {
		id.setRestaurante(restaurante);
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
		PedidoDoRestaurante other = (PedidoDoRestaurante) obj;
		return Objects.equals(id, other.id);
	}

}
