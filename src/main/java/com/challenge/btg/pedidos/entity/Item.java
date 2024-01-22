package com.challenge.btg.pedidos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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


    private Double preco;

    // getters e setters
}
