package br.cefet.sisbiblioteca.model;

import java.util.Date;

public class Relatorio {
	private int id;
	private Bibliotecario bibliotecario;
	private Emprestimo emprestimo;
	
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}
	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	private	Date dataGerado;
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
	public Date getDataGerado() {
		return dataGerado;
	}
	public void setDataGerado(Date dataGerado) {
		this.dataGerado = dataGerado;
	}

}
