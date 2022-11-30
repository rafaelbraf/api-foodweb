package com.foodweb.api.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "restaurantes")
public class Restaurante {
	
	// Variáveis
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpfCnpj;
	private String email;
	private String senha;
	private String telefone;
	private String endereco;
	
	@OneToMany(mappedBy = "id.restaurante")
	private Set<ProdutoDoRestaurante> produtosDoRestaurante = new HashSet<>();
	
	@OneToMany(mappedBy = "id.restaurante")
	private Set<PedidoDoRestaurante> pedidosDoRestaurante = new HashSet<>();
	
	// Construtores
	public Restaurante() {
	}

	public Restaurante(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public Restaurante(Long id, String nome, String cpfCnpj, String email, String senha, String telefone,
			String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	// Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@JsonIgnore
	public Set<ProdutoDoRestaurante> getProdutosDoRestaurante() {
		return produtosDoRestaurante;
	}
	
	@JsonIgnore
	public Set<PedidoDoRestaurante> getPedidosDoRestaurante() {
		return pedidosDoRestaurante;
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
		Restaurante other = (Restaurante) obj;
		return Objects.equals(id, other.id);
	}

}
