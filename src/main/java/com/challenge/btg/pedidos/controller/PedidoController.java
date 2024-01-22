package com.challenge.btg.pedidos.controller;

import com.challenge.btg.pedidos.model.pedido.DadosInserirPedido;
import com.challenge.btg.pedidos.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    @Transactional
    public ResponseEntity inserir(@RequestBody @Valid DadosInserirPedido dados, UriComponentsBuilder uriComponentsBuilder){
        var dadosDetalhamentoPedido = service.inserirPedido(dados);

        var uri = uriComponentsBuilder.path("/api/pedido/{id}").buildAndExpand(dadosDetalhamentoPedido.idPedido()).toUri();
        return ResponseEntity.created(uri).body(dadosDetalhamentoPedido);
    }
}
