import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int opcao;
        Scanner sc = new Scanner(System.in);
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        do {
            System.out.println("\n---------------------------\nBem vindo ao Banco Digital! \nO que você pretende fazer hoje? \n 1 - Cadastrar cliente \n 2 - Realizar saque " +
                    "\n 3 - Realizar transferência \n 4 - Realizar depósito \n 5 - Consultar extrato \n 6 - Mostrar clientes cadastrados \n 7 - Sair do sistema \n\n Digite a opção desejada aqui: ");
            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Insira o nome do cliente: ");
                    String nomeCliente = sc.next();
                    System.out.println("Insira o CPF do cliente: ");
                    String cpf = sc.next();
                    System.out.println("Insira a data de nascimento do cliente: ");
                    String dataNascimento = sc.next();

                    listaClientes.add(new Cliente(nomeCliente, cpf, dataNascimento, Conta.SEQUENCIAL, Conta.AGENCIA_PADRAO));
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("Mostra o sistema de realizar saque");
                    break;

                case 3:
                    System.out.println("Mostra o sistema de realizar transferência");
                    break;

                case 4:
                    System.out.println("Mostra o sistema de realizar depósito");

                case 5:
                    System.out.println("Mostra o sistema de consultar extrato");
                    break;

                case 6:

                    for (Cliente cliente : listaClientes){

                        System.out.println("Cliente: " + cliente.getNome() + " | "+ cliente.getCpf() + " | "+  cliente.getDataNascimento() + "\n" + "Agência: " + cliente.getAgencia() + " | " + "Conta: " +  + cliente.getNumero() + "\n");
                    }
                    break;

                case 7:
                    System.out.println("Agradecemos por confiar em nosso sistema! \nVolte sempre!");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao !=5);
        sc.close();
    }
}