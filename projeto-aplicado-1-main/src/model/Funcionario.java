package model;

import java.io.Serializable;
import java.util.Date;

public class Funcionario implements Serializable {
	
	private int idFuncionario;
	private String nome;
	private Date aniversario;
	private Date ingresso;
	private String endereco;
	private String habilitacao;
	
	public Funcionario(int idfuncionario, String nome, Date aniversario, Date ingresso, String endereco,
			String habilitacao) {
		this.idFuncionario = idfuncionario;
		this.nome = nome;
		this.aniversario = aniversario;
		this.ingresso = ingresso;
		this.endereco = endereco;
		this.habilitacao = habilitacao;
	}
	
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idfuncionario) {
		this.idFuncionario = idfuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getAniversario() {
		return aniversario;
	}
	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}
	public Date getIngresso() {
		return ingresso;
	}
	public void setIngresso(Date ingresso) {
		this.ingresso = ingresso;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getHabilitacao() {
		return habilitacao;
	}
	public void setHabilitacao(String habilitacao) {
		this.habilitacao = habilitacao;
	}
	
	public String toString() {
		return nome + " - " + habilitacao;
	}
	
	
}
