package com.challenge.btg.pedidos.model.cliente;

import com.challenge.btg.pedidos.entity.Cliente;

public record DadosDetalhamentoCliente(
        Long idCliente,
        String nome,
        String email,
        String telefone
) {
    public DadosDetalhamentoCliente(Cliente cliente) {
        this(
                cliente.getIdCliente(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone()
        );
    }
}
