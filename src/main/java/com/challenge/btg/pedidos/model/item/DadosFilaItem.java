package com.challenge.btg.pedidos.model.item;

import java.math.BigDecimal;

public record DadosFilaItem(
        String produto,
        Integer quantidade,
        BigDecimal preco
) {
}
