package com.challenge.btg.pedidos.model.pedido;

import com.challenge.btg.pedidos.entity.Pedido;
import com.challenge.btg.pedidos.model.cliente.DadosDetalhamentoCliente;

public record DadosDetalhamentoPedido(
        Long idPedido,
        DadosDetalhamentoCliente cliente
) {
    public DadosDetalhamentoPedido(Pedido pedido) {
        this(
                pedido.getIdPedido(),
                new DadosDetalhamentoCliente(pedido.getCliente())
        );
    }
}
