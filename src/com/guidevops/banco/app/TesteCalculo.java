package com.guidevops.banco.app;

import java.math.BigDecimal;

public class TesteCalculo {

    public static void main(String[] args) {
        BigDecimal x = new BigDecimal("1.0");
        x = x.subtract(new BigDecimal("0.10"));
        x = x.subtract(new BigDecimal("0.20"));
        x = x.subtract(new BigDecimal("0.30"));
        System.out.println(x);

// BigDecimal é para trabalhar em situações que precisa de numeros precisos, tipo para contar dinheiro.
//        double x = 1.0;
//        x = x - 0.10;
//        x = x - 0.20;
//        x = x - 0.30;
//        System.out.println(x);
    }
}
