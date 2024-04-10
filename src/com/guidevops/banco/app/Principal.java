package com.guidevops.banco.app;

import com.guidevops.banco.modelo.ContaEspecial;
import com.guidevops.banco.modelo.ContaInvestimento;
import com.guidevops.banco.modelo.Pessoa;
import com.guidevops.banco.modelo.TipoPessoa;
import com.guidevops.banco.modelo.atm.CaixaEletronico;
import com.guidevops.banco.modelo.excecao.SaldoInsuficienteException;
import com.guidevops.banco.modelo.pagamento.Boleto;
import com.guidevops.banco.modelo.pagamento.Holerite;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Principal {

    public static void main(String[] args) {
        Pessoa titular1 = new Pessoa();
        titular1.setNome("João da Silva");
        titular1.setDocumento("123131654");
        titular1.setRendimentoAnual(new BigDecimal("15000")); //auto boxing, colocou dentro do wapper automaticamente
        titular1.setTipo(TipoPessoa.JURIDICA);
        System.out.println(titular1.getDataUltimaAtualizacao());

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Maria Abadia");
        titular2.setDocumento("3103213843");

        CaixaEletronico caixaEletronico = new CaixaEletronico(); //instanciando a class CaixaEletronico

        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 123, 987);
        ContaEspecial suaConta = new ContaEspecial(titular2, 222, 333, new BigDecimal("1000"));

        try {
            minhaConta.depositar(new BigDecimal("30000"));
            minhaConta.sacar(new BigDecimal("1000"));
//        minhaConta.creditarRendimentos(0.8);
//        minhaConta.debitarTarifaMensal();


            suaConta.depositar(new BigDecimal("15000"));
            suaConta.sacar(new BigDecimal("15500"));
//        suaConta.sacar(10000,10);
//        suaConta.debitarTarifaMensal();

            Boleto boletoEscola = new Boleto(titular2,new BigDecimal("800"));
            Holerite salarioFuncionario = new Holerite(titular2, new BigDecimal("100"), 160);

            caixaEletronico.pagar(boletoEscola, minhaConta);
            caixaEletronico.pagar(salarioFuncionario, minhaConta);
            caixaEletronico.estornarPagamento(boletoEscola, minhaConta);

            boletoEscola.imprimirRecibo();
            salarioFuncionario.imprimirRecibo();

//        System.out.println("Boleto pago: " + boletoEscola.estaPago());
//        System.out.println("Salário pago: " + salarioFuncionario.estaPago());

        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro ao executar operação na conta: " + e.getMessage());
        }
        caixaEletronico.imprimirSaldo(minhaConta);
        caixaEletronico.imprimirSaldo(suaConta);
    }
//        Conta conta = minhaConta; //upcasting
        //poliformismo capacidade de se enxergar o objeto com vários objetos.

//        System.out.println(" Titular: " + minhaConta.getTitular().getNome());
//        System.out.println("Saldo: " + minhaConta.getSaldo());
//
//        System.out.println(" Titular: " + suaConta.getTitular().getNome());
//        System.out.println("Saldo: " + suaConta.getSaldo());
}

