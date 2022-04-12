import controller.FuncionarioController;
import model.Funcionario;

public class Principal {

	public static void main(String[] args) {
		
		Funcionario f1 = new Funcionario(0, null, null, null, null, null);
		f1.setIdFuncionario(1);
		f1.setNome("JOSÉ DUARTE");
		f1.setHabilitacao("B");
		
		Funcionario f2 = new Funcionario(0, null, null, null, null, null);
		f2.setIdFuncionario(2);
		f2.setNome("LUIS FERNANDO");
		f2.setHabilitacao(null);
		
		FuncionarioController controller = new FuncionarioController();
		try {
		controller.salvar(f1);
		controller.salvar(f2);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Funcionario f : controller.listar()) {
			System.out.println(f.toString());
		}
	}
	
}
