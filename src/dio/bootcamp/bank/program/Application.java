package dio.bootcamp.bank.program;

import dio.bootcamp.bank.program.Conta;

import java.util.ArrayList;
import static dio.bootcamp.bank.program.Operacao.contasBancarias;
import static dio.bootcamp.bank.program.Operacao.operacoes;

public class Application {

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

}
