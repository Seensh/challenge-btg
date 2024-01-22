package com.challenge.btg.pedidos.controller;

import com.challenge.btg.pedidos.model.pedido.DadosInserirPedido;
import com.challenge.btg.pedidos.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    @Transactional
    public ResponseEntity inserir(@RequestBody @Valid DadosInserirPedido dados, UriComponentsBuilder uriComponentsBuilder){
        var dadosDetalhamentoPedido = service.inserirPedido(dados);

        var uri = uriComponentsBuilder.path("/api/pedido/{id}").buildAndExpand(dadosDetalhamentoPedido.codigoPedido()).toUri();
        return ResponseEntity.created(uri).body(dadosDetalhamentoPedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscaPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPedidoPorId(id));
    }

    @GetMapping("/valorTotal/{id}")
    public ResponseEntity buscaValorTotalPedido(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarValorTotalPedido(id));
    }
}
