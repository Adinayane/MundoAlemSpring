package com.mundoAlem.enums;

public enum tipoDestino {
	Nacional("Nacional"), 
	Internacional("Internacional");
	
	private String tipo;
	
	tipoDestino(String tipo){
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
