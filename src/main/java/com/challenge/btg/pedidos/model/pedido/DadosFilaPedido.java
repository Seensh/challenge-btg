package com.challenge.btg.pedidos.model.pedido;

import com.challenge.btg.pedidos.model.item.DadosFilaItem;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DadosFilaPedido(
        @NotNull Long codigoPedido,
        @NotNull Long codigoCliente,
        @Valid @NotEmpty List<DadosFilaItem> itens
) {
}