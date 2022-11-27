package com.foodweb.api.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.foodweb.api.entities.Pedido;
import com.foodweb.api.entities.Restaurante;

public class PedidoDoRestaurantePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "restaurante_id")
	private Restaurante restaurante;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pedido, restaurante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoDoRestaurantePK other = (PedidoDoRestaurantePK) obj;
		return Objects.equals(pedido, other.pedido) && Objects.equals(restaurante, other.restaurante);
	}

}
