package com.challenge.btg.pedidos.service;

import com.challenge.btg.pedidos.entity.Item;
import com.challenge.btg.pedidos.entity.Pedido;
import com.challenge.btg.pedidos.model.item.DadosFilaItem;
import com.challenge.btg.pedidos.model.pedido.DadosDetalhamentoPedido;
import com.challenge.btg.pedidos.model.pedido.DadosFilaPedido;
import com.challenge.btg.pedidos.model.pedido.DadosInserirPedido;
import com.challenge.btg.pedidos.repository.ClienteRepository;
import com.challenge.btg.pedidos.repository.ItemRepository;
import com.challenge.btg.pedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    public DadosDetalhamentoPedido inserirPedido(DadosInserirPedido dados) {
        var cliente = clienteRepository.findById(dados.codigoCliente())
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));

        var pedido = pedidoRepository.saveAndFlush(new Pedido(cliente));

        return new DadosDetalhamentoPedido(pedido);
    }

    public DadosDetalhamentoPedido buscarPedidoPorId(Long id) {
        var pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pedido não encontrado"));

        return new DadosDetalhamentoPedido(pedido);
    }


    public void processarPedido(DadosFilaPedido dadosFilaPedido) {
        var pedido = pedidoRepository.findById(dadosFilaPedido.codigoPedido())
                .orElseThrow(() -> new NoSuchElementException("Pedido não encontrado"));

        var cliente = clienteRepository.findById(dadosFilaPedido.codigoCliente())
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));


        BigDecimal valorTotalPedido = calcularValorTotalPedido(dadosFilaPedido.itens());

        pedido.addClienteAndItens(cliente, dadosFilaPedido.itens(), valorTotalPedido);

        pedidoRepository.save(pedido);
    }

    private BigDecimal calcularValorTotalPedido(List<DadosFilaItem> itens) {
        BigDecimal valorTotalPedido = BigDecimal.ZERO;
        for (DadosFilaItem dadosFilaItem : itens) {
            if (dadosFilaItem.preco() != null && dadosFilaItem.preco().compareTo(BigDecimal.ZERO) > 0) {
                BigDecimal valorTotalItem = (dadosFilaItem.quantidade() != null)
                        ? dadosFilaItem.preco().multiply(BigDecimal.valueOf(dadosFilaItem.quantidade()))
                        : BigDecimal.ZERO;
                valorTotalPedido = valorTotalPedido.add(valorTotalItem);
            }
        }
        return valorTotalPedido;
    }

}
