package com.challenge.btg.pedidos.entity;

import com.challenge.btg.pedidos.model.item.DadosFilaItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity(name = "pedido")
@Table(name = "pedido")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idPedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    @JsonIgnore
    private Cliente cliente;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlteracao;

    private BigDecimal valorTotal;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<Item> itens;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.dataInclusao = new Date();
        this.dataAlteracao = new Date();
        this.valorTotal = BigDecimal.ZERO;
    }

    public void addClienteAndItens(Cliente cliente, List<DadosFilaItem> itens, BigDecimal valorTotalPedido) {
        this.cliente = cliente;

        this.itens = itens.stream().map(dadosFilaItem -> {
            return new Item(dadosFilaItem, this);
        }).toList();

        this.valorTotal = this.valorTotal != null && this.valorTotal.compareTo(BigDecimal.ZERO) > 0 ? this.valorTotal.add(valorTotalPedido) : valorTotalPedido;
        this.dataAlteracao = new Date();
    }
}