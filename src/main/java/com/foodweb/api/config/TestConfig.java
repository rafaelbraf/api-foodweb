package com.foodweb.api.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.foodweb.api.entities.Categoria;
import com.foodweb.api.entities.ItemDoPedido;
import com.foodweb.api.entities.Pagamento;
import com.foodweb.api.entities.Pedido;
import com.foodweb.api.entities.Produto;
import com.foodweb.api.entities.Restaurante;
import com.foodweb.api.entities.Cliente;
import com.foodweb.api.entities.enums.StatusPedido;
import com.foodweb.api.repositories.CategoriaRepository;
import com.foodweb.api.repositories.ItemDoPedidoRepository;
import com.foodweb.api.repositories.PedidoRepository;
import com.foodweb.api.repositories.ProdutoRepository;
import com.foodweb.api.repositories.ClienteRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private ClienteRepository usuarioRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired ItemDoPedidoRepository itemDoPedidoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoria1 = new Categoria(null, "Eletrônicos");
		Categoria categoria2 = new Categoria(null, "Livros");
		Categoria categoria3 = new Categoria(null, "Computadores");
		
		Restaurante restaurante1 = new Restaurante(null, "Pizzaria Top1", "00000000002", "pizzariatop@mail.com", "123456", "85988888888", "Rua 1 - Antônio Bezerra");
		Restaurante restaurante2 = new Restaurante(null, "Pizzaria Top2", "00000000002", "pizzariatop@mail.com", "123456", "85988888888", "Rua 1 - Antônio Bezerra");
		Restaurante restaurante3 = new Restaurante(null, "Pizzaria Top3", "00000000002", "pizzariatop@mail.com", "123456", "85988888888", "Rua 1 - Antônio Bezerra");
		
		Produto produto1 = new Produto(null, "Galaxy A22", "Smartphone Samsung Galaxy A22 6,5'", 1300.00, "http://img.com", restaurante1);
		Produto produto2 = new Produto(null, "Notebook Acer Nitro 5", "Notebook Acer Nitro 5 Windows 10 GTX 1650'", 5600.00, "http://img.com", restaurante1);
		Produto produto3 = new Produto(null, "Notebook Lenovo Ideapad 330", "Notebook Lenovo Ideapad 330 Windows 10 Vídeo Integrado", 2900.00, "http://img.com", restaurante2);
		Produto produto4 = new Produto(null, "Percy Jackson e os Olimpianos", "Livro Percy Jackson e os Olimpianos 220 páginas", 29.99, "http://img.com", restaurante3);
		Produto produto5 = new Produto(null, "Marvel: Guerra Civil", "Livro Marvel: Guerra Civil Capa Dura", 59.99, "http://img.com", restaurante1);
		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));
		
		produto1.getCategorias().add(categoria1);
		produto2.getCategorias().add(categoria3);
		produto3.getCategorias().add(categoria3);
		produto4.getCategorias().add(categoria2);
		produto5.getCategorias().add(categoria2);
		
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));
		
		Cliente usuario1 = new Cliente(null, "Rafael", "rafael@mail.com", "123456", "85984316990", "Rua Capitão Brasil, 171");
		Cliente usuario2 = new Cliente(null, "Cleo", "cleo@mail.com", "123456", "85984316990", "Rua Capitão Brasil, 171");
		
		Pedido pedido1 = new Pedido(null, Instant.parse("2022-10-10T21:53:10Z"), StatusPedido.APROVADO, usuario1);
		Pedido pedido2 = new Pedido(null, Instant.parse("2022-10-09T20:45:10Z"), StatusPedido.ENTREGUE, usuario2);
		Pedido pedido3 = new Pedido(null, Instant.parse("2022-10-09T21:45:10Z"), StatusPedido.FINALIZADO, usuario1);		
		
		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));		
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3));		
		
		ItemDoPedido itemDoPedido1 = new ItemDoPedido(pedido1, produto1, 2, produto1.getPreco());
		ItemDoPedido itemDoPedido2 = new ItemDoPedido(pedido1, produto3, 3, produto3.getPreco());
		ItemDoPedido itemDoPedido3 = new ItemDoPedido(pedido2, produto3, 1, produto3.getPreco());
		ItemDoPedido itemDoPedido4 = new ItemDoPedido(pedido3, produto5, 1, produto5.getPreco());
		
		itemDoPedidoRepository.saveAll(Arrays.asList(itemDoPedido1, itemDoPedido2, itemDoPedido3, itemDoPedido4));
		
		Pagamento pagamento1 = new Pagamento(null, Instant.parse("2022-10-10T23:53:10Z"), pedido1);
		pedido1.setPagamento(pagamento1);
		
		pedidoRepository.save(pedido1);
		
	}

}
