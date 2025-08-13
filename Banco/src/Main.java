import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int opcao;

        Scanner sc = new Scanner(System.in);
        ArrayList<Conta> listaContas = new ArrayList<>();

        do {
            System.out.println("\n----- Bem vindo ao Banco Digital! -----\nO que você pretende fazer hoje? \n 1 - Cadastrar nova conta \n 2 - Realizar depósito " +
                    "\n 3 - Realizar saque \n 4 - Realizar transferência \n 5 - Consultar saldo \n 6 - Mostrar contas cadastradas \n 7 - Sair do sistema \n\n Digite a opção desejada aqui: ");
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
                    System.out.println("Conta cadastrada com sucesso!");
                    break;

                case 2:
                    System.out.println("Digite o número da conta para depósito: ");
                    int contaDeposito = sc.nextInt();

                    for (Conta c : listaContas){
                        if(c.getNumeroConta() != contaDeposito) {
                            System.out.println("Não é possível realizar o depósito, pois o número da conta destino está incorreto ou não existe.");
                        } else {
                            System.out.println("Digite o valor que deseja depositar: ");
                            double valorDeposito = sc.nextDouble();

                            for (Conta c1 : listaContas){
                                if(c.getNumeroConta() == contaDeposito){
                                    c.depositar(valorDeposito);
                                    System.out.println("Depósito realizado com sucesso!");
                                }
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("Digite o número da conta para sacar: ");
                    int contaSaque = sc.nextInt();

                    for (Conta c : listaContas){
                        if(c.getNumeroConta() != contaSaque) {
                            System.out.println("Não é possível realizar o saque, pois o número da conta está incorreto ou não existe.");
                        } else {
                            System.out.println("Digite o valor que deseja sacar: ");
                            double valorSaque = sc.nextDouble();

                            for (Conta c1 : listaContas){
                                if(c.getNumeroConta() == contaSaque){
                                    if(c.getSaldoCorrente() >= valorSaque){
                                        c.sacar(valorSaque);
                                        System.out.println("Saque realizado com sucesso!");
                                    } else {
                                        System.out.println("Não é possível realizar o saque, pois não há saldo suficiente na conta.");
                                    }
                                }
                            }
                        }
                    }
                    break;

                case 4:

                case 5:
                    System.out.println("Mostra o sistema de consultar extrato");
                    break;

                case 6:
                    for (Conta c : listaContas){
                        c.mostrarInfos();
                        System.out.println("--------------------");
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