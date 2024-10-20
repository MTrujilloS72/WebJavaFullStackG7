package com.example.examen.repository;

import com.example.examen.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    PedidoEntity findPedidoByEstado(int estado);
}
