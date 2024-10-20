package com.example.examen.service.impl;

import com.example.examen.Constantes;
import com.example.examen.entity.PedidoEntity;
import com.example.examen.entity.PersonaEntity;
import com.example.examen.repository.PedidoRepository;
import com.example.examen.repository.PersonaRepository;
import com.example.examen.service.PedidoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PersonaRepository personaRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository, PersonaRepository personaRepository) {
        this.pedidoRepository = pedidoRepository;
        this.personaRepository = personaRepository;
    }

    @Override
    public PedidoEntity crearPedido(Long clienteId, PedidoEntity pedido) {
        PersonaEntity personaEncontrada = personaRepository.findById(clienteId).orElseThrow(() ->
                new NoSuchElementException("Persona no existe"));
        pedido.setPersona(personaEncontrada);
        return pedidoRepository.save(pedido);
    }

    @Override
    public List<PedidoEntity> buscarTodos() {
        return pedidoRepository.findAll();
    }

    @Override
    public PedidoEntity buscarPedidoPorParametro(Long id) {
        return pedidoRepository.findById(id).orElseThrow(()
                -> new NoSuchElementException("Pedido no encontrado"));
    }

    @Override
    public PedidoEntity buscarPedidoPorParametro(int estado) {
        return pedidoRepository.findPedidoByEstado(estado);
    }

    @Override
    public PedidoEntity actualizarPedido(Long id, Long personaId, PedidoEntity pedido) {
        PedidoEntity pedidoExistente = buscarPedidoPorParametro(id);
        PersonaEntity personaEncontrada = personaRepository.findById(personaId).orElseThrow(()->
                new RuntimeException("Error, no se puede relacionar"));
        pedidoExistente.setDescripcion(pedido.getDescripcion());
        pedidoExistente.setCantidad(pedido.getCantidad());
        pedidoExistente.setEstado(pedido.getEstado());
        pedidoExistente.setPersona(personaEncontrada);

        return pedidoRepository.save(pedidoExistente);
    }

    @Override
    public PedidoEntity eliminarPedido(Long id) {
        PedidoEntity pedidoEncontrado = buscarPedidoPorParametro(id);
        pedidoEncontrado.setEstado(Constantes.ELIMINADO);
        return null;
    }
}
