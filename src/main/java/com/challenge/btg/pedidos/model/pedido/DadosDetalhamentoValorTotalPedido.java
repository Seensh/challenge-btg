package com.challenge.btg.pedidos.model.pedido;

import com.challenge.btg.pedidos.entity.Pedido;

import java.math.BigDecimal;

public record DadosDetalhamentoValorTotalPedido(
        BigDecimal valorTotal
) {
    public DadosDetalhamentoValorTotalPedido(Pedido pedido) {
        this(
                pedido.getValorTotal()
        );
    }
}
