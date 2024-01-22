package com.challenge.btg.pedidos.entity;

import com.challenge.btg.pedidos.model.item.DadosFilaItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "item")
@Table(name = "item")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idItem")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;

    @ManyToOne
    @JoinColumn(name = "idPedido")
    @JsonIgnore
    private Pedido pedido;


    private String produto;


    private Integer quantidade;


    private BigDecimal preco;


    public Item(DadosFilaItem dadosFilaItem, Pedido pedido) {
        this.pedido = pedido;
        this.produto = dadosFilaItem.produto();
        this.quantidade = dadosFilaItem.quantidade();
        this.preco = dadosFilaItem.preco();
    }
}
