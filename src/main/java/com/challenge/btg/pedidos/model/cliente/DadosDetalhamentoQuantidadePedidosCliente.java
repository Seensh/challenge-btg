package com.challenge.btg.pedidos.model.cliente;

import com.challenge.btg.pedidos.entity.Cliente;

public record DadosDetalhamentoQuantidadePedidosCliente(
        DadosDetalhamentoCliente cliente,
        Integer quantidade_pedidos
) {
    public DadosDetalhamentoQuantidadePedidosCliente(Cliente cliente) {
        this(
                new DadosDetalhamentoCliente(cliente).withoutPedidos(),
                cliente.getPedidos().size()
        );
    }
}
