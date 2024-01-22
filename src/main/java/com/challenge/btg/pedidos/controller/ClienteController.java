package com.challenge.btg.pedidos.controller;

import com.challenge.btg.pedidos.model.cliente.DadosInserirCliente;
import com.challenge.btg.pedidos.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    @Transactional
    public ResponseEntity inserir(@RequestBody @Valid DadosInserirCliente dados, UriComponentsBuilder uriComponentsBuilder){
        var dadosDetalhamentoCliente = service.inserirCliente(dados);

        var uri = uriComponentsBuilder.path("/api/cliente/{id}").buildAndExpand(dadosDetalhamentoCliente.codigoCliente()).toUri();
        return ResponseEntity.created(uri).body(dadosDetalhamentoCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscaPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscaClientePorId(id));
    }

    @GetMapping("/{id}/quantidade/pedidos")
    public ResponseEntity buscarQuantidadeDePedidosPorCliente(@PathVariable Long id) {

        return ResponseEntity.ok(service.buscaQuantidadePedidos(id));
    }
}
