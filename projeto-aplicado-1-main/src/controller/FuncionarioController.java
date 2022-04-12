package controller;

import dao.FuncionarioDao;
import model.Funcionario;

import java.util.List;

public class FuncionarioController {
	
	public void salvar(Funcionario funcionario) throws Exception {
		if (funcionario.getNome() == null || funcionario.getNome().length() < 3) {
			throw new Exception("Nome inválido!");
		}
		FuncionarioDao.getInstance().salvar(funcionario);
	}
	
	public void atualizar(Funcionario funcionario) throws Exception {
		if (funcionario.getNome() == null || funcionario.getNome().length() < 3) {
			throw new Exception("Nome inválido!");
		}
		FuncionarioDao.getInstance().atualizar(funcionario);
	}
	
	public void excluir(int idFuncionario) throws Exception {
		if (idFuncionario == 0) {
			throw new Exception("Nenhum funcionario selecionado.");
		}
		FuncionarioDao.getInstance().excluir(idFuncionario);
	}
	
	public List<Funcionario> listar(){
		return FuncionarioDao.getInstance().listar();
	}
}
