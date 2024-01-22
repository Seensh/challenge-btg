package com.challenge.btg.pedidos.service;

import com.challenge.btg.pedidos.entity.Cliente;
import com.challenge.btg.pedidos.entity.Pedido;
import com.challenge.btg.pedidos.model.pedido.DadosDetalhamentoPedido;
import com.challenge.btg.pedidos.model.pedido.DadosFilaPedido;
import com.challenge.btg.pedidos.model.pedido.DadosInserirPedido;
import com.challenge.btg.pedidos.repository.ClienteRepository;
import com.challenge.btg.pedidos.repository.ItemRepository;
import com.challenge.btg.pedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ItemRepository itemRepository;

    public DadosDetalhamentoPedido inserirPedido(DadosInserirPedido dados) {
        var cliente = clienteRepository.findById(dados.idCliente())
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));

        var pedido = pedidoRepository.saveAndFlush(new Pedido(cliente));

        return new DadosDetalhamentoPedido(pedido);
    }


    public void processarPedido(DadosFilaPedido dadosFilaPedido) {

        Pedido pedido = new Pedido();
        //BigDecimal valorTotal = calcularValorTotalPedido(dadosFilaPedido.getItens());
        pedidoRepository.save(pedido);
    }

}
