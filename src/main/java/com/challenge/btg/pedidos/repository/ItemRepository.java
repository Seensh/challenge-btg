package com.challenge.btg.pedidos.repository;

import com.challenge.btg.pedidos.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
