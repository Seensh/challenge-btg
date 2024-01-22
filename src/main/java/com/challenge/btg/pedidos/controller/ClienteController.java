package com.challenge.btg.pedidos.controller;

import com.challenge.btg.pedidos.model.cliente.DadosInserirCliente;
import com.challenge.btg.pedidos.service.ClienteService;
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
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    @Transactional
    public ResponseEntity inserir(@RequestBody @Valid DadosInserirCliente dados, UriComponentsBuilder uriComponentsBuilder){
        var dadosDetalhamentoCliente = service.inserirCliente(dados);

        var uri = uriComponentsBuilder.path("/api/cliente/{id}").buildAndExpand(dadosDetalhamentoCliente.idCliente()).toUri();
        return ResponseEntity.created(uri).body(dadosDetalhamentoCliente);
    }
}
