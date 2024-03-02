package boundary;

import java.util.List;
import java.util.Scanner;
import controller.ClienteController;
import model.Cliente;

public class Main {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String nomeCliente;
		Cliente c1 = new Cliente();
		ClienteController cControl = new ClienteController();
		int escolha;

		do {
			System.out.println("Menu:");
			System.out.println("1. Inserir Cliente");
			System.out.println("2. Pequisar um Cliente");
			System.out.println("3. Pesquisar Todos");
			System.out.println("4. Remover um Cliente");
			System.out.println("5. Sair");

			System.out.print("Escolha uma opcao: ");
			escolha = scanner.nextInt();

			switch (escolha) {
			case 1:
				System.out.println("Inserir Cliente");
				c1.setId(0);
				c1.setNome("Luigi");
				c1.setEndereco("Av. Paulista");
				c1.setTelefone("(11)99999-9999");
				cControl.inserirCliente(c1);		
				break;
				
			case 2:
				
				System.out.println("Pesquisar um cliente = ");
				nomeCliente = scanner.next();
				List<Cliente> clientes = cControl.pesquisarUmCliente(nomeCliente);	
				if (!(clientes.isEmpty())) {
					for (Cliente cliente : clientes ) {
						System.out.println("Nome: " + cliente.getNome() +
								" Id: " + cliente.getId() + 
								" Endereco: " + cliente.getEndereco() + 
								" Telefone: " + cliente.getTelefone());
					}
				}
				else System.out.println("Cliente n„o encontrado!");
				scanner.nextLine();
				break;
				
			case 3:
				
				System.out.println("Listando Todos os Clientes");
				clientes = cControl.pesquisarTodos();	
				if (!(clientes.isEmpty())) {
					for (Cliente cliente : clientes ) {
						System.out.println("Nome: " + cliente.getNome() + ", Endereco: " + cliente.getEndereco() + ", Telefone: " + cliente.getTelefone());
					}
				}
				else System.out.println("N„o h· clientes cadastrados!");
				break;
				
			case 4:
				System.out.println("Escolha um cliente para apagar ");
				long id = scanner.nextLong();
				cControl.apagar(id);
				break;
				
			case 5:
				System.out.println("Saindo do menu.");
				break;
			default:
				System.out.println("Op√ß√£o inv√°lida. Tente novamente.");
			}
		} while (escolha != 5);

		scanner.close();
	}
}
