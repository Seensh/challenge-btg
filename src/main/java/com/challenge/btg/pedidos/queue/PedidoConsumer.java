package com.challenge.btg.pedidos.queue;

import com.challenge.btg.pedidos.model.pedido.DadosFilaPedido;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class PedidoConsumer {

    @RabbitListener(queues = {"pedidos-request-queue"})
    public void receberMensagem(DadosFilaPedido dadosFilaPedido) {
        System.out.println("Mensagem Recebida: " + dadosFilaPedido);
        // Faça o processamento da mensagem conforme necessário
    }
}