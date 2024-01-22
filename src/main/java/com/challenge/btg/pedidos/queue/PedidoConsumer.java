package com.challenge.btg.pedidos.queue;

import com.challenge.btg.pedidos.model.pedido.DadosFilaPedido;
import com.challenge.btg.pedidos.service.PedidoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PedidoConsumer {

    @Autowired
    private PedidoService service;

    @RabbitListener(queues = {"pedidos-request-queue"})
    public void receberMensagem(DadosFilaPedido dadosFilaPedido) {
        service.processarPedido(dadosFilaPedido);
    }
}