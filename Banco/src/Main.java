import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int opcao;

        Scanner sc = new Scanner(System.in);
        ArrayList<Conta> listaContas = new ArrayList<>();

        do {
            System.out.println("\n----- Bem vindo ao Banco Digital! -----\nO que você pretende fazer hoje? \n 1 - Cadastrar cliente \n 2 - Realizar saque " +
                    "\n 3 - Realizar transferência \n 4 - Realizar depósito \n 5 - Consultar saldo \n 6 - Mostrar clientes cadastrados \n 7 - Sair do sistema \n\n Digite a opção desejada aqui: ");
            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Insira o nome do cliente: ");
                    String nomeCliente = sc.next();
                    System.out.println("Insira o CPF do cliente: ");
                    String cpf = sc.next();
                    System.out.println("Insira a data de nascimento do cliente: ");
                    String dataNascimento = sc.next();

                    Cliente novoCliente = new Cliente(nomeCliente, cpf, dataNascimento);
                    Conta novaConta = new ContaCorrente(novoCliente);

                    listaContas.add(novaConta);
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