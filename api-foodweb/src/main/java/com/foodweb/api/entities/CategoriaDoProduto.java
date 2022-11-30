package com.foodweb.api.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.foodweb.api.entities.pk.CategoriaDoProdutoPK;

@Entity
@Table(name = "categorias_dos_produtos")
public class CategoriaDoProduto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CategoriaDoProdutoPK id = new CategoriaDoProdutoPK();

	public CategoriaDoProduto() {
		
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
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
		CategoriaDoProduto other = (CategoriaDoProduto) obj;
		return Objects.equals(id, other.id);
	}

}
