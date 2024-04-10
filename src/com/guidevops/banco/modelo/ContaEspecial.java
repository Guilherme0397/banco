package com.guidevops.banco.modelo;

import java.math.BigDecimal;

public class ContaEspecial extends Conta {

    private BigDecimal valorLimite;

    public ContaEspecial(Pessoa titular, int agencia, int numero, BigDecimal valorLimite) {
        super(titular, agencia, numero);
        this.valorLimite = valorLimite;
    }

    @Override
    public void debitarTarifaMensal() {
        sacar(new BigDecimal("20"));
    }

    @Override
    public BigDecimal getSaltdoDisponivel() {
        return getSaldo().add(getValorLimite());
    }

    public BigDecimal getValorLimite() {
        return valorLimite;
    }

    public void setValorLimite(BigDecimal valorLimite) {
        this.valorLimite = valorLimite;
    }
}
