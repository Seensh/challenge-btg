package com.challenge.btg.pedidos.model.cliente;

import com.challenge.btg.pedidos.entity.Cliente;
import com.challenge.btg.pedidos.model.pedido.DadosDetalhamentoPedido;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DadosDetalhamentoCliente(
        Long codigoCliente,
        String nome,
        String email,
        String telefone,
        List<DadosDetalhamentoPedido> pedidos
) {
    public DadosDetalhamentoCliente(Cliente cliente) {
        this(
                cliente.getIdCliente(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getPedidos() == null ? null : cliente.getPedidos().stream().map(DadosDetalhamentoPedido::new).toList()
        );
    }

    public DadosDetalhamentoCliente withoutPedidos() {
        return new DadosDetalhamentoCliente(codigoCliente(), nome(), email(), telefone(), null);
    }
}
