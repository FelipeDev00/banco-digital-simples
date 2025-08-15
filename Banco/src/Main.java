import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int opcao;

        Scanner sc = new Scanner(System.in);
        ArrayList<Conta> listaContas = new ArrayList<>();

        do {
            System.out.println("\n----- Bem vindo ao Banco Digital! -----\nO que você pretende fazer hoje? \n 1 - Cadastrar nova conta \n 2 - Realizar depósito " +
                    "\n 3 - Realizar saque \n 4 - Realizar transferência \n 5 - Consultar informações da conta \n 6 - Sair do sistema \n\n Digite a opção desejada aqui: ");
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

                    //Realiza a leitura das contas e verifica se o número da conta digitada pelo usuário está correto.
                    for (Conta c : listaContas){
                        if(c.getNumeroConta() != contaDeposito) {
                            System.out.println("Não é possível realizar o depósito, pois o número da conta está incorreto ou não existe.");
                        }
                        else {
                            System.out.println("Digite o valor que deseja depositar: ");
                            double valorDeposito = sc.nextDouble();

                            //Verifica se o usuário digitou um número válido.
                            if(valorDeposito <= 0){
                                System.out.println("Por favor, digite um número válido.");
                            } else {
                                c.depositar(valorDeposito);
                                System.out.println("Depósito realizado com sucesso!");
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("Digite o número da conta para sacar: ");
                    int contaSaque = sc.nextInt();

                    //Realiza a leitura das contas e verifica se o número da conta digitada pelo usuário está correto.
                    for (Conta c : listaContas){
                        if(c.getNumeroConta() != contaSaque) {
                            System.out.println("Não é possível realizar o saque, pois o número da conta está incorreto ou não existe.");
                        }
                        else {
                            System.out.println("Digite o valor que deseja sacar: ");
                            double valorSaque = sc.nextDouble();

                            //Verifica se o saldo da conta é maior que o valor do saque.
                            if(c.getSaldoCorrente() < valorSaque){
                                System.out.println("Não é possível realizar o saque, pois não há saldo suficiente na conta.");
                            } else {
                                c.sacar(valorSaque);
                                System.out.println("Saque realizado com sucesso!");
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("Digite o número da sua conta: ");
                    int numeroContaOrigem = sc.nextInt();

                    System.out.println("Digite o número da conta que deseja realizar a tansferência: ");
                    int numeroContaDestino = sc.nextInt();

                    Conta contaOrigem = null;
                    Conta contaDestino = null;

                    //Leitura e armazenamento das contas nas variáveis do tipo Conta.
                    for (Conta c : listaContas) {
                        if (c.getNumeroConta() == numeroContaOrigem) {
                            contaOrigem = c;
                        }
                        if (c.getNumeroConta() == numeroContaDestino) {
                            contaDestino = c;
                        }
                    }
                    //Validação das contas: verifica se as contas existem no sistema.
                    if (contaOrigem == null) {
                        System.out.println("Conta de origem não encontrada!");
                    }
                    else if (contaDestino == null) {
                        System.out.println("Conta de destino não encontrada!");
                    }

                    //Caso exista, pede o valor que o usuário deseja transferir.
                    else {
                        System.out.println("Digite o valor que deseja transferir: ");
                        double valorTransferencia = sc.nextDouble();

                        //validação do valor da transferência: Verifica se o valor da transferência é menor que o saldo disponível na conta.
                        if(contaOrigem.getSaldoCorrente() < valorTransferencia){
                            System.out.println("Saldo insuficiente para realizar a transferência!");
                        }

                        //Após todas as validações serem bem sucedidas, o sistema realiza a transferencia.
                        else{
                            contaOrigem.transferir(valorTransferencia, contaDestino);
                            System.out.println("Tranferência realizada com sucesso!");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Digite o número da conta que quer consultar informações: ");
                    int contaNumero = sc.nextInt();

                    //Realiza a leitura e mostra as informações da conta digitada pelo usuário.
                    for (Conta c : listaContas){
                        if(contaNumero == c.numeroConta){
                            c.mostrarInfos();
                        } else{
                            System.out.println("Conta não encontrada!");
                        }
                    }
                    break;

                case 6:
                    System.out.println("Agradecemos por utilizar nosso sistema! \nVolte sempre!");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao !=6);
        sc.close();
    }
}