package com.foodweb.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodweb.api.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	

}
