package com.challenge.btg.pedidos.model.pedido;

import com.challenge.btg.pedidos.model.item.DadosFilaItem;

import java.util.List;

public record DadosFilaPedido(
        Long codigoPedido,
        Long codigoCliente,
        List<DadosFilaItem> itens
) {
}