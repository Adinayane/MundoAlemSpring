package com.mundoAlem.enums;

public enum formaPagamento {
	Boleto(1, "Boleto"),
	Debito(2, "Débito"),
	Credito(3,"Crédito"),
	Pix(4,"pix");
	
	private int codigo;
	private String descricao;
	
	formaPagamento( int codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
