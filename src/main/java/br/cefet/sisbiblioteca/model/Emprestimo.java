package br.cefet.sisbiblioteca.model;

import java.util.Date;

public class Emprestimo {
	private int id;
	private Bibliotecario bibliotecario;
	private Usuario user;
	private Livro livro;
	private Date dataDeRetorno;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Bibliotecario getBibliotecario() {
		return bibliotecario;
	}
	public void setBibliotecario(Bibliotecario bibliotecario) {
		this.bibliotecario = bibliotecario;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Date getDataDeRetorno() {
		return dataDeRetorno;
	}
	public void setDataDeRetorno(Date dataDeRetorno) {
		this.dataDeRetorno = dataDeRetorno;
	}

}
