package com.guidevops.banco.modelo;

import com.guidevops.banco.modelo.excecao.SaldoInsuficienteException;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Conta { //class abstrata ela não é instânciada

    private Pessoa titular;
    private int agencia;
    private int numero;
    private BigDecimal saldo = BigDecimal.ZERO;

    Conta() {
    }

    public Conta(Pessoa titular, int agencia, int numero){
        Objects.requireNonNull(titular); //valida que a variavel titular não receba valores null
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

   public void depositar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <=0) {
            throw new IllegalStateException("Valor deve ser maior que 0");
        }
        saldo = saldo.add(valor);
    }

   public void sacar(BigDecimal valor){
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalStateException("Valor dever ser maior que 0");
        }
        if (getSaltdoDisponivel().subtract(valor).compareTo(BigDecimal.ZERO) < 0) {
           throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        saldo = saldo.subtract(valor);
    }

   public void sacar(BigDecimal valor, BigDecimal taxaSaque) {
        sacar(valor.add(taxaSaque));
    }

    public abstract void debitarTarifaMensal(); // abstratos

    public Pessoa getTitular() {
        return titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public BigDecimal getSaltdoDisponivel(){
        return getSaldo();
    }

}
