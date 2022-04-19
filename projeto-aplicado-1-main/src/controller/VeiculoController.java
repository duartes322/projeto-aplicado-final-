package controller;

import model.Veiculo;
import dao.VeiculoDao;

import java.util.List;

public class VeiculoController {
	
	public void salvar(Veiculo veiculo) throws Exception{
		if(veiculo.getPlaca()==null || veiculo.getPlaca().length() < 7) {
			throw new Exception("Placa inválida!");
		}
		VeiculoDao.getInstance().salvar(veiculo);
	}
	
	public void atualizar(Veiculo veiculo) throws Exception{
		if(veiculo.getPlaca()==null || veiculo.getPlaca().length() < 7) {
			throw new Exception("Placa inválida!");
		}
		VeiculoDao.getInstance().atualizar(veiculo);	
	}
	
	public void excluir(int idVeiculo) throws Exception {
		if(idVeiculo == 0) {
			throw new Exception("Nenhum veículo selecionado.");
		}
		VeiculoDao.getInstance().excluir(idVeiculo);
	} 
	
	public List<Veiculo> listar(){
		return VeiculoDao.getInstance().listar();
	}
}
