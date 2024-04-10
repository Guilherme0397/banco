package com.guidevops.banco.modelo.pagamento;

import java.math.BigDecimal;

public interface DocumentoPagavel { //A interface DocumentoPpagavel define um contrato que diz quais os requisitos são necessários para usar os métodos dessa interface.

    BigDecimal getValorTotal();
    boolean estaPago();
    void quitarPagamento();

    default void imprimirRecibo() {
        System.out.println("RECIBO:");
        System.out.println("Valor Total: " + getValorTotal());
        System.out.println("Pago: " + estaPago());
    }

}
