package com.challenge.btg.pedidos.service;

import com.challenge.btg.pedidos.entity.Cliente;
import com.challenge.btg.pedidos.model.cliente.DadosDetalhamentoCliente;
import com.challenge.btg.pedidos.model.cliente.DadosInserirCliente;
import com.challenge.btg.pedidos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public DadosDetalhamentoCliente inserirCliente(DadosInserirCliente dados) {
        var cliente = repository.saveAndFlush(new Cliente(dados));

        return new DadosDetalhamentoCliente(cliente);
    }
}
