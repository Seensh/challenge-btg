package com.challenge.btg.pedidos.model.pedido;

import com.challenge.btg.pedidos.entity.Pedido;
import com.challenge.btg.pedidos.model.item.DadosDetalhamentoItem;

import java.math.BigDecimal;
import java.util.List;

public record DadosDetalhamentoPedido(
        Long codigoPedido,
        Long codigoCliente,
        List<DadosDetalhamentoItem> itens,
        BigDecimal valorTotal

) {
    public DadosDetalhamentoPedido(Pedido pedido) {
        this(
                pedido.getIdPedido(),
                pedido.getCliente() == null ? null : pedido.getCliente().getIdCliente(),
                pedido.getItens() == null ? null : pedido.getItens().stream().map(DadosDetalhamentoItem::new).toList(),
                pedido.getValorTotal()
        );
    }
}
