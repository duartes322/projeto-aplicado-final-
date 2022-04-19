package model;

import java.io.Serializable;

public class Veiculo implements Serializable {
	private int idVeiculo;
	private String placa;
	private String modelo;
	private int km;
	private float consumo;
	
	public Veiculo(int idveiculo, String placa, String modelo, int km, float consumo) {
		super();
		this.idVeiculo = idveiculo;
		this.placa = placa;
		this.modelo = modelo;
		this.km = km;
		this.consumo = consumo;
	}
	public int getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(int idveiculo) {
		this.idVeiculo = idveiculo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public float getConsumo() {
		return consumo;
	}
	public void setConsumo(float consumo) {
		this.consumo = consumo;
	}
	
	
}
