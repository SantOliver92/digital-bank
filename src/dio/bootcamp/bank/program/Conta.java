package dio.bootcamp.bank.program;

import dio.bootcamp.bank.utilities.Utils;

public class Conta {

    private static final int agenciaPadrao = 1;
    private static int contadorConta = 1;

    private int agencia;
    private int numeroConta;
    private Pessoa pessoa;
    private Double saldo = 0.0;

    public Conta(Pessoa pessoa) {
        this.agencia = Conta.agenciaPadrao;
        this.numeroConta = contadorConta;
        this.pessoa = pessoa;
        contadorConta += 1;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String toString() {
        return "\nNúmero da Conta: " + this.getNumeroConta() +
                "\nNome: " + this.pessoa.getNome() +
                "\nCPF: " + this.pessoa.getCpf() +
                "\nEmail: " + this.pessoa.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n";
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("***** |   Titular: %s", this.pessoa.getNome()));
        System.out.println(String.format("***** |   Número: %d", this.numeroConta));
        System.out.println(String.format("***** |   Saldo: %.2f", this.saldo));
    }

    public void depositar(Double valor) {
        if(valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar o depósito!");
        }
    }

    public void sacar(Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
        } else {
            System.out.println("Não foi possível realizar o saque!");
        }
    }

    public void transferir(Conta contaDeposito, Double valor) {
        if (valor > 0 && getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);

            contaDeposito.saldo = contaDeposito.getSaldo() + valor;
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Não foi possível realizar a transferência!");
        }
    }

    public void imprimirExtrato() {
        System.out.println("***** |         EXTRATO");
        System.out.println("***** |________________________");
        this.imprimirInfosComuns();
    }

}
