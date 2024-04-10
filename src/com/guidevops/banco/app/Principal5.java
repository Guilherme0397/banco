package com.guidevops.banco.app;


import com.guidevops.banco.modelo.Banco;
import com.guidevops.banco.modelo.Conta;

import java.math.BigDecimal;
import java.util.Optional;

public class Principal5 {

    public static void main(String[] args) {
        Banco banco = new Banco();

//        Optional<Conta> contaOptional = banco.buscar(123,188);

//       banco.buscar(123,188)
//                .ifPresent(conta -> System.out.println(conta.getSaldo()));

//        Conta contaEncontrada = banco.buscar(123,128)
//                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
//
//        System.out.println(contaEncontrada.getSaldo());

//        if (contaOptional.isPresent()) {
//            Conta contaEncontrada = contaOptional.get();
//            System.out.println(contaEncontrada.getSaldo());
//        }
        BigDecimal saldo = banco.buscar(123,222)
                .map(Conta::getSaldo)
                .orElse(BigDecimal.ZERO);

        System.out.println(saldo);
    }

}

