package com.challenge.btg.pedidos.model.item;

import com.challenge.btg.pedidos.entity.Item;

import java.math.BigDecimal;

public record DadosDetalhamentoItem(
        Long codigoItem,
        String produto,
        Integer quantidade,
        BigDecimal preco
) {
    public DadosDetalhamentoItem(Item item){
        this(
                item.getIdItem(),
                item.getProduto(),
                item.getQuantidade(),
                item.getPreco()
        );
    }
}
