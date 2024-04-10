package com.guidevops.banco.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaInvestimento extends Conta { //extends faz herdar todas propriedades da classe conta

    public ContaInvestimento(Pessoa titular, int agencia, int numero) {
        super(titular, agencia, numero); //chama o construtor da super class
    }

    @Override
    public void debitarTarifaMensal() {
        if (getSaldo().compareTo(new BigDecimal("10000")) < 0) {
            sacar(new BigDecimal("30"));
        }
    }

    public void creditarRendimentos(BigDecimal percentualJuros) {
        BigDecimal valorRendimentos = getSaldo().multiply(percentualJuros).divide(new BigDecimal("100"), 2, RoundingMode.HALF_EVEN); //Arredondamento Bancario
//        double valorRendimentos = getSaldo() * percentualJuros / 100;
        depositar(valorRendimentos);
    }


}
