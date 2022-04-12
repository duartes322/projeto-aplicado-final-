package model;

import java.io.Serializable;
import java.util.Date;

public class Chamado implements Serializable{
	private int idChamado;
	private Date data;
	private String endereco;
	private float distancia;
	private Veiculo veiculo;
	private Funcionario funcionario;
	
	public Chamado(int idChamado, Date data, String endereco, float distancia, Veiculo veiculo,
			Funcionario funcionario) {
		this.idChamado = idChamado;
		this.data = data;
		this.endereco = endereco;
		this.distancia = distancia;
		this.veiculo = veiculo;
		this.funcionario = funcionario;
	}
	
	public double calcularCarbono() {
		return (veiculo.getConsumo() * this.distancia * 0.82 * 0.75 * 3.7);
	}
	
	public int getIdChamado() {
		return idChamado;
	}
	public void setIdChamado(int idChamado) {
		this.idChamado = idChamado;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public float getDistancia() {
		return distancia;
	}
	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
}
