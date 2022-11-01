package com.foodweb.api.entities.enums;

public enum StatusPedido {
	
	AGUARDANDO_APROVACAO(1),
	APROVADO(2),
	EM_PREPARACAO(3),
	AGUARDANDO_ENTREGADOR(4),
	EM_ROTA_DE_ENTREGA(5),
	ENTREGUE(6),
	FINALIZADO(7);
	
	private int code;
	
	private StatusPedido(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static StatusPedido valueOf(int code) {
		for(StatusPedido value : StatusPedido.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de Status Pedido inválido");
	}

}
