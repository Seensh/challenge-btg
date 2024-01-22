package com.challenge.btg.pedidos.entity;

import com.challenge.btg.pedidos.model.cliente.DadosInserirCliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity(name = "cliente")
@Table(name = "cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idCliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String nome;

    private String email;

    private String telefone;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Pedido> pedidos;

    public Cliente(DadosInserirCliente dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
    }
}
