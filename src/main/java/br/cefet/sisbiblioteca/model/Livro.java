package br.cefet.sisbiblioteca.model;

import java.util.Date;

public class Livro {
	private int id;
	private String titulo;
	private String autor;
	private Float valor;
	private Genero genero;
	private Date dataDePublicacao ;
	private int quantidadeEstoque;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Date getDataDePublicacao() {
		return dataDePublicacao;
	}
	public void setDataDePublicacao(Date dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
   
	public Float aplicarDesconto() {
        if (valor != null) {
            Float desconto = valor * 0.1f;
            return valor - desconto;
        } else {
            return null; 
        }
    }
}
