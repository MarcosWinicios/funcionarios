package teste;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;

import com.hepta.funcionarios.rest.FuncionarioService;



public class Teste {
	@Inject
	private static FuncionarioService service = new FuncionarioService();
	
	private static Response response;

	public static void main(String[] args) throws Exception {
		
		Funcionario fun = new Funcionario("Bill Gates", new Setor(1, "Desenvolvimento"), 2000.00, "billgates@gmail.com", 22);
		
		response =  service.funcionarioRead();
		System.out.println(response.getEntity());
		System.out.println(response);
	}
	
	public static void deletarFuncionario(Integer id) throws Exception {
		
		response = service.funcionarioDelete(id);
		System.out.println(response);
	}
	
	public static void atualizarFuncionario(Integer id, Funcionario funcionarios) throws Exception {
		response = service.funcionarioUpdate(id, funcionarios);
		System.out.println(response);
	}
	

	public static void inserirFuncionario(Funcionario funcionario) throws Exception {
		response = service.funcionarioCreate(funcionario);
		System.out.println(response);
	}
	
	@SuppressWarnings("unchecked")
	public static void listaFuncionarios() {
		List<Funcionario> funcionarios = new ArrayList<>();
		funcionarios = (List<Funcionario>) service.funcionarioRead();
		printarArray(funcionarios);
	}
	
	
	public static void printarArray(List<Funcionario> list) {
		System.out.println("-----------------------");
		System.out.println("\nLISTA DE FUNCIONARIOS");
		list.forEach(funcionario -> {
			System.out.println("\n");
			System.out.println(funcionario.toString());
		});
		System.out.println("-----------------------");

	}
}
