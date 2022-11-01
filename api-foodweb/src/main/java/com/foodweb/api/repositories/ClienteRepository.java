package com.foodweb.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.foodweb.api.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	@Query("select c from Cliente c where c.email = :email and c.senha = :password")
	Optional<Cliente> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}
