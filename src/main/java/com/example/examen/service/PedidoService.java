package com.example.examen.service;

import com.example.examen.entity.PedidoEntity;
import java.util.List;

public interface PedidoService {
    PedidoEntity crearPedido(Long clienteId, PedidoEntity pedido);
    List<PedidoEntity> buscarTodos();
    PedidoEntity buscarPedidoPorParametro(Long id);
    PedidoEntity buscarPedidoPorParametro(int estado);
    PedidoEntity actualizarPedido(Long id, Long personaId, PedidoEntity pedido);
    PedidoEntity eliminarPedido(Long id);
}
