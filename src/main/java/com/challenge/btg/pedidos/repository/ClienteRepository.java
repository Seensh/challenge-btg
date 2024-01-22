package com.challenge.btg.pedidos.repository;

import com.challenge.btg.pedidos.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
