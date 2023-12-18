package com.mundoAlem.model;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.mundoAlem.enums.tipoDestino;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Destino {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDestino;
	
	@Column(nullable = false)
	private tipoDestino titulo;
	
	@Column(nullable = false)
	private String nomeDestino;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	@NumberFormat(style = Style.CURRENCY, pattern="#,##0.00")
	private BigDecimal valor;

	public Destino() {
		
	}
	
	public Destino(int idDestino, tipoDestino titulo, String nomeDestino, String descricao, BigDecimal valor) {
		super();
		this.idDestino = idDestino;
		this.titulo = titulo;
		this.nomeDestino = nomeDestino;
		this.descricao = descricao;
		this.valor = valor;
	}

	public int getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}

	public String getNomeDestino() {
		return nomeDestino;
	}

	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public tipoDestino getTitulo() {
		return titulo;
	}

	public void setTitulo(tipoDestino titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
