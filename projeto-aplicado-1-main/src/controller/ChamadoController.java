package controller;

import java.util.List;

import dao.ChamadoDao;
import model.Chamado;

public class ChamadoController {
	
	public void salvar(Chamado chamado) throws Exception {
		if (chamado.getDistancia()==0) {
			throw new Exception("Distância inválida!");
		}
		if (chamado.getFuncionario()==null) {
			throw new Exception("Funcionário inválido!");
		}
		if (chamado.getVeiculo()==null) {
			throw new Exception("Veículo inválido!");
		}
		ChamadoDao.getInstance().salvar(chamado);
	}
	
	public void atualizar(Chamado chamado) throws Exception {
		if (chamado.getDistancia()==0) {
			throw new Exception("Distância inválida!");
		}
		if (chamado.getFuncionario()==null) {
			throw new Exception("Funcionário inválido!");
		}
		if (chamado.getVeiculo()==null) {
			throw new Exception("Veículo inválido!");
		}
		ChamadoDao.getInstance().atualizar(chamado);
	}
	
	public void excluir(int idChamado) throws Exception {
		if(idChamado == 0) {
			throw new Exception("Nenhum chamado selecionado.");
		}
	}
	
	public List<Chamado> listar(){
		return ChamadoDao.getInstance().listar();
	}
}
