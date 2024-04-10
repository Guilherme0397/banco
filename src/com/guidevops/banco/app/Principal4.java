package com.guidevops.banco.app;

import com.guidevops.banco.modelo.Banco;
import com.guidevops.banco.modelo.Conta;
import com.guidevops.banco.modelo.Pessoa;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal4 {

    public static void main(String[] args) {
        Banco banco = new Banco();

        List<Pessoa> titulares = banco.getContas().stream()
                .map(Conta::getTitular)
                .distinct()
                        .toList();
//                .collect(Collectors.toList());

        System.out.println(titulares);

        BigDecimal saldoTotal = banco.getContas().stream()
                        .map(Conta::getSaldo)
                                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(saldoTotal);

        banco.getContas().stream() // fonte de dados
                .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("50")) > 0) // op intermediaria
                .filter(conta -> conta.getNumero() > 100) // op intermediaria
                .map(Conta :: getTitular) // op intermediaria
                .distinct() // op intermediaria
                .forEach(System.out::println);  //op terminal

//        banco.getContas().stream() // fonte de dados
//                .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("50")) > 0) // op intermediaria
//                .filter(conta -> conta.getNumero() > 100) // op intermediaria
//                .sorted(Comparator.comparingInt(Conta::getNumero)) // op intermediaria
//                    .forEach(conta -> { //op terminal
//                        System.out.println(conta.getAgencia() + "/" + conta.getNumero() + " = " + conta.getSaldo());
//                    });
    }

}

// pipeline conjunto de operações que irão ser executadas em algum momento.