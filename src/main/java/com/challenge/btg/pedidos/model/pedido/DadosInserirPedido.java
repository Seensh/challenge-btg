package com.challenge.btg.pedidos.model.pedido;
import jakarta.validation.constraints.NotNull;

public record DadosInserirPedido(
    @NotNull(message = "O campo idCliente não pode ser nulo") Long codigoCliente
) {
}
