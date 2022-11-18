package dio.bootcamp.bank.program;

import java.util.ArrayList;
import java.util.Scanner;

public class Operacao {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void operacoes() {

        System.out.println("| ***************************************************************************** |");
        System.out.println("| *********************** BEM VINDO AO SANT'OLIVER BANK *********************** |");
        System.out.println("| ***************************************************************************** |");
        System.out.println("| ***************** SELECIONE A OPERAÇÃO QUE DESEJA REALIZAR! ***************** |");
        System.out.println("| ***************************************************************************** |");
        System.out.println("| ********************* |   OPÇÃO 1 - CRIAR CONTA       | ********************* |");
        System.out.println("| ********************* |   OPÇÃO 2 - DEPOSITAR         | ********************* |");
        System.out.println("| ********************* |   OPÇÃO 3 - SACAR             | ********************* |");
        System.out.println("| ********************* |   OPÇÃO 4 - TRANSFERIR        | ********************* |");
        System.out.println("| ********************* |   OPÇÃO 5 - RETIRAR EXTRATO   | ********************* |");
        System.out.println("| ********************* |   OPÇÃO 6 - LISTAR            | ********************* |");
        System.out.println("| ********************* |   OPÇÃO 7 - SAIR              | ********************* |");
        System.out.println("| ***************************************************************************** |");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                extrato();
                break;
            case 6:
                listar();
                break;
            case 7:
                System.out.println("Fechando Aba de Operações!");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida!");
                operacoes();
                break;
        }
    }

    private static void criarConta() {
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        Pessoa pessoa = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);

        System.out.println("Conta criada com Sucesso!");

        operacoes();
    }

    private static void depositar() {
        System.out.println("Conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Valor: ");
            Double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("O valor de R$" + valorDeposito + " foi depositado com sucesso!");
        } else {
            System.out.println("Conta não encontrada ou não existe!");
        }
        operacoes();
    }

    private static void sacar() {
        System.out.println("Conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Valor: ");
            Double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
        } else {
            System.out.println("Conta não encontrada ou não existe!");
        }
        operacoes();
    }

    private static void transferir() {
        System.out.println("Conta Remetente: ");
        int numeroContaRemetente = input.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente != null)  {
            System.out.println("Conta Destinatário: ");
            int numeroContaDestinatario = input.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario != null) {
                System.out.println("Valor: ");
                Double valor = input.nextDouble();

                contaRemetente.transferir(contaDestinatario, valor);
            } else {
                System.out.println("Conta Destinatário não encontrada ou não existe!");
            }
        } else {
            System.out.println("Conta Remetente não encontrada ou não existe!");
        }
        operacoes();
    }

    private static void extrato() {
        System.out.println("Conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);
        if(conta != null) {
            conta.imprimirExtrato();
        } else {
            System.out.println("Conta não encontrada ou não existe!");
        }
        operacoes();
    }

    private static void listar() {
        if(contasBancarias.size() > 0) {
            for(Conta conta: contasBancarias) {
                System.out.println(conta);
            }
        } else {
            System.out.println("Não há contas cadastradas!");
        }
        operacoes();
    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            for(Conta c: contasBancarias) {
                if(c.getNumeroConta() == numeroConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }

}