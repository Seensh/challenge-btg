package com.challenge.btg.pedidos.repository;

import com.challenge.btg.pedidos.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
