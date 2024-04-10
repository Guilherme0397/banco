package com.guidevops.banco.app;

import com.guidevops.banco.modelo.Banco;
import com.guidevops.banco.modelo.Conta;

import java.util.Comparator;
import java.util.function.ToIntFunction;

public class Principal3 {

    public static void main(String[] args) {
        Banco banco = new Banco();
//        ToIntFunction<Conta> function = (Conta conta) -> {
//          return conta.getNumero();
//        };

//        banco.getContas().sort(Comparator.comparingInt(new NumeroContaFunction())); //ordena pelos numeros
//        banco.getContas().sort(Comparator.comparingInt(conta -> conta.getNumero())); //expressão lambda
        banco.getContas().sort(Comparator.comparingInt(Conta::getNumero)); //referencia o getNumero da class conta

        for (Conta conta : banco.getContas()) {
            System.out.println(conta.getAgencia() + "/" + conta.getNumero());
        }
    }
}
