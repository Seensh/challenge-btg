package com.challenge.btg.pedidos.entity;

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
    }
}