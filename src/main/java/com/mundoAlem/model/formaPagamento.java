package com.mundoAlem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class formaPagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idForma;
	
	@Column(nullable = false)
	private String descricao;
	
	public formaPagamento() {
		
	}

	public formaPagamento(int idForma, String descricao) {
		super();
		this.idForma = idForma;
		this.descricao = descricao;
	}

	public int getIdForma() {
		return idForma;
	}

	public void setIdForma(int idForma) {
		this.idForma = idForma;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
